package bg.softuni.productshop.domain.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Setter
@Getter
@NoArgsConstructor
@Entity
@Table(name = "users")
public class User extends BaseEntity {
    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name", nullable = false)
    private String lastName;

    @Column
    private Integer age;

    @OneToMany(targetEntity = Product.class,
            mappedBy = "seller",
            fetch = FetchType.EAGER)
    private Set<Product> sellingProducts;

    @OneToMany(targetEntity = Product.class,
            mappedBy = "buyer",
            fetch = FetchType.EAGER)
    private Set<Product> boughtProducts;

    @ManyToMany
    private Set<User> friends;
}
