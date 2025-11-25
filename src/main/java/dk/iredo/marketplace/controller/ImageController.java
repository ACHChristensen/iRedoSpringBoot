package dk.iredo.marketplace.controller;

import com.azure.core.annotation.Get;
import dk.iredo.marketplace.services.BlobService;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.method.annotation.StreamingResponseBody;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/image")
public class ImageController {

    private final BlobService blobService;

    public ImageController(BlobService blobService) {
        this.blobService = blobService;
    }

    @GetMapping(value = "/{fileName}", produces = MediaType.IMAGE_JPEG_VALUE)
    public ResponseEntity<StreamingResponseBody> getImage(@PathVariable String fileName) {
        try {
            InputStream inputStream = blobService.getImage(fileName);

            StreamingResponseBody stream = outputStream -> {
                byte[] buffer = new byte[8192];
                int bytesRead;
                while ((bytesRead = inputStream.read(buffer)) != -1) {
                    outputStream.write(buffer, 0, bytesRead);
                }
                inputStream.close();
            };

            return ResponseEntity.ok()
                    .contentType(MediaType.IMAGE_JPEG)
                    .body(stream);

        } catch (Exception e) {
            return ResponseEntity.status(404).build();
        }
    }

    @PostMapping("/upload")
    public ResponseEntity<String> uploadImage(
            @RequestParam("fileName") String fileName,
            @RequestParam("file") MultipartFile file) {

        BlobService.UploadResult result = blobService.uploadImage(fileName, file);

        if (result.code() == 1) {
            // success
            return ResponseEntity.ok(result.message());
        } else {
            // failure
            return ResponseEntity.badRequest().body(result.message());
        }
    }

    @GetMapping("/count")
    public ResponseEntity<String> count() {
        int blobCount = blobService.getBlobCount();   // <-- use the injected instance
        return ResponseEntity.ok(Integer.toString(blobCount));
    }


    @GetMapping("/names")
    public ResponseEntity<List<String>> names() {
        List<String> names = new ArrayList<>();
        List<String> request = blobService.getAllBlobNames();
        for (String name : request) {
            names.add(name);
        }
        return ResponseEntity.ok(names);
    }
}
