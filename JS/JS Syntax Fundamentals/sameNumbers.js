function sameNumbers(number) {
    let sum = 0;
    let isSame = true;
    let prevDigit = number % 10;
    do {
        currDigit = number % 10;
        sum += currDigit;

        if(currDigit != prevDigit) {
            isSame = false;
        }

        number /= 10;
        number = Math.floor(number);
    } while(number > 0)

    console.log(isSame);
    console.log(sum);
}

sameNumbers(2222222);
sameNumbers(1234);