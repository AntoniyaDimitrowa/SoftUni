import entities.Address;
import entities.Employee;
import entities.Town;

import javax.persistence.EntityManager;
import java.util.Scanner;
import java.util.Set;

public class AddingANewAddressAndUpdatingTheEmployee {
    public static void main(String[] args) {
        final EntityManager em = Utils.createEntityManager();

        final Scanner scanner = new Scanner(System.in);
        final String inputLastName = scanner.nextLine();

        em.getTransaction().begin();

        final Town town = em.createQuery("FROM Town WHERE id = 32", Town.class).getSingleResult();

        Address newAddress = new Address();
        newAddress.setText("Vitoshka 15");
        newAddress.setTown(town);

        em.persist(newAddress);

        final Set<Employee> employees = Set.copyOf(em
                .createQuery("FROM Employee WHERE lastName = :lastName", Employee.class)
                .setParameter("lastName", inputLastName)
                .getResultList());

        employees.forEach(e -> e.setAddress(newAddress));

        em.flush();
        em.getTransaction().commit();
        em.close();
    }
}
