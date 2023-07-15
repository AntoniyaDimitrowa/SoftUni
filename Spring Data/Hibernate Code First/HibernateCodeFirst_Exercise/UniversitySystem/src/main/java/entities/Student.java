package entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import java.math.BigDecimal;
import java.util.List;

@Entity
@Table(name = "students")
public class Student extends Person {

    @Column(name = "average_grade", nullable = false, scale = 2, precision = 3)
    private BigDecimal averageGrade;

    @Column(name = "attendance_count")
    private int attendanceCount;

    @ManyToMany(targetEntity = Course.class, mappedBy = "students")
    private List<Course> courses;

    public Student() {super();}

    public BigDecimal getAverageGrade() {
        return averageGrade;
    }

    public void setAverageGrade(BigDecimal averageGrade) {
        this.averageGrade = averageGrade;
    }

    public int getAttendanceCount() {
        return attendanceCount;
    }

    public void setAttendanceCount(int attendanceCount) {
        this.attendanceCount = attendanceCount;
    }

    public List<Course> getCourses() {
        return courses;
    }

    public void setCourses(List<Course> courses) {
        this.courses = courses;
    }
}
