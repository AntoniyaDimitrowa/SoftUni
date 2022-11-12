import java.util.*;

public class P05_Courses {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        LinkedHashMap<String, Integer> courses = new LinkedHashMap<>();
        LinkedHashMap<String, String> students = new LinkedHashMap<>();

        String[] command = scanner.nextLine().split(" : ");
        while(!command[0].equals("end")) {
            String courseName = command[0];
            String studentName = command[1];
            students.put(studentName, courseName);

            if(courses.containsKey(courseName)) {
                courses.put(courseName, courses.get(courseName) + 1);
            } else {
                courses.put(courseName, 1);
            }
            command = scanner.nextLine().split(" : ");
        }

        for (Map.Entry<String, Integer> course : courses.entrySet()) {
            System.out.printf("%s: %d%n", course.getKey(), course.getValue());
            for (Map.Entry<String, String> student : students.entrySet()) {
                if(course.getKey().equals(student.getValue())) {
                    System.out.printf("-- %s%n", student.getKey());
                }
            }
        }
    }
}
