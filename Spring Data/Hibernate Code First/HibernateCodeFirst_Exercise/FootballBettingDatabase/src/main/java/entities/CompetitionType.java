package entities;

import javax.persistence.*;

@Entity@Table(name = "competition_types")
public class CompetitionType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false)
    private String name;
}
