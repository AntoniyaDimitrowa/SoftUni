package entities;

import javax.persistence.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "patients")
public class Patient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "first_name", nullable = false, length = 50)
    private String firstName;

    @Column(name = "last_name", nullable = false, length = 50)
    private String lastName;

    @Column(length = 60)
    private String address;

    @Column(length = 60)
    private String email;

    @Column(name = "date_of_birth")
    private Date dateOfBirth;

    @Column(name = "has_medical_insurance")
    private boolean hasMedicalInsurance;

    @OneToMany(targetEntity = Visitation.class,
            mappedBy = "patient",
            fetch = FetchType.EAGER)
    private List<Visitation> visitations;

    public Patient() {
    }

    public Patient(String firstName, String lastName, String address, String email, Date dateOfBirth, boolean hasMedicalInsurance) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.email = email;
        this.dateOfBirth = dateOfBirth;
        this.hasMedicalInsurance = hasMedicalInsurance;
        this.visitations = new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public boolean isHasMedicalInsurance() {
        return hasMedicalInsurance;
    }

    public void setHasMedicalInsurance(boolean hasMedicalInsurance) {
        this.hasMedicalInsurance = hasMedicalInsurance;
    }

    public List<Visitation> getVisitations() {
        return visitations;
    }

    public void setVisitations(List<Visitation> visitations) {
        this.visitations = visitations;
    }
}
