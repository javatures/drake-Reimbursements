let params = new URLSearchParams(window.location.search)

let status = params.get('status')
console.log(status)

let response = document.getElementById('response')
console.log(response)

if (status == 'user') {
    response.innerHTML = 'Error: Username not found'
}
else if (status == 'pass') {
    response.innerHTML = 'Error: Incorrect password'
}