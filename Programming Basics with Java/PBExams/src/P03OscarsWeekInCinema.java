import java.util.Scanner;

public class P03OscarsWeekInCinema {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String movieName = scanner.nextLine();
        String hallType = scanner.nextLine();
        int ticketsCount = Integer.parseInt(scanner.nextLine());
        double price = 0.0;

        if(hallType.equals("normal")) {
            switch(movieName) {
                case "A Star Is Born":
                    price = ticketsCount * 7.50;
                    break;
                case "Bohemian Rhapsody":
                    price = ticketsCount * 7.35;
                    break;
                case "Green Book":
                    price = ticketsCount * 8.15;
                    break;
                case "The Favourite":
                    price = ticketsCount * 8.75;
                    break;
            }
        } else if(hallType.equals("luxury")) {
            switch(movieName) {
                case "A Star Is Born":
                    price = ticketsCount * 10.50;
                    break;
                case "Bohemian Rhapsody":
                    price = ticketsCount * 9.45;
                    break;
                case "Green Book":
                    price = ticketsCount * 10.25;
                    break;
                case "The Favourite":
                    price = ticketsCount * 11.55;
                    break;
            }
        } else if(hallType.equals("ultra luxury")) {
            switch(movieName) {
                case "A Star Is Born":
                    price = ticketsCount * 13.50;
                    break;
                case "Bohemian Rhapsody":
                    price = ticketsCount * 12.75;
                    break;
                case "Green Book":
                    price = ticketsCount * 13.25;
                    break;
                case "The Favourite":
                    price = ticketsCount * 13.95;
                    break;
            }
        }
        System.out.printf("%s -> %.2f lv.", movieName, price);
    }
}
