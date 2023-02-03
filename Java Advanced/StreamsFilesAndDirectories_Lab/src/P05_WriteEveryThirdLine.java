import java.io.*;

public class P05_WriteEveryThirdLine {
    public static void main(String[] args) throws FileNotFoundException {
        String basePath = "D:\\SoftUni\\Java\\04. Java-Advanced-Files-and-Streams-Lab-Resources";
        String inputPath = basePath + "\\input.txt";
        String outputPath = basePath + "\\05_output.txt";

        try(BufferedReader reader = new BufferedReader(new FileReader(inputPath));
            PrintWriter writer = new PrintWriter(new FileWriter(outputPath))) {

            String currLine = reader.readLine();
            int count = 1;
            while(currLine != null) {
                if(count % 3 == 0) {
                    writer.println(currLine);
                }
                count++;
                currLine = reader.readLine();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
