import java.util.Scanner;

public class P01PipesInPool {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int volume = Integer.parseInt(scanner.nextLine());
        int flowRateFirstPipePerHour = Integer.parseInt(scanner.nextLine());
        int flowRateSecondPipePerHour = Integer.parseInt(scanner.nextLine());
        double hours = Double.parseDouble(scanner.nextLine());

        double firstPipeLiters = flowRateFirstPipePerHour * hours;
        double secondPipeLiters = flowRateSecondPipePerHour * hours;
        double bothPipesLiters = firstPipeLiters + secondPipeLiters;
        double firstPipePercent = (firstPipeLiters / bothPipesLiters) * 100;
        double secondPipePercent = (secondPipeLiters / bothPipesLiters) * 100;
        double bothPipesPercent = (bothPipesLiters / volume) * 100;

        if(bothPipesPercent<=100) {
            System.out.printf("The pool is %.2f%% full. Pipe 1: %.2f%%. Pipe 2: %.2f%%.", bothPipesPercent, firstPipePercent, secondPipePercent);
        } else {
            double litersOverflows = ((bothPipesPercent / 100) * volume) - volume;
            System.out.printf("For %.2f hours the pool overflows with %.2f liters.", hours, litersOverflows);
        }
    }
}
