package dk.iredo.marketplace.dto;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class ListingDto {
    private Boolean soldSeperately;
    private BigDecimal price;
}