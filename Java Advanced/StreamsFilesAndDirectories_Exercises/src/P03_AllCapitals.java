import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;

public class P03_AllCapitals {
    public static void main(String[] args) {
        String basePath = "D:\\SoftUni\\SoftUni\\Java Advanced\\StreamsFilesAndDirectories_Exercises\\src\\Java-Advanced-Files-and-Streams-Exercises-Resources";
        String input = basePath + "\\input.txt";
        String output = basePath + "\\output_03.txt";

        try(BufferedReader reader = Files.newBufferedReader(Paths.get(input));
            PrintWriter writer = new PrintWriter(output)) {
            int currByte = reader.read();
            while(currByte >= 0) {
                if(Character.isAlphabetic(currByte)) {
                    currByte = Character.toUpperCase((char)currByte);
                }
                writer.print((char)currByte);
                currByte = reader.read();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
