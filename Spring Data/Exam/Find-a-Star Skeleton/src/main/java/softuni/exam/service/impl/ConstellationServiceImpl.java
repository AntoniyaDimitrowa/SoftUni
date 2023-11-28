package softuni.exam.service.impl;

import com.google.gson.Gson;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import softuni.exam.models.dto.ConstellationImportDTO;
import softuni.exam.models.dto.StarImportDTO;
import softuni.exam.models.entity.Constellation;
import softuni.exam.models.entity.Star;
import softuni.exam.repository.ConstellationRepository;
import softuni.exam.service.ConstellationService;
import softuni.exam.util.ValidationUtils;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static softuni.exam.models.Constants.*;

@Service
public class ConstellationServiceImpl implements ConstellationService {
    private static final String CONSTELLATIONS_FILE_PATH = "src/main/resources/files/json/constellations.json";


    private final ConstellationRepository constellationRepository;
    private final ValidationUtils validationUtils;
    private final ModelMapper modelMapper;
    private final Gson gson;

    @Autowired
    public ConstellationServiceImpl(ConstellationRepository constellationRepository, ValidationUtils validationUtils, ModelMapper modelMapper, Gson gson) {
        this.constellationRepository = constellationRepository;
        this.validationUtils = validationUtils;
        this.modelMapper = modelMapper;
        this.gson = gson;
    }

    @Override
    public boolean areImported() {
        return this.constellationRepository.count() > 0;
    }

    @Override
    public String readConstellationsFromFile() throws IOException {
        return Files.readString(Path.of(CONSTELLATIONS_FILE_PATH));
    }

    @Override
    public String importConstellations() throws IOException {
        final StringBuilder stringBuilder = new StringBuilder();

        final List<ConstellationImportDTO> constellations =
                Arrays.stream(gson.fromJson(readConstellationsFromFile(), ConstellationImportDTO[].class))
                        .collect(Collectors.toList());

        for (ConstellationImportDTO constellation : constellations) {
            stringBuilder.append(System.lineSeparator());

            if (this.constellationRepository.findFirstByName(constellation.getName()).isPresent() ||
                    !this.validationUtils.isValid(constellation)) {
                stringBuilder.append(INVALID_CONSTELLATION_FORMAT);
                continue;
            }

            this.constellationRepository.save(this.modelMapper.map(constellation, Constellation.class));

            stringBuilder.append(String.format(SUCCESSFUL_CONSTELLATION_FORMAT,
                    constellation.getName(),
                    constellation.getDescription()));
        }

        return stringBuilder.toString().trim();
    }
}
