package dk.iredo.marketplace.rest.data.domain;

import jakarta.persistence.*;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.math.BigDecimal;

@Entity
@Table(name = "listing_items", schema = "marketplace_core")
public class ListingItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "listing_id", nullable = false)
    private Listing listing;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "product_id", nullable = false)
    private Product product;

    @ColumnDefault("1")
    @Column(name = "quantity", nullable = false)
    private Integer quantity;

    @Column(name = "price", nullable = false, precision = 10, scale = 2)
    private BigDecimal price;

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

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Listing getListing() {
        return listing;
    }

    public void setListing(Listing listing) {
        this.listing = listing;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
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

}