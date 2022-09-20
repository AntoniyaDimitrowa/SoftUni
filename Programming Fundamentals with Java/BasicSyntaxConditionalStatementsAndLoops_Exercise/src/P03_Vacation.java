import java.util.Scanner;

public class P03_Vacation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int peopleInGroup = Integer.parseInt(scanner.nextLine());
        String typeOfGroup = scanner.nextLine();
        String dayOfTheWeek = scanner.nextLine();

        double priceForOnePerson = 0.0;
        if(typeOfGroup.equals("Students")) {
            switch (dayOfTheWeek) {
                case "Friday":
                    priceForOnePerson = 8.45;
                    break;
                case "Saturday":
                    priceForOnePerson = 9.80;
                    break;
                case "Sunday":
                    priceForOnePerson = 10.46;
                    break;
            }
        } else if(typeOfGroup.equals("Business")) {
            switch (dayOfTheWeek) {
                case "Friday":
                    priceForOnePerson = 10.90;
                    break;
                case "Saturday":
                    priceForOnePerson = 15.60;
                    break;
                case "Sunday":
                    priceForOnePerson = 16;
                    break;
            }
        } else if(typeOfGroup.equals("Regular")) {
            switch (dayOfTheWeek) {
                case "Friday":
                    priceForOnePerson = 15;
                    break;
                case "Saturday":
                    priceForOnePerson = 20;
                    break;
                case "Sunday":
                    priceForOnePerson = 22.50;
                    break;
            }
        }

        double totalPrice = peopleInGroup * priceForOnePerson;

        if(typeOfGroup.equals("Students") && peopleInGroup >= 30) {
            totalPrice = totalPrice - totalPrice * 0.15;
        } else if(typeOfGroup.equals("Business") && peopleInGroup >= 100) {
            totalPrice = (peopleInGroup - 10) * priceForOnePerson;
        } else if(typeOfGroup.equals("Regular") && peopleInGroup >= 10 && peopleInGroup <= 20) {
            totalPrice = totalPrice - totalPrice * 0.05;
        }
        System.out.printf("Total price: %.2f", totalPrice);
    }
}
