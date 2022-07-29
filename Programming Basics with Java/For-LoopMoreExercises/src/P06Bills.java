import java.util.Scanner;

public class P06Bills {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int months = Integer.parseInt(scanner.nextLine());

        double billsForElectricity = 0.0;
        double billsForWater = 0.0;
        double billsForInternet = 0.0;
        double billsForOther = 0.0;

        for(int i = 1; i <= months; i++) {
            double currElectricityBill = Double.parseDouble(scanner.nextLine());
            billsForElectricity = billsForElectricity + currElectricityBill;
            billsForWater = billsForWater + 20;
            billsForInternet = billsForInternet + 15;
            billsForOther = billsForOther + (currElectricityBill + 20 + 15) + ((currElectricityBill + 20 + 15) * 0.20);
        }
        System.out.printf("Electricity: %.2f lv%n", billsForElectricity);
        System.out.printf("Water: %.2f lv%n", billsForWater);
        System.out.printf("Internet: %.2f lv%n", billsForInternet);
        System.out.printf("Other: %.2f lv%n", billsForOther);
        System.out.printf("Average: %.2f lv%n", (billsForElectricity + billsForWater + billsForInternet + billsForOther)/months);
    }
}
