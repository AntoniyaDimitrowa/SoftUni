import java.util.*;

public class P06_OrderByAge {

    static class Person {
        private String name;
        private String id;
        private int age;

        public String getName() {
            return this.name;
        }
        public String getID() {
            return this.id;
        }
        public int getAge() {
            return this.age;
        }

        public Person(String name, String id, int age) {
            this.name = name;
            this.id = id;
            this.age = age;
        }

        public String toString() {
            return getName() + " with ID: " + getID() + " is " + getAge() + " years old.%n";
        }

    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        List<Person> people = new ArrayList<>();

        while (!input.equals("End")) {
            String name = input.split(" ")[0];
            String id = input.split(" ")[1];
            int age = Integer.parseInt(input.split(" ")[2]);

            Person currPerson = new Person(name, id, age);
            people.add(currPerson);
            input = scanner.nextLine();
        }

       people.sort(Comparator.comparing(Person::getAge));
        for (int i = 0; i < people.size(); i++) {
            System.out.printf(people.get(i).toString());
        }
    }
}
