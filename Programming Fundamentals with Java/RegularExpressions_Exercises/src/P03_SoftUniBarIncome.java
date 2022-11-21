import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class P03_SoftUniBarIncome {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String regex = "%(?<customer>[A-Z][a-z]*)%[^\\|\\$\\.\\%]*<(?<product>\\w+)>[^\\|\\$\\.\\%]*\\|(?<count>[0-9]+)\\|[^\\|\\$\\.\\%[0-9]]*(?<price>[0-9]+\\.?[0-9]*)\\$";
        Pattern pattern = Pattern.compile(regex);
        double totalIncome = 0.00;

        String input = scanner.nextLine();
        while(!input.equals("end of shift")) {
            Matcher validOrder = pattern.matcher(input);
            if(validOrder.find()) {
                String customer = validOrder.group("customer");
                String product = validOrder.group("product");
                int count = Integer.parseInt(validOrder.group("count"));
                double price = Double.parseDouble(validOrder.group("price"));
                double currPrice = price * count;
                totalIncome += currPrice;

                System.out.printf("%s: %s - %.2f%n", customer, product, currPrice);
            }
            input = scanner.nextLine();
        }
        System.out.printf("Total income: %.2f", totalIncome);
    }
}
