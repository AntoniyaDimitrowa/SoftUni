package P02_BlackBoxInteger.blackBoxInteger;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws RuntimeException {
        Scanner scanner = new Scanner(System.in);

        Class<BlackBoxInt> blackBoxIntClass = BlackBoxInt.class;

        BlackBoxInt blackBoxInt;
        try {
            Constructor<BlackBoxInt> declaredConstructor = blackBoxIntClass.getDeclaredConstructor();
            declaredConstructor.setAccessible(true);
            blackBoxInt = declaredConstructor.newInstance();
        } catch (NoSuchMethodException | IllegalAccessException | InstantiationException | InvocationTargetException e) {
            throw new IllegalStateException(e);
        }

        String command = scanner.nextLine();
        while (!"END".equals(command)) {
            String[] commandParts = command.split("_");

            String methodName = commandParts[0];
            int parameter = Integer.parseInt(commandParts[1]);

            try {
                Method declaredMethod = blackBoxIntClass.getDeclaredMethod(methodName, int.class);
                declaredMethod.setAccessible(true);
                declaredMethod.invoke(blackBoxInt, parameter);
            } catch (NoSuchMethodException | InvocationTargetException | IllegalAccessException e) {
                throw new IllegalStateException(e);
            }

            int currValue;
            try {
                Field innerValue = blackBoxIntClass.getDeclaredField("innerValue");
                innerValue.setAccessible(true);
                currValue = innerValue.getInt(blackBoxInt);
            } catch (NoSuchFieldException | IllegalAccessException e) {
                throw new IllegalStateException(e);
            }

            System.out.println(currValue);

            command = scanner.nextLine();
        }
    }
}
