let greeting = document.getElementById("greeting")

let employee = fetch("/api/employee").then(response => response.json())

greeting.innerHTML = `Welcome, ${employee.firstName}!`



let logout = document.getElementById('logout')

logout.onclick = function() {window.location.href = "/logout"}