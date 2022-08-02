import java.util.Scanner;

public class P01OldBooks {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String favouriteBook = scanner.nextLine();
        String command = scanner.nextLine();
        int checkedBooksCounter = 0;

        while(!command.equals("No More Books")) {
            if(command.equals(favouriteBook)) {
                System.out.printf("You checked %d books and found it.", checkedBooksCounter);
                break;
            }
            checkedBooksCounter++;
            command = scanner.nextLine();
        }

        if(command.equals("No More Books")) {
            System.out.println("The book you search is not here!");
            System.out.printf("You checked %d books.", checkedBooksCounter);
        }
    }
}
