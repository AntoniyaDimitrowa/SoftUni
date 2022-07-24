import java.util.Scanner;

public class P03Histogram {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        int firstGroupNumbers = 0;
        int secondGroupNumbers = 0;
        int thirdGroupNumbers= 0;
        int fourthGroupNumbers = 0;
        int fifthGroupNumbers = 0;
        for (int i = 1; i <= n; i++)
        {
            int num = Integer.parseInt(scanner.nextLine());
            if (num<200)
            {
                firstGroupNumbers++;
            }
            if (num >= 200 && num<400)
            {
                secondGroupNumbers++;
            }
            if (num >= 400 && num < 600)
            {
                thirdGroupNumbers++;
            }
            if (num >= 600 && num < 800)
            {
                fourthGroupNumbers++;
            }
            if (num >= 800)
            {
                fifthGroupNumbers++;
            }
        }

        System.out.printf("%.2f%% %n", (firstGroupNumbers*1.0) / n * 100);
        System.out.printf("%.2f%% %n", (secondGroupNumbers * 1.0) / n * 100);
        System.out.printf("%.2f%% %n", (thirdGroupNumbers * 1.0) / n * 100);
        System.out.printf("%.2f%% %n", (fourthGroupNumbers * 1.0) / n * 100);
        System.out.printf("%.2f%% %n", (fifthGroupNumbers * 1.0) / n * 100);
    }
}
