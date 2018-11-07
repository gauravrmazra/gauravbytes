const uniqueNumbers = new Set([0, 0, 2, 2, 3, 1, 1, 6, 7, 8, 9, 10])
console.log(uniqueNumbers);

uniqueNumbers.add(100);
console.log(uniqueNumbers);

uniqueNumbers.remove(1);
console.log(uniqueNumbers);

//clear all items from set
uniqueNumbers.clear();

//WeakSet example
const weakSetFlavors = new WeakSet();

const chocochip = { flavor: 'chocochip' };
const redvelvet = { flavor: 'redvelvet' };
weakSetFlavors.add(chocochip);
weakSetFlavors.add(redvelvet);