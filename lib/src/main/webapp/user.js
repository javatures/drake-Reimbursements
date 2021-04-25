let info = document.getElementById("info")

fetch("/api/employee")
    .then(response => response.json())
    .then(data => {
        info.innerHTML = `<form action="edit" method="POST">
                            <label for="pass">Current password:</label>
                            <input type="password" id="pass" name="pass"><br>
                            <label for="firstname">First name:</label>
                            <input type="text" id="firstname" name="firstname" value="${data.firstName}"><br>
                            <label for="lastname">Last name:</label>
                            <input type="text" id="lastname" name="lastname" value="${data.lastName}"><br>
                            <label for="user">Username:</label>
                            <input type="text" id="user" name="user" value="${data.user}"><br>
                            <label for="newpass">New password:</label>
                            <input type="password" id="newpass" name="newpass"><br>
                            <button type="submit">Edit info</button>`
    })