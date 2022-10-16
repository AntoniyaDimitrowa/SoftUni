import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class P05_ListManipulationAdvanced {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> numbersList = Arrays.stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        String input = scanner.nextLine();
        while(!input.equals("end")) {
            String[] commandArr = input.split(" ");
            String command = commandArr[0];
            if(command.equals("Contains")) {
                int number = Integer.parseInt(commandArr[1]);
                if(contains(number, numbersList)) {
                    System.out.println("Yes");
                } else {
                    System.out.println("No such number");
                }
            } else if(command.equals("Print")) {
                if(commandArr[1].equals("even")) {
                    printEvenNumbers(numbersList);
                } else if(commandArr[1].equals("odd")) {
                    printOddNumbers(numbersList);
                }
            } else if(command.equals("Get")) {
                System.out.println(getSum(numbersList));
            } else if(command.equals("Filter")) {
                String condition = commandArr[1];
                int num = Integer.parseInt(commandArr[2]);
                printFilteredList(condition, num, numbersList);
            }
            input = scanner.nextLine();
        }
    }
    public static boolean contains(int num, List<Integer> list) {
        for (int i = 0; i < list.size(); i++) {
            if(num == list.get(i)) {
                return true;
            }
        }
        return false;
    }

    public static void printEvenNumbers(List<Integer> list) {
        List<Integer> evenNumbersList = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            if(list.get(i) % 2 == 0) {
                evenNumbersList.add(list.get(i));
            }
        }
        for (int i = 0; i < evenNumbersList.size(); i++) {
            System.out.printf("%d ", evenNumbersList.get(i));
        }
        System.out.println();
    }

    public static void printOddNumbers(List<Integer> list) {
        List<Integer> oddNumbersList = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            if(list.get(i) % 2 != 0) {
                oddNumbersList.add(list.get(i));
            }
        }
        for (int i = 0; i < oddNumbersList.size(); i++) {
            System.out.printf("%d ", oddNumbersList.get(i));
        }
        System.out.println();
    }

    public static int getSum(List<Integer> list) {
        int sum = 0;
        for (int i = 0; i < list.size(); i++) {
            sum += list.get(i);
        }
        return sum;
    }

    public static void printFilteredList(String condition, int num, List<Integer> list) {
        List<Integer> filteredList = new ArrayList<>();
        if(condition.equals(">")) {
            for (int i = 0; i < list.size(); i++) {
                if(list.get(i) > num) {
                    filteredList.add(list.get(i));
                }
            }
        } else if(condition.equals("<")) {
            for (int i = 0; i < list.size(); i++) {
                if(list.get(i) < num) {
                    filteredList.add(list.get(i));
                }
            }
        } else if(condition.equals(">=")) {
            for (int i = 0; i < list.size(); i++) {
                if(list.get(i) >= num) {
                    filteredList.add(list.get(i));
                }
            }
        } else if(condition.equals("<=")) {
            for (int i = 0; i < list.size(); i++) {
                if(list.get(i) <= num) {
                    filteredList.add(list.get(i));
                }
            }
        }

        for (int i = 0; i < filteredList.size(); i++) {
            System.out.printf("%d ", filteredList.get(i));
        }
        System.out.println();
    }
}
