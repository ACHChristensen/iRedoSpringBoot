package dk.iredo.marketplace.services;

import com.azure.storage.blob.*;
import com.azure.storage.blob.models.BlobHttpHeaders;
import com.azure.storage.blob.models.BlobItem;
import org.springframework.core.env.Environment;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

@Service
public class BlobService {

    private final Environment env;
    private final ResourceLoader resourceLoader;

    public record UploadResult(int code, String message) {}
    public BlobService(Environment env, ResourceLoader resourceLoader) {
        this.env = env;
        this.resourceLoader = resourceLoader;
    }

    public InputStream getImage(String filename) throws IOException {
        if (filename == null) {
            throw new IllegalArgumentException("Filename is null");
        }

        BlobContainerClient containerClient = getBlobContainerClient();
        try {
            BlobClient blobClient = containerClient.getBlobClient(filename);
            if (!blobClient.exists()) {
                throw new FileNotFoundException("Blob not found");
            }
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            blobClient.download(baos);
            return new ByteArrayInputStream(baos.toByteArray());
        } catch (Exception e) {
            // return default image from resources/static (or wherever you keep it)
            Resource defaultImg = resourceLoader.getResource("classpath:static/images/no-image.jpg");
            if (!defaultImg.exists()) {
                // last resort: empty stream
                return new ByteArrayInputStream(new byte[0]);
            }
            return defaultImg.getInputStream();
        }
    }

    public UploadResult uploadImage(String fileName, MultipartFile file) {
        try {
            byte[] fileBytes = file.getBytes();

            if (imageExists(fileName)) {
                return new UploadResult(0, "Image already exists");
            }

            BlobContainerClient containerClient = getBlobContainerClient();
            BlobClient blobClient = containerClient.getBlobClient(fileName);

            BlobHttpHeaders headers = new BlobHttpHeaders()
                    .setContentType(file.getContentType() == null ? "application/octet-stream" : file.getContentType());

            ByteArrayInputStream dataStream = new ByteArrayInputStream(fileBytes);
            blobClient.upload(dataStream, fileBytes.length, true);
            blobClient.setHttpHeaders(headers);

            // Azure upload returns void in sync client; check existence as verification
            if (blobClient.exists()) {
                return new UploadResult(1, fileName);
            } else {
                return new UploadResult(0, "Image not uploaded");
            }
        } catch (IOException ex) {
            return new UploadResult(0, "Error reading file: " + ex.getMessage());
        } catch (Exception ex) {
            return new UploadResult(0, "Upload failed: " + ex.getMessage());
        }
    }

    public UploadResult deleteImage(String url) {
        try {
            BlobContainerClient containerClient = getBlobContainerClient();
            BlobClient blobClient = containerClient.getBlobClient(url);
            boolean deleted = blobClient.deleteIfExists();
            if (deleted) {
                return new UploadResult(1, "Image deleted");
            } else {
                return new UploadResult(0, "Image not found");
            }
        } catch (Exception e) {
            return new UploadResult(0, "Delete failed: " + e.getMessage());
        }
    }

    public boolean imageExists(String filename) {
        BlobContainerClient containerClient = getBlobContainerClient();
        BlobClient blobClient = containerClient.getBlobClient(filename);
        return blobClient.exists();
    }

    public int getBlobCount() {
        BlobContainerClient containerClient = getBlobContainerClient();
        Iterable<BlobItem> blobs = containerClient.listBlobs();
        // Convert to count
        AtomicInteger count = new AtomicInteger();
        blobs.forEach(b -> count.incrementAndGet());
        return count.get();
    }

    public List<String> getAllBlobNames() {
        BlobContainerClient c = getBlobContainerClient();
        List<String> names = new ArrayList<>();
        for (BlobItem b : c.listBlobs()) names.add(b.getName());
        return names;
    }

    public boolean wipe() {
        BlobContainerClient containerClient = getBlobContainerClient();
        Iterable<BlobItem> blobs = containerClient.listBlobs();
        try {
            for (BlobItem blob : blobs) {
                BlobClient blobClient = containerClient.getBlobClient(blob.getName());
                blobClient.deleteIfExists();
            }
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    private BlobContainerClient getBlobContainerClient() {
        String connectionString = env.getProperty("azurite.connectionString");
        String containerName = env.getProperty("azurite.container");
        BlobServiceClient blobServiceClient = new BlobServiceClientBuilder()
                .connectionString(connectionString)
                .buildClient();
        BlobContainerClient containerClient = blobServiceClient.getBlobContainerClient(containerName);
        containerClient.createIfNotExists(); // safe to call even if exists
        return containerClient;
    }
}
