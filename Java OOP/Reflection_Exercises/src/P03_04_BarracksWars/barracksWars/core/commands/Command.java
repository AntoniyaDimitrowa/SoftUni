package P03_04_BarracksWars.barracksWars.core.commands;

import P03_04_BarracksWars.barracksWars.interfaces.Executable;
import P03_04_BarracksWars.barracksWars.interfaces.Repository;
import P03_04_BarracksWars.barracksWars.interfaces.UnitFactory;

public abstract class Command implements Executable {
    private String[] data;
    private Repository repository;
    private UnitFactory unitFactory;

    protected Command(String[] data, Repository repository, UnitFactory unitFactory) {
        this.data = data;
        this.repository = repository;
        this.unitFactory = unitFactory;
    }

    protected String[] getData() {
        return data;
    }

    protected Repository getRepository() {
        return repository;
    }

    protected UnitFactory getUnitFactory() {
        return unitFactory;
    }
}
