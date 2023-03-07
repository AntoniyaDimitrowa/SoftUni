package P02_CarShopExtended;

public interface Rentable extends Car {
    Integer getMinRentDay();
    Double getPricePerDay();

    default Double getPriceForDays(int days) {
        if(days < this.getMinRentDay()) {
            String message = String.format("Cannot rent %s for less than %d days.",
                    this.getModel(),
                    this.getMinRentDay());

            throw new IllegalArgumentException(message);
        }

        return days * this.getPricePerDay();
    }
}
