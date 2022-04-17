<%@ taglib prefix="c" uri="http://www.springframework.org/tags" %>

<jsp:include page="../include/header.jsp" />

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
                        <a class="nav-link" href="/user/register">Register</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="/user/search">Search</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link active" href="/user/create">Create</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="/user/assignment">Assign</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="/user/logout">Sign Out</a>
                    </li>
                </ul>
            </div>
        </div>
    </nav>
</header>
<form id="register-form" action="/user/createSubmit" method="post">
    <input type="hidden" name="id" value="${form.id}">
    <div class="mb-3">
        <label for="Status" class="form-label">Status:</label>
        <input
                type="text"
                class="form-control"
                name="status"
                id="Status"
                placeholder="rental status"
                value="${form.status}"
        />
    </div>
    <div class="mb-3">
        <label for="FloorPlan" class="form-label">Floor Plan:</label>
        <input
                type="text"
                class="form-control"
                name="floorPlan"
                id="FloorPlan"
                placeholder="floor plan"
                value="${form.floorPlan}"
        />
    </div>
    <div class="mb-3">
        <label for="Bathrooms" class="form-label">Bathrooms:</label>
        <input
                type="text"
                class="form-control"
                name="baths"
                id="Bathrooms"
                placeholder="number of bathrooms"
                value="${form.baths}"
        />
    </div>
    <div class="mb-3">
        <label for="Bedrooms" class="form-label">Bedrooms:</label>
        <input
                type="text"
                class="form-control"
                name="beds"
                id="Bedrooms"
                placeholder="number of bedrooms"
                value="${form.beds}"
        />
    </div>
    <div class="mb-3">
        <label for="Rent" class="form-label">Rent:</label>
        <input
                type="text"
                class="form-control"
                name="rent"
                id="Rent"
                placeholder="rent amount"
                value="${form.rent}"
        />
    </div>
    <div class="mb-3">
        <label for="SquareFeet" class="form-label">Square Feet:</label>
        <input
                type="text"
                class="form-control"
                name="squareFeet"
                id="SquareFeet"
                placeholder="square footage"
                value="${form.squareFeet}"
        />
    </div>

    <button type="submit" class="btn btn-primary" id="sButton">Create</button>
</form>


<footer>

</footer>

</body>
</html>
