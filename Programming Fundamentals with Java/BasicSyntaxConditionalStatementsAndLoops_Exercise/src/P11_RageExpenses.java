import java.util.Scanner;

public class P11_RageExpenses {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int lostGamesCount = Integer.parseInt(scanner.nextLine());
        double headsetPrice = Double.parseDouble(scanner.nextLine());
        double mousePrice = Double.parseDouble(scanner.nextLine());
        double keyboardPrice = Double.parseDouble(scanner.nextLine());
        double displayPrice = Double.parseDouble(scanner.nextLine());

        int trashedHeadsets = 0;
        int trashedMice = 0;
        int trashedKeyboards = 0;
        int trashedDisplays = 0;
        int keyboardsCount = 0;

        for(int i = 1; i <= lostGamesCount; i++){
            if(i % 2 == 0 && i % 3 == 0) {
                trashedHeadsets++;
                trashedMice++;
                trashedKeyboards++;
                keyboardsCount = trashedKeyboards;
            } else if(i % 2 == 0) {
                trashedHeadsets++;
            } else if(i % 3 == 0) {
                trashedMice++;
            }

            if(keyboardsCount % 2 == 0 && keyboardsCount != 0) {
                trashedDisplays++;
                keyboardsCount = 0;
            }
        }

        double expenses = (trashedDisplays * displayPrice) + (trashedHeadsets * headsetPrice) + (trashedKeyboards * keyboardPrice) + (trashedMice * mousePrice);
        System.out.printf("Rage expenses: %.2f lv.", expenses);
    }
}
