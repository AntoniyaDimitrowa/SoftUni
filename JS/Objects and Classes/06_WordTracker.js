function wordsTracker(arr) {
    let words = arr[0].split(" ");
    let wordsCounts = [];

    words.forEach(word => {
        wordsCounts.push({word: word, count: 0})
    });

    for (let i = 1; i < arr.length; i++) {
        let searching = wordsCounts.find((el) => el.word === arr[i]);

        if (searching) {
            searching["count"]++;
        }
    }

    wordsCounts.sort((el1, el2) => el2.count - el1.count);
    wordsCounts.forEach((word) => console.log(`${word.word} - ${word.count}`));
}

wordsTracker([
    'this sentence',
    'In', 'this', 'sentence', 'you', 'have',
    'to', 'count', 'the', 'occurrences', 'of',
    'the', 'words', 'this', 'and', 'sentence',
    'because', 'this', 'is', 'your', 'task']);

    wordsTracker([
    'is the',
    'first', 'sentence', 'Here', 'is',
    'another', 'the', 'And', 'finally', 'the',
    'the', 'sentence']);