import java.util.*;

public class P03_DegustationParty {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, List<String>> guests = new LinkedHashMap<>();
        int unlikedMealsCount = 0;
        String[] commandArr = scanner.nextLine().split("-");
        while (!commandArr[0].equals("Stop")) {
            String command = commandArr[0];
            String guest = commandArr[1];
            String meal = commandArr[2];
            List<String> currLikedMeals = new ArrayList<>();

            if(command.equals("Like")) {
                if(guests.containsKey(guest)) {
                    currLikedMeals = guests.get(guest);
                    if(!currLikedMeals.contains(meal)) {
                        currLikedMeals.add(meal);
                    }
                    guests.put(guest, currLikedMeals);
                } else {
                    currLikedMeals.add(meal);
                    guests.put(guest, currLikedMeals);
                }
            } else if(command.equals("Dislike")) {
                if(guests.containsKey(guest)) {
                    currLikedMeals = guests.get(guest);
                    if(currLikedMeals.contains(meal)) {
                        currLikedMeals.remove(meal);
                        System.out.printf("%s doesn't like the %s.%n", guest, meal);
                        guests.put(guest, currLikedMeals);
                        unlikedMealsCount++;
                    } else {
                        System.out.printf("%s doesn't have the %s in his/her collection.%n", guest, meal);
                    }
                } else {
                    System.out.println(guest + " is not at the party.");
                }
            }
            commandArr = scanner.nextLine().split("-");
        }
        for (Map.Entry<String, List<String>> entry : guests.entrySet()) {
            String currGuest = entry.getKey();
            List<String> currGuestLikedMeals = entry.getValue();
            System.out.print(currGuest + ": ");
            System.out.println(String.join(", ", currGuestLikedMeals));
        }
        System.out.println("Unliked meals: " + unlikedMealsCount);
    }
}
