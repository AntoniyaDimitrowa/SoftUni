package P02_GettersAndSetters;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Comparator;

public class Main {
    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        Class<Reflection> reflectionClass = Reflection.class;
        Method[] methods = reflectionClass.getDeclaredMethods();

        Arrays.stream(methods)
                .filter(m -> isGetterMethod(m))
                .sorted(Comparator.comparing(Method::getName))
                .forEach(m -> System.out.printf("%s will return class %s%n",
                        m.getName(),
                        m.getReturnType().getSimpleName()));

        Arrays.stream(methods)
                .filter(m -> isSetterMethod(m))
                .sorted(Comparator.comparing(Method::getName))
                .forEach(m -> System.out.printf("%s and will set field of class %s%n",
                        m.getName(),
                        m.getParameterTypes()[0].getSimpleName()));
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
