package bg.softuni.softunigamestore.services.game;

import bg.softuni.softunigamestore.domain.entities.Game;
import bg.softuni.softunigamestore.domain.models.GameAddDTO;
import bg.softuni.softunigamestore.domain.models.GameEditDTO;
import bg.softuni.softunigamestore.repositories.GameRepository;
import bg.softuni.softunigamestore.services.user.UserService;
import org.modelmapper.ModelMapper;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class GameServiceImpl implements GameService {
    final private ModelMapper modelMapper = new ModelMapper();

    final private GameRepository gameRepository;
    final private UserService userService;

    public GameServiceImpl(GameRepository gameRepository, UserService userService) {
        this.gameRepository = gameRepository;
        this.userService = userService;
    }

    @Override
    public String add(String[] args) {
        if (!this.userService.isLoggedUserAdmin()) return "Logged user is not admin.";

        int argsLength = args.length;

        final String title = argsLength > 1 ? args[1] : "";
        final BigDecimal price = argsLength > 2 ? new BigDecimal(args[2]) : BigDecimal.ZERO;
        final float size = argsLength > 3 ? Float.parseFloat(args[3]) : Float.parseFloat("0.0");
        final String trailer = argsLength > 4 ? args[4] : "";
        final String thumbnailURL = argsLength > 5 ? args[5] : "";
        final String description = argsLength > 6 ? args[6] : "";
        final LocalDate releaseDate = LocalDate.now();

        final GameAddDTO gameAddDTO = new GameAddDTO(title,
                price,
                size,
                trailer,
                thumbnailURL,
                description,
                releaseDate);

        Game gameToBeSaved = this.modelMapper.map(gameAddDTO, Game.class);

        Game savedGame = gameRepository.saveAndFlush(gameToBeSaved);

        return gameAddDTO.successfullyAddedGame();
    }

    @Override
    public String delete(String[] args) {
        if (!this.userService.isLoggedUserAdmin()) return "Logged user is not admin.";

        final Optional<Game> gameToBeDeleted = this.gameRepository.findById(Long.valueOf(args[1]));

        if (gameToBeDeleted.isEmpty()) return "No Such game";

        this.gameRepository.delete(gameToBeDeleted.get());

        return "Deleted" + gameToBeDeleted.get().getTitle();    }

    @Override
    public String edit(String[] args) {
        if (!this.userService.isLoggedUserAdmin()) return "Logged user is not admin.";

        final Optional<Game> gameToBeEdited = this.gameRepository.findById(Long.valueOf(args[1]));

        if (gameToBeEdited.isEmpty()) return "No Such game";

        Map<String, String> updatingArguments = new HashMap<>();

        for (int i = 2; i < args.length; i++) {
            String[] argumentsForUpdate = args[i].split("=");
            updatingArguments.put(argumentsForUpdate[0], argumentsForUpdate[1]);
        }

        final GameEditDTO gameEditDTO = this.modelMapper.map(gameToBeEdited.get(), GameEditDTO.class);

        gameEditDTO.updateFields(updatingArguments);

        Game gameToBeSaved = this.modelMapper.map(gameEditDTO, Game.class);

        this.gameRepository.saveAndFlush(gameToBeSaved);

        return gameEditDTO.successfullyEditedGame();
    }
}
