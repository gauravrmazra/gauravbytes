function greet(greeting = "Hello, ", name = "Gaurav") {
    return `${greeting} ${name}`
}

function makeJuice([addSalt = false, addSugar = false, fruits = ['Orange', 'Pomegranate', 'Pineapple']] = []) {
    const salt = addSalt ? '' : 'no';
    const sugar = addSugar ? '': 'no';
    return `Your juice is made from ${fruits.join(' and ')}; has ${salt} salt and ${sugar} sugar added.`;
}