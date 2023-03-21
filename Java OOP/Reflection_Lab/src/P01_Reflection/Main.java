package P01_Reflection;

import java.lang.reflect.InvocationTargetException;

public class Main {
    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        Class reflectionClass = Reflection.class;

        System.out.println("class " + reflectionClass.getSimpleName());

        System.out.println(reflectionClass.getSuperclass());

        Class[] interfaces = reflectionClass.getInterfaces();
        for (Class i: interfaces ) {
            System.out.println(i);
        }

        Object reflectionObject = reflectionClass.getDeclaredConstructor().newInstance();
        System.out.println(reflectionObject);
    }
}
