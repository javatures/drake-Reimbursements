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
            let approve = ''
            if (manager) {
                employee = `<p>Submitted by: ${request.employee}</p>`
                approve = `<p><a href="approve?id=${request.id}">Approve this request</a></p>`
            }

            return `<li>
                    ${employee}
                    <p>Reason: ${request.reason}</p>
                    <p>Image: <img src="${request.image}" alt="Image for this request"></p>
                    ${approve}
                    </li>`
        }).join('')
        requests.innerHTML = output
    })