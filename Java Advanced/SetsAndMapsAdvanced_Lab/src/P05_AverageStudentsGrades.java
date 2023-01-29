import java.util.*;

public class P05_AverageStudentsGrades {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, List<Double>> students = new TreeMap<>();
        int num = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < num; i++) {
            String[] input = scanner.nextLine().split("\\s+");
            String name = input[0];
            double grade = Double.parseDouble(input[1]);
            if(students.containsKey(name)) {
                List<Double> grades = students.get(name);
                grades.add(grade);
                students.put(name, grades);
            } else {
                List<Double> grades = new ArrayList<>();
                grades.add(grade);
                students.put(name, grades);
            }
        }
        for (Map.Entry<String, List<Double>> entry : students.entrySet()) {
            String name = entry.getKey();
            List<Double> grades = entry.getValue();
            double averageGrade = 0;
            System.out.print(name + " -> ");
            for (int i = 0; i < grades.size(); i++) {
                averageGrade += grades.get(i);
                System.out.printf("%.2f ", grades.get(i));
            }
            averageGrade = averageGrade / grades.size();
            System.out.printf("(avg: %.2f)%n", averageGrade);
        }
    }
}
