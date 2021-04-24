let greeting = document.getElementById("greeting")

fetch("/api/employee")
    .then(response => response.json())
    .then(employee => {greeting.innerHTML = `Welcome, ${employee.firstName}!`})



let logout = document.getElementById('logout')

logout.onclick = function() {window.location.href = "/logout"}