import java.util.Scanner;

public class P02Hospital {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int period = Integer.parseInt(scanner.nextLine());
        int doctors = 7;
        int treatedPatients = 0;
        int untreatedPatients = 0;

        for(int i = 1; i <= period; i++) {
            int patientsForTheDay = Integer.parseInt(scanner.nextLine());
            if(i % 3 == 0) {
                if(untreatedPatients > treatedPatients) {
                    doctors++;
                }
            }
            if(patientsForTheDay < doctors) {
                treatedPatients = treatedPatients + patientsForTheDay;
            } else {
                treatedPatients = treatedPatients + doctors;
                untreatedPatients = untreatedPatients + (patientsForTheDay - doctors);
            }
        }
        System.out.printf("Treated patients: %d.%n", treatedPatients);
        System.out.printf("Untreated patients: %d.", untreatedPatients);

    }
}
