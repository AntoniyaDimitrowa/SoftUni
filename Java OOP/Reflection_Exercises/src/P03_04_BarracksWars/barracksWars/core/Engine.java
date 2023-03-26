package P03_04_BarracksWars.barracksWars.core;

import P03_04_BarracksWars.barracksWars.core.commands.Command;
import P03_04_BarracksWars.barracksWars.core.commands.NamedCommand;
import P03_04_BarracksWars.barracksWars.interfaces.Repository;
import P03_04_BarracksWars.barracksWars.interfaces.Runnable;
import P03_04_BarracksWars.barracksWars.interfaces.UnitFactory;
import jdk.jshell.spi.ExecutionControl;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.InvocationTargetException;
import java.util.LinkedHashMap;
import java.util.Map;

public class Engine implements Runnable {

	private Repository repository;
	private UnitFactory unitFactory;

	private Map<String, Class<?>> registeredCommands = new LinkedHashMap<>();

	public Engine(Repository repository, UnitFactory unitFactory) {
		this.repository = repository;
		this.unitFactory = unitFactory;
	}

	@Override
	public void run() {
		BufferedReader reader = new BufferedReader(
				new InputStreamReader(System.in));
		while (true) {
			try {
				String input = reader.readLine();
				String[] data = input.split("\\s+");
				String commandName = data[0];
				String result = interpretCommand(data, commandName);
				if (result.equals("fight")) {
					break;
				}
				System.out.println(result);
			} catch (RuntimeException e) {
				System.out.println(e.getMessage());
			} catch (IOException | ExecutionControl.NotImplementedException e) {
				e.printStackTrace();
			}
		}
	}

	public void registerCommand(Class<?> commandClass) {
		NamedCommand annotation = commandClass.getAnnotation(NamedCommand.class);
		if(annotation == null) {
			throw new IllegalArgumentException("Expected " + commandClass.getSimpleName() + " to have a " + NamedCommand.class.getSimpleName() + "annotation.");
		}

		registeredCommands.put(annotation.commandName(), commandClass);
	}

	private String interpretCommand(String[] data, String commandName) throws ExecutionControl.NotImplementedException {
		Command command = buildCommand(data, commandName);

		if(command == null) {
			throw new IllegalArgumentException("Can't find command " + commandName);
		}

		return command.execute();
	}

	private Command buildCommand(String[] data, String commandName) {
		if(!registeredCommands.containsKey(commandName)) {
			return null;
		}

		try {
			return (Command) registeredCommands.get(commandName).getConstructor(String[].class, Repository.class, UnitFactory.class).newInstance(data, repository, unitFactory);
		} catch (InvocationTargetException | InstantiationException | IllegalAccessException | NoSuchMethodException e) {
			throw new IllegalStateException(e);
		}

	}
}
