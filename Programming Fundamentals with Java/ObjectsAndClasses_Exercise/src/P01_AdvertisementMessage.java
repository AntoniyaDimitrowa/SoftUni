import java.util.Random;
import java.util.Scanner;

public class P01_AdvertisementMessage {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = Integer.parseInt(scanner.nextLine());
        String[] phrases = {"Excellent product.", "Such a great product.", "I always use that product.", "Best product of its category.", "Exceptional product.", "I can't live without this product."};
        String[] events = {"Now I feel good.", "I have succeeded with this product.", "Makes miracles. I am happy of the results!", "I cannot believe but now I feel awesome.", "Try it yourself, I am very satisfied.", "I feel great!"};
        String[] authors = {"Diana", "Petya", "Stella", "Elena", "Katya", "Iva", "Annie", "Eva"};
        String[] cities = {"Burgas", "Sofia", "Plovdiv", "Varna", "Ruse"};

        for (int i = 0; i < num; i++) {
            Random rd = new Random();
            String phrase = phrases[rd.nextInt(phrases.length)];
            String event = events[rd.nextInt(events.length)];
            String author = authors[rd.nextInt(authors.length)];
            String city = cities[rd.nextInt(cities.length)];

            System.out.println(String.join(" ", phrase + " " + event + " " + author + " - " + city));
        }
    }
}
