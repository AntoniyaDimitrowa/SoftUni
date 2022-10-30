import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class P05_Students {

    static class Student {
        private String firstName;
        private String lastName;
        private int age;
        private String hometown;

        public Student(String firstName, String lastName, int age, String hometown) {
            this.firstName = firstName;
            this.lastName = lastName;
            this.age = age;
            this.hometown = hometown;
        }

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
        public int getAge() {
            return this.age;
        }
        public void setAge(int age) {
            this.age = age;
        }
        public String getHometown() {
            return this.hometown;
        }
        public void setHometown(String hometown) {
            this.hometown = hometown;
        }

        public static boolean IsStudentExisting(List<Student> students, String firstName, String lastName) {
            for(Student student : students) {
                if(student.getFirstName().equals(firstName) && student.getLastName().equals(lastName)) {
                    return true;
                }
            }
            return false;
        }

        public static Student getStudent(List<Student> students, String firstName, String lastName) {
            Student existingStudent = null;

            for (Student student : students) {
                if (student.getFirstName().equals(firstName) && student.getLastName().equals(lastName)) {
                    existingStudent = student;
                }
            }
            return existingStudent;
        }
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Student> students = new ArrayList<>();
        String[] command = scanner.nextLine().split("\\s+");

        while (!command[0].equals("end")) {
            String firstName = command[0];
            String lastName = command[1];
            int age = Integer.parseInt(command[2]);
            String hometown = command[3];

            if(Student.IsStudentExisting(students, firstName, lastName)) {
                Student student = Student.getStudent(students, firstName, lastName);

                student.setFirstName(firstName);
                student.setLastName(lastName);
                student.setAge(age);
                student.setHometown(hometown);
            } else {
                Student currStudent = new Student(firstName, lastName, age, hometown);
                students.add(currStudent);
            }

            command = scanner.nextLine().split("\\s+");
        }

        String filterTown = scanner.nextLine();
        for (int i = 0; i < students.size(); i++) {
            if(filterTown.equals(students.get(i).hometown)) {
                System.out.printf("%s %s is %d years old%n", students.get(i).firstName, students.get(i).lastName, students.get(i).age);
            }
        }
    }
}
