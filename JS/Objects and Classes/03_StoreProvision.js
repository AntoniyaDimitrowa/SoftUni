function updateStockData(currStock, orderedProducts) {
    const stock = {};

    let updateStock = function(arr) {
        for (let i = 0; i < arr.length; i+=2) {
            let product = arr[i];
            let quantity = Number(arr[i+1]);
            
            if (!stock.hasOwnProperty(product)) {
                stock[product] = quantity;
            } else {
                stock[product] += quantity;
            }
        }
    }
    
    updateStock(currStock);
    updateStock(orderedProducts);

    for (const product in stock) {
        console.log(`${product} -> ${stock[product]}`);
    }
}

updateStockData([
    'Chips', '5', 'CocaCola', '9', 'Bananas', '14', 'Pasta', '4', 'Beer', '2'
    ],
    [
    'Flour', '44', 'Oil', '12', 'Pasta', '7', 'Tomatoes', '70', 'Bananas', '30'
    ]
    );
updateStockData([
    'Salt', '2', 'Fanta', '4', 'Apple', '14', 'Water', '4', 'Juice', '5'
    ],
    [
    'Sugar', '44', 'Oil', '12', 'Apple', '7', 'Tomatoes', '7', 'Bananas', '30'
    ]
    );