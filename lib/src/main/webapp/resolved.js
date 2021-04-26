let requests = document.getElementById("requests")

let manager = false

fetch(`/api/employee`)
    .then(response => response.json())
    .then(data => {manager = (data.type == 'manager')})

fetch(`/api/requests?approved=true`)
    .then(response => response.json())
    .then(data => {
        let output = data.map((request) => {
            let employee = ''
            if (manager) {
                employee = `<p>Submitted by: ${request.employee}</p>`
            }

            return `<li>
                    ${employee}
                    <p>Reason: ${request.reason}</p>
                    <p>Image: <img src="${request.image}" alt="Image for this request"></p>
                    <p>Approved by ${request.manager}</p>
                    </li>`
        }).join('')
        requests.innerHTML = output
    })