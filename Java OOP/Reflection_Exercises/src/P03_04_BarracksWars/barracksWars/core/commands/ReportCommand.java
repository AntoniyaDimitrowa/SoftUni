package P03_04_BarracksWars.barracksWars.core.commands;

import P03_04_BarracksWars.barracksWars.interfaces.Repository;
import P03_04_BarracksWars.barracksWars.interfaces.UnitFactory;

@NamedCommand(commandName = "report")
public class ReportCommand extends Command {
    public ReportCommand(String[] data, Repository repository, UnitFactory unitFactory) {
        super(data, repository, unitFactory);
    }

    @Override
    public String execute() {
        String output = this.getRepository().getStatistics();
        return output;
    }
}
