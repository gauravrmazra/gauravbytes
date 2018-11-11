const employees = new Map();

//Add key-value pairs to map
employees.set("gaurav.r.mazra@gmail.com", {
    firstName: 'Gaurav Rai',
    lastName: 'Mazra',
    department: 'Product development',
    role: 'Senior Software Developer'
});

//remove from single key-value pair from map
employees.delete('gaurav.r.mazra@gmail.com');

//clear all key-value pairs from map
employees.clear();

// Check if particular key-value pair exists in the map
const hasGauravEmployee = employees.has('gaurav.r.mazra@gmail.com');


// reterive value from map by passing key
const gaurav = employees.get('gaurav.r.mazra@gmail.com');


