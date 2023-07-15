package entities;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name = "deposits")
public class Deposit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "deposit_group", length = 20)
    private String group;

    @Column(name = "start_date")
    private Date startDate;

    @Column(name = "amount", scale = 2, precision = 10)
    private BigDecimal amount;

    @Column(name = "interest", scale = 2, precision = 4)
    private BigDecimal interest;

    @Column(name = "charge", scale = 2, precision = 10)
    private BigDecimal charge;

    @Column(name = "expiration_date")
    private Date expirationDate;

    @Column(name = "is_deposit_expired")
    private boolean isDepositExpired;

    public Deposit() {}

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public BigDecimal getInterest() {
        return interest;
    }

    public void setInterest(BigDecimal interest) {
        this.interest = interest;
    }

    public BigDecimal getCharge() {
        return charge;
    }

    public void setCharge(BigDecimal charge) {
        this.charge = charge;
    }

    public Date getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(Date expirationDate) {
        this.expirationDate = expirationDate;
    }

    public boolean isDepositExpired() {
        return isDepositExpired;
    }

    public void setDepositExpired(boolean depositExpired) {
        isDepositExpired = depositExpired;
    }
}
