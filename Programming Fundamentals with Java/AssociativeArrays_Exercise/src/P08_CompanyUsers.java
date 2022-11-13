import java.util.*;

public class P08_CompanyUsers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        LinkedHashMap<String, List<String>> companies = new LinkedHashMap<>();
        String[] command = scanner.nextLine().split(" -> ");

        while (!command[0].equals("End")) {
            String companyName = command[0];
            String employeeId = command[1];

            if(companies.containsKey(companyName)) {
                if(!companies.get(companyName).contains(employeeId)) {
                    List<String> employees = new ArrayList<>(List.copyOf(companies.get(companyName)));
                    employees.add(employeeId);
                    companies.put(companyName, employees);
                }
            } else {
                List<String> employees = new ArrayList<>();
                employees.add(employeeId);
                companies.put(companyName, employees);
            }
            command = scanner.nextLine().split(" -> ");
        }

        for (Map.Entry<String, List<String>> entry : companies.entrySet()) {
            System.out.println(entry.getKey());
            for (int i = 0; i < entry.getValue().size(); i++) {
                System.out.printf("-- %s%n", entry.getValue().get(i));
            }
        }
    }
}
