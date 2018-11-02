const evens = [2, 4, 6, 8, 10]
const odds = [1, 3, 5, 7, 9]

//Concat arrays old way
const oldWayConcatedNumbers = evens.concat(odds);
console.log('Older way concated array results: ', oldWayConcatedNumbers);

//Concat Arrays with Spread operator
const numbers = [...evens, ...odds]

console.log('Concated arrays with spread operator: ', numbers);