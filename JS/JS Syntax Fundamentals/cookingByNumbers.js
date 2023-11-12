function cookingByNumbers(number, operation1, operation2, operation3, operation4, operation5) {
    let listOfOperations = [operation1, operation2, operation3, operation4, operation5];

    for (let i = 0; i < listOfOperations.length; i++) {
        let currOperation = listOfOperations[i];

        switch (currOperation) {
            case `chop`:
                number /= 2;
                break;
            case `dice`:
                number = Math.sqrt(number);
                break;
            case `spice`:
                number++;
                break;
            case `bake`:
                number *= 3;
                break;
            case `fillet`:
                number = number - number * 0.20;
                break;
            default:
                break;
        }
        console.log(number);
    }
}

cookingByNumbers('32', 'chop', 'chop', 'chop', 'chop', 'chop');
cookingByNumbers('9', 'dice', 'spice', 'chop', 'bake', 'fillet');