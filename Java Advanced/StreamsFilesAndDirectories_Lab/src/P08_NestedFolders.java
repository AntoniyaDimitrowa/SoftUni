import java.io.File;
import java.util.ArrayDeque;
import java.util.Deque;

public class P08_NestedFolders {
    public static void main(String[] args) {
        String folderPath = "D:\\SoftUni\\Java\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\Files-and-Streams";

        File file = new File(folderPath);
        Deque<File> folders = new ArrayDeque<>();
        folders.offer(file);
        int count = 0;
        while (!folders.isEmpty()) {
            File currFolder = folders.poll();
            File[] currFolderFiles = currFolder.listFiles();
            if (currFolderFiles != null) {
                for (File f : currFolderFiles) {
                    if (f.isDirectory()) {
                        folders.offer(f);

                    }
                }
            }
            System.out.println(currFolder.getName());
            count++;
        }
        System.out.println(count + " folders");
    }
}
