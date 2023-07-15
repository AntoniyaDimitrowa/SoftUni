package entities.composition;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "companies")
public class Company {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Basic
    private String name;

    @OneToMany(targetEntity = CompositionPlane.class,
            mappedBy = "company",
            fetch = FetchType.EAGER,
            cascade = CascadeType.ALL)
    private List<CompositionPlane> planes;

    public Company() {}

    public Company(String name) {
        this.name = name;
        this.planes = new ArrayList<>();
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<CompositionPlane> getPlanes() {
        return planes;
    }

    public void setPlanes(List<CompositionPlane> planes) {
        this.planes = planes;
    }
}
