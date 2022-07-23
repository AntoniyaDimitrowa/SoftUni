import java.util.Scanner;

public class P06VowelsSum {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String text = scanner.nextLine();
        int result = 0;

        for(int i = 0; i < text.length(); i++) {
            char letter = text.charAt(i);
            if(letter == 'a'){
                result = result + 1;
            } else if(letter == 'e'){
                result = result + 2;
            } else if(letter == 'i'){
                result = result + 3;
            } else if(letter == 'o'){
                result = result + 4;
            } else if(letter == 'u'){
                result = result + 5;
            }
        }
        System.out.println(result);
    }
}
