<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<title>carousel</title>
<div class="container-fluid">
<div id="myCarousel" class="carousel slide" data-ride="carousel">
                       <ol class="carousel-indicators">
                <li data-target="#myCarousel" data-slide-to="0" class="active"></li>
                <li data-target="#myCarousel" data-slide-to="1"></li>
                <li data-target="#myCarousel" data-slide-to="2"></li>
                <li data-target="#myCarousel" data-slide-to="3"></li>
                <li data-target="#myCarousel" data-slide-to="4"></li>
            </ol>
            <div class="carousel-inner" role="listbox">
                <div class="item active">
                    <img class="first-slide home-image" src="resources/images/image1.jpg" alt="first slide" >
                    
                </div>
                <div class="item">
                    <img class="second-slide home-image" src="resources/images/image2.jpg" alt="Second slide">
                </div>
                <div class="item">
                    <img class="Third-slide home-image" src="resources/images/image3.jpg" alt="Third slide">
                </div>
                <div class="item">
                    <img class="forth-slide home-image " src="resources/images/image4.jpg" alt="forth slide">
                </div>
                 <div class="item">
                    <img class="fifth-slide home-image " src="resources/images/image5.jpg" alt="fifth slide">
                    <div class="container">
                    </div>
                </div>
            </div>
            <a class="left carousel-control" href="#myCarousel" role="button" data-slide="prev">
                <span class="glyphicon glyphicon-chevron-left"></span>
                <span class="sr-only">Previous</span>
            </a>
            <a class="right carousel-control" href="#myCarousel" role="button" data-slide="next">
                <span class="glyphicon glyphicon-chevron-right" ></span>
                <span class="sr-only">Next</span>
            </a>
        </div>
</div>
