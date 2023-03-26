package P03_04_BarracksWars.barracksWars;

import P03_04_BarracksWars.barracksWars.core.Engine;
import P03_04_BarracksWars.barracksWars.core.commands.AddUnitCommand;
import P03_04_BarracksWars.barracksWars.core.commands.FightCommand;
import P03_04_BarracksWars.barracksWars.core.commands.ReportCommand;
import P03_04_BarracksWars.barracksWars.core.commands.RetireCommand;
import P03_04_BarracksWars.barracksWars.data.UnitRepository;
import P03_04_BarracksWars.barracksWars.interfaces.Repository;
import P03_04_BarracksWars.barracksWars.interfaces.UnitFactory;
import P03_04_BarracksWars.barracksWars.core.factories.UnitFactoryImpl;

public class Main {

    public static void main(String[] args) {
        Repository repository = new UnitRepository();
        UnitFactory unitFactory = new UnitFactoryImpl();

        Engine engine = new Engine(repository, unitFactory);
        engine.registerCommand(AddUnitCommand.class);
        engine.registerCommand(ReportCommand.class);
        engine.registerCommand(RetireCommand.class);
        engine.registerCommand(FightCommand.class);

        engine.run();
    }
}
