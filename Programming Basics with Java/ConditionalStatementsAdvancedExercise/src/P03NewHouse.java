import java.util.Scanner;

public class P03NewHouse {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String flowerType = scanner.nextLine();
        int numberOfFlowers = Integer.parseInt(scanner.nextLine());
        int budget = Integer.parseInt(scanner.nextLine());

        double priceWithoutDiscount = 0.0;
        double priceWithDiscount = 0.0;

        switch (flowerType) {
            case "Roses": priceWithoutDiscount = numberOfFlowers * 5.00;break;
            case "Dahlias": priceWithoutDiscount = numberOfFlowers * 3.80;break;
            case "Tulips": priceWithoutDiscount = numberOfFlowers * 2.80;break;
            case "Narcissus": priceWithoutDiscount = numberOfFlowers * 3.00;break;
            case "Gladiolus": priceWithoutDiscount = numberOfFlowers * 2.50;break;
        }

        if(numberOfFlowers>80 && flowerType.equals("Roses"))
        {
            priceWithDiscount = priceWithoutDiscount - priceWithoutDiscount * 0.10;
        }
        else if (numberOfFlowers > 90 && flowerType.equals("Dahlias"))
        {
            priceWithDiscount = priceWithoutDiscount - priceWithoutDiscount * 0.15;
        }
        else if (numberOfFlowers > 80 && flowerType.equals("Tulips"))
        {
            priceWithDiscount = priceWithoutDiscount - priceWithoutDiscount * 0.15;
        }
        else if (numberOfFlowers < 120 && flowerType.equals("Narcissus"))
        {
            priceWithDiscount = priceWithoutDiscount + priceWithoutDiscount * 0.15;
        }
        else if (numberOfFlowers < 80 && flowerType.equals("Gladiolus"))
        {
            priceWithDiscount = priceWithoutDiscount + priceWithoutDiscount * 0.2;
        }
        else { priceWithDiscount = priceWithoutDiscount; }

        if(priceWithDiscount > budget)
        {
            System.out.printf("Not enough money, you need %.2f leva more.", priceWithDiscount - budget);
        }
        else
        {
            System.out.printf("Hey, you have a great garden with %d %s and %.2f leva left.", numberOfFlowers, flowerType, budget - priceWithDiscount);
        }
    }
}
