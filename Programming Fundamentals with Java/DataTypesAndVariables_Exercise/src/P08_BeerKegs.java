import java.util.Scanner;

public class P08_BeerKegs {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int beerKegsCount = Integer.parseInt(scanner.nextLine());
        String biggestKeg = "";
        double biggestBeerKegsVolume = 0.0;

        for (int i = 0; i < beerKegsCount; i++) {
            String model = scanner.nextLine();
            double radius = Double.parseDouble(scanner.nextLine());
            int height = Integer.parseInt(scanner.nextLine());
            double beerKegsVolume = Math.PI * radius * radius * height;
            if(biggestBeerKegsVolume < beerKegsVolume) {
                biggestBeerKegsVolume = beerKegsVolume;
                biggestKeg = model;
            }
        }
        System.out.println(biggestKeg);
    }
}
