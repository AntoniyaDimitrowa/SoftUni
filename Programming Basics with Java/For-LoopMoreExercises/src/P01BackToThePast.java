import java.util.Scanner;

public class P01BackToThePast {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double inheritedMoney = Double.parseDouble(scanner.nextLine());
        int year = Integer.parseInt(scanner.nextLine());

        double spentMoney = 0.0;
        int age = 18;
        for(int i = 1800; i <= year; i++) {
            if(i % 2 == 0) {
                spentMoney = spentMoney + 12000;
            } else {
                spentMoney = spentMoney + 12000 + 50 * age;
            }
            age++;
        }

        if(inheritedMoney < spentMoney) {
            System.out.printf("He will need %.2f dollars to survive.", spentMoney - inheritedMoney);
        } else {
            System.out.printf("Yes! He will live a carefree life and will have %.2f dollars left.", inheritedMoney - spentMoney);
        }
    }
}
