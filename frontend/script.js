window.onload = function () {

    document.getElementById("loginForm").addEventListener("submit", function (e) {
        e.preventDefault();

        const email = document.getElementById("email").value;
        const password = document.getElementById("password").value;

        fetch("http://localhost:8080/api/login", {
            method: "POST",
            headers: {
                "Content-Type": "application/json"
            },
            body: JSON.stringify({
                email: email,
                password: password
            })
        })
        .then(response => response.json())   // ✅ IMPORTANT CHANGE
        .then(data => {

            console.log(data); // for debugging

            if (data == null) {
                alert("Invalid credentials");
                return;
            }

            alert("Login Successful");

            // 🔥 ROLE BASED REDIRECT
            if (data.role === "FARMER") {
                window.location.href = "farmer.html";
            } else if (data.role === "OWNER") {
                window.location.href = "owner.html";
            }

        })
        .catch(error => {
            console.error(error);
            alert("Error occurred");
        });

    });

};