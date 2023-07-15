import databaseOperations.Adding;
import databaseOperations.Deleting;
import databaseOperations.Finding;
import databaseOperations.Updating;
import entities.Patient;
import entities.Visitation;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Write add, delete, update or find");
        String operation = scanner.nextLine();

        EntityManager em = Persistence
                .createEntityManagerFactory("hospital")
                .createEntityManager();
        em.getTransaction().begin();
        if(operation.equals("add")) {
            add(scanner);
        } else if(operation.equals("find")) {
            System.out.println("Write Patient or Visitation");
            String input = scanner.nextLine();
            if(input.equals("Patient")) {
                Patient patient = findPatient(scanner);
                System.out.println(patient);
            } else if(input.equals("Visitation")) {
                List<Visitation> visitation = findVisitation(scanner);
                visitation.forEach(System.out::println);
            } else {
                throw new IllegalArgumentException("Error");
            }
        } else if(operation.equals("delete")) {
            System.out.println("Write info about patient");
            String info = scanner.nextLine();
            Deleting.deletePatientByFullNameAndBirthDate(info);
        } else if (operation.equals("update")) {
            update(scanner);
        } else {
            throw new IllegalArgumentException("Error");
        }


        em.getTransaction().commit();
    }

    private static void add(Scanner scanner) {
        System.out.println("Write Patient or Visitation");
        String input = scanner.nextLine();
        if(input.equals("Patient")) {
            System.out.println("Write info about patient");
            String info = scanner.nextLine();
            Adding.addPatient(info);
        } else if(input.equals("Visitation")) {
            System.out.println("Write patient full name and date of birth(Ivan Ivanov 01.12.2004)");
            String patientInfo = scanner.nextLine();
            System.out.println("Write info about visitation");
            String visitationInfo = scanner.nextLine();
            Adding.addVisitation(visitationInfo, patientInfo);
        } else {
            throw new IllegalArgumentException("Error");
        }
    }

    private static Patient findPatient (Scanner scanner) {
        System.out.println("Write patient full name and date of birth(Ivan Ivanov 01.12.2004)");
        String info = scanner.nextLine();
        return Finding.findPatientByFullNameAndBirthDate(info);
    }

    private static List<Visitation> findVisitation (Scanner scanner) {
        System.out.println("Write date of visitations");
        String date = scanner.nextLine();
        return Finding.findVisitationsByDate(date);
    }

    private static void update(Scanner scanner) {
        System.out.println("Write Patient, Visitation, Diagnose or Medicament");
        String input = scanner.nextLine();
        if(input.equals("Patient")) {
            System.out.println("Write info about patient");
            String info = scanner.nextLine();
            Updating.updatePatient(info);
        } else if(input.equals("Visitation")) {
            System.out.println("Write info about visitation");
            String info = scanner.nextLine();
            Updating.updateVisitation(info);
        } else if(input.equals("Diagnose")) {
            System.out.println("Write info about diagnose");
            String info = scanner.nextLine();
            Updating.updateDiagnose(info);
        } else if(input.equals("Medicament")) {
            System.out.println("Write the old name of the medicament");
            String oldName = scanner.nextLine();
            System.out.println("Write the new name of the medicament");
            String newName = scanner.nextLine();
            Updating.updateMedicament(oldName, newName);
        } else {
            throw new IllegalArgumentException("Error");
        }
    }
}
