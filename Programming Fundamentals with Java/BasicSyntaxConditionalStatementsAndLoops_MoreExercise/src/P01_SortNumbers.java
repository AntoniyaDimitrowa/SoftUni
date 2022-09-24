import java.util.Scanner;

public class P01_SortNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num1 = Integer.parseInt(scanner.nextLine());
        int num2 = Integer.parseInt(scanner.nextLine());
        int num3 = Integer.parseInt(scanner.nextLine());

        for(int i = 0; i < 3; i++) {
            if(num1 > num2) {
                if(num1 > num3) {
                    System.out.println(num1);
                    num1 = Integer.MIN_VALUE;
                } else {
                    System.out.println(num3);
                    num3 = Integer.MIN_VALUE;
                }
            } else {
                if(num2 > num3) {
                    System.out.println(num2);
                    num2 = Integer.MIN_VALUE;
                } else {
                    System.out.println(num3);
                    num3 = Integer.MIN_VALUE;
                }
            }

        }
    }
}
