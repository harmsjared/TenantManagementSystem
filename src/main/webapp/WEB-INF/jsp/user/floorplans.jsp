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
                        <a class="nav-link active" href="/user/floorplans">Floor Plans</a>
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

<div  id="floorplans" class="container">
    <div class="row align-items-start">
        <div id="floorplan_column" class="col-sm-4">
            <img id="myImg" src="https://statesmanapartments.com/wp-content/uploads/A-1-bed-1-bath-789-2.jpg">
            <p><br>Floor Plan One</p>
        </div>
        <div class="col">
            <p><strong>Description:</strong><span> Floor Plan One is our simple yet luxurious base model apartment. It features one bathroom with a shower, one bedroom, in-unit laundry, a full kitchen, a hybrid dining/family room, and a balcony. </span></p>
            <p><strong>Square Footage:</strong> 950 </p>
            <p><strong>Rent:</strong> $900</p>
            <p>This home is perfect for any individual or a couple who doesn't need a huge amount of space. Pets under 25 lbs are allowed. <strong>We welcome everyone and anyone. Apply Today!</strong></p>
            <br>
            <div class="bottom-border"></div>
        </div>
    </div>
    <div  class="row align-items-start">
        <div id="floorplan_column2" class="col-sm-4">
            <img id="myImg2" src="https://statesmanapartments.com/wp-content/uploads/B-1-bed-1-bath-den-968.jpg">
            <p><br>Floor Plan Two</p>
        </div>
        <div class="col">
            <p><strong>Description:</strong><span> Floor Plan Two is our step up from the  luxurious base model apartment. It features: one bathroom, one full-size bedroom and a half-bedroom that can be used as a den or workspace, in-unit laundry, a full-size kitchen, a hybrid dining/family room, and a balcony. </span></p>
            <p><strong>Square footage:</strong> 1075</p>
            <p><strong>Rent:</strong> $1100</p>
            <p>This home is perfect for anyone as it is spacious, provides needed privacy, and a great optional bedroom. Pets under 40 lbs are allowed. <strong>Apply Today!</strong></p>
            <br>
            <div class="bottom-border"></div>
        </div>
    </div>
    <div class="row align-items-start">
        <div id="floorplan_column3" class="col-sm-4">
            <img id="myImg3" src="https://statesmanapartments.com/wp-content/uploads/D-2-bed-2-bath-1090.jpg">
            <p><br>Floor Plan Three</p>
        </div>
        <div class="col">
            <p><strong>Description:</strong><span> Floor Plan Three is our pride and joy. Featuring two bathrooms, two bedrooms, a full-size kitchen and living area, a full-size laundry room, and a balcony. </span></p>
            <p><strong>Square footage:</strong> 1350 sg/ft</p>
            <p><strong>Rent:</strong>$1400</p>
            <p>We like to think of this home as our family unit. It's the perfect size for a couple and a kid or two. Pets under 80 lbs are allowed. <strong>Apply Today!</strong></p>
            <br>
            <div class="bottom-border"></div>
        </div>
    </div>

    <!-- <div id="fullpage" onclick="this.style.display = 'none';"></div> -->
    <div id="myModal" class="modal">
        <span class="close">&times;</span>
        <img class="modal-content" id="img01">
        <div id="caption"></div>
    </div>
    <div id="myModal2" class="modal">
        <span class="close1">&times;</span>
        <img class="modal-content" id="img02">
        <div id="caption"></div>
    </div>
    <div id="myModal3" class="modal">
        <span class="close2">&times;</span>
        <img class="modal-content" id="img03">
        <div id="caption"></div>
    </div>



    <footer>

    </footer>
    <script>
        var modal = document.getElementById("myModal");
        var img = document.getElementById("myImg");
        var modalImg = document.getElementById("img01");
        var captionText = document.getElementById("caption");
        img.onclick = function(){
            modal.style.display = "block";
            modalImg.src = this.src;
            captionText.innerHTML = this.alt;
        }
        var span = document.getElementsByClassName("close")[0];
        span.onclick = function() {
            modal.style.display = "none";
        }
        var modal = document.getElementById("myModal2");
        var img = document.getElementById("myImg2");
        var modalImg = document.getElementById("img02");
        var captionText = document.getElementById("caption");
        img.onclick = function(){
            modal.style.display = "block";
            modalImg.src = this.src;
            captionText.innerHTML = this.alt;
        }
        var span = document.getElementsByClassName("close1")[0];
        span.onclick = function() {
            modal.style.display = "none";
        }
        var modal = document.getElementById("myModal3");
        var img = document.getElementById("myImg3");
        var modalImg = document.getElementById("img03");
        var captionText = document.getElementById("caption");
        img.onclick = function(){
            modal.style.display = "block";
            modalImg.src = this.src;
            captionText.innerHTML = this.alt;
        }
        var span = document.getElementsByClassName("close2")[0];
        span.onclick = function() {
            modal.style.display = "none";
        }
    </script>
</div>
</body>

