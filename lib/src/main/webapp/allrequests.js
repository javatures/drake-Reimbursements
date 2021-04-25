let params = new URLSearchParams(window.location.search)

let employee = params.get('employee')

let requests = document.getElementById("requests")

fetch(`/api/requests?employee=${employee}`)
    .then(response => response.json())
    .then(data => {
        let output = data.map((request) => {
            let approval = ''
            if (request.approved) {
                approval = `<p>Approved by ${request.manager}</p>`
            } else {
                approval = `<p>Not approved</p>`
            }
            return `<li>
                    <p>Reason: ${request.reason}</p>
                    <p>Image: <img src="${request.image}" alt="Image for this request"></p>
                    ${approval}
                    </li>`
        }).join('')
        requests.innerHTML = output
    })