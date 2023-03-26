package P03_04_BarracksWars.barracksWars.core.commands;

import P03_04_BarracksWars.barracksWars.interfaces.Repository;
import P03_04_BarracksWars.barracksWars.interfaces.Unit;
import P03_04_BarracksWars.barracksWars.interfaces.UnitFactory;
import jdk.jshell.spi.ExecutionControl;

@NamedCommand(commandName = "add")
public class AddUnitCommand extends Command {

    public AddUnitCommand(String[] data, Repository repository, UnitFactory unitFactory) {
        super(data, repository, unitFactory);
    }

    @Override
    public String execute() {
        String unitType = this.getData()[1];
        Unit unitToAdd = null;
        try {
            unitToAdd = this.getUnitFactory().createUnit(unitType);
        } catch (ExecutionControl.NotImplementedException e) {
            throw new IllegalStateException(e);
        }
        this.getRepository().addUnit(unitToAdd);
        String output = unitType + " added!";
        return output;
    }
}
