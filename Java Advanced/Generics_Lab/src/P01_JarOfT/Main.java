package P01_JarOfT;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Jar<Integer> jar = new Jar<>();

        jar.add(1);
        jar.add(2);
        jar.add(3);
        jar.add(4);

        System.out.println(jar.remove());
        System.out.println(jar.remove());
    }
}
