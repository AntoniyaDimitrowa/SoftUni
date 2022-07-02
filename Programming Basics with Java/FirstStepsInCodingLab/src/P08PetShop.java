import java.util.Scanner;

public class P08PetShop
{
    public static void main(String[] args) {
        Scanner scanner = new Scanner((System.in));

        int dogsFoodCount = Integer.parseInt(scanner.nextLine());
        int catsFoodCount = Integer.parseInt(scanner.nextLine());

        double result = (dogsFoodCount * 2.50) + (catsFoodCount * 4);
        System.out.println(result + " lv.");
    }
}
