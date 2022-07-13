import java.util.Scanner;

public class P07Shopping {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double petersBudget = Double.parseDouble(scanner.nextLine());
        int numberOfVideoCards = Integer.parseInt(scanner.nextLine());
        int numberOfProcessors = Integer.parseInt(scanner.nextLine());
        int numberOfRAMMemory = Integer.parseInt(scanner.nextLine());
        double videoCardsPrice = numberOfVideoCards * 250;
        double processorsPrice = numberOfProcessors * (0.35*videoCardsPrice);
        double RAMMemoryPrice = numberOfRAMMemory * (0.1 * videoCardsPrice);
        double totalPrice = videoCardsPrice + processorsPrice + RAMMemoryPrice; ;

        if(numberOfVideoCards>numberOfProcessors)
        {
            totalPrice = totalPrice - 0.15 * totalPrice;
        }

        if(petersBudget >= totalPrice)
        {
            System.out.printf("You have %.2f leva left!", petersBudget - totalPrice);
        }
        else
        {
            System.out.printf("Not enough money! You need %.2f leva more!", totalPrice - petersBudget);
        }
    }
}
