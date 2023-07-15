package entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.math.BigDecimal;
import java.util.List;

@Entity
@Table(name = "teachers")
public class Teacher extends Person {
    @Column(length = 60)
    private BigDecimal email;

    @Column(name = "salary_per_hour", scale = 2, precision = 3)
    private BigDecimal salaryPerHour;

    @OneToMany(targetEntity = Course.class, mappedBy = "teacher")
    private List<Course> courses;

    public Teacher() {super();}

    public BigDecimal getEmail() {
        return email;
    }

    public void setEmail(BigDecimal email) {
        this.email = email;
    }

    public BigDecimal getSalaryPerHour() {
        return salaryPerHour;
    }

    public void setSalaryPerHour(BigDecimal salaryPerHour) {
        this.salaryPerHour = salaryPerHour;
    }

    public List<Course> getCourses() {
        return courses;
    }

    public void setCourses(List<Course> courses) {
        this.courses = courses;
    }
}
