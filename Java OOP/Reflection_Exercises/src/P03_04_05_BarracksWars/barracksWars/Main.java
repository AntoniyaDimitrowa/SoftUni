package P03_04_05_BarracksWars.barracksWars;

import P03_04_05_BarracksWars.barracksWars.core.Engine;
import P03_04_05_BarracksWars.barracksWars.data.UnitRepository;
import P03_04_05_BarracksWars.barracksWars.interfaces.Repository;
import P03_04_05_BarracksWars.barracksWars.interfaces.Runnable;
import P03_04_05_BarracksWars.barracksWars.interfaces.UnitFactory;
import P03_04_05_BarracksWars.barracksWars.core.factories.UnitFactoryImpl;

public class Main {

    public static void main(String[] args) {
        Repository repository = new UnitRepository();
        UnitFactory unitFactory = new UnitFactoryImpl();

        Runnable engine = new Engine(repository, unitFactory);
        engine.run();
    }
}
