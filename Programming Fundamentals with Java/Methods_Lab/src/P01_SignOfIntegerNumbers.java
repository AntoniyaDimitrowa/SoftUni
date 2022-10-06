import java.util.Scanner;

public class P01_SignOfIntegerNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = Integer.parseInt(scanner.nextLine());
        printSign(num);
    }
    public static void printSign(int num) {
        if(num < 0) {
            System.out.printf("The number %d is negative.", num);
        } else if(num > 0){
            System.out.printf("The number %d is positive.", num);
        } else {
            System.out.printf("The number %d is zero.", num);
        }
    }
}
