function sortNumbers(arr) {
    let result = [];
    let sortedArray = arr.sort((a, b) => a - b);
    let arrLength = arr.length;
    
    for (let i = 0; i < arrLength; i++) {
        if(i % 2 === 0) {
            let first = sortedArray.shift();
            result.push(first);
        } else {
            let last = sortedArray.pop();
            result.push(last);
        }
    }

    return result;
}

console.log(sortNumbers([1, 65, 3, 52, 48, 63, 31, -3, 18, 56]));