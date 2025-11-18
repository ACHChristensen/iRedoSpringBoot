package dk.iredo.marketplace.rest.API.DTOs;

import dk.iredo.marketplace.rest.data.domain.Listing;

import java.io.Serializable;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * DTO for {@link Listing}
 */
public class ListingDto implements Serializable {
    private final Integer id;
    private final Double price;
    private final Integer totalStock;
    private final Integer totalSold;
    private final Integer availableStock;
    private final Double discountPercentage;
    private final Integer minAmountPerOrder;
    private final Instant createdAt;
    private final Instant updatedAt;
    private final String description;

    public ListingDto(Integer id, Double price, Integer totalStock, Integer totalSold, Integer availableStock, Double discountPercentage, Integer minAmountPerOrder, Instant createdAt, Instant updatedAt, String description) {
        this.id = id;
        this.price = price;
        this.totalStock = totalStock;
        this.totalSold = totalSold;
        this.availableStock = availableStock;
        this.discountPercentage = discountPercentage;
        this.minAmountPerOrder = minAmountPerOrder;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.description = description;
    }

    public ListingDto(Listing listing) {
        this.id = listing.getId();
        this.price = listing.getPrice();
        this.totalStock = listing.getTotalStock();
        this.totalSold = listing.getTotalSold();
        this.availableStock = listing.getAvailableStock();
        this.discountPercentage = listing.getDiscountPercentage();
        this.minAmountPerOrder = listing.getMinAmountPerOrder();
        this.createdAt = listing.getCreatedAt();
        this.updatedAt = listing.getUpdatedAt();
        this.description = listing.getDescription();
    }

    public Integer getId() {
        return id;
    }

    public Double getPrice() {
        return price;
    }

    public Integer getTotalStock() {
        return totalStock;
    }

    public Integer getTotalSold() {
        return totalSold;
    }

    public Integer getAvailableStock() {
        return availableStock;
    }

    public Double getDiscountPercentage() {
        return discountPercentage;
    }

    public Integer getMinAmountPerOrder() {
        return minAmountPerOrder;
    }

    public Instant getCreatedAt() {
        return createdAt;
    }

    public Instant getUpdatedAt() {
        return updatedAt;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ListingDto entity = (ListingDto) o;
        return Objects.equals(this.id, entity.id) &&
                Objects.equals(this.price, entity.price) &&
                Objects.equals(this.totalStock, entity.totalStock) &&
                Objects.equals(this.totalSold, entity.totalSold) &&
                Objects.equals(this.availableStock, entity.availableStock) &&
                Objects.equals(this.discountPercentage, entity.discountPercentage) &&
                Objects.equals(this.minAmountPerOrder, entity.minAmountPerOrder) &&
                Objects.equals(this.createdAt, entity.createdAt) &&
                Objects.equals(this.updatedAt, entity.updatedAt) &&
                Objects.equals(this.description, entity.description);
    }

    // TODO - What is that ? Is this the propper values??
    @Override
    public int hashCode() {
        return Objects.hash(id, price, totalStock, totalSold, availableStock, discountPercentage, minAmountPerOrder, createdAt, updatedAt, description);
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "(" +
                "id = " + id + ", " +
                "price = " + price + ", " +
                "totalStock = " + totalStock + ", " +
                "totalSold = " + totalSold + ", " +
                "availableStock = " + availableStock + ", " +
                "discountPercentage = " + discountPercentage + ", " +
                "minAmountPerOrder = " + minAmountPerOrder + ", " +
                "createdAt = " + createdAt + ", " +
                "updatedAt = " + updatedAt + ", " +
                "description = " + description + ")";
    }

}