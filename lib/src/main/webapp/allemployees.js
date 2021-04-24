let employees = document.getElementById("employees")

fetch("/api/allemployees")
    .then(response => response.json())
    .then(data => {
        let output = data.map((employee) => {
            return `<li>
                    <h3><a href="">${employee.firstName} ${employee.lastName}</a></h3>
                    <p>Username: ${employee.user}</p>
                    <p>Type: ${employee.type}</p>
                    </li>`
        })
        employees.innerHTML = output
    })