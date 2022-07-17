import java.util.Scanner;

public class P12TradeCommissions {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String city = scanner.nextLine();
        double salesVolume = Double.parseDouble(scanner.nextLine());

        if(salesVolume >= 0 && salesVolume <= 500) {
            switch (city) {
                case "Sofia":
                    System.out.printf("%.2f", salesVolume * 0.05);
                    break;
                case "Varna":
                    System.out.printf("%.2f", salesVolume * 0.045);
                    break;
                case "Plovdiv":
                    System.out.printf("%.2f", salesVolume * 0.055);
                    break;
                default:
                    System.out.println("error");
                    break;
            }
        } else if(salesVolume > 500 && salesVolume <= 1000) {
            switch (city) {
                case "Sofia":
                    System.out.printf("%.2f", salesVolume * 0.07);
                    break;
                case "Varna":
                    System.out.printf("%.2f", salesVolume * 0.075);
                    break;
                case "Plovdiv":
                    System.out.printf("%.2f", salesVolume * 0.08);
                    break;
                default:
                    System.out.println("error");
                    break;
            }
        } else if(salesVolume >= 1000 && salesVolume <= 10000) {
            switch (city) {
                case "Sofia":
                    System.out.printf("%.2f", salesVolume * 0.08);
                    break;
                case "Varna":
                    System.out.printf("%.2f", salesVolume * 0.10);
                    break;
                case "Plovdiv":
                    System.out.printf("%.2f", salesVolume * 0.12);
                    break;
                default:
                    System.out.println("error");
                    break;
            }
        } else if(salesVolume > 10000) {
            switch (city) {
                case "Sofia":
                    System.out.printf("%.2f", salesVolume * 0.12);
                    break;
                case "Varna":
                    System.out.printf("%.2f", salesVolume * 0.13);
                    break;
                case "Plovdiv":
                    System.out.printf("%.2f", salesVolume * 0.145);
                    break;
                default:
                    System.out.println("error");
                    break;
            }
        } else {
            System.out.println("error");
        }
    }
}
