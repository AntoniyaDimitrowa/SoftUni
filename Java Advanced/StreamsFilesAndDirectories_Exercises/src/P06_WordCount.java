import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.LinkedHashMap;
import java.util.Map;


public class P06_WordCount {
    public static void main(String[] args) {
        String basePath = "D:\\SoftUni\\SoftUni\\Java Advanced\\StreamsFilesAndDirectories_Exercises\\src\\Java-Advanced-Files-and-Streams-Exercises-Resources";
        String wordsPath = basePath + "\\words.txt";
        String textPath = basePath + "\\text.txt";
        String output = basePath + "\\result_06.txt";
        Map<String, Integer> wordCount = new LinkedHashMap<>();

        try(BufferedReader readerWords = Files.newBufferedReader(Paths.get(wordsPath));
            BufferedReader readerText = Files.newBufferedReader(Paths.get(textPath));
            PrintWriter writer = new PrintWriter(output)) {
            String[] words = readerWords.readLine().split("\\s+");
            for (int i = 0; i < words.length; i++) {
                wordCount.put(words[i], 0);
            }
            String currLine = readerText.readLine();
            while(currLine != null) {
                String[] currLineArr = currLine.split("[\\,\\.]*\\s+");
                for (int i = 0; i < currLineArr.length; i++) {
                    if(wordCount.containsKey(currLineArr[i])) {
                        int count = wordCount.get(currLineArr[i]);
                        count++;
                        wordCount.put(currLineArr[i], count);
                    }
                }
                currLine = readerText.readLine();
            }
            wordCount.entrySet().stream()
                    .sorted((e1, e2) -> e2.getValue().compareTo(e1.getValue()))
                    .forEach(k -> writer.printf("%s - %d%n", k.getKey(), k.getValue()));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
