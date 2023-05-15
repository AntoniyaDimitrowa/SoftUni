package goldDigger.models.discoverer;

public class Archaeologist extends BaseDiscoverer {
    public Archaeologist(String name) {
        super(name, 60);
    }

    @Override
    public boolean canDig() {
        return false;
    }

    @Override
    public void dig() {

    }
}
