import java.lang.reflect.Array;
import java.util.*;

public class P04_Students {
    static class Student {
        private String firstName;
        private String lastName;
        private double grade;

        public String getFirstName() {
            return this.firstName;
        }
        public void setFirstName(String firstName) {
            this.firstName = firstName;
        }
        public String getLastName() {
            return this.lastName;
        }
        public void setLastName(String lastName) {
            this.lastName = lastName;
        }
        public double getGrade() {
            return this.grade;
        }
        public void setGrade(double grade) {
            this.grade = grade;
        }

        public Student(String firstName, String lastName, double grade) {
            this.firstName = firstName;
            this.lastName = lastName;
            this.grade = grade;
        }

        public String toString() {
            return this.firstName + " " + this.lastName + ": " + this.grade;
        }

    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numberOfStudents = Integer.parseInt(scanner.nextLine());
        List<Student> students = new ArrayList<>();
        List<Double> grades = new ArrayList<>();
        for (int i = 0; i < numberOfStudents; i++) {
            String[] studentInfo = scanner.nextLine().split("\\s+");
            String firstName = studentInfo[0];
            String lastName = studentInfo[1];
            double grade = Double.parseDouble(studentInfo[2]);

            Student currStudent = new Student(firstName, lastName, grade);
            students.add(currStudent);

            grades.add(grade);
        }

        Collections.sort(grades);
        Collections.reverse(grades);
        for (int i = 0; i < grades.size(); i++) {
            for (int j = 0; j < students.size(); j++) {
                if(grades.get(i) == students.get(j).grade) {
                    System.out.printf("%s %s: %.2f%n", students.get(j).firstName, students.get(j).lastName, students.get(j).grade);
                }
            }
        }
    }
}
