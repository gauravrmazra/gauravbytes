const evenNumbers = [2, 4, 6, 8, 10]

const [first, second, third] = evenNumbers;

const employee = {
    id: 1818,
    name: 'Gaurav Rai Mazra',
    department: 'Software development',
    designation: 'Senior Software Developer' 
}

const {id, name, department, designation} = employee;

const data = `
    <div class="card">
        <h3 class="card-header">${name}</h3>
        <span class="alert alert-info mt-3">Detailed information</span>
        <ul class="list-group">
            <li class="list-group-item"><span class="font-weight-bold">Employee ID: </span> ${id}</li>
            <li class="list-group-item"><span class="font-weight-bold">Designation: </span> ${designation}</li>
            <li class="list-group-item"><span class="font-weight-bold">Department: </span> ${department}</li>
        </ul>
    </div>
`