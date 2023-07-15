package entities;

import javax.persistence.*;

@Entity
@Table(name = "continent")
public class Continent {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false, unique = true)
    private String name;
}
