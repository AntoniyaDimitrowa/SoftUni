package robotService.entities.services;

import robotService.entities.robot.Robot;

import java.util.stream.Collectors;

public class MainService extends BaseService {
    public MainService(String name) {
        super(name, 30);
    }

    @Override
    public String getStatistics() {
        String namesOfRobots;
        if(this.getRobots().isEmpty()) {
            namesOfRobots = "none";
        } else {
            namesOfRobots = this.getRobots().stream().map(Robot::getName).collect(Collectors.joining(" "));
        }
        return String.format("%s MainService:" + System.lineSeparator() +
                        "Robots: %s" + System.lineSeparator() +
                        "Supplements: %d Hardness: %d",
                this.getName(),
                namesOfRobots,
                this.getSupplements().size(),
                this.sumHardness());

    }
}
