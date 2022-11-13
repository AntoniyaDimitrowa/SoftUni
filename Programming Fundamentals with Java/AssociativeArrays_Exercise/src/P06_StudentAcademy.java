import java.util.*;

public class P06_StudentAcademy {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numberOfPairs = Integer.parseInt(scanner.nextLine());
        LinkedHashMap<String, List<Double>> studentsGrades = new LinkedHashMap<>();
        LinkedHashMap<String, Double> students = new LinkedHashMap<>();

        for (int i = 0; i < numberOfPairs; i++) {
            String studentsName = scanner.nextLine();
            double currGrade = Double.parseDouble(scanner.nextLine());

            if(studentsGrades.containsKey(studentsName)) {
                List<Double> currGrades = new ArrayList<>(List.copyOf(studentsGrades.get(studentsName)));
                currGrades.add(currGrade);
                studentsGrades.put(studentsName, currGrades);
            } else {
                List<Double> currGrades = new ArrayList<>();
                currGrades.add(currGrade);
                studentsGrades.put(studentsName, currGrades);
            }
        }

        for (Map.Entry<String, List<Double>> entry: studentsGrades.entrySet()) {
            double averageGrade = entry.getValue().stream().mapToDouble(Double::doubleValue).average().getAsDouble();
            students.put(entry.getKey(), averageGrade);
        }

        for (Map.Entry<String, Double> entry: students.entrySet()) {
            if(entry.getValue() >= 4.50) {
                System.out.printf("%s -> %.2f%n", entry.getKey(), entry.getValue());
            }
        }
    }
}
