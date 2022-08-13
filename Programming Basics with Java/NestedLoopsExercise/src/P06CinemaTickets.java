import java.util.Scanner;

public class P06CinemaTickets {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String command = scanner.nextLine();
        int totalSoldTickets = 0;
        int totalStudentTickets = 0;
        int totalStandardTickets = 0;
        int totalKidsTickets = 0;

        while (!command.equals("Finish")) {
            String movieName = command;
            int freeSeats = Integer.parseInt(scanner.nextLine());
            String command2 = scanner.nextLine();
            int occupiedSeats = 0;

            while (!command2.equals("End")) {
                occupiedSeats++;
                String ticketType = command2;
                int studentTickets = 0;
                int standardTickets = 0;
                int kidsTickets = 0;
                switch (ticketType) {
                    case "student":
                        studentTickets++;
                        break;
                    case "standard":
                        standardTickets++;
                        break;
                    case "kid":
                        kidsTickets++;
                        break;
                }
                totalKidsTickets += kidsTickets;
                totalStudentTickets += studentTickets;
                totalStandardTickets += standardTickets;
                totalSoldTickets = totalSoldTickets + studentTickets + standardTickets + kidsTickets;

                if(freeSeats == occupiedSeats) {
                    break;
                }
                command2 = scanner.nextLine();
            }
            System.out.printf("%s - %.2f%% full.%n", movieName, ((occupiedSeats*1.0/freeSeats) * 100));
            command = scanner.nextLine();
        }
        System.out.printf("Total tickets: %d%n", totalSoldTickets);
        System.out.printf("%.2f%% student tickets.%n", (totalStudentTickets*1.0 / totalSoldTickets)*100);
        System.out.printf("%.2f%% standard tickets.%n", (totalStandardTickets*1.0 / totalSoldTickets)*100);
        System.out.printf("%.2f%% kids tickets.%n", (totalKidsTickets*1.0 / totalSoldTickets)*100);

    }
}
