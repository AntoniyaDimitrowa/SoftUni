import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class P01_SumLines {
    public static void main(String[] args) {
        String pathToFile = "D:\\SoftUni\\SoftUni\\Java Advanced\\StreamsFilesAndDirectories_Exercises\\src\\Java-Advanced-Files-and-Streams-Exercises-Resources\\input.txt";

        try(BufferedReader reader = Files.newBufferedReader(Paths.get(pathToFile))) {
            String line = reader.readLine();
            while(line != null) {
                int sum = 0;
                for (int i = 0; i < line.length(); i++) {
                    sum = sum + line.charAt(i);
                }
                System.out.println(sum);
                line = reader.readLine();
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
