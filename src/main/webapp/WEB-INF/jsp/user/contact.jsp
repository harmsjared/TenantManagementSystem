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
                        <a class="nav-link active" href="/user/contact">Contact</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="/user/signin">Sign In</a>
                    </li>
                </ul>
            </div>
        </div>
    </nav>
</header>
<div class="container">

    <form id="register-form" action="https://formsubmit.co/harms.jared.e@gmail.com" method="POST">

        <!-- create thank you page/model/popup that displays cute thank you message -->
        <input type="hidden" name="_next" value="http://localhost:8080/index">


        <div class="mb-3">
        <label class="form-label">Full Name:</label>
        <input type="text" class="form-control" name="name" placeholder="Full Name" value="${form.fullName}" required/>
        </div>

        <div class="mb-3">
        <label class="form-label">Email Address:</label>
        <input type="email" class="form-control" name="email" placeholder="Email Address" value="${form.email}" required/>
        </div>

        <div class="mb-3">
        <label class="form-label">Message:</label>
        <textarea type="text" rows="5" class="form-control" name="message" placeholder="Message" value="${form.message}" required></textarea>
        </div>

        <input type="hidden" name="_captcha" value="false">

<%--        <button type="submit" class="btn btn-primary" id="jButton" value="/user/contactSubmit">Save</button>--%>
        <button type="submit" class="btn btn-primary" id="sButton">Send</button>
        <br>
        <br>
        <div style="color: black">*After pressing the Send button you will be redirected to the homepage. One of our agents will reach out to you within 24 hours. </div>
    </form>






</div>
<footer class="homepage">

</footer>

</body>
</html>
