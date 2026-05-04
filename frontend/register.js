window.onload = function () {

    document.getElementById("registerForm").addEventListener("submit", function (e) {
        e.preventDefault();

        const user = {
            name: document.getElementById("name").value,
            email: document.getElementById("email").value,
            phone: document.getElementById("phone").value,
            password: document.getElementById("password").value,
            role: document.getElementById("role").value
        };

        fetch("http://localhost:8080/api/register", {
            method: "POST",
            headers: {
                "Content-Type": "application/json"
            },
            body: JSON.stringify(user)
        })
        .then(res => res.text())
        .then(data => {
            alert(data);

            if (data === "User Registered Successfully") {
                window.location.href = "login.html";
            }
        })
        .catch(err => {
            console.error(err);
            alert("Error occurred");
        });

    });

};