import java.util.Scanner;

public class P10_PadawanEquipment {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double amountOfMoney = Double.parseDouble(scanner.nextLine());
        int studentsCount = Integer.parseInt(scanner.nextLine());
        double sabresPrice = Double.parseDouble(scanner.nextLine());
        double robesPrice = Double.parseDouble(scanner.nextLine());
        double beltsPrice = Double.parseDouble(scanner.nextLine());

        double moneyForLightsabers = sabresPrice * (studentsCount + (Math.ceil(studentsCount * 0.10)));
        double moneyForRobes = robesPrice * studentsCount;
        double freeBelts = Math.floor(studentsCount / 6.0);
        double moneyForBelts = (studentsCount - freeBelts) * beltsPrice;
        double totalPrice = moneyForLightsabers + moneyForRobes + moneyForBelts;

        if(totalPrice <= amountOfMoney) {
            System.out.printf("The money is enough - it would cost %.2flv.", totalPrice);
        } else {
            System.out.printf("George Lucas will need %.2flv more.", totalPrice - amountOfMoney);
        }
    }
}
