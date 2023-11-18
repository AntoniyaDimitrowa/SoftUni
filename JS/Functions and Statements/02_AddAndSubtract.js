function addAndSubstract(num1, num2, num3) {
    let sum = (num1, num2) => {
        return num1 + num2;
    }
    
    let substract = (num1, num2) => {
        return num1 - num2
    }

    result = sum(num1, num2);
    result = substract(result, num3);
    console.log(result);
}

addAndSubstract(23, 6, 10);
addAndSubstract(1, 17, 30);
addAndSubstract(42, 58, 100);