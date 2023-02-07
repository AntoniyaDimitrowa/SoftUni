package P02_CompanyRoster;

import java.util.Comparator;
import java.util.List;

import static java.lang.Double.compare;

public class Department {
    private String departmentName;
    private List<Employee> employees;

    private static double averageSalary;

    public String getName() {
        return departmentName;
    }

    public void setName(String name) {
        this.departmentName = name;
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }

    public Department(String departmentName, List<Employee> employees) {
        this.departmentName = departmentName;
        this.employees = employees;
    }

    public double getAverageSalary() {
        double sum = 0;

        for (int i = 0; i < this.employees.size(); i++) {
            sum += this.employees.get(i).getSalary();
        }
        return sum / this.employees.size();
    }

    public void printDepartment() {
        Comparator<Employee> employeeComparator = (emp1, emp2) -> compare(emp2.getSalary(), emp1.getSalary());;

        System.out.println(this.departmentName);
        this.employees
                .stream().sorted(employeeComparator)
                .forEach(emp -> emp.printEmployee());
    }
}
