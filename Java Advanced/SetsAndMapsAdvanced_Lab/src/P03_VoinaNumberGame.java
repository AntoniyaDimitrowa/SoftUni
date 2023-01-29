import java.util.*;
import java.util.stream.Collectors;

public class P03_VoinaNumberGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Set<Integer> deckOne = new LinkedHashSet<>();
        Set<Integer> deckTwo = new LinkedHashSet<>();
        List<Integer> inputOne = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        deckOne.addAll(inputOne);

        List<Integer> inputTwo = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        deckTwo.addAll(inputTwo);

        //Iterator<Integer> iteratorOne = deckOne.iterator();
        //Iterator<Integer> iteratorTwo = deckTwo.iterator();

        int step = 1;
        while (!deckOne.isEmpty() && !deckTwo.isEmpty()) {
            if(step >= 50) {
                break;
            }
            int cardOne = deckOne.iterator().next();
            int cardTwo = deckTwo.iterator().next();
            deckOne.remove(cardOne);
            deckTwo.remove(cardTwo);

            if(cardOne > cardTwo) {
                deckOne.add(cardOne);
                deckOne.add(cardTwo);
            } else if(cardOne < cardTwo){
                deckTwo.add(cardOne);
                deckTwo.add(cardTwo);
            }
            step++;
        }
        if(deckTwo.isEmpty()) {
            System.out.println("First player win!");
        } else if(deckOne.isEmpty()){
            System.out.println("Second player win!");
        } else {
            if(deckOne.size() > deckTwo.size()) {
                System.out.println("First player win!");
            } else {
                System.out.println("Second player win!");
            }
        }
    }
}
