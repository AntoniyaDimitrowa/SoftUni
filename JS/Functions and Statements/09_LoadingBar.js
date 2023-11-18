function visualizeLoadingBar(percentage) {
    if(percentage == 100) {
        console.log("100% Complete!");
        console.log("[%%%%%%%%%%]");
    } else {
        let numberOfPercent = percentage / 10;
        let numberOfDots = 10 - numberOfPercent;
        let resultString = `${percentage}% [`;
        for (let i = 0; i < numberOfPercent; i++) {
            resultString += "%";
        }
        for (let i = 0; i < numberOfDots; i++) {
            resultString += ".";
        }
        resultString += "]";

        console.log(resultString);
        console.log("Still loading...");
    }
}

visualizeLoadingBar(30);
visualizeLoadingBar(50);
visualizeLoadingBar(100);