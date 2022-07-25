import java.util.Scanner;

public class P05Salary {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int tabsCount = Integer.parseInt(scanner.nextLine());
        double salary = Double.parseDouble(scanner.nextLine());

        for(int i = 1; i <= tabsCount; i++) {
            String tabType = scanner.nextLine();
            switch (tabType) {
                case "Facebook":
                    salary = salary - 150;
                    break;
                case "Instagram":
                    salary = salary - 100;
                    break;
                    case "Reddit":
                    salary = salary - 50;
                    break;
            }

            if(salary <= 0) {
                System.out.println("You have lost your salary.");
                break;
            }
        }

        if(salary > 0) {
            System.out.println((int)salary);
        }
    }
}
