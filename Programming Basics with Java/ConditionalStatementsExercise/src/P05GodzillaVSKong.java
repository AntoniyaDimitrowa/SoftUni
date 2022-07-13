import java.util.Scanner;

public class P05GodzillaVSKong {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        double budget = Double.parseDouble(scanner.nextLine());
        int statistsCount = Integer.parseInt(scanner.nextLine());
        double priceForClothingOfOneStatist = Double.parseDouble(scanner.nextLine());

        double decor = budget * 0.1;
        double priceForAllClothing = statistsCount * priceForClothingOfOneStatist;

        if(statistsCount > 150){
            priceForAllClothing = priceForAllClothing - (priceForAllClothing*0.1);
        }

        if((decor + priceForAllClothing) > budget) {
            System.out.println("Not enough money!");
            System.out.printf("Wingard needs %.2f leva more.", (decor + priceForAllClothing) - budget);
        } else {
            System.out.println("Action!");
            System.out.printf("Wingard starts filming with %.2f leva left.", budget - (decor + priceForAllClothing));
        }
    }
}
