import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class P01_Furniture {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<String> boughtFurniture = new ArrayList<>();
        double totalSum = 0.0;

        String regex = ">>(?<furniture>[A-Za-z]+)<<(?<price>[0-9]+\\.?[0-9]*)!(?<quantity>[0-9]+)";
        Pattern pattern = Pattern.compile(regex);

        String inputLine = scanner.nextLine();
        while (!inputLine.equals("Purchase")) {
            Matcher matcher = pattern.matcher(inputLine);
            if(matcher.find()) {
                String furniture = matcher.group("furniture");
                double price = Double.parseDouble(matcher.group("price"));
                int quantity = Integer.parseInt(matcher.group("quantity"));

                boughtFurniture.add(furniture);
                double currPrice = price * quantity;
                totalSum += currPrice;
            }
            inputLine = scanner.nextLine();
        }
        System.out.println("Bought furniture:");
        boughtFurniture.forEach(System.out::println);
        System.out.printf("Total money spend: %.2f", totalSum);
    }
}
