package entities;

import entities.enums.ResultPredictionValue;

import javax.persistence.*;

@Entity
@Table(name = "result_predictions")
public class ResultPrediction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Enumerated(EnumType.STRING)
    private ResultPredictionValue resultPrediction;
}
