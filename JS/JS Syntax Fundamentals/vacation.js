function vacation(numberOfPeople, groupType, day) {
    let pricePerPerson = 0;
    let totalPrice = 0;

    if(groupType == "Students") {
        switch(day) {
            case "Friday" :
                pricePerPerson = 8.45;
                break;
            case "Saturday" :
                pricePerPerson = 9.80;
                break;
            case "Sunday" :
                pricePerPerson = 10.46;
                break;
        }
        
        totalPrice = numberOfPeople * pricePerPerson;

        if(numberOfPeople >= 30) {
            totalPrice = totalPrice - totalPrice*0.15;
        }

        console.log(`Total price: ${totalPrice.toFixed(2)}`);

    } else if(groupType == "Business") {
        switch(day) {
            case "Friday" :
                pricePerPerson = 10.90;
                break;
            case "Saturday" :
                pricePerPerson = 15.60;
                break;
            case "Sunday" :
                pricePerPerson = 16;
                break;
        }

        totalPrice = numberOfPeople * pricePerPerson;

        if(numberOfPeople >= 100) {
            totalPrice = totalPrice - 10*pricePerPerson;
        }

        console.log(`Total price: ${totalPrice.toFixed(2)}`);

    } else if(groupType == "Regular") {
        switch(day) {
            case "Friday" :
                pricePerPerson = 15;
                break;
            case "Saturday" :
                pricePerPerson = 20;
                break;
            case "Sunday" :
                pricePerPerson = 22.50;
                break;
        }

        totalPrice = numberOfPeople * pricePerPerson;

        if(numberOfPeople >= 10 && numberOfPeople <=20) {
            totalPrice = totalPrice - totalPrice*0.05;
        }

        console.log(`Total price: ${totalPrice.toFixed(2)}`);

    } else {
        console.log("Wrong group type!");
    }
}

vacation(30,"Students","Sunday");
vacation(40,"Regular","Saturday");