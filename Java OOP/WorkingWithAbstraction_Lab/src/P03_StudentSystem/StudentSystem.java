package P03_StudentSystem;

import java.util.HashMap;
import java.util.Map;

public class StudentSystem {
    private Map<String, Student> repo;

    public StudentSystem()
    {
        this.repo = new HashMap<>();
    }

    public void createStudent () {

    }

    public String showStudent () {
        return this.repo.get(name).toString();
    }
}
