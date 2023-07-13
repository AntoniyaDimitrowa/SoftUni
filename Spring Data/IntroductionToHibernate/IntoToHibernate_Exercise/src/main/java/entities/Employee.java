package entities;

import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.text.DecimalFormat;
import java.time.LocalDateTime;
import java.util.Comparator;
import java.util.Set;

@Entity
@Table(name = "employees")
public class Employee {
    private Integer id;
    private String firstName;
    private String lastName;
    private String middleName;
    private String jobTitle;
    private Department department;
    private Employee manager;
    private LocalDateTime hireDate;
    private BigDecimal salary;
    private Address address;
    private Set<Project> projects;

    private static final DecimalFormat DECIMAL_FORMAT_FOR_SALARY = new DecimalFormat("#.00");

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "employee_id")
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Column(name = "first_name")
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @Column(name = "last_name")
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Column(name = "middle_name")
    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    @Column(name = "job_title")
    public String getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    @ManyToOne
    @JoinColumn(name = "department_id", referencedColumnName = "department_id")
    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    @ManyToOne
    @JoinColumn(name = "manager_id", referencedColumnName = "employee_id")
    public Employee getManager() {
        return manager;
    }

    public void setManager(Employee manager) {
        this.manager = manager;
    }

    @Column(name = "hire_date")
    public LocalDateTime getHireDate() {
        return hireDate;
    }

    public void setHireDate(LocalDateTime hireDate) {
        this.hireDate = hireDate;
    }

    @Column(name = "salary")
    public BigDecimal getSalary() {
        return salary;
    }

    public void setSalary(BigDecimal salary) {
        this.salary = salary;
    }

    @ManyToOne
    @JoinColumn(name = "address_id", referencedColumnName = "address_id")
    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    @ManyToMany
    @JoinTable(name = "employees_projects",
            joinColumns = @JoinColumn(name = "employee_id", referencedColumnName = "employee_id"),
            inverseJoinColumns = @JoinColumn(name = "project_id", referencedColumnName = "project_id"))
    public Set<Project> getProjects() {
        return projects;
    }

    public void setProjects(Set<Project> projects) {
        this.projects = projects;
    }

    public void printFullNameDepNameAndSalary() {
        System.out.println(String.format("%s %s from %s - $%s",
                this.getFirstName(),
                this.getLastName(),
                this.getDepartment().getName(),
                this.getSalary()));
    }

    public void printFullNameJobTitleAndProjects() {
        System.out.printf("%s %s - %s",
                this.getFirstName(),
                this.getLastName(),
                this.getJobTitle());
        System.out.println();
        this.getProjects().stream()
                .sorted(Comparator.comparing(Project::getName))
                .forEach(p -> System.out.println("\t" + p.getName()));

    }

    public void printFullNameAndSalary() {
        String formattedSalary = DECIMAL_FORMAT_FOR_SALARY.format(this.getSalary());
        System.out.printf("%s %s ($%s)",
                this.getFirstName(),
                this.getLastName(),
                formattedSalary);

        System.out.println();
    }
    public void printFullNameJobTitleAndSalary() {
        String formattedSalary = DECIMAL_FORMAT_FOR_SALARY.format(this.getSalary());
        System.out.printf("%s %s - %s - ($%s)",
                this.getFirstName(),
                this.getLastName(),
                this.getJobTitle(),
                formattedSalary);

        System.out.println();
    }
}
