class Vehicle {
    constructor(type, model, parts, fuel) {
        this.type = type;
        this.model = model;
        this.parts = {
            engine: parts.engine,
            power: parts.power,
            quality: parts.power * parts.engine
        };
        this.fuel = fuel;
    }

    drive(fuel){
        this.fuel -= fuel;
    }
}



let parts = { engine: 6, power: 100 };
let vehicle = new Vehicle('a', 'b', parts, 200);
vehicle.drive(100);
console.log(vehicle.fuel);
console.log(vehicle.parts.quality);

let parts2 = {engine: 9, power: 500};

let vehicle2 = new Vehicle('l', 'k', parts, 840);

vehicle2.drive(20);

console.log(vehicle2.fuel);