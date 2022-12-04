import java.util.Scanner;

public class P01_StringGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        String[] commandArr = scanner.nextLine().split("\\s+");
        while (!commandArr[0].equals("Done")) {
            String command = commandArr[0];
            if(command.equals("Change")) {
                String charToReplace = commandArr[1];
                String replacement = commandArr[2];
                input = input.replaceAll(charToReplace, replacement);
                System.out.println(input);
            } else if(command.equals("Includes")) {
                String substring = commandArr[1];
                boolean includes = input.contains(substring);
                if(includes) {
                    System.out.println("True");
                } else {
                    System.out.println("False");
                }
            } else if(command.equals("End")) {
                String substring = commandArr[1];
                boolean includes = input.contains(substring);
                if(includes) {
                    int lastIndex = input.lastIndexOf(substring);
                    if(lastIndex + substring.length() - 1 == input.length() - 1) {
                        System.out.println("True");
                    } else {
                        System.out.println("False");
                    }
                } else {
                    System.out.println("False");
                }
            } else if(command.equals("Uppercase")) {
                input = input.toUpperCase();
                System.out.println(input);
            } else if(command.equals("FindIndex")) {
                char wantedCharacter = commandArr[1].charAt(0);
                int index = input.indexOf(wantedCharacter);
                System.out.println(index);
            } else if(command.equals("Cut")) {
                int startIndex = Integer.parseInt(commandArr[1]);
                int count = Integer.parseInt(commandArr[2]);
                input = input.substring(startIndex, startIndex + count);
                System.out.println(input);
            }
            commandArr = scanner.nextLine().split("\\s+");
        }
    }
}
