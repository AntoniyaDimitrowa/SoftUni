import java.util.Scanner;

public class P08BasketballEquipment {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int tax = Integer.parseInt(scanner.nextLine());
        double sneakersPrice = tax - (tax * 0.4);
        double outfitPrice = sneakersPrice - (sneakersPrice * 0.2);
        double bollPrice = outfitPrice/4;
        double accessoriesPrice = bollPrice/5;

        double totalPrice = tax + sneakersPrice + outfitPrice + bollPrice + accessoriesPrice;
        System.out.println(totalPrice);
    }
}
