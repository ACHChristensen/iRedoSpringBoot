package dk.iredo.marketplace.rest.data.domain;

import jakarta.persistence.*;

@Entity
@Table(name = "user_roles", schema = "marketplace_core", uniqueConstraints = {
        @UniqueConstraint(name = "role", columnNames = {"role"})
})
public class UserRole {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;
    
    @Column(name = "role", nullable = false)
    private String role;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

}