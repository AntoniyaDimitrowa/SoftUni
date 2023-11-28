function piccolo(arr) {
    let parkingLot = [];

    arr.forEach((el) => {
        let [direction, carNumber] = el.split(", ");

        if (direction === "IN" && !parkingLot.includes(carNumber)) {
            parkingLot.push(carNumber);
        } else if(direction === "OUT" && parkingLot.includes(carNumber)) {
            parkingLot = parkingLot.filter(el => el !== carNumber);
        }
    });

    if (parkingLot.length === 0) {
        console.log("Parking Lot is Empty");
    } else {
        parkingLot.sort();
        parkingLot.forEach(carNumber => console.log(carNumber));
    }
}

piccolo(['IN, CA2844AA', 'IN, CA1234TA', 'OUT, CA2844AA', 'IN, CA9999TT', 'IN, CA2866HI', 'OUT, CA1234TA', 'IN, CA2844AA', 'OUT, CA2866HI', 'IN, CA9876HH', 'IN, CA2822UU']);
piccolo(['IN, CA2844AA', 'IN, CA1234TA', 'OUT, CA2844AA', 'OUT, CA1234TA']);