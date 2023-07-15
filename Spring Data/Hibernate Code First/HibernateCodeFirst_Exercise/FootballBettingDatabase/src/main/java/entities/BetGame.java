package entities;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "bets_games")
public class BetGame implements Serializable {
    @Id
    @OneToOne
    private Game game;

    @Id
    @OneToOne
    private Bet bet;

    @OneToOne
    @JoinColumn
    private ResultPrediction resultPrediction;
}
