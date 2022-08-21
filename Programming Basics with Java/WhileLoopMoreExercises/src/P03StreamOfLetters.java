import java.util.Scanner;

public class P03StreamOfLetters {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String command = scanner.nextLine();
        String word = "";
        int numberOfC = 0;
        int numberOfO = 0;
        int numberOfN = 0;
        while(!command.equals("End")) {

            if(command.equals("n")) {
                numberOfN++;
                if(numberOfN > 1) {
                    word = word + command + " ";
                    System.out.printf(word);
                    word = "";
                }
            }
            if(command.equals("c")) {
                numberOfC++;
                if(numberOfC > 1) {
                    word = word + command + " ";
                    System.out.printf(word);
                    word = "";
                }
            }
            if(command.equals("o")) {
                numberOfO++;
                if(numberOfO > 1) {
                    word = word + command + " ";
                    System.out.printf(word);
                    word = "";
                }
            }




            command = scanner.nextLine();
        }
    }
}
