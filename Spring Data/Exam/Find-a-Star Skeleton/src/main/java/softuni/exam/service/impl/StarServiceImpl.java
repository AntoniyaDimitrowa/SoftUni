package softuni.exam.service.impl;

import com.google.gson.Gson;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import softuni.exam.models.dto.StarBasicInfoDTO;
import softuni.exam.models.dto.StarImportDTO;
import softuni.exam.models.entity.Star;
import softuni.exam.models.entity.StarType;
import softuni.exam.repository.StarRepository;
import softuni.exam.service.StarService;
import softuni.exam.util.ValidationUtils;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static softuni.exam.models.Constants.INVALID_STAR_FORMAT;
import static softuni.exam.models.Constants.SUCCESSFUL_STAR_FORMAT;

@Service
public class StarServiceImpl implements StarService {
    private static final String STARS_FILE_PATH = "src/main/resources/files/json/stars.json";

    private final StarRepository starRepository;
    private final ValidationUtils validationUtils;
    private final ModelMapper modelMapper;
    private final Gson gson;

    @Autowired
    public StarServiceImpl(StarRepository starRepository, ValidationUtils validationUtils, ModelMapper modelMapper, Gson gson) {
        this.starRepository = starRepository;
        this.validationUtils = validationUtils;
        this.modelMapper = modelMapper;
        this.gson = gson;
    }

    @Override
    public boolean areImported() {
        return this.starRepository.count() > 0;
    }

    @Override
    public String readStarsFileContent() throws IOException {
        return Files.readString(Path.of(STARS_FILE_PATH));
    }

    @Override
    public String importStars() throws IOException {
        final StringBuilder stringBuilder = new StringBuilder();

        final List<StarImportDTO> stars =
                Arrays.stream(gson.fromJson(readStarsFileContent(), StarImportDTO[].class))
                        .collect(Collectors.toList());

        for (StarImportDTO star : stars) {
            stringBuilder.append(System.lineSeparator());

            if (this.starRepository.findFirstByName(star.getName()).isPresent() ||
                    !this.validationUtils.isValid(star)) {
                stringBuilder.append(INVALID_STAR_FORMAT);
                continue;
            }

            this.starRepository.save(this.modelMapper.map(star, Star.class));

            stringBuilder.append(String.format(SUCCESSFUL_STAR_FORMAT,
                    star.getName(),
                    star.getLightYears()));
        }

        return stringBuilder.toString().trim();
    }

    @Override
    public String exportStars() {
        List<Star> stars = this.starRepository.findAllByStarTypeOrderByLightYears(StarType.RED_GIANT)
                .stream().filter(s -> s.getObservers().size() < 1)
                .collect(Collectors.toList());

        List<StarBasicInfoDTO> starBasicInfoDTOs = stars.stream()
                .map(star -> modelMapper.map(star, StarBasicInfoDTO.class))
                .collect(Collectors.toList());

        StringBuilder stringBuilder = new StringBuilder();

        for (StarBasicInfoDTO star : starBasicInfoDTOs) {
            stringBuilder.append(star.toString()).append(System.lineSeparator());
        }

        return stringBuilder.toString().trim();
    }
}
