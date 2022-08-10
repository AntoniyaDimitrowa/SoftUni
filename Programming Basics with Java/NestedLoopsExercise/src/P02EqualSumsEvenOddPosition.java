import java.util.Scanner;

public class P02EqualSumsEvenOddPosition {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int firstNum = Integer.parseInt(scanner.nextLine());
        int secondNum = Integer.parseInt(scanner.nextLine());

        for (int i = firstNum; i <= secondNum; i++)
        {
            String currNum = "" + i;
            int sumOddPositions = 0;
            int sumEvenPositions = 0;
            for(int j = 0; j < currNum.length(); j++)
            {
                if(j%2==0)
                {
                    sumEvenPositions += currNum.charAt(j);
                }
                else
                {
                    sumOddPositions += currNum.charAt(j);
                }
            }
            if(sumOddPositions == sumEvenPositions)
            {
                System.out.printf("%d ", currNum);
            }
        }
    }
}
