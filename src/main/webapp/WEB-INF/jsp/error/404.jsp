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
</head>

<body>
<header>
    <nav id="navbar" class="navbar navbar-expand-lg navbar-light">
        <div class="container-fluid">
            <a href="#" class="logo"><img src="<c:url value="/resources/mytheme/images/happyhomeslogo.png"/>" /></a>
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
                        <a class="nav-link active" aria-current="page" href="/index">Home</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="/user/about">About</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="/user/floorplans">Floor Plans</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="/user/agents">Agents</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="/user/contact">Contact</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="/user/signin">Sign In</a>
                    </li>
                </ul>
            </div>
        </div>
    </nav>
</header>
<div id="error-page" class="container">
    <h1> 404 </h1>
    <h2> It seems the page you're looking for doesn't exist. </h2>
    <h3> Let's take you <a style="color:black;" href="/index">home</a>.</h3>
</div>
<footer>

</footer>
</body>
</html>