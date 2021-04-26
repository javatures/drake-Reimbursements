let requests = document.getElementById("requests")

let manager = false

fetch(`/api/employee`)
    .then(response => response.json())
    .then(data => {manager = (data.type == 'manager')})

fetch(`/api/requests?approved=false`)
    .then(response => response.json())
    .then(data => {
        let output = data.map((request) => {
            let employee = ''
            if (manager) {
                employee = `<p>Submitted by: ${data.employee}</p>`
            }

            return `<li>
                    ${employee}
                    <p>Reason: ${request.reason}</p>
                    <p>Image: <img src="${request.image}" alt="Image for this request"></p>
                    </li>`
        }).join('')
        requests.innerHTML = output
    })