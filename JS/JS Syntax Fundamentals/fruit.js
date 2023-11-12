function fruitPrice(fruitType, weightInGrams, pricePerKilo) {
    weightInKilograms = weightInGrams / 1000;
    money = weightInKilograms * pricePerKilo;
    console.log(`I need $${money.toFixed(2)} to buy ${weightInKilograms.toFixed(2)} kilograms ${fruitType}.`);
}

fruitPrice('orange', 2500, 1.80);
fruitPrice('apple', 1563, 2.35);