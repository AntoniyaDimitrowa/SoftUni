import entities.Employee;

import javax.persistence.EntityManager;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.List;

public class IncreaseSalaries {
    private static final List<String> DEPARTMENT_NAMES =
            List.of("Engineering",
                    "Tool Design",
                    "Marketing",
                    "Information Services");

    public static void main(String[] args) {
        final EntityManager em = Utils.createEntityManager();
        em.getTransaction().begin();

        final List<Employee> employees = em.createQuery("FROM Employee WHERE department.name IN (:departments)", Employee.class)
                .setParameter("departments", DEPARTMENT_NAMES)
                .getResultList();

//        for (Employee e : employees) {
//            e.setSalary(e.getSalary().multiply(BigDecimal.valueOf(1.12)));
//        }
//
//        em.flush();
        em.getTransaction().commit();
        em.close();

        employees.forEach(Employee::printFullNameAndSalary);
    }
}
