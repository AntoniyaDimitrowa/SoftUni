package P03_StudentSystem;

public class CommandExecutor {
    private static final String EXIT_COMMAND = "Exit";
    private static final String CREATE_STUDENT_COMMAND = "Create";
    private static final String SHOW_STUDENT_COMMAND = "Show";

    private StudentSystem studentSystem;

    public CommandExecutor() {
        this.studentSystem = new StudentSystem();
    }

    public static boolean isExitCommand(String command) {
        return command.equals(EXIT_COMMAND);
    }

    public void executeCommand(String command, String[] data) {
        if (args[0].equals("Create")) {
            var name = args[1];
            var age = Integer.parseInt(args[2]);
            var grade = Double.parseDouble(args[3]);
            if (!repo.containsKey(name)) {
                var student = new Student(name, age, grade);
                repo.put(name, student);
            }
        } else if (args[0].equals("Show")) {
            var name = args[1];
            if (repo.containsKey(name)) {
                var student = repo.get(name);
                String view = String.format("%s is %s years old.", student.getName(), student.getAge());

                if (student.getGrade() >= 5.00) {
                    view += " Excellent student.";
                } else if (student.getGrade() < 5.00 && student.getGrade() >= 3.50) {
                    view += " Average student.";
                } else {
                    view += " Very nice person.";
                }

                System.out.println(view);
            }

        }
    }
}
