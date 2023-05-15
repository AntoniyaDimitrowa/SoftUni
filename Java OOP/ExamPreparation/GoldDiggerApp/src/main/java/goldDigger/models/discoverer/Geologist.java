package goldDigger.models.discoverer;

public class Geologist extends BaseDiscoverer {
    public Geologist(String name) {
        super(name, 100);
    }

    @Override
    public boolean canDig() {
        return false;
    }

    @Override
    public void dig() {

    }
}
