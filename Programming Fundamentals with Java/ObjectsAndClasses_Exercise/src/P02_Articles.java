import java.util.Scanner;

public class P02_Articles {
    static class Article {
        private String title;
        private String content;
        private String author;

        public String getTitle() {
            return this.title;
        }
        public void setTitle(String title) {
            this.title = title;
        }
        public String getContent() {
            return this.content;
        }
        public void setContent(String content) {
            this.content = content;
        }
        public String getAuthor() {
            return this.author;
        }
        public void setAuthor(String author) {
            this.author = author;
        }

        public Article(String title, String content, String author) {
            this.title = title;
            this.content = content;
            this.author = author;
        }

        public void Edit(String newContent) {
            this.content = newContent;
        }

        public void ChangeAuthor(String newAuthor) {
            this.author = newAuthor;
        }

        public void Rename(String newTitle) {
            this.title = newTitle;
        }

        public String toString() {
            return this.title + " - " + this.content + ": " + this.author;
        }
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] articleArr = scanner.nextLine().split(", ");
        Article article = new Article(articleArr[0], articleArr[1], articleArr[2]);

        int n = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < n; i++) {
            String[] commandArr = scanner.nextLine().split(": ");
            String command = commandArr[0];

            switch (command) {
                case "Edit":
                    String newContent = commandArr[1];
                    article.Edit(newContent);
                    break;
                case "ChangeAuthor":
                    String newAuthor = commandArr[1];
                    article.ChangeAuthor(newAuthor);
                    break;
                case "Rename":
                    String newTitle = commandArr[1];
                    article.Rename(newTitle);
                    break;
            }
        }
        System.out.println(article.toString());
    }
}
