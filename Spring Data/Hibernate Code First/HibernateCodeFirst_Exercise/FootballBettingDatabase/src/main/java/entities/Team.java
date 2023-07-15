package entities;

import entities.enums.TeamShortName;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "teams")
public class Team {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false)
    private String name;

    @Column
    private String logo;

    @Column
    @Enumerated(EnumType.STRING)
    private TeamShortName shortName;

    @ManyToOne
    @JoinColumn
    private Color primaryColor;

    @ManyToOne
    @JoinColumn
    private Color secondaryColor;

    @ManyToOne
    private Town homeTown;

    @Column
    private BigDecimal budget;
}
