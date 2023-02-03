import java.io.File;

public class P08_NestedFolders {
    public static void main(String[] args) {
        String folderPath = "D:\\SoftUni\\Java\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\Files-and-Streams";

        File file = new File(folderPath);
        File[] nestedFiles = file.listFiles();

        int count = 0;
        for (File nestedFile : nestedFiles) {
            if(nestedFile.isDirectory()) {
                System.out.println(nestedFile.getName());
                count++;
            }
        }
        System.out.println(count + " folders");
    }
}
