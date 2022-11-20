import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class P02_Race {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<String> participants  = Arrays.stream(scanner.nextLine().split(", ")).collect(Collectors.toList());
        Map<String, Integer> distances = new LinkedHashMap<>();
        participants.forEach(participant -> distances.put(participant, 0));

        String regexLetters = "[A-Za-z]+";
        Pattern patternLetters = Pattern.compile(regexLetters);

        String regexDigits = "[0-9]";
        Pattern patternDigits = Pattern.compile(regexDigits);

        String inputLine = scanner.nextLine();
        while (!inputLine.equals("end of race")) {
            StringBuilder racerNameSB = new StringBuilder();
            Matcher letters = patternLetters.matcher(inputLine);
            while(letters.find()) {
                racerNameSB.append(letters.group());
            }
            String racerName = racerNameSB.toString();

            int distance = 0;
            Matcher digits = patternDigits.matcher(inputLine);
            while(digits.find()) {
                int currDigit = Integer.parseInt(digits.group());
                distance += currDigit;
            }

            if(distances.containsKey(racerName)) {
                int newDistance = distance + distances.get(racerName);
                distances.put(racerName, newDistance);
            }
            inputLine = scanner.nextLine();
        }

        //sort
        List<String> top3Names = distances.entrySet().stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .limit(3)
                .map(entry -> entry.getKey())
                .collect(Collectors.toList());

        System.out.println("1st place: " + top3Names.get(0));
        System.out.println("2nd place: " + top3Names.get(1));
        System.out.println("3rd place: " + top3Names.get(2));

    }
}
