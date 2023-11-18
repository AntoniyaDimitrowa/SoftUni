function isPerfectNumber(number) {
    let findSumOfDevisors = (number) => {
        let sum = 0;

        for (let devisor = 1; devisor <= number / 2; devisor++) {
            if (number % devisor == 0) {
                sum += devisor;
            }
        }

        return sum;
    }

    if(number == findSumOfDevisors(number)) {
        console.log("We have a perfect number!");
    } else {
        console.log("It's not so perfect.");
    }
}

isPerfectNumber(6);
isPerfectNumber(28);
isPerfectNumber(1236498);