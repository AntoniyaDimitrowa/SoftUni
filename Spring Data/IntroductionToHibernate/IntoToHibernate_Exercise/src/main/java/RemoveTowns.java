import entities.Address;
import entities.Town;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.Scanner;

public class RemoveTowns {
    public static void main(String[] args) {
        final EntityManager em = Utils.createEntityManager();
        final Scanner scanner = new Scanner(System.in);
        final String inputTown = scanner.nextLine();

        em.getTransaction().begin();

        final Town townToBeRemoved = em.createQuery("FROM Town WHERE name = :townName", Town.class)
                .setParameter("townName", inputTown)
                .getSingleResult();

        final List<Address> addressesToBeRemoved = em.createQuery("FROM Address WHERE town.id = :townId", Address.class)
                .setParameter("townId", townToBeRemoved.getId())
                .getResultList();

        addressesToBeRemoved.forEach(a -> a.getEmployees()
                .forEach(e -> e.setAddress(null)));

        addressesToBeRemoved.forEach(a -> em.remove(a));
        em.remove(townToBeRemoved);

        System.out.printf("%d address%s in %s deleted",
                addressesToBeRemoved.size(),
                addressesToBeRemoved.size() == 1 ? "" : "es",
                inputTown);

        em.getTransaction().commit();
        em.close();
    }
}
