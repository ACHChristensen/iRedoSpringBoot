package dk.iredo.marketplace.rest.data.domain;

import jakarta.persistence.*;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.time.Instant;

@Entity
@Table(name = "interested_buyers", schema = "marketplace_core", indexes = {
        @Index(name = "idx_user_listing", columnList = "user_id, listing_id"),
        @Index(name = "idx_user_id", columnList = "user_id"),
        @Index(name = "idx_listing_id", columnList = "listing_id")
}, uniqueConstraints = {
        @UniqueConstraint(name = "uniq_user_listing", columnNames = {"user_id", "listing_id"})
})
public class InterestedBuyer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "listing_id", nullable = false)
    private Listing listing;

    @ColumnDefault("CURRENT_TIMESTAMP")
    @Column(name = "time_registered")
    private Instant timeRegistered;

    @ColumnDefault("CURRENT_TIMESTAMP")
    @Column(name = "updated_at")
    private Instant updatedAt;

    @Lob
    @Column(name = "buyers_comments")
    private String buyersComments;

    @ColumnDefault("1")
    @Column(name = "amount_to_buy", nullable = false)
    private Integer amountToBuy;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Listing getListing() {
        return listing;
    }

    public void setListing(Listing listing) {
        this.listing = listing;
    }

    public Instant getTimeRegistered() {
        return timeRegistered;
    }

    public void setTimeRegistered(Instant timeRegistered) {
        this.timeRegistered = timeRegistered;
    }

    public Instant getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Instant updatedAt) {
        this.updatedAt = updatedAt;
    }

    public String getBuyersComments() {
        return buyersComments;
    }

    public void setBuyersComments(String buyersComments) {
        this.buyersComments = buyersComments;
    }

    public Integer getAmountToBuy() {
        return amountToBuy;
    }

    public void setAmountToBuy(Integer amountToBuy) {
        this.amountToBuy = amountToBuy;
    }

}