package dk.iredo.marketplace.rest.data.domain;

import jakarta.persistence.*;
import org.hibernate.annotations.ColumnDefault;

import java.time.Instant;

@Entity
@Table(name = "user_follows", schema = "marketplace_corev3", indexes = {
        @Index(name = "idx_user_id", columnList = "user_id"),
        @Index(name = "idx_followed_user_id", columnList = "followed_user_id")
}, uniqueConstraints = {
        @UniqueConstraint(name = "uniq_user_follow", columnNames = {"user_id", "followed_user_id"})
})
public class UserFollow {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @ColumnDefault("CURRENT_TIMESTAMP")
    @Column(name = "created_at")
    private Instant createdAt;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Instant getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Instant createdAt) {
        this.createdAt = createdAt;
    }

}