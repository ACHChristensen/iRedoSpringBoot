package dk.iredo.marketplace.model;

import jakarta.persistence.*;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.time.Instant;

@Entity
@Table(name = "user_blocks", schema = "marketplace_core", indexes = {
        @Index(name = "idx_user_id", columnList = "user_id"),
        @Index(name = "idx_blocked_user_id", columnList = "blocked_user_id")
}, uniqueConstraints = {
        @UniqueConstraint(name = "uniq_user_block", columnNames = {"user_id", "blocked_user_id"})
})
public class UserBlock {
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
    @JoinColumn(name = "blocked_user_id", nullable = false)
    private User blockedUser;

    @ColumnDefault("CURRENT_TIMESTAMP")
    @Column(name = "blocked_at")
    private Instant blockedAt;

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

    public User getBlockedUser() {
        return blockedUser;
    }

    public void setBlockedUser(User blockedUser) {
        this.blockedUser = blockedUser;
    }

    public Instant getBlockedAt() {
        return blockedAt;
    }

    public void setBlockedAt(Instant blockedAt) {
        this.blockedAt = blockedAt;
    }

}