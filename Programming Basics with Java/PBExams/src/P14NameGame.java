import java.util.Scanner;

public class P14NameGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String command = scanner.nextLine();
        String winner = "";
        int winnersPoints = 0;

        while(!command.equals("Stop")) {
            String name = command;
            int currPlayerPoints = 0;
            for(int i = 0; i < name.length(); i++) {
                int num = Integer.parseInt(scanner.nextLine());
                int letterASCII = name.charAt(i);
                if(num == letterASCII) {
                    currPlayerPoints = currPlayerPoints + 10;
                } else {
                    currPlayerPoints = currPlayerPoints + 2;
                }
            }
            if(currPlayerPoints >= winnersPoints) {
                winner = name;
                winnersPoints = currPlayerPoints;
            }
            command = scanner.nextLine();
        }
        System.out.printf("The winner is %s with %d points!", winner, winnersPoints);
    }
}
