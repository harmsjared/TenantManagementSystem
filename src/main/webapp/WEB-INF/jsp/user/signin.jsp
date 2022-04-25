<%@ taglib prefix="c" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="d" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:include page="../include/header.jsp" />

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
                        <a class="nav-link" href="/user/assignment">Assign</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="/user/admin">Admin</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link active" href="/user/signin">Sign In</a>
                    </li>
                </ul>
            </div>
        </div>
    </nav>
</header>
<form id="signin-form" action="/user/signinSubmit" method="post">
    <div class="mb-3">
        <label class="form-label">Email address</label>
        <input type="text" name="username" class="form-control">
        <d:forEach items="${bindingResult.getFieldErrors('username')}" var="error">
            <div style="color: black;">
                    ${error.getDefaultMessage()}
            </div>
        </d:forEach>
    </div>
    <div class="mb-3">
        <label class="form-label">Password</label>
        <input type="password" name="password" class="form-control">
        <d:forEach items="${bindingResult.getFieldErrors('password')}" var="error">
            <div style="color: black;">
                    ${error.getDefaultMessage()}
            </div>
        </d:forEach>
    </div>

    <button type="submit" class="btn btn-primary">Sign In</button>
</form>
<footer>
</footer>
</body>
