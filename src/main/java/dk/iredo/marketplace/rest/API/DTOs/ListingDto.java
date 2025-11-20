package dk.iredo.marketplace.rest.API.DTOs;

import dk.iredo.marketplace.rest.data.domain.Listing;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * DTO for {@link Listing}
 */
public class ListingDto implements Serializable {
    private final Integer id;
    private final Boolean soldSeperately;
    private final BigDecimal price;

    public ListingDto(Integer id, Boolean soldSeperately, BigDecimal price) {
        this.id = id;
        this.soldSeperately = soldSeperately;
        this.price = price;
    }

    public ListingDto(Listing listing) {
        this.id = listing.getId();
        this.soldSeperately = listing.getSoldSeperately();
        this.price = listing.getPrice();
    }

    public Integer getId() {
        return this.id;
    }

    public Boolean getSoldSeperately() {return this.soldSeperately;}

    public BigDecimal getPrice() {
        return this.price;
    }

}