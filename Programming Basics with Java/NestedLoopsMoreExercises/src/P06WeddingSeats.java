import java.util.Scanner;

public class P06WeddingSeats {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        char firstSector = 'A';
        char firstSeat = 'a';
        String lastSector = scanner.nextLine();
        char lastSectorSymbol = lastSector.charAt(0);
        int rowsInSector = Integer.parseInt(scanner.nextLine());
        int seatsInOddRows = Integer.parseInt(scanner.nextLine());
        int seatsInEvenRows = seatsInOddRows + 2;
        int seatsCounter = 0;

        for(char sector = firstSector; sector <= lastSectorSymbol; sector++) {
            for(int row = 1; row <= rowsInSector; row++) {
                if(row % 2 != 0) {
                    int freeSeats = seatsInOddRows;
                    for(char seat = firstSeat; seat <= 'z'; seat++) {
                        System.out.printf("%c%d%c%n", sector, row, seat);
                        seatsCounter++;
                        freeSeats--;
                        if(freeSeats==0) {
                            break;
                        }
                    }
                } else {
                    int freeSeats = seatsInEvenRows;
                    for(char seat = firstSeat; seat <= 'z'; seat++) {
                        System.out.printf("%c%d%c%n", sector, row, seat);
                        seatsCounter++;
                        freeSeats--;
                        if(freeSeats==0) {
                            break;
                        }
                    }
                }
            }
            rowsInSector++;
        }
        System.out.println(seatsCounter);
    }
}
