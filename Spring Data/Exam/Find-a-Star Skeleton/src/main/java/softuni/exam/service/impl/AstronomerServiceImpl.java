package softuni.exam.service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import softuni.exam.models.dto.AstronomerImportDTO;
import softuni.exam.models.dto.AstronomerWrapperDTO;
import softuni.exam.models.entity.Astronomer;
import softuni.exam.repository.AstronomerRepository;
import softuni.exam.repository.StarRepository;
import softuni.exam.service.AstronomerService;
import softuni.exam.util.ValidationUtils;
import softuni.exam.util.XmlParser;

import javax.xml.bind.JAXBException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

import static softuni.exam.models.Constants.*;


@Service
public class AstronomerServiceImpl implements AstronomerService {
    private static final String ASTRONOMERS_FILE_PATH = "src/main/resources/files/xml/astronomers.xml";


    private final AstronomerRepository astronomerRepository;
    private final StarRepository starRepository;
    private final ValidationUtils validationUtils;
    private final ModelMapper modelMapper;

    private final XmlParser xmlParser;

    @Autowired
    public AstronomerServiceImpl(AstronomerRepository astronomerRepository, StarRepository starRepository, ValidationUtils validationUtils, ModelMapper modelMapper, XmlParser xmlParser) {
        this.astronomerRepository = astronomerRepository;
        this.starRepository = starRepository;
        this.validationUtils = validationUtils;
        this.modelMapper = modelMapper;
        this.xmlParser = xmlParser;
    }

    @Override
    public boolean areImported() {
        return this.astronomerRepository.count() > 0;
    }

    @Override
    public String readAstronomersFromFile() throws IOException {
        return Files.readString(Path.of(ASTRONOMERS_FILE_PATH));
    }

    @Override
    public String importAstronomers() throws IOException, JAXBException {
        final StringBuilder stringBuilder = new StringBuilder();

        final List<AstronomerImportDTO> astronomers =
                this.xmlParser
                        .fromFile(Path.of(ASTRONOMERS_FILE_PATH).toFile(), AstronomerWrapperDTO.class)
                        .getAstronomers();

        for (AstronomerImportDTO astronomer : astronomers) {
            stringBuilder.append(System.lineSeparator());

            if (this.astronomerRepository.findFirstByFirstNameAndLastName(astronomer.getFirstName(), astronomer.getLastName()).isPresent() ||
                    this.starRepository.findFirstById(astronomer.getObservingStar()).isEmpty() ||
                    !this.validationUtils.isValid(astronomer)) {
                stringBuilder.append(INVALID_ASTRONOMER_FORMAT);
                continue;
            }

            this.astronomerRepository.save(this.modelMapper.map(astronomer, Astronomer.class));

            stringBuilder.append(String.format(SUCCESSFUL_ASTRONOMER_FORMAT,
                    astronomer.getFirstName(),
                    astronomer.getLastName(),
                    astronomer.getAverageObservationHours()));
        }

        return stringBuilder.toString().trim();
    }
}
