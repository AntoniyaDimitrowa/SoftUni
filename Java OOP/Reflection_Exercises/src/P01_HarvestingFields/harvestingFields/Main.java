package P01_HarvestingFields.harvestingFields;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		Class<RichSoilLand> richSoilLandClass = RichSoilLand.class;

		String command = scanner.nextLine();
		while (!"HARVEST".equals(command)) {
			switch (command) {
				case "private":
					Arrays.stream(richSoilLandClass.getDeclaredFields())
							.filter(f -> Modifier.isPrivate(f.getModifiers()))
							.forEach(f -> System.out.printf("private %s %s%n", f.getType().getSimpleName(), f.getName()));
					break;
				case "public":
					Arrays.stream(richSoilLandClass.getDeclaredFields())
							.filter(f -> Modifier.isPublic(f.getModifiers()))
							.forEach(f -> System.out.printf("public %s %s%n", f.getType().getSimpleName(), f.getName()));
					break;
				case "protected":
					Arrays.stream(richSoilLandClass.getDeclaredFields())
							.filter(f -> Modifier.isProtected(f.getModifiers()))
							.forEach(f -> System.out.printf("protected %s %s%n", f.getType().getSimpleName(), f.getName()));
					break;
				case "all":
					Arrays.stream(richSoilLandClass.getDeclaredFields())
							.forEach(f -> System.out.printf("%s %s %s%n", getModifier(f), f.getType().getSimpleName(), f.getName()));
					break;
			}
			command = scanner.nextLine();
		}
	}

	private static String getModifier(Field f) {
		int modifiers = f.getModifiers();
		if(Modifier.isPrivate(modifiers)) {
			return "private";
		} else if(Modifier.isPublic(modifiers)) {
			return "public";
		} else if(Modifier.isProtected(modifiers)) {
			return "protected";
		}

		throw new IllegalArgumentException("Unexpected modifier!");
	}
}
