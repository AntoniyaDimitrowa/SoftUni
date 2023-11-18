function charactersInRange(char1, char2) {
    charList = [];

    let start;
    let end;

    if(char1 < char2) {
        start = char1.charCodeAt();
        end = char2.charCodeAt();
    } else {
        start = char2.charCodeAt();
        end = char1.charCodeAt();
    }

    for (let currCode = start+1; currCode < end; currCode++) {
        charList.push(String.fromCharCode(currCode));
    }

    console.log(charList.join(" "));
}

charactersInRange('a', 'd');
charactersInRange('#', ':');
charactersInRange('C', '#');