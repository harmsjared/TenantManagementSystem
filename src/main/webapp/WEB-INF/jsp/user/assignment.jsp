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
                        <a class="nav-link" aria-current="page" href="/index">Home</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="/user/register">Register</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="/user/search">Search</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="/user/create">Create</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link active" href="/user/assignment">Assign</a>
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
<div class="container">
<form id="signin-form" action="/user/assignmentSubmit" method="post">
    <div class="mb-3">
        <label  class="form-label">Tenant Id:</label>
        <input
                type="text"
                class="form-control"
                name="t_id"
                placeholder="Tenant"
                value="${form.t_id}"
        />
        <d:forEach items="${bindingResult.getFieldErrors('t_id')}" var="error">
            <div style="color: black;">
                    ${error.getDefaultMessage()}
            </div>
        </d:forEach>
    </div>
        <div class="mb-3">
            <label  class="form-label">Apartment Id:</label>
            <input
                    type="text"
                    class="form-control"
                    name="a_id"
                    placeholder="Apartment"
                    value="${form.a_id}"
            />
            <d:forEach items="${bindingResult.getFieldErrors('a_id')}" var="error">
                <div style="color: black;">
                        ${error.getDefaultMessage()}
                </div>
            </d:forEach>
        </div>
<br>
        <button type="submit" class="btn btn-primary" id="sButton">Assign</button>

</form>

</div>
</body>
<footer>


</footer>
</html>