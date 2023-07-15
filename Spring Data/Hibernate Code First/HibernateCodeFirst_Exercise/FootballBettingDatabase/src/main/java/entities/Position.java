package entities;

import javax.persistence.*;

@Entity
@Table(name = "positions")
public class Position {
    @Id
    @Column(length = 2)
    private String id;

    @Column
    private String description;
}
