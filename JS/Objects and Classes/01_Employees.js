function createListOfEmployees(arr) {
    let list = [];

    for (const name of arr) {
        let personalNumber = name.length;

        employee = {
            name: name,
            personalNumber: personalNumber
        };

        console.log(`Name: ${employee.name} -- Personal Number: ${employee.personalNumber}`);
        list.push(employee);
    }
    return list;
}

createListOfEmployees(['Silas Butler', 'Adnaan Buckley', 'Juan Peterson', 'Brendan Villarreal']);