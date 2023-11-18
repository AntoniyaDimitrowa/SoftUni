function pascalCaseSplitter(string) {
    const regex = /[A-Z][a-z]*/g;

    let result = string.match(regex);
    console.log(result.join(', '));
}

pascalCaseSplitter('SplitMeIfYouCanHaHaYouCantOrYouCan');