import java.util.Scanner;

public class P07SchoolCamp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String season = scanner.nextLine();
        String groupType = scanner.nextLine();
        int studentsCount = Integer.parseInt(scanner.nextLine());
        int nightsCount = Integer.parseInt(scanner.nextLine());
        double price = 0.0;
        String sport = "";

        if(season.equals("Winter")) {
            switch (groupType) {
                case "girls":
                    price = studentsCount * nightsCount * 9.60;
                    sport = "Gymnastics";
                    break;
                case "boys":
                    price = studentsCount * nightsCount * 9.60;
                    sport = "Judo";
                    break;
                case "mixed":
                    price = studentsCount * nightsCount * 10.0;
                    sport = "Ski";
                    break;
            }
        } else if(season.equals("Spring")) {
            switch (groupType) {
                case "girls":
                    price = studentsCount * nightsCount * 7.20;
                    sport = "Athletics";
                    break;
                case "boys":
                    price = studentsCount * nightsCount * 7.20;
                    sport = "Tennis";
                    break;
                case "mixed":
                    price = studentsCount * nightsCount * 9.50;
                    sport = "Cycling";
                    break;
            }
        } else if(season.equals("Summer")) {
            switch (groupType) {
                case "girls":
                    price = studentsCount * nightsCount * 15.0;
                    sport = "Volleyball";
                    break;
                case "boys":
                    price = studentsCount * nightsCount * 15.0;
                    sport = "Football";
                    break;
                case "mixed":
                    price = studentsCount * nightsCount * 20.0;
                    sport = "Swimming";
                    break;
            }
        }

        if(studentsCount >= 50) {
            price = price * 0.50;
        } else if(studentsCount >= 20) {
            price = price * 0.85;
        } else if(studentsCount >= 10) {
            price = price * 0.95;
        }

        System.out.printf("%s %.2f lv.", sport, price);
    }
}
