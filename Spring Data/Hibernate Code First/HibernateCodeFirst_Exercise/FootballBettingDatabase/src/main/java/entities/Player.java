package entities;

import javax.persistence.*;

@Entity
@Table(name = "players")
public class Player {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false)
    private String name;

    @Column(name = "squad_number")
    private Integer squadNumber;

    @ManyToOne
    private Team team;

    @ManyToOne
    private Position position;

    @Column(name = "is_currently_injured")
    private Boolean isCurrentlyInjured;

}
