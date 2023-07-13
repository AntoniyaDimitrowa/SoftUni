import entities.Employee;

import java.util.Scanner;

public class FindEmployeesByFirstName {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String inputLetters = scanner.nextLine();

        Utils.createEntityManager()
                .createQuery("FROM Employee WHERE firstName LIKE CONCAT(:letters, '%')", Employee.class)
                .setParameter("letters", inputLetters)
                .getResultList()
                .forEach(Employee::printFullNameJobTitleAndSalary);
    }
}
