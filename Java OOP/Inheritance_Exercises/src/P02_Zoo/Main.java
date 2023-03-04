package P02_Zoo;

import P02_Zoo.zoo.Bear;
import P02_Zoo.zoo.Gorilla;
import P02_Zoo.zoo.Lizard;
import P02_Zoo.zoo.Snake;

public class Main {
    public static void main(String[] args) {
        Bear bear  = new Bear("Ted");
        Gorilla gorilla  = new Gorilla("John");
        Lizard lizard  = new Lizard("Lizy");
        Snake snake  = new Snake("Lily");

        System.out.println(bear.getClass().getName() + ": " + bear.getName());
        System.out.println(gorilla.getClass().getName() + ": " + gorilla.getName());
        System.out.println(lizard.getClass().getName() + ": " + lizard.getName());
        System.out.println(snake.getClass().getName() + ": " + snake.getName());
    }
}
