import java.util.Scanner;

public class P03_ExtractFile {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] pathArr = scanner.nextLine().split("\\\\");
        String[] file = pathArr[pathArr.length - 1].split("\\.");
        String extension = file[1];
        String name = file[0];

        System.out.printf("File name: %s%n", name);
        System.out.printf("File extension: %s%n", extension);
    }
}
