import java.util.Scanner;

public class P01_SmallestOfThreeNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num1 = Integer.parseInt(scanner.nextLine());
        int num2 = Integer.parseInt(scanner.nextLine());
        int num3 = Integer.parseInt(scanner.nextLine());
        System.out.println(getTheSmallestNum(num1, num2, num3));
    }

    public static int getTheSmallestNum(int num1, int num2, int num3) {
        int smallestNum = Integer.MAX_VALUE;
        int[] array = {num1, num2, num3};
        for (int i = 0; i < 3; i++) {
            if(smallestNum > array[i]) {
                smallestNum = array[i];
            }
        }
        return smallestNum;
    }
}
