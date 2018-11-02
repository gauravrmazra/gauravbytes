const numbers = [1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13]

// Newer forOf Loop
for (const number of numbers) {
    console.log(number);
}

// Older for loop
for (let i = 0; i < numbers.length; i++) {
    console.log(numbers[i]);
}

//for in loop. Only downside is if you prototyped array, then will iterate over added properties as well.
for (let index in numbers) {
    console.log(numbers[index]);
}