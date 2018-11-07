// Unique and immutable data-type to identify object's properties
const symb = Symbol('lion')

const animals = {
    'lion': { weight: 220.5, length: 155 },
    'monkey': { weight: 20.1, length: 35 },
    'lion': { weight: 300, length: 165 }
}

console.log(animals); // Will print only two objects

const animalWithSymbols = {
    [Symbol('lion')]: { weight: 220.5, length: 155 },
    [Symbol('monkey')]: { weight: 20.1, length: 35 },
    [Symbol('lion')]: { weight: 300, length: 165 }
}