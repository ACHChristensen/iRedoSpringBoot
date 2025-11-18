package dk.iredo.marketplace.rest.data.domain;

import jakarta.persistence.*;
import org.hibernate.annotations.ColumnDefault;

import java.time.Instant;

@Entity
@Table(name = "user_blocks", schema = "marketplace_corev3", indexes = {
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

    @ColumnDefault("CURRENT_TIMESTAMP")
    @Column(name = "blocked_at")
    private Instant blockedAt;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Instant getBlockedAt() {
        return blockedAt;
    }

    public void setBlockedAt(Instant blockedAt) {
        this.blockedAt = blockedAt;
    }

}