package robotService.entities.services;

import robotService.entities.robot.Robot;

import java.util.stream.Collectors;

public class SecondaryService extends BaseService {

    public SecondaryService(String name) {
        super(name, 15);
    }

    @Override
    public String getStatistics() {
        String namesOfRobots;
        if(this.getRobots().isEmpty()) {
            namesOfRobots = "none";
        } else {
            namesOfRobots = this.getRobots().stream().map(Robot::getName).collect(Collectors.joining(" "));
        }
        return String.format("%s SecondaryService:" + System.lineSeparator() +
                "Robots: %s" + System.lineSeparator() +
                "Supplements: %d Hardness: %d",
                this.getName(),
                namesOfRobots,
                this.getSupplements().size(),
                this.sumHardness());

    }
}
