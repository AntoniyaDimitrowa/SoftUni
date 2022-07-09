import java.util.Scanner;

public class P09WeatherForecast {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Input \"degrees\", if you are going to work with degrees or \"weather\", if you are going to use words like \"sunny\".");
        String command = scanner.nextLine();
        if(command.equals("weather")){
            System.out.println("Input word like \"sunny, cloudy, snowy\".");
            String weather = scanner.nextLine().toLowerCase();
            if (weather.equals("sunny")) {
                System.out.println("It's warm outside!");
            }
            else if(weather.equals("cloudy")){
                System.out.println("It's cloudy so it might be cold outside!");
            }
            else if(weather.equals("snowy")){
                System.out.println("It's cold outside!");
            }
            else {
                System.out.println("Unknown");
            }
        }
        else if (command.equals("degrees")) {
            System.out.println("Input degrees(Ex.: 20.5).");
            double degrees = Double.parseDouble(scanner.nextLine());
            if(degrees>=26 && degrees<=35) {
                System.out.println("Hot");
            }
            else if(degrees>=20.1 && degrees<=25.9) {
                System.out.println("Warm");
            }
            else if(degrees>=15 && degrees<=20) {
                System.out.println("Mild");
            }
            else if(degrees>=12 && degrees<=14.9) {
                System.out.println("Cool");
            }
            else if(degrees>=5 && degrees<=11.9) {
                System.out.println("Cold");
            }
            else if(degrees<5) {
                System.out.println("Very cold");
            }
            else if(degrees>35) {
                System.out.println("Very hot");
            }
        }
        else{
            System.out.println("Wrong command");
        }
    }
}
