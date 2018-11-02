function getClothing(isCold)
{
    if (isCold) {
        var freezing = 'Grab a jacket!';
    }
    else {
        var hot = 'It\'s a shorts kind of day.';
        console.log(freezing);
    }
}

function getClothingBlockScoped(isCold) {
    if (isCold) {
        let freezing = 'Grab a jacket!';
    }
    else {
        let hot = 'It\'s a shorts kind of day.';
        console.log(freezing);
    }
}

// Const scoped variables
const PI = 3.14;


function getClothingConstScoped(isCold) {
    if (isCold) {
        const freezing = 'Grab a jacket!';
    }
    else {
        const hot = 'It\'s a shorts kind of day.';
        console.log(freezing);
    }
}
