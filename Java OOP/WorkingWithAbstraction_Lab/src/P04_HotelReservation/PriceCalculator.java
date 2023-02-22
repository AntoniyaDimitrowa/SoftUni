package P04_HotelReservation;

public class PriceCalculator {
    public static double calculate(String[] info) {
        double pricePerDay = Double.parseDouble(info[0]);
        int numberOfDays = Integer.parseInt(info[1]);
        String seasonName = info[2];
        String discountType = info[3];

        int seasonValue = Main.Season.valueOf(seasonName).getValue();
        double discountValue = Main.DiscountType.valueOf(discountType).getValue() / 100.0;

        pricePerDay = pricePerDay * seasonValue;
        double totalPrice = pricePerDay * numberOfDays;

        return totalPrice - (totalPrice * discountValue);
    }
}
