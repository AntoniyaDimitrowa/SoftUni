package bg.softuni.bookshopsystem.domain.models;

import bg.softuni.bookshopsystem.domain.enums.AgeRestriction;
import bg.softuni.bookshopsystem.domain.enums.EditionType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@AllArgsConstructor
public class BookPrintInformation {
    private String title;
    private EditionType editionType;
    private AgeRestriction ageRestriction;
    private BigDecimal price;

    @Override
    public String toString() {
        return this.title + " "
                + this.editionType + " "
                + this.ageRestriction + " "
                + this.price;
    }
}
