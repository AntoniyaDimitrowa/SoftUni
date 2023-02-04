import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;

public class P07_MergeTwoFiles {
    public static void main(String[] args) {
        String basePath = "D:\\SoftUni\\SoftUni\\Java Advanced\\StreamsFilesAndDirectories_Exercises\\src\\Java-Advanced-Files-and-Streams-Exercises-Resources";
        String inputOnePath = basePath + "\\inputOne.txt";
        String inputTwoPath = basePath + "\\inputTwo.txt";
        String output = basePath + "\\result_07.txt";

        try(BufferedReader readerOne = Files.newBufferedReader(Paths.get(inputOnePath));
            BufferedReader readerTwo = Files.newBufferedReader(Paths.get(inputTwoPath));
            PrintWriter writer = new PrintWriter(output)) {
            String currLine1 = readerOne.readLine();
            while(currLine1 != null) {
                writer.println(currLine1);
                currLine1 = readerOne.readLine();
            }
            String currLine2 = readerTwo.readLine();
            while(currLine2 != null) {
                writer.println(currLine2);
                currLine2 = readerTwo.readLine();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
