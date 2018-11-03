class Animal {
    constructor(category = 'Unknown') {
        this.category = category;
    }

    getCategory() {
        return this.category;
    }

    whoAmI(){
        return `I am ${getName()}. My species is ${getCategory()}.`
    }

    getName() {
        return 'Animal'
    }
}

class Lion extends Animal {
    constructor() {
        super('Mammal');
    }

    getName() {
        return 'Lion';
    }
}

class Snake extends Animal {
    constructor() {
        super('Reptile')
    }

    getName() {
        return 'Snake';
    }
}