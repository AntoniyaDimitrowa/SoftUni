function findSmallest(num1, num2, num3) {
    if(num1 < num2 && num1 < num3) {
        console.log(num1);
    } else if(num2 < num1 && num2 < num3) {
        console.log(num2);
    } else {
        console.log(num3);
    }
}

findSmallest(2, 5, 3);
findSmallest(600, 342, 123);
findSmallest(25, 21, 4);
findSmallest(2, 2, 2);