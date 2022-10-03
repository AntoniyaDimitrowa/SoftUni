import java.util.Scanner;

public class P01_Train {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int wagons = Integer.parseInt(scanner.nextLine());
        int[] array = new int[wagons];
        int totalPeople = 0;
        for (int i = 0; i < wagons; i++) {
            int people = Integer.parseInt(scanner.nextLine());
            array[i] = people;
            totalPeople += people;
        }
        for (int i = 0; i < wagons; i++) {
            System.out.printf("%d ", array[i]);
        }
        System.out.println();
        System.out.println(totalPeople);
    }
}
