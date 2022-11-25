import java.util.Scanner;

public class P01_ActivationKeys {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        StringBuilder activationKey = new StringBuilder(input);

        String[] commandArr = scanner.nextLine().split(">>>");
        while(!commandArr[0].equals("Generate")) {
            String command = commandArr[0];
            if(command.equals("Contains")) {
                String substring = commandArr[1];
                if (activationKey.toString().contains(substring)) {
                    System.out.println(activationKey + " contains " + substring);
                } else {
                    System.out.println("Substring not found!");
                }
            } else if(command.equals("Flip")) {
                String upOrLow = commandArr[1];
                int startIndex = Integer.parseInt(commandArr[2]);
                int endIndex = Integer.parseInt(commandArr[3]);
                if(upOrLow.equals("Upper")) {
                    String substring = activationKey.substring(startIndex, endIndex);
                    substring = substring.toUpperCase();
                    activationKey.replace(startIndex, endIndex, substring);

                } else if(upOrLow.equals("Lower")) {
                    String substring = activationKey.substring(startIndex, endIndex);
                    substring = substring.toLowerCase();
                    activationKey.replace(startIndex, endIndex, substring);
                }
                System.out.println(activationKey);
            } else if(command.equals("Slice")) {
                int startIndex = Integer.parseInt(commandArr[1]);
                int endIndex = Integer.parseInt(commandArr[2]);
                activationKey.delete(startIndex, endIndex);
                System.out.println(activationKey);
            }
            commandArr = scanner.nextLine().split(">>>");
        }
        System.out.println("Your activation key is: " + activationKey);
    }
}
