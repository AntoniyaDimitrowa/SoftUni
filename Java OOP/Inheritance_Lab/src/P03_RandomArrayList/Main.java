package P03_RandomArrayList;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        RandomArrayList<Integer> randomArrayList = new RandomArrayList<>();
        randomArrayList.add(5);
        randomArrayList.add(7);
        randomArrayList.add(6);
        randomArrayList.add(8);
        randomArrayList.add(9);
        randomArrayList.add(10);
        randomArrayList.add(11);

        System.out.println(randomArrayList.getRandomElement());
        System.out.println(randomArrayList.getRandomElement());
        System.out.println(randomArrayList.getRandomElement());
        System.out.println(randomArrayList.getRandomElement());
        System.out.println(randomArrayList.getRandomElement());
        System.out.println(randomArrayList.getRandomElement());
    }
}
