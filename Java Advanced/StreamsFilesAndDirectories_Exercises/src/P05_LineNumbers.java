import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;

public class P05_LineNumbers {
    public static void main(String[] args) {
        String basePath = "D:\\SoftUni\\SoftUni\\Java Advanced\\StreamsFilesAndDirectories_Exercises\\src\\Java-Advanced-Files-and-Streams-Exercises-Resources";
        String input = basePath + "\\inputLineNumbers.txt";
        String output = basePath + "\\output_05.txt";

        try(BufferedReader reader = Files.newBufferedReader(Paths.get(input));
            PrintWriter writer = new PrintWriter(output)) {
            String currLine = reader.readLine();
            int count = 1;
            while(currLine != null) {
                writer.print(count + ". ");
                writer.println(currLine);
                count++;
                currLine = reader.readLine();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
