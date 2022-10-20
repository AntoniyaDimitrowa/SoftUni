import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class P06_CardsGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> deck1 = Arrays.stream(scanner.nextLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList());
        List<Integer> deck2 = Arrays.stream(scanner.nextLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList());

        while(deck1.size() > 0 && deck2.size() > 0) {
            int card1 = deck1.get(0);
            int card2 = deck2.get(0);
            if(card1 > card2) {
                deck1.remove(0);
                deck2.remove(0);
                deck1.add(card1);
                deck1.add(card2);
            } else if (card1 < card2) {
                deck1.remove(0);
                deck2.remove(0);
                deck2.add(card2);
                deck2.add(card1);
            } else {
                deck1.remove(0);
                deck2.remove(0);
            }
        }
        if(deck1.size() == 0) {
            int sum = 0;
            for (int i = 0; i < deck2.size(); i++) {
                sum += deck2.get(i);
            }
            System.out.printf("Second player wins! Sum: %d", sum);
        } else if(deck2.size() == 0) {
            int sum = 0;
            for (int i = 0; i < deck1.size(); i++) {
                sum += deck1.get(i);
            }
            System.out.printf("First player wins! Sum: %d", sum);
        }

    }
}
