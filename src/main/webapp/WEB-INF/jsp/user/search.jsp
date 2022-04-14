<%@ taglib prefix="c" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="d" uri="http://java.sun.com/jsp/jstl/core" %>
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
                        <a class="nav-link" aria-current="page" href="/index"
                        >Home</a>
                    </li>
<%--                     <li class="nav-item">--%>
<%--                      <a class="nav-link" href="about.html">About</a>--%>
<%--                    </li>--%>
<%--                    <li class="nav-item">--%>
<%--                      <a class="nav-link" href="floorplans.html">Floor Plans</a>--%>
<%--                    </li>--%>
<%--                    <li class="nav-item">--%>
<%--                      <a class="nav-link active" href="agents.html">Agents</a>--%>
<%--                    </li>--%>
                    <li class="nav-item">
                      <a class="nav-link" href="/user/register">Register</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link active" href="/user/search">Tenant Search</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="/user/create">Apartment Creator</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="/user/logout">Sign Out</a>
                    </li>
                </ul>
            </div>
        </div>
    </nav>
</header>
<div id="search-container" class="container">
<h1>Tenant Search</h1>

<form action="/user/search" method="get">
    First Name  <input type="text" name="firstName" id="firstNameId" value="${firstName}">
    <button type="submit" class="btn btn-primary">Search</button>
</form>
<br>
<table class="table">
    <tr scope="row">
        <th>Email</th>
        <th>First Name</th>
        <th>Last Name</th>
        <th>Options</th>
    </tr>

    <d:forEach items = "${usersModelKey}" var = "tenant">
        <tr scope="row">
            <td>${tenant.email}</td>
            <td>${tenant.firstName}</td>
            <td>${tenant.lastName}</td>
            <td>Select</td>

        </tr>

    </d:forEach>
</table>
</div>
<br>
<div id="apartmentSearch-container" class="container">
    <h1>Apartment Search</h1>

    <form action="/user/search2" method="get">
        Floor Plan  <input type="text" name="floorPlan" id="apartmentId" value="${floorPlan}">
        <button type="submit" class="btn btn-primary">Search</button>
    </form>
    <br>
    <table class="table">
        <tr scope="row">
            <th>Apartment Id</th>
            <th>Status</th>
            <th>Floor Plan</th>
            <th>Bathrooms</th>
            <th>Bedrooms</th>
            <th>Rent</th>
            <th>Square Feet</th>
        </tr>

        <d:forEach items = "${apartmentsModelKey}" var = "apartment">
            <tr scope="row">
                <td>${apartment.id}</td>
                <td>${apartment.status}</td>
                <td>${apartment.floorPlan}</td>
                <td>${apartment.baths}</td>
                <td>${apartment.beds}</td>
                <td>${apartment.rent}</td>
                <td>${apartment.squareFeet}</td>
<%--                <td>Select</td>--%>

            </tr>

        </d:forEach>
    </table>
</div>
</body>