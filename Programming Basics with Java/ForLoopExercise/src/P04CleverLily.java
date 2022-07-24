import java.util.Scanner;

public class P04CleverLily {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int age = Integer.parseInt(scanner.nextLine());
        double laundryPrice = Double.parseDouble(scanner.nextLine());
        int toyPrice = Integer.parseInt(scanner.nextLine());
        double birthdayMoney = 0;
        double toys = 0;

        for (int i = 1; i <= age; i++)
        {
            if(i%2==0)
            {
                birthdayMoney = birthdayMoney + (i * 5)-1;
            }
            else
            {
                toys++;
            }
        }

        double totalMoney = birthdayMoney + (toys * toyPrice);

        if(totalMoney >= laundryPrice)
        {
            System.out.printf("Yes! %.2f", (totalMoney - laundryPrice));
        }
        else
        {
            System.out.printf("No! %.2f", (laundryPrice - totalMoney));
        }
    }
}
