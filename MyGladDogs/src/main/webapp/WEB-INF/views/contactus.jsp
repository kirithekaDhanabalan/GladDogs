<title>Contact Us GladDogs</title>
<style type="text/css">
.header-title {
	margin-top: 10px;
	text-align: center;
	color: #8B4513;
	margin-bottom: -10px;
}

#tip {
	display: none;
}

.fadeIn {
	animation-duration: 3s;
}

.form-control {
	border-radius: 0px;
	border: 1px solid black;
}

.form-control:focus {
	border: 1px solid brown;
}

.textarea-contact {
	resize: none;
}

.btn-send {
	border-radius: 0px;
	border: 1px solid #000000;
	background: #8B4513;
	color: #ffffff;
}

.btn-send:hover {
	border: 1px solid #800000;
	background: #fff;
	color: #8B4513;
	transition: background 0.5s;
}

.second-portion {
	margin-top: 3px;
}

@import
	"//netdna.bootstrapcdn.com/font-awesome/4.0.3/css/font-awesome.min.css"
	;

@import "http://fonts.googleapis.com/css?family=Roboto:400,500";

.box>.icon {
	text-align: center;
	position: relative;
}

.box>.icon>.image {
	position: relative;
	z-index: 2;
	margin: auto;
	width: 88px;
	height: 88px;
	border: 8px solid white;
	line-height: 88px;
	border-radius: 50%;
	background: #8B4513;
	vertical-align: middle;
}

.box>.icon:hover>.image {
	background: #000000;
}

.box>.icon>.image>i {
	font-size: 36px !important;
	color: #fff !important;
}

.box>.icon:hover>.image>i {
	color: white !important;
}

.box>.icon>.info {
	margin-top: -24px;
	background: rgba(0, 0, 0, 0.04);
	border: 1px solid #e0e0e0;
	padding: 15px 0 10px 0;
	min-height: 163px;
}

.box>.icon:hover>.info {
	background: rgba(0, 0, 0, 0.04);
	border-color: #e0e0e0;
	color: white;
}

.box>.icon>.info>h3.title {
	font-family: "Robot", sans-serif !important;
	font-size: 16px;
	color: #222;
	font-weight: 700;
}

.box>.icon>.info>p {
	font-family: "Robot", sans-serif !important;
	font-size: 13px;
	color: #666;
	line-height: 2.5em;
	margin: 10px;
}

.box>.icon:hover>.info>h3.title, .box>.icon:hover>.info>p, .box>.icon:hover>.info>.more>a
	{
	color: #222;
}

.box>.icon>.info>.more a {
	font-family: "Robot", sans-serif !important;
	font-size: 12px;
	color: #808080;
	line-height: 90px;
	text-transform: uppercase;
	text-decoration: none;
}

.box>.icon:hover>.info>.more>a {
	color: #fff;
	padding: 3px 3px;
	background-color: red;
}

.box .space {
	height: 30px;
}

@media only screen and (max-width: 768px) {
	.contact-form {
		margin-top: 25px;
	}
	.btn-send {
		width: 100%;
		padding: 10px;
	}
	.second-portion {
		margin-top: 25px;
	}
}
/* Conatact end */
</style>
<jsp:include page="header.jsp" />
<div class="container animated fadeIn">
	<div class="row">
		
		<div class="col-sm-12" id="parent">
			<div class="col-sm-6">
				<iframe width="100%" height="280"
					src="https://www.mapsdirections.info/en/custom-google-maps/map.php?width=100%&height=280&hl=ru&q=%20Dr%20Rajendra%20Prasad%20Road%20%2C%20100%20Feet%20Road%20%2C%20Gandhipuram%2C%20Coimbatore-641012+(GladDogs)&ie=UTF8&t=&z=16&iwloc=A&output=embed"
					frameborder="0" scrolling="no" marginheight="0" marginwidth="0">
				</iframe>
			</div>
			<div class="col-sm-6">
				<form action="form.php" class="contact-form" method="post">
					<div class="form-group">
						<input type="text" class="form-control" id="name" name="nm"
							placeholder="Name" required="" autofocus="">
					</div>

					<div class="form-group form_left">
						<input type="email" class="form-control" id="email" name="em"
							placeholder="Email" required="">
					</div>

					<div class="form-group">
						<input type="text" class="form-control" id="phone"
							onkeypress="return event.charCode >= 48 && event.charCode <= 57"
							maxlength="10" placeholder="Mobile No." required="">
					</div>
					<div class="form-group">
						<textarea class="form-control textarea-contact" rows="3"
							id="comment" name="FB"
							placeholder="Type Your Message/Feedback here..." required=""></textarea>
						<br>
						<button class="btn btn-default btn-send">
							<span class="glyphicon glyphicon-send"></span> Send
						</button>
					</div>
				</form>
			</div>
		</div>
	</div>

	<div class="container second-portion">
		<div class="row">
			<div class="col-xs-12 col-sm-6 col-lg-4">
				<div class="box">
					<div class="icon">
						<div class="image">
							<i class="fa fa-envelope" aria-hidden="true"></i>
						</div>
						<div class="info">
							<h3 class="title">MAIL & WEBSITE</h3>
							<p>
								<i class="fa fa-envelope" aria-hidden="true"></i> &nbsp
								info@gladdogs.com <br> <i class="fa fa-globe"
									aria-hidden="true"></i> &nbsp www.gladdogs.com
							</p>
						</div>
					</div>
					<div class="space"></div>
				</div>
			</div>

			<div class="col-xs-12 col-sm-6 col-lg-4">
				<div class="box">
					<div class="icon">
						<div class="image">
							<i class="fa fa-mobile" aria-hidden="true"></i>
						</div>
						<div class="info">
							<h3 class="title">CONTACT</h3>
							<p>
								<i class="fa fa-mobile" aria-hidden="true"></i> &nbsp
								(+91)-97120 20865 <br> <i class="fa fa-mobile"
									aria-hidden="true"></i> &nbsp (+91)-7567065254
							</p>
						</div>
					</div>
					<div class="space"></div>
				</div>
			</div>

			<div class="col-xs-12 col-sm-6 col-lg-4">
				<div class="box">
					<div class="icon">
						<div class="image">
							<i class="fa fa-map-marker" aria-hidden="true"></i>
						</div>
						<div class="info">
							<h3 class="title">ADDRESS</h3>
							<p>
								<i class="fa fa-map-marker" aria-hidden="true"></i> &nbsp Office
								no.41 , 2nd floor , Dr Rajendra Prasad Road , 100 Feet Road ,
								Gandhipuram, Coimbatore-641012
							</p>
						</div>
					</div>
					<div class="space"></div>
				</div>
			</div>
		</div>
	</div>
</div>
<jsp:include page="footer.jsp" />
