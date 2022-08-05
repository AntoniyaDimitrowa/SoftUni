import java.util.Scanner;

public class P04SumOfTwoNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int intervalBeginning = Integer.parseInt(scanner.nextLine());
        int intervalEnd = Integer.parseInt(scanner.nextLine());
        int magicalNum = Integer.parseInt(scanner.nextLine());
        int combinationsCount = 0;
        boolean isFound = false;

        for(int x1 = intervalBeginning; x1 <= intervalEnd; x1++) {
            for(int x2 = intervalBeginning; x2 <= intervalEnd; x2++) {
                combinationsCount++;
                if(x1 + x2 == magicalNum) {
                    isFound = true;
                    System.out.printf("Combination N:%d (%d + %d = %d)", combinationsCount, x1, x2, magicalNum);
                    break;
                }
            }
            if(isFound) {
                break;
            }
        }
        if (isFound == false)
        {
            System.out.printf("%d combinations - neither equals %d", combinationsCount, magicalNum);
        }
    }
}
