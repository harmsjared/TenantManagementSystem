<%@ taglib prefix="c" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="d" uri="http://java.sun.com/jsp/jstl/core" %>

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
                        <a class="nav-link" aria-current="page" href="/index"
                        >Home</a>
                    </li>
                    <li class="nav-item">
                      <a class="nav-link" href="/user/register">Register</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link active" href="/user/search">Search</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="/user/create">Create</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="/user/assignment">Assign</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="/user/admin">Admin</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="/user/logout">Sign Out</a>
                    </li>
                </ul>
            </div>
        </div>
    </nav>
</header>

<div id="tenant-container" class="container">
    <h1>Display All Tenants</h1>

    <form action="/user/searchAll" method="get">

        <button type="submit" class="btn btn-primary">Display</button>
    </form>
    <br>
    <table class="table">
        <tr scope="row">
            <th>Tenant Id</th>
            <th>Email</th>
            <th>First Name</th>
            <th>Last Name</th>
            <th>Status</th>
        </tr>

        <d:forEach items = "${tenantModelKey}" var = "tenant">
            <tr scope="row">
                <td>${tenant.id}</td>
                <td>${tenant.email}</td>
                <td>${tenant.firstName}</td>
                <td>${tenant.lastName}</td>
<%--                <td>Select</td>--%>

            </tr>

        </d:forEach>
    </table>
</div>
<br>
<div id="search-container" class="container">
<h1>Tenant Search</h1>

<form action="/user/search" method="get">
    First Name  <input type="text" name="firstName" id="firstNameId" value="${firstName}">
    <button type="submit" class="btn btn-primary">Search</button>

</form>
<br>
<table class="table">
    <tr scope="row">
        <th>Tenant Id</th>
        <th>First Name</th>
        <th>Last Name</th>
        <th>Email</th>
        <th>Tel</th>
        <th>Status</th>
        <th>Edit</th>
    </tr>

    <d:forEach items = "${usersModelKey}" var = "tenant">
        <tr scope="row">
            <td>${tenant.id}</td>
            <td>${tenant.firstName}</td>
            <td>${tenant.lastName}</td>
            <td>${tenant.email}</td>
            <td>${tenant.contactNumber}</td>
            <td>${tenant.status}</td>
            <td><a href="/user/edit/${tenant.id}">Edit</a></td>

        </tr>

    </d:forEach>
</table>
</div>
<br>
<div id="apartmentSearch-container" class="container">
    <h1>Apartment Search</h1>

    <form action="/user/search2" method="get">
        Floor Plan  <input type="text" name="floorPlan" id="floorPlan" value="${floorPlan}">
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
<br>
<div id="delete-container" class="container">
    <h1>Delete Tenant</h1>

    <form action="/user/delete" method="get" >
        Tenant Id  <input type="text" name="id" id="tenantId" value="${id}">
        <button type="submit" class="btn btn-primary">Delete</button>


    </form><br>
</div>
</body>
<footer>

</footer>