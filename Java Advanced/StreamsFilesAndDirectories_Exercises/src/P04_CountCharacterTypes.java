import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.LinkedHashMap;
import java.util.Map;

public class P04_CountCharacterTypes {
    public static void main(String[] args) {
        String basePath = "D:\\SoftUni\\SoftUni\\Java Advanced\\StreamsFilesAndDirectories_Exercises\\src\\Java-Advanced-Files-and-Streams-Exercises-Resources";
        String input = basePath + "\\input.txt";
        String output = basePath + "\\output_04.txt";
        Map<String, Integer> groups = new LinkedHashMap<>();
        groups.put("Vowels", 0);
        groups.put("Other symbols", 0);
        groups.put("Punctuation", 0);

        try(BufferedReader reader = Files.newBufferedReader(Paths.get(input));
            PrintWriter writer = new PrintWriter(output)) {
            int currByte = reader.read();
            while(currByte >= 0) {
                if(currByte == '!' || currByte == '?' || currByte == '.' || currByte == ',') {
                    int count = groups.get("Punctuation");
                    count++;
                    groups.put("Punctuation", count);
                } else if(currByte == 'a' || currByte == 'e' || currByte == 'i' || currByte == 'o' || currByte == 'u') {
                    int count = groups.get("Vowels");
                    count++;
                    groups.put("Vowels", count);
                } else if(currByte != 10 && currByte != 32 && currByte != 13) {
                    int count = groups.get("Other symbols");
                    count++;
                    groups.put("Other symbols", count);
                }
                currByte = reader.read();
            }
            groups.forEach((k,v) -> writer.printf("%s: %d%n", k, v));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
