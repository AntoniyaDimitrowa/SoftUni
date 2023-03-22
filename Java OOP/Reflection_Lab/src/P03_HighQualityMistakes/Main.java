package P03_HighQualityMistakes;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Arrays;
import java.util.Comparator;

public class Main {
    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        Class<Reflection> reflectionClass = Reflection.class;

        Field[] fields = reflectionClass.getDeclaredFields();
        Method[] methods = reflectionClass.getDeclaredMethods();

        //mistakes in fields modifiers
        Arrays.stream(fields)
                .filter(f -> !hasPrivateModifier(f))
                .sorted(Comparator.comparing(Field::getName))
                .forEach(f -> System.out.printf("%s must be private!%n", f.getName()));

        //mistakes in getters modifiers
        Arrays.stream(methods)
                .filter(m -> isGetterMethod(m))
                .filter(m -> !hasPublicModifier(m))
                .sorted(Comparator.comparing(Method::getName))
                .forEach(m -> System.out.printf("%s have to be public!%n",
                        m.getName(),
                        m.getReturnType().getSimpleName()));

        //mistakes in setters modifiers
        Arrays.stream(methods)
                .filter(m -> isSetterMethod(m))
                .filter(m -> !hasPrivateModifier(m))
                .sorted(Comparator.comparing(Method::getName))
                .forEach(m -> System.out.printf("%s have to be private!%n",
                        m.getName(),
                        m.getParameterTypes()[0].getSimpleName()));
    }

    private static boolean hasPrivateModifier(Method m) {
        if(Modifier.isPrivate(m.getModifiers())) {
            return true;
        }
        return false;
    }

    private static boolean hasPublicModifier(Method m) {
        if(Modifier.isPublic(m.getModifiers())) {
            return true;
        }
        return false;
    }

    private static boolean hasPrivateModifier(Field f) {
        if(Modifier.isPrivate(f.getModifiers())) {
            return true;
        }
        return false;
    }

    private static boolean isSetterMethod(Method m) {
        if(!m.getName().startsWith("set")) { return false; }

        if(!m.getReturnType().equals(void.class)) { return false; }

        if(m.getParameterCount() != 1) { return false; }

        return true;
    }

    private static boolean isGetterMethod(Method m) {
        if(!m.getName().startsWith("get")) { return false; }

        if(m.getReturnType().equals(void.class)) { return false; }

        if(m.getParameterCount() > 0) { return false; }

        return true;
    }
}
