import entities.Project;

import java.util.Comparator;

public class FindTheLatest10Projects {
    public static void main(String[] args) {
        Utils.createEntityManager()
                .createQuery("FROM Project ORDER BY startDate DESC, name", Project.class)
                .setMaxResults(10)
                .getResultStream()
                .sorted(Comparator.comparing(Project::getName))
                .forEach(Project::printBasicInfo);
    }
}
