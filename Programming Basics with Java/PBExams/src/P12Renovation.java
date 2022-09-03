import java.util.Scanner;

public class P12Renovation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int height = Integer.parseInt(scanner.nextLine());
        int width = Integer.parseInt(scanner.nextLine());
        int percent = Integer.parseInt(scanner.nextLine());

        double areaForPainting = Math.ceil(height * width * 4 - (height * width * 4) * (percent / 100.0));

        String command = scanner.nextLine();
        while (!command.equals("Tired!")) {
            int litersOfPaint = Integer.parseInt(command);
            areaForPainting -= litersOfPaint;
            if(areaForPainting <= 0) {
                break;
            }
            command = scanner.nextLine();
        }
        if(areaForPainting == 0) {
            System.out.println("All walls are painted! Great job, Pesho!");
        } else if(areaForPainting < 0) {
            System.out.printf("All walls are painted and you have %.0f l paint left!%n", Math.abs(areaForPainting));
        } else {
            System.out.printf("%.0f quadratic m left.", areaForPainting);
        }
    }
}
