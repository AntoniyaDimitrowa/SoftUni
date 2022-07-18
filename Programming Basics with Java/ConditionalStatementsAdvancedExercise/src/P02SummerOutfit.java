import java.util.Scanner;

public class P02SummerOutfit {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int degrees = Integer.parseInt(scanner.nextLine());
        String timeOfDay = scanner.nextLine();
        if(degrees >= 10 && degrees <=18) {
            switch (timeOfDay) {
                case "Morning":
                    System.out.printf("It's %d degrees, get your Sweatshirt and Sneakers.", degrees);break;
                case "Afternoon":
                case "Evening":
                    System.out.printf("It's %d degrees, get your Shirt and Moccasins.", degrees);break;
                default: System.out.println("error");break;
            }
        }
        else if (degrees > 18 && degrees <= 24)
        {
            switch (timeOfDay)
            {
                case "Morning":
                case "Evening":
                    System.out.printf("It's %d degrees, get your Shirt and Moccasins.", degrees); break;
                case "Afternoon":
                    System.out.printf("It's %d degrees, get your T-Shirt and Sandals.", degrees); break;
                default: System.out.println("error"); break;
            }
        }
        else if (degrees >=25)
        {
            switch (timeOfDay)
            {
                case "Morning":
                    System.out.printf("It's %d degrees, get your T-Shirt and Sandals.", degrees); break;
                case "Afternoon":
                    System.out.printf("It's %d degrees, get your Swim Suit and Barefoot.", degrees); break;
                case "Evening":
                    System.out.printf("It's %d degrees, get your Shirt and Moccasins.", degrees); break;
                default: System.out.println("error"); break;
            }
        }
        else {
            System.out.println("error");
        }
    }
}
