package dk.iredo.marketplace.rest.data.domain;

import jakarta.persistence.*;
import org.hibernate.annotations.ColumnDefault;

import java.time.Instant;

@Entity
@Table(name = "listings", schema = "marketplace_corev3")
public class Listing {

    public Listing() {

    }

    public Listing(Double price, Integer totalStock, Integer totalSold, Integer availableStock,
                   Double discountPercentage, Integer minAmountPerOrder, String description) {
        this.price = price;
        this.totalStock = totalStock;
        this.totalSold = totalSold;
        this.availableStock = availableStock;
        this.discountPercentage = discountPercentage;
        this.minAmountPerOrder = minAmountPerOrder;
        this.description = description;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "price", nullable = false)
    private Double price;

    @ColumnDefault("1")
    @Column(name = "total_stock", nullable = false)
    private Integer totalStock;

    @ColumnDefault("0")
    @Column(name = "total_sold", nullable = false)
    private Integer totalSold;

    @ColumnDefault("1")
    @Column(name = "available_stock", nullable = false)
    private Integer availableStock;

    @ColumnDefault("0.00")
    @Column(name = "discount_percentage")
    private Double discountPercentage;

    @ColumnDefault("1")
    @Column(name = "min_amount_per_order", nullable = false)
    private Integer minAmountPerOrder;

    @ColumnDefault("CURRENT_TIMESTAMP")
    @Column(name = "created_at", columnDefinition = "TIMESTAMP")
    private Instant createdAt;

    @ColumnDefault("CURRENT_TIMESTAMP")
    @Column(name = "updated_at", columnDefinition = "TIMESTAMP")
    private Instant updatedAt;

    @Column(name = "description")
    private String description;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Integer getTotalStock() {
        return totalStock;
    }

    public void setTotalStock(Integer totalStock) {
        this.totalStock = totalStock;
    }

    public Integer getTotalSold() {
        return totalSold;
    }

    public void setTotalSold(Integer totalSold) {
        this.totalSold = totalSold;
    }

    public Integer getAvailableStock() {
        return availableStock;
    }

    public void setAvailableStock(Integer availableStock) {
        this.availableStock = availableStock;
    }

    public Double getDiscountPercentage() {
        return discountPercentage;
    }

    public void setDiscountPercentage(Double discountPercentage) {
        this.discountPercentage = discountPercentage;
    }

    public Integer getMinAmountPerOrder() {
        return minAmountPerOrder;
    }

    public void setMinAmountPerOrder(Integer minAmountPerOrder) {
        this.minAmountPerOrder = minAmountPerOrder;
    }

    public Instant getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Instant createdAt) {
        this.createdAt = createdAt;
    }

    public Instant getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Instant updatedAt) {
        this.updatedAt = updatedAt;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

}