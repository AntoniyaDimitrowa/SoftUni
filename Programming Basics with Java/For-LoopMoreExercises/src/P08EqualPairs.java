import java.util.Scanner;

public class P08EqualPairs {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        int sums[] = new int[n];
        int differences[] = new int[n-1];
        for(int i = 0; i < n; i++) {
            int num1 = Integer.parseInt(scanner.nextLine());
            int num2 = Integer.parseInt(scanner.nextLine());
            sums[i] = num1 + num2;
            if(i > 0) {
                differences[i-1] = Math.abs(sums[i] - sums[i-1]);
            }
        }

        int maxDiff = Integer.MIN_VALUE;
        boolean sameValues = true;
        for(int j = 0; j < differences.length; j++) {
            if(differences[j] != 0) {
                sameValues = false;
                if(maxDiff < differences[j]) {
                    maxDiff = differences[j];
                }
            }
        }

        if(sameValues) {
            System.out.printf("Yes, value=%d", sums[0]);
        } else {
            System.out.printf("No, maxdiff=%d", maxDiff);
        }
    }
}
