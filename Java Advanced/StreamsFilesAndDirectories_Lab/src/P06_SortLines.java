import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

public class P06_SortLines {
    public static void main(String[] args) throws IOException {
        String basePath = "D:\\SoftUni\\Java\\04. Java-Advanced-Files-and-Streams-Lab-Resources";
        String inputPath = basePath + "\\input.txt";

        Path path = Paths.get(inputPath);
        //Paths.get("folder", "folder3", "inner", "file");

        List<String> sortedLines = Files.readAllLines(path)
                .stream()
                .sorted()
                .collect(Collectors.toList());

        Path outputPath = Paths.get(basePath + "\\06_output.txt");
        Files.write(outputPath, sortedLines);
    }
}
