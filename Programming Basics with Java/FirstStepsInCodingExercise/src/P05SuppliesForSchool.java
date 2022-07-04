import java.util.Scanner;

public class P05SuppliesForSchool {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int penPacksCount = Integer.parseInt(scanner.nextLine());
        int pencilPacksCount = Integer.parseInt(scanner.nextLine());
        int litersOfWhiteboardCleaner = Integer.parseInt(scanner.nextLine());
        int percentDiscount = Integer.parseInt(scanner.nextLine());

        double totalPenPrice = penPacksCount * 5.80;
        double totalPencilPrice = pencilPacksCount * 7.20;
        double totalWhiteboardCleanerPrice = litersOfWhiteboardCleaner * 1.20;
        double totalPriceWithoutDiscount = totalPenPrice + totalPencilPrice + totalWhiteboardCleanerPrice;
        double finalePrice = totalPriceWithoutDiscount - (totalPriceWithoutDiscount * percentDiscount / 100);

        System.out.println(finalePrice);
    }
}
