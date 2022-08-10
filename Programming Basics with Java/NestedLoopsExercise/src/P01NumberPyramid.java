import java.util.Scanner;

public class P01NumberPyramid {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        int currNum = 1;
        for (int row = 1; row <= n; row++)
        {
            for (int col = 1; col <= row; col++)
            {
                if (currNum > n)
                {
                    break;
                }
                System.out.printf("%d ", currNum);
                currNum++;
            }
            if (currNum > n)
            {
                break;
            }
            System.out.println();
        }
    }
}
