import entities.Employee;

import javax.persistence.EntityManager;
import java.util.Scanner;

public class ContainsEmployee {
    public static void main(String[] args) {
        final EntityManager em = Utils.createEntityManager();

        Scanner scanner = new Scanner(System.in);
        String inputName = scanner.nextLine();

        em.getTransaction().begin();

        try {
            final Employee employee = em.createQuery("FROM Employee WHERE CONCAT_WS(' ', first_name, last_name) = :fullName", Employee.class)
                    .setParameter("fullName", inputName)
                    .getSingleResult();

            em.getTransaction().commit();
            System.out.println("Yes");

        } catch (Exception e) {
            System.out.println("No");
        }

        em.close();
    }
}
