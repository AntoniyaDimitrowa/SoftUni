package P04_FoodShortage;

public class FoodShortageCommandHandler extends CommandHandler {
    int finalResult;

    public FoodShortageCommandHandler(String endCommand) {
        super(endCommand);
    }

    public int getFinalResult() {
        return finalResult;
    }

    @Override
    protected void processNonEndCommand(String command) {
        String[] parameters = command.split("\\s+");
        if(parameters.length == 3) {
            this.finalResult += 5;
        } else if(parameters.length == 4){
            this.finalResult += 5;
        }
    }
}
