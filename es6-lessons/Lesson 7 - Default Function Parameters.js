function greet(greeting = "Hello, ", name = "Gaurav") {
    return `${greeting} ${name}`
}

function makeJuice([addSalt = false, addSugar = false, fruits = ['Orange', 'Pomegranate', 'Pineapple']] = []) {
    const salt = addSalt ? '' : 'no';
    const sugar = addSugar ? '': 'no';
    return `Your juice is made from ${fruits.join(' and ')}; has ${salt} salt and ${sugar} sugar added.`;
}

/** 
 * Object destructing function is much better choice then array destructing
 * Because in array destructing if you want to pass only fruits then have to call it like this
 * makeJuice([undefined, undefined, ['Grapes']]);
 * Whereas you can call Object Destructing function as follows
 * makeJuiceWithObjectDestructing({fruits: ['Grapes']});
 * 
*/
function makeJuiceWithObjectDestructing({addSalt = false, addSugar = false, fruits = ['Orange']} = {}) {
    const salt = addSalt ? '' : 'no';
    const sugar = addSugar ? '': 'no';
    return `Your juice is made from ${fruits.join(' and ')}; has ${salt} salt and ${sugar} sugar added.`;
}