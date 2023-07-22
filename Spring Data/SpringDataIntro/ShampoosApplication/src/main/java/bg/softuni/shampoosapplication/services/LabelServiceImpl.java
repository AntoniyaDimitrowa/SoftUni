package bg.softuni.shampoosapplication.services;

import bg.softuni.shampoosapplication.repositories.LabelRepository;
import org.springframework.stereotype.Service;

@Service
public class LabelServiceImpl implements LabelService {
    final private LabelRepository labelRepository;

    public LabelServiceImpl(LabelRepository labelRepository) {
        this.labelRepository = labelRepository;
    }
}
