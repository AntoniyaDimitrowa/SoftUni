function oddAndEvenSum(number) {
    let oddSum = 0;
    let evenSum = 0;

    while(number > 0) {
        let currDigit = number % 10;
        
        if (currDigit % 2 == 0) {
            evenSum += currDigit;
        } else {
            oddSum += currDigit;
        }

        number = Math.floor(number / 10);
    }

    console.log(`Odd sum = ${oddSum}, Even sum = ${evenSum}`);
}

oddAndEvenSum(1000435);
oddAndEvenSum(3495892137259234);