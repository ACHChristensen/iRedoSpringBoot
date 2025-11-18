package dk.iredo.marketplace.rest.data.domain;

import jakarta.persistence.*;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.time.Instant;

@Entity
@Table(name = "wishlist_items", schema = "marketplace_corev5", indexes = {
        @Index(name = "idx_wishlist_id", columnList = "wishlist_id"),
        @Index(name = "idx_listing_id", columnList = "listing_id")
}, uniqueConstraints = {
        @UniqueConstraint(name = "uniq_wishlist_listing", columnNames = {"wishlist_id", "listing_id"})
})
public class WishlistItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "wishlist_id", nullable = false)
    private Wishlist wishlist;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "listing_id", nullable = false)
    private Listing listing;

    @ColumnDefault("CURRENT_TIMESTAMP")
    @Column(name = "added_at", columnDefinition = "TIMESTAMP")
    private Instant addedAt;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Wishlist getWishlist() {
        return wishlist;
    }

    public void setWishlist(Wishlist wishlist) {
        this.wishlist = wishlist;
    }

    public Listing getListing() {
        return listing;
    }

    public void setListing(Listing listing) {
        this.listing = listing;
    }

    public Instant getAddedAt() {
        return addedAt;
    }

    public void setAddedAt(Instant addedAt) {
        this.addedAt = addedAt;
    }

}