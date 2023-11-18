function factorialDevision(num1, num2) {
    let calcFactorial = (number) => {
        let result = 1;
        for (let i = 1; i <= number; i++) {
            result *= i;
        }
        return result;
    }

    let factorialOfNum1 = calcFactorial(num1);
    let factorialOfNum2 = calcFactorial(num2);

    console.log((factorialOfNum1 / factorialOfNum2).toFixed(2));
}

factorialDevision(5, 2);
factorialDevision(6, 2);