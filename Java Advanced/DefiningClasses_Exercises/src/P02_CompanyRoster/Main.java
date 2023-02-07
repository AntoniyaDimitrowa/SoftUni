package P02_CompanyRoster;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static final Map<String, Department> departments = new HashMap<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int linesCount = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < linesCount; i++) {
            String[] input = scanner.nextLine().split("\\s+");
            createEmployee(input);
        }

        Department departmentWithHighestAvgSalary = findDepartmentWithHighestAvgSalary();
        System.out.print("Highest Average Salary: ");
        departmentWithHighestAvgSalary.printDepartment();
    }

    private static Department findDepartmentWithHighestAvgSalary() {
        double theHighestAvgSalary = Double.MIN_VALUE;
        String departmentNameWithHAS = "";
        for (Map.Entry<String, Department> entry : departments.entrySet()) {
            double currAvgSalary = entry.getValue().getAverageSalary();
            if(currAvgSalary > theHighestAvgSalary) {
                theHighestAvgSalary = currAvgSalary;
                departmentNameWithHAS = entry.getKey();
            }
        }
        return departments.get(departmentNameWithHAS);
    }

    private static void createEmployee(String[] input) {
        String name = input[0];
        double salary = Double.parseDouble(input[1]);
        String position = input[2];
        String department = input[3];

        Employee employee;
        if(input.length == 4) {
            employee = new Employee(name, salary, position, department);
        } else if(input.length == 6) {
            String email = input[4];
            int age = Integer.parseInt(input[5]);
            employee = new Employee(name, salary, position, department, email, age);
        } else {
            String param = input[4];
            if(param.contains("@")) {
                employee = new Employee(name, salary, position, department, param);
            } else {
                int age = Integer.parseInt(param);
                employee = new Employee(name, salary, position, department, age);
            }
        }

        if(departments.containsKey(department)) {
            Department currDepartment = departments.get(department);
            currDepartment.getEmployees().add(employee);
            departments.put(department, currDepartment);
        } else {
            Department currDepartment = new Department(department, new ArrayList<>());
            currDepartment.getEmployees().add(employee);
            departments.put(department, currDepartment);
        }
    }
}
