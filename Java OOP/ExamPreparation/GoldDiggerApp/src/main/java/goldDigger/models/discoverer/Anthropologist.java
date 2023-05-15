package goldDigger.models.discoverer;

public class Anthropologist extends BaseDiscoverer {
    public Anthropologist(String name) {
        super(name, 40);
    }

    @Override
    public boolean canDig() {
        return false;
    }

    @Override
    public void dig() {

    }
}
