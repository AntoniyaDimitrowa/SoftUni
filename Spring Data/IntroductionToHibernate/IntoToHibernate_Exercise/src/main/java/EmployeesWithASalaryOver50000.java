import entities.Employee;

import javax.persistence.EntityManager;

public class EmployeesWithASalaryOver50000 {
    public static void main(String[] args) {
        final EntityManager em = Utils.createEntityManager();
        em.getTransaction().begin();

        em.createQuery("FROM Employee WHERE salary > 50000", Employee.class)
                .getResultList()
                .forEach(e -> System.out.println(e.getFirstName()));

        em.getTransaction().commit();
        em.close();
    }
}
