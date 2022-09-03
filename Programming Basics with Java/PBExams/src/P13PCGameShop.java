import java.util.Scanner;

public class P13PCGameShop {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int soldGamesCount = Integer.parseInt(scanner.nextLine());
        int soldHearthstones = 0;
        int soldFornites = 0;
        int soldOverwatches = 0;
        int soldOthers = 0;
        for(int i = 1; i <= soldGamesCount; i++) {
            String gameName = scanner.nextLine();

            switch (gameName) {
                case "Hearthstone":
                    soldHearthstones++;
                    break;
                case "Fornite":
                    soldFornites++;
                    break;
                case "Overwatch":
                    soldOverwatches++;
                    break;
                default:
                    soldOthers++;
                    break;
            }
        }

        System.out.printf("Hearthstone - %.2f%%%n", ((soldHearthstones * 1.0) / soldGamesCount) * 100);
        System.out.printf("Fornite - %.2f%%%n", ((soldFornites * 1.0) / soldGamesCount) * 100);
        System.out.printf("Overwatch - %.2f%%%n", ((soldOverwatches * 1.0) / soldGamesCount) * 100);
        System.out.printf("Others - %.2f%%%n", ((soldOthers * 1.0) / soldGamesCount) * 100);
    }
}
