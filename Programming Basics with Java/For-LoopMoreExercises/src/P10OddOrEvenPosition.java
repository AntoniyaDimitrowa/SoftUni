import java.util.Scanner;

public class P10OddOrEvenPosition {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());

        double[] oddPositionsNums = new double[0];
        double[] evenPositionsNums = new double[0];
        if(n % 2 == 0) {
            oddPositionsNums = new double[n / 2];
        } else {
            oddPositionsNums = new double[n / 2 + 1];
        }
        evenPositionsNums = new double[n / 2];
        double oddSum = 0.0;
        int oddIndex = 0;
        double evenSum = 0.0;
        int evenIndex = 0;

        for(int i = 1; i <= n; i++) {
            double num = Double.parseDouble(scanner.nextLine());
            if(i % 2 == 0) {
                evenSum = evenSum + num;
                evenPositionsNums[evenIndex] = num;
                evenIndex++;
            } else {
                oddSum = oddSum + num;
                oddPositionsNums[oddIndex] = num;
                oddIndex++;
            }
        }

        double oddMin = 0.0;
        double oddMax = 0.0;
        double evenMin = 0.0;
        double evenMax = 0.0;
        if(oddPositionsNums.length != 0) {
            oddMin = oddPositionsNums[0];
            oddMax = oddPositionsNums[0];
        }
        if(evenPositionsNums.length != 0) {
            evenMin = evenPositionsNums[0];
            evenMax = evenPositionsNums[0];
        }

        for(int i = 0; i < oddPositionsNums.length; i++) {
            if(oddPositionsNums[i] > oddMax) {
                oddMax = oddPositionsNums[i];
            }
            if(oddPositionsNums[i] < oddMin) {
                oddMin = oddPositionsNums[i];
            }
        }
        for(int i = 0; i < evenPositionsNums.length; i++) {
            if(evenPositionsNums[i] > evenMax) {
                evenMax = evenPositionsNums[i];
            }
            if(evenPositionsNums[i] < evenMin) {
                evenMin = evenPositionsNums[i];
            }
        }

        if(oddSum != 0) {
            System.out.printf("OddSum=%.2f,%n", oddSum);
            System.out.printf("OddMin=%.2f,%n", oddMin);
            System.out.printf("OddMax=%.2f,%n", oddMax);
        } else {
            System.out.printf("OddSum=%.2f,%n", oddSum);
            System.out.println("OddMin=No,");
            System.out.println("OddMax=No,");
        }

        if(evenSum != 0) {
            System.out.printf("EvenSum=%.2f,%n", evenSum);
            System.out.printf("EvenMin=%.2f,%n", evenMin);
            System.out.printf("EvenMax=%.2f%n", evenMax);
        } else {
            System.out.printf("EvenSum=%.2f,%n", evenSum);
            System.out.println("EvenMin=No,");
            System.out.println("EvenMax=No");
        }
    }
}
