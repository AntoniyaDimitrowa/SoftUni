function printAndSum(beginning, end) {
    let list = ``;
    let sum = 0;
    for (let i = beginning; i <= end; i++) {
        list += i + ` `;
        sum += i;
    }
    console.log(list);
    console.log(`Sum: ${sum}`);
}

printAndSum(5, 10);
printAndSum(0, 26);
printAndSum(50, 60);