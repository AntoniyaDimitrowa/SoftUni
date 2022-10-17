import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class P01_Train {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> passengersInWagons =
                Arrays.stream(scanner.nextLine().split(" "))
                        .map(Integer::parseInt)
                        .collect(Collectors.toList());
        int maxCapacity = Integer.parseInt(scanner.nextLine());
        String input = scanner.nextLine();
        while (!input.equals("end")) {
            String[] commandArr = input.split(" ");
            if(commandArr[0].equals("Add")) {
                int passengers = Integer.parseInt(commandArr[1]);
                passengersInWagons.add(passengers);
            } else {
                int passengers = Integer.parseInt(commandArr[0]);
                for (int i = 0; i < passengersInWagons.size(); i++) {
                    if(passengers + passengersInWagons.get(i) <= maxCapacity) {
                        passengersInWagons.set(i, (passengers + passengersInWagons.get(i)));
                        break;
                    }
                }
            }
            input = scanner.nextLine();
        }

        for (int item : passengersInWagons) {
            System.out.print(item + " ");
        }
    }
}
