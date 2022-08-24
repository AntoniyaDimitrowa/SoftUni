import java.util.Scanner;

public class P07SafePasswordsGenerator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int a = Integer.parseInt(scanner.nextLine());
        int b = Integer.parseInt(scanner.nextLine());
        int generatedPasswordsMaximum = Integer.parseInt(scanner.nextLine());

        char first = 35;
        char second = 64;
        for(int x = 1; x <= a; x++) {
            for(int y = 1; y <= b; y++) {
                System.out.printf("%c%c%d%d%c%c|", first, second, x, y, second, first);
                generatedPasswordsMaximum--;
                first++;
                if(first == 56) {
                    first = 35;
                }
                second++;
                if(second == 97) {
                    second = 64;
                }
                if(generatedPasswordsMaximum == 0) {
                    break;
                }
            }
            if(generatedPasswordsMaximum == 0) {
                break;
            }
        }
    }
}
