import entities.Employee;

import java.util.Scanner;

public class GetEmployeesWithProject {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int inputId = Integer.parseInt(scanner.nextLine());

        Utils.createEntityManager()
                .createQuery("FROM Employee WHERE id = :id", Employee.class)
                .setParameter("id", inputId)
                .getSingleResult()
                .printFullNameJobTitleAndProjects();
    }
}
