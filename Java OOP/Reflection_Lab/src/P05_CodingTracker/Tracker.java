package P05_CodingTracker;

import java.lang.reflect.Method;

public class Tracker {
    @Author(name = "George")
    public static void main(String[] args) {
        printMethodsByAuthor(Tracker.class);
    }

    @Author(name = "Peter")
    public static void printMethodsByAuthor(Class<?> clazz) {
        Method[] methods = clazz.getDeclaredMethods();
        for (Method m : methods) {
            Author author = m.getAnnotation(Author.class);
            if(author != null) {
                System.out.printf("%s: %s()%n", author.name(), m.getName());
            }
        }
    }
}
