import java.io.*;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;


public class P02_WriteToFile {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        String basePath = "D:\\SoftUni\\Java\\04. Java-Advanced-Files-and-Streams-Lab-Resources";
        String inputPath = basePath + "\\input.txt";
        String outputPath = basePath + "\\output.txt";
        List<Character> punctuation = Arrays.asList(',', '.', '!', '?');

        OutputStream outputStream = new FileOutputStream(outputPath);

        try(InputStream inputStream = new FileInputStream(inputPath)) {
            int readByte  = inputStream.read();
            while (readByte >= 0) {

                if(!punctuation.contains((char)readByte)) {
                    outputStream.write(readByte);
                }

                readByte  = inputStream.read();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        outputStream.close();
    }
}
