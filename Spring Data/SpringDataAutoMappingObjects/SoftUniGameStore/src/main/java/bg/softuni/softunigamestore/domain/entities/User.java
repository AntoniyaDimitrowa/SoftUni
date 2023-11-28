package bg.softuni.softunigamestore.domain.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import lombok.*;

import java.util.Set;

@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "users")
public class User extends BaseEntity {
    @Column(nullable = false, unique = true)
    @Email
    private String email;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false, length = 60)
    private String fullName;

    @Column(name = "is_admin",nullable = false)
    private boolean isAdmin;

    @ManyToMany(fetch = FetchType.EAGER)
    private Set<Game> games;

    @OneToMany(targetEntity = Order.class,
            mappedBy = "user",
            fetch = FetchType.EAGER)
    private Set<Order> orders;
}
