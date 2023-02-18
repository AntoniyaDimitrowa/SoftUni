import java.util.*;

public class P01_ApocalypsePreparation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] textilesArr = scanner.nextLine().split(" ");
        String[] medicamentsArr = scanner.nextLine().split(" ");
        Map<String, Integer> items = new TreeMap<>();
        items.put("Patch", 0);
        items.put("Bandage", 0);
        items.put("MedKit", 0);

        Queue<Integer> textiles = new ArrayDeque<>();
        for (int i = 0; i < textilesArr.length; i++) {
            textiles.offer(Integer.parseInt(textilesArr[i]));
        }

        Deque<Integer> medicaments = new ArrayDeque<>();
        for (int i = 0; i < medicamentsArr.length; i++) {
            medicaments.push(Integer.parseInt(medicamentsArr[i]));
        }

        while(!textiles.isEmpty() && !medicaments.isEmpty()) {
            int currSum = textiles.peek() + medicaments.peek();
            if(currSum == 30) {
                int currCount = items.get("Patch");
                currCount++;
                items.put("Patch", currCount);
                textiles.poll();
                medicaments.pop();
            } else if(currSum == 40) {
                int currCount = items.get("Bandage");
                currCount++;
                items.put("Bandage", currCount);
                textiles.poll();
                medicaments.pop();
            } else if(currSum == 100) {
                int currCount = items.get("MedKit");
                currCount++;
                items.put("MedKit", currCount);
                textiles.poll();
                medicaments.pop();
            } else if(currSum > 100) {
                int currCount = items.get("MedKit");
                currCount++;
                items.put("MedKit", currCount);
                textiles.poll();
                medicaments.pop();
                currSum -= 100;
                int currMed = medicaments.pop() + currSum;
                medicaments.push(currMed);
            } else {
                textiles.poll();
                int currMed = medicaments.pop() + 10;
                medicaments.push(currMed);
            }
        }

        if(textiles.isEmpty() && medicaments.isEmpty()) {
            System.out.println("Textiles and medicaments are both empty.");
        } else if(textiles.isEmpty()) {
            System.out.println("Textiles are empty.");
        } else {
            System.out.println("Medicaments are empty.");
        }

        items.entrySet().stream()
                .filter(e -> e.getValue() != 0)
                .sorted((e1, e2) -> e2.getValue().compareTo(e1.getValue()))
                .forEach(e -> System.out.printf("%s - %d%n", e.getKey(), e.getValue()));

        if(!textiles.isEmpty()) {
            System.out.print("Textiles left: " + textiles.poll());
            while (!textiles.isEmpty()) {
                System.out.print(", " + textiles.poll());
            }
        } else if(!medicaments.isEmpty()) {
            System.out.print("Medicaments left: " + medicaments.pop());
            while (!medicaments.isEmpty()) {
                System.out.print(", " + medicaments.pop());
            }
        }
    }
}
