function sumDigits(number) {
    let sum = 0;
    do {
        sum += (number % 10);
        number /= 10;
        number = Math.floor(number);
    } while(number > 0)

    console.log(sum);
}

sumDigits(245678);
sumDigits(97561);
sumDigits(543);