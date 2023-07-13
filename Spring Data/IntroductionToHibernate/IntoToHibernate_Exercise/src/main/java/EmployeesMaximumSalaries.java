public class EmployeesMaximumSalaries {
    public static void main(String[] args) {
        Utils.createEntityManager()
                .createQuery("SELECT department.name, MAX(salary) " +
                        "FROM Employee " +
                        "GROUP BY department.name " +
                        "HAVING MAX(salary) < 30000 OR MAX(salary) > 70000", Object[].class)
                .getResultList()
                .forEach(objects -> System.out.println(objects[0] + " " + objects[1]));
    }
}
