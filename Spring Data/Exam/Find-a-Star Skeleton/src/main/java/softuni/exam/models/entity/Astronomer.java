package softuni.exam.models.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "astronomers")
public class Astronomer extends BaseEntity {
    @Column(name = "first_name", nullable = false)
    private String firstName;

    @Column(name = "last_name", nullable = false)
    private String lastName;

    @Column(nullable = false, columnDefinition = "DOUBLE")
    private Double salary;

    @Column(nullable = false, columnDefinition = "DOUBLE")
    private Double averageObservationHours;

    @Column(columnDefinition = "DATE")
    private Date birthday;

    @ManyToOne
    @JoinColumn(name = "observing_star_id")
    private Star observingStar;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    public Double getAverageObservationHours() {
        return averageObservationHours;
    }

    public void setAverageObservationHours(Double averageObservationHours) {
        this.averageObservationHours = averageObservationHours;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public Star getObservingStar() {
        return observingStar;
    }

    public void setObservingStar(Star observingStar) {
        this.observingStar = observingStar;
    }
}
