package dk.iredo.marketplace.model;

import jakarta.persistence.*;
import org.hibernate.annotations.ColumnDefault;

import java.math.BigDecimal;

@Entity
@Table(name = "listings", schema = "marketplace_core")
public class Listing {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @ColumnDefault("1")
    @Column(name = "sold_seperately", nullable = false)
    private Boolean soldSeperately = false;

    @Column(name = "price", nullable = false, precision = 10, scale = 2)
    private BigDecimal price;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Boolean getSoldSeperately() {
        return soldSeperately;
    }

    public void setSoldSeperately(Boolean soldSeperately) {
        this.soldSeperately = soldSeperately;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

}