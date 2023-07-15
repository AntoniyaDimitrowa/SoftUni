package entities;

import javax.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class BillingDetails {
    @Id
    @Column(unique = true, length = 30)
    private String number;

    @ManyToOne
    private User owner;
}
