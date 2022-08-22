import java.util.Scanner;

public class P03StreamOfLetters {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String command = scanner.nextLine();
        StringBuilder word = new StringBuilder();
        String result = "";
        int numberOfC = 0;
        int numberOfO = 0;
        int numberOfN = 0;
        while(!command.equals("End")) {

            if(command.equals("n")) {
                numberOfN++;
                if(numberOfN > 1) {
                    word.append(command);
                    //System.out.printf(result.toString());
                }
            } else if(command.equals("c")) {
                numberOfC++;
                if(numberOfC > 1) {
                    word.append(command);
                    //System.out.printf(result.toString());
                }
            } else if(command.equals("o")) {
                numberOfO++;
                if(numberOfO > 1) {
                    word.append(command);
                    //System.out.printf(result.toString());
                }
            } else {
                if(Character.isAlphabetic(command.charAt(0))) {
                    word.append(command);
                }
            }
            if(numberOfC > 0 && numberOfN > 0 && numberOfO > 0) {
                //System.out.printf(word + " ");
                result = result + word + " ";
                word = new StringBuilder();
                numberOfC = 0;
                numberOfO = 0;
                numberOfN = 0;
            }
            command = scanner.nextLine();
        }
        System.out.println(result);
    }
}
