import java.util.Scanner;

public class P04CarToGo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double budget = Double.parseDouble(scanner.nextLine());
        String season = scanner.nextLine();
        String[] carType = {"Cabrio", "Jeep"};
        String[] classType = {"Economy class", "Compact class", "Luxury class"};
        int carTypeIndex = 0;
        int classTypeIndex = 0;
        double price = 0.0;

        if(budget <= 100) {
            classTypeIndex = 0;
            switch (season) {
                case "Summer":
                    price = budget * 0.35;
                    carTypeIndex = 0;
                    break;
                case "Winter":
                    price = budget * 0.65;
                    carTypeIndex = 1;
                    break;
            }
        } else if(budget <= 500) {
            classTypeIndex = 1;
            switch (season) {
                case "Summer":
                    price = budget * 0.45;
                    carTypeIndex = 0;
                    break;
                case "Winter":
                    price = budget * 0.80;
                    carTypeIndex = 1;
                    break;
            }
        } else {
            classTypeIndex = 2;
            carTypeIndex = 1;
            price = budget * 0.90;
        }

        System.out.println(classType[classTypeIndex]);
        System.out.printf("%s - %.2f", carType[carTypeIndex], price);
    }
}
