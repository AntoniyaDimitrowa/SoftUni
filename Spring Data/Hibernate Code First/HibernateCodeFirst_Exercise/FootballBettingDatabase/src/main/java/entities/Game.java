package entities;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "games")
public class Game {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @OneToOne
    @JoinColumn
    private Team homeTeam;

    @OneToOne
    @JoinColumn
    private Team awayTeam;

    @Column
    private Short homeGoals;

    @Column
    private Short awayGoals;

    @Column
    private Date date;

    @Column
    private Double homeTeamWinBetRate;

    @Column
    private Double awayTeamWinBetRate;

    @Column
    private Double drawGameBetRate;

    // one to one || many to one
    @ManyToOne
    @JoinColumn
    private Round round;

    @ManyToOne
    @JoinColumn
    private Competition competition;
}
