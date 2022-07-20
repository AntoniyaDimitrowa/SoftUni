import java.util.Scanner;

public class P08OnTimeForTheExam {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int examHour = Integer.parseInt(scanner.nextLine());
        int examMinute = Integer.parseInt(scanner.nextLine());
        int arrivalHour = Integer.parseInt(scanner.nextLine());
        int arrivalMinute = Integer.parseInt(scanner.nextLine());

        int examTimeInMinutes = examHour * 60 + examMinute;
        int arrivalTimeInMinutes = arrivalHour * 60 + arrivalMinute;
        int difference = Math.abs(examTimeInMinutes -arrivalTimeInMinutes );

        if (examTimeInMinutes < arrivalTimeInMinutes) {
            System.out.println("Late");
            if (difference >= 60) {
                int hour = difference / 60;
                int min = difference % 60;
                System.out.printf("%d:%02d hours after the start", hour, min);
            } else {
                System.out.printf("%d minutes after the start", difference);
            }
        } else if (examTimeInMinutes == arrivalTimeInMinutes || difference <= 30) {
            System.out.println("On time");
            if(difference >= 1 && difference <= 30) {
                System.out.printf("%d minutes before the start", difference);
            }
        } else {
            System.out.println("Early");
            if (difference >= 60) {
                int hour = difference / 60;
                int min = difference % 60;
                System.out.printf("%d:%02d hours before the start", hour, min);
            } else {
                System.out.printf("%d minutes before the start", difference);
            }
        }


    }
}
