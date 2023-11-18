function isPalindrome(listOfNumbers) {
    for (const currNumber of listOfNumbers) {
        let numberString = currNumber.toString(); 
        let reversedNumber = numberString.split('').reverse().join('');

        if(reversedNumber === numberString) {
            console.log("true");
        } else {
            console.log("false");
        }
    }
}

isPalindrome([123,323,421,121]);
isPalindrome([32,2,232,1010]);