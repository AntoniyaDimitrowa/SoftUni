import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class P02_SumBytes {
    public static void main(String[] args) {
        String pathToFile = "D:\\SoftUni\\SoftUni\\Java Advanced\\StreamsFilesAndDirectories_Exercises\\src\\Java-Advanced-Files-and-Streams-Exercises-Resources\\input.txt";

        try(BufferedReader reader = Files.newBufferedReader(Paths.get(pathToFile))) {
            long currByte = reader.read();
            long sum = 0;
            while(currByte >= 0) {
                if(currByte != 10 && currByte != 13) {
                    sum = sum + currByte;
                }
                currByte = reader.read();
            }
            System.out.println(sum);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
