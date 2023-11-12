function findHashTagWords(string) {
    const regex = /#[a-zA-Z]+/gm;
    let listOfWords = string.match(regex);
    
    for (let i = 0; i < listOfWords.length; i++) {
        console.log(listOfWords[i].substring(1));
    }
}

findHashTagWords('Nowadays everyone uses # to tag a #special word in #socialMedia');
findHashTagWords('The symbol # is known #variously in English-speaking #regions as the #number sign');