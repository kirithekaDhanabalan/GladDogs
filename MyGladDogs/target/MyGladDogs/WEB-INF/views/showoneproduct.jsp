<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.6.4/angular.min.js"></script>
<script>
	var prodet=${proobjstring};
	angular.module('gladdog',[]).controller('gdp1controller', function($scope){$scope.p=prodet;});
</script>	
<jsp:include page="header.jsp"/>
<div class="container" ng-app="gladdog" ng-controller="gdp1controller">
	<div class="row">
		<div class="col-xs-4 item-photo">
			<img style="max-width: 100%;"
				src="resources/proimage/{{p.ProductId}}.jpg" width="200"
				class="img-responsive" />
		</div>
		<div class="col-xs-5" style="border: 0px solid gray">
			<p>
			<h2>ProductName:{{p.ProductName}}</h2>
			</p>
			<h4 style="color: #337ab7">{{p.ProductDescription}}</h4>
			<h3 style="margin-top: 0px;">Rs.{{p.Price}}</h3>
		</div>
		<div class="col-xs-6 col-sm-6 col-md-6"></div>
		<div class="row">
			<div class="col-md-6">
				<a href="product" class="btn btn-primary btn-product"><span
					class="glyphicon glyphicon-info-sign"></span>Back to Products</a> <a
					href="addtocart" class="btn btn-success btn-product"><span
					class="glyphicon glyphicon-shopping-cart"></span>Cart</a>
			</div>
		</div>
	</div>
</div>
<jsp:include page="footer.jsp"/>
