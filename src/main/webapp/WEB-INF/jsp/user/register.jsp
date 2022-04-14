<%@ taglib prefix="c" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>Happy Homes</title>

    <script
            src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
            integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p"
            crossorigin="anonymous"
    ></script>
    <link
            href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
            rel="stylesheet"
            integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3"
            crossorigin="anonymous"
    />
    <link rel="preconnect" href="https://fonts.googleapis.com" />
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin />
    <link
            href="https://fonts.googleapis.com/css2?family=Ramaraja&display=swap"
            rel="stylesheet"
    />
    <link href="https://fonts.googleapis.com/css2?family=Bebas+Neue&display=swap" rel="stylesheet">
    <link href="<c:url value="/resources/mytheme/CSS/style.css"/>" rel="stylesheet" type="text/css"/>
    <link type="text/javascript" href="script.js">
</head>

<body>
<header>
    <nav id="navbar" class="navbar navbar-expand-lg navbar-light">
        <div class="container-fluid">
            <a class="logo"><img src="<c:url value="/resources/mytheme/images/happyhomeslogo.png"/>" /></a>
            <a class="navbar-brand" href="#"></a>
            <button
                    class="navbar-toggler"
                    type="button"
                    data-bs-toggle="collapse"
                    data-bs-target="#navbarNav"
                    aria-controls="navbarNav"
                    aria-expanded="false"
                    aria-label="Toggle navigation"
            >
                <span class="navbar-toggler-icon"></span>
            </button>
            <div class="collapse navbar-collapse" id="navbarNav">
                <ul class="navbar-nav ms-auto">
                    <li class="nav-item">
                        <a class="nav-link" aria-current="page" href="/index">Home</a>
                    </li>
<%--                    <li class="nav-item">--%>
<%--                        <a class="nav-link" href="/user/about">About</a>--%>
<%--                    </li>--%>
<%--                    <li class="nav-item">--%>
<%--                        <a class="nav-link" href="/user/floorplansl">Floor Plans</a>--%>
<%--                    </li>--%>
<%--                    <li class="nav-item">--%>
<%--                        <a class="nav-link" href="/user/agents">Agents</a>--%>
<%--                    </li>--%>
                    <li class="nav-item">
                        <a class="nav-link active" href="/user/register">Register</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="/user/search">Search</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="/user/create">Create</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="/user/assignments">Assign</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="/user/logout">Sign Out</a>
                    </li>
                </ul>
            </div>
        </div>
    </nav>
</header>
<form id="register-form" action="/user/registerSubmit" method="POST">
    <h1> Register New Tenant </h1>
    <input type="hidden" name="id" value="${form.id}">
    <div class="mb-3">
        <label for="FirstName" class="form-label">First Name:</label>
        <input
                type="text"
                class="form-control"
                name="firstName"
                id="FirstName"
                placeholder="first name"
                value="${form.firstName}"
        />
    </div>
    <div class="mb-3">
        <label for="LastName" class="form-label">Last Name:</label>
        <input
                type="text"
                class="form-control"
                name="lastName"
                id="LastName"
                placeholder="last name"
                value="${form.lastName}"
        />
    </div>
    <div class="mb-3">
        <label for="EmailAddress" class="form-label">Email address:</label>
        <input
                type="email"
                class="form-control"
                name="email"
                id="EmailAddress"
                placeholder="name@example.com"
                value="${form.email}"
        />
    </div>
    <div class="mb-3">
        <label for="contactNumber" class="form-label">Contact Number:</label>
        <input
                type="text"
                class="form-control"
                name="contactNumber"
                id="contactNumber"
                placeholder="phone number"
                value="${form.contactNumber}"
        />
    </div>
    <div class="mb-3">
        <label for="Password" class="form-label">Password:</label>
        <input
                type="password"
                class="form-control"
                name="password"
                id="Password"
                placeholder="password"
                value="${form.password}"
        />
    </div>
    <div class="mb-3">
        <label for="ConfirmPassword" class="form-label">Confirm password:</label>
        <input
                type="password"
                class="form-control"
                name="confirmPassword"
                id="ConfirmPassword"
                placeholder="confirm password"
                value="${form.confirmPassword}"
        />
    </div>

    <button type="submit" class="btn btn-primary" id="sButton">Register Tenant</button>
</form>


<footer>

</footer>

</body>
</html>
