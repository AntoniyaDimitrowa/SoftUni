package bg.softuni.shampoosapplication;

import bg.softuni.shampoosapplication.services.IngredientService;
import bg.softuni.shampoosapplication.services.LabelService;
import bg.softuni.shampoosapplication.services.ShampooService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Component
public class ConsoleRunner implements CommandLineRunner {
    final private ShampooService shampooService;
    final private IngredientService ingredientService;
    final private LabelService labelService;

    public ConsoleRunner(ShampooService shampooService, IngredientService ingredientService, LabelService labelService) {
        this.shampooService = shampooService;
        this.ingredientService = ingredientService;
        this.labelService = labelService;
    }

    @Override
    public void run(String... args) throws Exception {
//        //1
//        List<Shampoo> allBySize = this.shampooService.findAllBySize(Size.MEDIUM);
//         allBySize.forEach(System.out::println);
//
//        //2
//        this.shampooService.findAllBySizeOrLabelId(Size.MEDIUM, 10L)
//                .forEach(System.out::println);
//
//        //3
//        this.shampooService.findAllByPriceGreaterThan(BigDecimal.valueOf(5))
//                .forEach(System.out::println);
//
//        //4
//        this.ingredientService.findAllByNameStartingWith("M")
//                .forEach(System.out::println);
//
//        //5
//        this.ingredientService.findAllByNameWithin(List.of("Lavender", "Herbs", "Apple"))
//                .forEach(System.out::println);
//
//        //6
//        int count = this.shampooService.findCheaperThanCount(BigDecimal.valueOf(8.50));
//        System.out.println(count);
//
//        //7
//        this.shampooService.findAllWithIngredients(List.of("Berry", "Mineral-Collagen"))
//                .forEach(System.out::println);
//
//        //8
//        this.shampooService.findAllWithIngredients(List.of("Berry", "Mineral-Collagen"))
//                .forEach(System.out::println);
//
//        //9
//        this.shampooService.findAllWithIngredientsCount(2)
//                .forEach(System.out::println);

        //10
        this.ingredientService.increasePrice();

        //11


    }
}
