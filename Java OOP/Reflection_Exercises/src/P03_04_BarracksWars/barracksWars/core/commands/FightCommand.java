package P03_04_BarracksWars.barracksWars.core.commands;

import P03_04_BarracksWars.barracksWars.interfaces.Repository;
import P03_04_BarracksWars.barracksWars.interfaces.UnitFactory;

@NamedCommand(commandName = "fight")
public class FightCommand extends Command {
    public FightCommand(String[] data, Repository repository, UnitFactory unitFactory) {
        super(data, repository, unitFactory);
    }

    @Override
    public String execute() {
        return "fight";
    }
}
