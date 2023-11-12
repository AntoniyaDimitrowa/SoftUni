function fillTheTemplate(words, template) {
    let wordsList = words.split(", ");

    for (let i = 0; i < wordsList.length; i++) {
        let stars = wordsList[i].replace(/./g, '*');

        template = template.replace(stars, wordsList[i]);
    }

    return template;
}

let result1 = fillTheTemplate('great', 'softuni is ***** place for learning new programming languages');
let result2 = fillTheTemplate('great, learning', 'softuni is ***** place for ******** new programming languages');
console.log(result1);
console.log(result2);