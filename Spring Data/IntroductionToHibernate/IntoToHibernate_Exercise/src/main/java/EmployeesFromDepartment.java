import entities.Employee;

import javax.persistence.EntityManager;

public class EmployeesFromDepartment {
    public static void main(String[] args) {
        Utils.createEntityManager()
                .createQuery("FROM Employee WHERE department.name = 'Research and Development' ORDER BY salary, id",
                        Employee.class)
                .getResultList()
                .forEach(Employee::printFullNameDepNameAndSalary);
    }
}
