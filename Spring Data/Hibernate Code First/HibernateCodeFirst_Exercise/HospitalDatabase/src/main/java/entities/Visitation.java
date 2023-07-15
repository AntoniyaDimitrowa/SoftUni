package entities;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "visitations")
public class Visitation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false)
    private Date date;

    @Column(columnDefinition = "TEXT")
    private String comments;

    @OneToOne
    private Diagnose diagnose;

    @OneToMany
    private List<Medicament> medicaments;

    @ManyToOne
    private Patient patient;

    public Visitation() {}

    public Visitation(Date date, Diagnose diagnose, List<Medicament> medicaments) {
        this.date = date;
        this.diagnose = diagnose;
        this.medicaments = medicaments;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public Diagnose getDiagnose() {
        return diagnose;
    }

    public void setDiagnose(Diagnose diagnose) {
        this.diagnose = diagnose;
    }

    public List<Medicament> getMedicaments() {
        return medicaments;
    }

    public void setMedicaments(List<Medicament> medicaments) {
        this.medicaments = medicaments;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }
}
