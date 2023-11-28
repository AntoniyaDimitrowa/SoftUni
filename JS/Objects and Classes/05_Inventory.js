function updateInventory(arr) {
    let heros = [];

    arr.forEach((row) => {
        let [name, level, items] = row.split(" / ");
        let hero = {
            name, 
            level: Number(level), 
            items: items
        };

        heros.push(hero);
    });

    heros.sort((h1, h2) => h1.level - h2.level);
    heros.forEach((hero) => {
        console.log(`Hero: ${hero.name}`);
        console.log(`level => ${hero.level}`);
        console.log(`items => ${hero.items}`);
    });
}

updateInventory([
    'Isacc / 25 / Apple, GravityGun',
    'Derek / 12 / BarrelVest, DestructionSword',
    'Hes / 1 / Desolator, Sentinel, Antara'
    ]);

updateInventory([
    'Batman / 2 / Banana, Gun',
    'Superman / 18 / Sword',
    'Poppy / 28 / Sentinel, Antara'
    ]);