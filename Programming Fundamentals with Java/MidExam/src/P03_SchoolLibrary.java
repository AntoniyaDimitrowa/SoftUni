import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class P03_SchoolLibrary {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<String> bookList = Arrays.stream(scanner.nextLine().split("&")).collect(Collectors.toList());
        String input = scanner.nextLine();

        while (!input.equals("Done")) {
            String[] commandArr = input.split(" \\| ");
            String command = commandArr[0];
            switch (command) {
                case "Add Book":
                    String addBookName = commandArr[1];
                    if(!bookList.contains(addBookName)) {
                        bookList.add(0, addBookName);
                    }
                    break;
                case "Take Book":
                    String takeBookName = commandArr[1];
                    if(bookList.contains(takeBookName)) {
                        bookList.remove(takeBookName);
                    }
                    break;
                case "Swap Books":
                    String book1 = commandArr[1];
                    String book2 = commandArr[2];
                    if(bookList.contains(book1) && bookList.contains(book2)) {
                        int book1Index = bookList.indexOf(book1);
                        int book2Index = bookList.indexOf(book2);
                        bookList.remove(book1Index);
                        bookList.add(book1Index, book2);
                        bookList.remove(book2Index);
                        bookList.add(book2Index, book1);
                    }
                    break;
                case "Insert Book":
                    String insertBookName = commandArr[1];
                    if(!bookList.contains(insertBookName)) {
                        bookList.add(insertBookName);
                    }
                    break;
                case "Check Book":
                    int index = Integer.parseInt(commandArr[1]);
                    if(index >= 0 && index < bookList.size()) {
                        System.out.println(bookList.get(index));
                    }
                    break;
            }
            input = scanner.nextLine();
        }

        for (int i = 0; i < bookList.size() - 1; i++) {
            System.out.print(bookList.get(i) + ", ");
        }
        System.out.println(bookList.get(bookList.size()-1));
    }
}
