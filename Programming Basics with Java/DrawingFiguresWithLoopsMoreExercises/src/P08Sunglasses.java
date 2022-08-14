import java.util.Scanner;

public class P08Sunglasses {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = Integer.parseInt(scanner.nextLine());

        for(int row = 1; row <= num; row++) {
            if(row == 1 || row == num) {
                for(int coll = 1; coll <= num*2; coll++) {
                    System.out.printf("*");
                }
                for(int coll = 1; coll <= num; coll++) {
                    System.out.printf(" ");
                }
                for(int coll = 1; coll <= num*2; coll++) {
                    System.out.printf("*");
                }
            } else {
                for(int coll = 1; coll <= num*2; coll++) {
                    if(coll == 1 || coll == num*2) {
                        System.out.printf("*");
                    } else {
                        System.out.printf("/");
                    }
                }
                for(int coll = 1; coll <= num; coll++) {
                    if(row == Math.ceil(num / 2.0)) {
                        System.out.printf("|");
                    } else {
                        System.out.printf(" ");
                    }
                }
                for(int coll = 1; coll <= num*2; coll++) {
                    if(coll == 1 || coll == num*2) {
                        System.out.printf("*");
                    } else {
                        System.out.printf("/");
                    }
                }
            }
            System.out.println();
        }
    }
}
