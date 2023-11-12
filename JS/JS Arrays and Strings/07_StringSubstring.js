function findWord (word, text) {
    wordToLower = word.toLowerCase();
    wordsArray = text.toLowerCase().split(' ');
    
    let output = `${word} not found!`;
    
    for (let i = 0; i < wordsArray.length; i++) {
        let currWord = wordsArray[i];

        if(currWord === wordToLower) {
            output = word;
        }
    }

    console.log(output);
}

findWord('javaScript','JavaScript is the best programming language');
findWord('python','JavaScript is the best programming language');