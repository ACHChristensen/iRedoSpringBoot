package dk.iredo.marketplace.model;

import jakarta.persistence.*;
import org.hibernate.annotations.ColumnDefault;

import java.time.Instant;

@Entity
@Table(name = "archived_products", schema = "marketplace_core", indexes = {
        @Index(name = "idx_original_product", columnList = "original_product_id")
})
public class ArchivedProduct {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "original_product_id", nullable = false)
    private Integer originalProductId;

    @Column(name = "type", length = 100)
    private String type;

    @Column(name = "brand", nullable = false, length = 100)
    private String brand;

    @Column(name = "model", nullable = false, length = 100)
    private String model;

    @Column(name = "height_in_mm", nullable = false)
    private Integer heightInMm;

    @Column(name = "width_in_mm", nullable = false)
    private Integer widthInMm;

    @Column(name = "depth_in_mm", nullable = false)
    private Integer depthInMm;

    @Column(name = "weight_in_grams", nullable = false)
    private Integer weightInGrams;

    @Column(name = "main_material", nullable = false, length = 100)
    private String mainMaterial;

    @Column(name = "color", nullable = false, length = 50)
    private String color;

    @Lob
    @Column(name = "`condition`", nullable = false)
    private String condition;

    @Lob
    @Column(name = "description")
    private String description;

    @ColumnDefault("CURRENT_TIMESTAMP")
    @Column(name = "archived_at")
    private Instant archivedAt;

    @ColumnDefault("'unspecified'")
    @Column(name = "archived_reason")
    private String archivedReason;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getOriginalProductId() {
        return originalProductId;
    }

    public void setOriginalProductId(Integer originalProductId) {
        this.originalProductId = originalProductId;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Integer getHeightInMm() {
        return heightInMm;
    }

    public void setHeightInMm(Integer heightInMm) {
        this.heightInMm = heightInMm;
    }

    public Integer getWidthInMm() {
        return widthInMm;
    }

    public void setWidthInMm(Integer widthInMm) {
        this.widthInMm = widthInMm;
    }

    public Integer getDepthInMm() {
        return depthInMm;
    }

    public void setDepthInMm(Integer depthInMm) {
        this.depthInMm = depthInMm;
    }

    public Integer getWeightInGrams() {
        return weightInGrams;
    }

    public void setWeightInGrams(Integer weightInGrams) {
        this.weightInGrams = weightInGrams;
    }

    public String getMainMaterial() {
        return mainMaterial;
    }

    public void setMainMaterial(String mainMaterial) {
        this.mainMaterial = mainMaterial;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getCondition() {
        return condition;
    }

    public void setCondition(String condition) {
        this.condition = condition;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Instant getArchivedAt() {
        return archivedAt;
    }

    public void setArchivedAt(Instant archivedAt) {
        this.archivedAt = archivedAt;
    }

    public String getArchivedReason() {
        return archivedReason;
    }

    public void setArchivedReason(String archivedReason) {
        this.archivedReason = archivedReason;
    }

}