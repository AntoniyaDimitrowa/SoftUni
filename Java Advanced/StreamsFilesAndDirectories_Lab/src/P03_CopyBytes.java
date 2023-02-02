import java.io.*;
import java.util.Scanner;

public class P03_CopyBytes {
    public static void main(String[] args) {
        String basePath = "D:\\SoftUni\\Java\\04. Java-Advanced-Files-and-Streams-Lab-Resources";
        String inputPath = basePath + "\\input.txt";
        String outputPath = basePath + "\\03_output.txt";

        try(InputStream inputStream = new FileInputStream(inputPath);
            OutputStream outputStream = new FileOutputStream(outputPath)) {
            int currByte = inputStream.read();
            while(currByte >= 0) {
                if(currByte == 10 || currByte == 32) {
                    outputStream.write((char)currByte);
                } else {
                    String currCharASCII = String.valueOf(currByte);
                    for (int i = 0; i < currCharASCII.length(); i++) {
                        outputStream.write(currCharASCII.charAt(i));
                    }
                }
                currByte = inputStream.read();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
