import java.util.Scanner;

public class P04CinemaVoucher {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int voucherValue = Integer.parseInt(scanner.nextLine());
        String command = scanner.nextLine();
        int price = 0;
        int ticketsCount = 0;
        int othersCount = 0;

        while(!command.equals("End")) {
            char firstSymbol = command.charAt(0);
            char secondSymbol = command.charAt(1);
            if(command.length() > 8) {
                price = price + (int)firstSymbol + (int)secondSymbol;
                if(price > voucherValue) {
                    break;
                }
                ticketsCount++;
            } else {
                price = price + (int)firstSymbol;
                if(price > voucherValue) {
                    break;
                }
                othersCount++;
            }

            command = scanner.nextLine();
        }
        System.out.printf("%d%n",ticketsCount);
        System.out.printf("%d", othersCount);
    }
}
