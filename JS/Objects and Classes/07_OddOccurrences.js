function oddOccurrences(str) {
    str = str.toLowerCase();
    let words = str.split(" ");
    let wordsCounts = [];

    words.forEach(word => {
        let searching = wordsCounts.find((el) => el.word === word);

        if (searching) {
            searching["count"]++;
        } else {

            wordsCounts.push({word: word, count: 1})
        }
    });

    wordsCounts = wordsCounts.filter((el) => el.count % 2 != 0);

    let result = "";
    wordsCounts.forEach((word) => result += word.word + " ");

    console.log(result);
}

oddOccurrences('Java C# Php PHP Java PhP 3 C# 3 1 5 C#');
oddOccurrences('Cake IS SWEET is Soft CAKE sweet Food');