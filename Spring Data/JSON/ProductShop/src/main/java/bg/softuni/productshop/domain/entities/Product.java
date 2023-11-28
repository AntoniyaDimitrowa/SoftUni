package bg.softuni.productshop.domain.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.Set;

@Setter
@Getter
@NoArgsConstructor
@Entity
@Table(name = "products")
public class Product extends BaseEntity {
    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private BigDecimal price;

    @ManyToOne(fetch = FetchType.EAGER)
    private User buyer;

    @ManyToOne(fetch = FetchType.EAGER)
    private User seller;

    @ManyToMany(fetch = FetchType.EAGER)
    private Set<Category> categories;
}
