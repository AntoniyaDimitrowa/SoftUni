function passwordValidator(password) {
    let correctLength = (password) => {
        if(password.length < 6 || password.length > 10) {
            console.log("Password must be between 6 and 10 characters");
            return false;
        } else {
            return true;
        }
    }

    let correctConsistance = (password) => {
        const regex = /^[a-zA-Z0-9]+$/;

        if(password.match(regex)){
            return true;
        } else {
            console.log("Password must consist only of letters and digits");
            return false;
        }
    }

    let correctNumberOfDigits = (password) => {
        let digitsCount = 0;

        for (const currChar of password.split('')) {
            if(/\d/.test(currChar)) {
                digitsCount++;
            }
        }

        if (digitsCount >= 2) {
            return true;
        } else {
            console.log("Password must have at least 2 digits");
            return false;
        }
    }

    let goodLength = correctLength(password);
    let goodConsistance = correctConsistance(password);
    let goodNumberOfDigits = correctNumberOfDigits(password);
    if(goodConsistance && goodLength && goodNumberOfDigits) {
        console.log("Password is valid");
    }
}

passwordValidator('logIn');
passwordValidator('MyPass123');
passwordValidator('Pa$s$s');