function sortListAlphabetically(list) {
    list.sort((a, b) => {
        return a.localeCompare(b);
    });

    for (let i = 0; i < list.length; i++) {
        console.log((i + 1) + "." + list[i]);
    }
}

sortListAlphabetically(["John", "Bob", "Christina", "Ema"]);