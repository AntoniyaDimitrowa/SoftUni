import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class P02_FancyBarcodes {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int barcodesCount = Integer.parseInt(scanner.nextLine());
        String regex = "@#+[A-Z][A-Za-z0-9]{4}[A-Za-z0-9]*[A-Z]@#+";
        Pattern pattern = Pattern.compile(regex);

        for (int i = 0; i < barcodesCount; i++) {
            String currBarcode = scanner.nextLine();
            Matcher isValid = pattern.matcher(currBarcode);

            if(isValid.find()) {
                String productGroup = "";
                for (int j = 0; j < currBarcode.length(); j++) {
                    if(Character.isDigit(currBarcode.charAt(j))) {
                        productGroup += currBarcode.charAt(j);
                    }
                }
                if(productGroup.equals("")) {
                    productGroup = "00";
                }

                System.out.printf("Product group: %s%n", productGroup);
            } else {
                System.out.println("Invalid barcode");
            }
        }
    }
}
