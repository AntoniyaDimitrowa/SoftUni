import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class P03_OpinionPoll {
    static class Person {
        private String name;
        private int age;

        public String getName() {
            return this.name;
        }
        public void setName(String name) {
            this.name = name;
        }
        public int getAge() {
            return this.age;
        }
        public void setAge(int age) {
            this.age = age;
        }

        public Person(String name, int age) {
            this.name = name;
            this.age = age;
        }

        public String toString() {
            return this.name + " - " + this.age;
        }
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numberOfPeople = Integer.parseInt(scanner.nextLine());
        List<Person> people = new ArrayList<>();
        for (int i = 0; i < numberOfPeople; i++) {
            String[] personalInfo = scanner.nextLine().split("\\s+");
            String name = personalInfo[0];
            int age = Integer.parseInt(personalInfo[1]);

            Person currPerson = new Person(name, age);
            people.add(currPerson);
        }
        for (int i = 0; i < people.size(); i++) {
            if(people.get(i).age > 30) {
                System.out.println(people.get(i).toString());
            }
        }
    }
}
