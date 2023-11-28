package bg.softuni.cardealer.domain.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
@NoArgsConstructor
@Entity
@Table(name = "suppliers")
public class Supplier extends BaseEntity {
    @Column(nullable = false)
    private String name;

    @Column(name = "is_importer", nullable = false)
    private boolean isImporter;

    @OneToMany(targetEntity = Part.class,
            mappedBy = "supplier",
            fetch = FetchType.EAGER)
    private List<Part> parts;
}
