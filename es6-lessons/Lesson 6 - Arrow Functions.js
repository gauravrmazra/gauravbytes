const names = ['Gaurav', 'Rasham', 'Gagan', 'Aman'];

// Older way of function
const upperCaseNames = names.map(function(name) {
    return name.toUpperCase();
});

// Arrow function example
const arrowFuncUpperCaseNames = names.map(name => name.toUpperCase());