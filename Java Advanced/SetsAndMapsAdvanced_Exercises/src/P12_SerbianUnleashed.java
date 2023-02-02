import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

import static java.util.Map.Entry.comparingByValue;

public class P12_SerbianUnleashed {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Pattern pattern = Pattern.compile("(?<singer>\\w+(?: \\w+)*) \\@(?<venue>\\w+(?: \\w+)*) (?<ticketsPrice>[0-9]+) (?<ticketsCount>[0-9]+)");
        LinkedHashMap<String, LinkedHashMap<String, Integer>> venues = new LinkedHashMap<>();

        String command = scanner.nextLine();
        while (!command.equals("End")) {
            Matcher matcher = pattern.matcher(command);
            while (matcher.find()) {
                String singer = matcher.group("singer");
                String venue = matcher.group("venue");
                int ticketsPrice = Integer.parseInt(matcher.group("ticketsPrice"));
                int ticketsCount = Integer.parseInt(matcher.group("ticketsCount"));
                int currIncome = ticketsPrice * ticketsCount;

                venues.putIfAbsent(venue, new LinkedHashMap<>());
                venues.get(venue).putIfAbsent(singer, 0);
                venues.get(venue).put(singer, currIncome + venues.get(venue).get(singer));
            }
            command = scanner.nextLine();
        }
        venues.entrySet().stream().forEach(e -> {
            System.out.println(e.getKey());
            LinkedHashMap<String, Integer> singers = e.getValue();
            singers.entrySet().stream()
                    .sorted(Collections.reverseOrder(comparingByValue()))
                    .forEach(e2 -> System.out.println("#  " + e2.getKey() + " -> " + e2.getValue()));
        });
    }
}
