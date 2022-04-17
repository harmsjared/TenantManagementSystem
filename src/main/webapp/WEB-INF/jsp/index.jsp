<%@ taglib prefix="c" uri="http://www.springframework.org/tags" %>

<jsp:include page="include/header.jsp" />

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
<div id="main" class="container">
    <div class="row">
        <div id="homepage" class="col-sm-4">
            <div id="card-main" class="card-transparent">
                <img class="card-img-top" src="<c:url value="/resources/mytheme/images/undraw_shared_goals_re_jvqd.svg"/>" alt="..."/>
                <div class="card-body">
                    <p class="card-text">
                        At Happy Homes we use our literal superpowers to make your living experience affordable, enjoyable, and uplifting. That's the Happy Homes promise.
                    </p>
                </div>
            </div>
        </div>
        <div class="col-sm-8">
            <div id="carouselExampleControls" class="carousel slide" data-bs-ride="carousel">
                <div class="carousel-inner">
                    <div class="carousel-item active">
                        <img src="https://www.southwestjournal.com/wp-content/uploads/2020/06/Nicollet-scaled.jpg" class="d-block w-100" alt="...">
                    </div>
                    <div class="carousel-item">
                        <img src="https://www.treehugger.com/thmb/yJMEhqi4Y4bQcZxF8cbpxTLg9to=/2000x1333/filters:fill(auto,1)/__opt__aboutcom__coeus__resources__content_migration__treehugger__images__2018__12__pax-futura-vivian-hsu-01-22d54f9aed2e4b07a5ae22ece5de55dd.jpg" class="d-block w-100" alt="...">
                    </div>
                    <div class="carousel-item">
                        <img src="https://www.thekickassentrepreneur.com/wp-content/uploads/2019/06/Apartment-Buildings.jpg" class="d-block w-100" alt="...">
                    </div>
                </div>
                <button class="carousel-control-prev" type="button" data-bs-target="#carouselExampleControls" data-bs-slide="prev">
                    <span class="carousel-control-prev-icon" aria-hidden="true"></span>
                    <span class="visually-hidden">Previous</span>
                </button>
                <button class="carousel-control-next" type="button" data-bs-target="#carouselExampleControls" data-bs-slide="next">
                    <span class="carousel-control-next-icon" aria-hidden="true"></span>
                    <span class="visually-hidden">Next</span>
                </button>
            </div>
        </div>
    </div>
</div>
</div>
<footer class="homepage">

</footer>

</body>
</html>

