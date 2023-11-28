function createTowns(arr) {
    let list = [];

    for (const dataString of arr) {
        let data = dataString.split(" | ");

        row = {
            town: data[0],
            latitude: parseFloat(data[1]).toFixed(2),
            longitude: parseFloat(data[2]).toFixed(2)
        };

        list.push(row);
    }
    
    for (const row of list) {
        console.log(row);
    }

}

createTowns(['Sofia | 42.696552 | 23.32601', 'Beijing | 39.913818 | 116.363625']);
createTowns(['Plovdiv | 136.45 | 812.575']);