import java.util.Scanner;

public class P05MovieRatings {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int moviesCount = Integer.parseInt(scanner.nextLine());
        double minRating = Double.MAX_VALUE;
        String minRatedMovieName = "";
        double maxRating = Double.MIN_VALUE;
        String maxRatedMovieName = "";
        double ratingsSum = 0;
        for(int i = 1; i <= moviesCount; i++) {
            String movieName = scanner.nextLine();
            double rating = Double.parseDouble(scanner.nextLine());
            ratingsSum += rating;
            if(minRating > rating) {
                minRating = rating;
                minRatedMovieName = movieName;
            }
            if(maxRating < rating) {
                maxRating = rating;
                maxRatedMovieName = movieName;
            }
        }
        System.out.printf("%s is with highest rating: %.1f%n", maxRatedMovieName, maxRating);
        System.out.printf("%s is with lowest rating: %.1f%n", minRatedMovieName, minRating);
        System.out.printf("Average rating: %.1f", ratingsSum / moviesCount);
    }
}
