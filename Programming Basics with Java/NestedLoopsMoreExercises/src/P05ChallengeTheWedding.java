import java.util.Scanner;

public class P05ChallengeTheWedding {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int maleCustomers = Integer.parseInt(scanner.nextLine());
        int femaleCustomers = Integer.parseInt(scanner.nextLine());
        int tables = Integer.parseInt(scanner.nextLine());

        int table = 0;
        for(int male = 1; male <= maleCustomers; male++) {
            for(int female = 1; female <= femaleCustomers; female++) {
                System.out.printf("(%d <-> %d) ", male, female);
                table++;
                if(table == tables) {
                    break;
                }
            }
            if(table == tables) {
                break;
            }
        }

    }
}
