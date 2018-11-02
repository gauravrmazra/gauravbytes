const cheetah = {
    name: 'Cheetah',
    scientificName: 'Acinonyx jubatus',
    lifespan: '10-12 years',
    speed: '68-75 mph',
    diet: 'carnivore',
    summary: 'Fastest mammal on land, the cheetah can reach speeds of 60 or perhaps even 70 miles (97 or 113 kilometers) an hour over short distances. It usually chases its prey at only about half that speed, however. After a chase, a cheetah needs half an hour to catch its breath before it can eat.',
    fact: 'Cheetahs have “tear marks” that run from the inside corners of their eyes down to the outside edges of their mouth.'
};

// creates an animal trading card
function createAnimalTradingCardHTML(animal) {
    const cardHTML = `<div class="card">
        <h3 class="card-header"> ${animal.name} </h3>
        <img src=" ${animal.name}.jpg" alt="${animal.name}" class="img-fluid m-auto pt-3" style="width: 20rem">
        <div class="card-body">
            <p class="alert alert-info"> ${animal.fact} </p>
            <ul class="list-group mb-3">
                <li class="list-group-item"><span class="font-weight-bold">Scientific Name</span>: ${animal.scientificName} </li>
                <li class="list-group-item"><span class="font-weight-bold">Average Lifespan</span>:  ${animal.lifespan} </li>
                <li class="list-group-item"><span class="font-weight-bold">Average Speed</span>:  ${animal.speed} </li>
                <li class="list-group-item"><span class="font-weight-bold">Diet</span>:  ${animal.diet} </li>
            </ul>
            <p class="alert alert-info"> ${animal.summary} </p>
        </div>
    </div>`;

    return cardHTML;
}

console.log(createAnimalTradingCardHTML(cheetah));
