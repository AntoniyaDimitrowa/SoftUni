package P03_04_BarracksWars.barracksWars.core.commands;

import P03_04_BarracksWars.barracksWars.interfaces.Repository;
import P03_04_BarracksWars.barracksWars.interfaces.UnitFactory;

@NamedCommand(commandName = "retire")
public class RetireCommand extends Command {
    public RetireCommand(String[] data, Repository repository, UnitFactory unitFactory) {
       super(data, repository, unitFactory);
    }

    @Override
    public String execute() {
        try {
            getRepository().removeUnit(getData()[1]);
            return getData()[1] + " retired!";
        } catch (IllegalStateException e) {
            return e.getMessage();
        }
    }
}
