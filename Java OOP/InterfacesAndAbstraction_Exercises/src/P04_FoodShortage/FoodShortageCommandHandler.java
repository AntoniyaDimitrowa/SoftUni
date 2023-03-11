package P04_FoodShortage;

import java.util.Map;

public class FoodShortageCommandHandler extends CommandHandler {
    private Map<String, Buyer> buyers;

    public FoodShortageCommandHandler(Map<String, Buyer> buyers, String endCommand) {
        super(endCommand);
        this.buyers = buyers;
    }

    @Override
    protected void processNonEndCommand(String name) {
        Buyer targetPerson = getBuyingPerson(name);

        if(targetPerson != null) {
            targetPerson.buyFood();
        }
    }

    private Buyer getBuyingPerson(String name) {
        return buyers.get(name);
    }
}
