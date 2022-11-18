import java.util.Scanner;

public class P05_MultiplyBigNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String bigNum = scanner.nextLine().replaceFirst("^0+(?!$)", "");
        int smallNum = Integer.parseInt(scanner.nextLine());

        if(bigNum.isEmpty() || bigNum.equals("0") || smallNum == 0) {
            System.out.println(0);
            return;
        }

        StringBuilder strb = new StringBuilder();
        int remainder = 0;

        for (int i = bigNum.length() - 1; i >= 0; i--) {

            int currentRes = 0;
            int currDigit = Integer.parseInt(String.valueOf(bigNum.charAt(i)));

            if (i == 0) {
                int remaining = currDigit * smallNum + remainder;
                String preReversed = Integer.toString(remaining);

                String reversedNum = new StringBuffer(preReversed).reverse().toString();
                strb.append(reversedNum);
                break;
            }

            if (currDigit * smallNum + remainder < 10) {

                currentRes = currDigit * smallNum + remainder;
                strb.append(currentRes);
                remainder = 0;

            } else {
                currentRes = currDigit * smallNum + remainder;
                strb.append(currentRes % 10);
                currentRes /= 10;
                remainder = currentRes;
            }

        }

        System.out.println(strb.reverse());
    }
}
