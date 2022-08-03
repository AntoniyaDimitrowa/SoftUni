import java.util.Scanner;

public class P07Moving {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int width = Integer.parseInt(scanner.nextLine());
        int length = Integer.parseInt(scanner.nextLine());
        int height = Integer.parseInt(scanner.nextLine());
        int emptyArea = length * width * height;
        String command = scanner.nextLine();

        while(!command.equals("Done")) {
            int currBoxesCount = Integer.parseInt(command);
            emptyArea -= currBoxesCount;

            if(emptyArea < 0) {
                System.out.printf("No more free space! You need %d Cubic meters more.", Math.abs(emptyArea));
                break;
            }
            command = scanner.nextLine();
        }

        if(command.equals("Done")) {
            System.out.printf("%d Cubic meters left.", emptyArea);
        }
    }
}
