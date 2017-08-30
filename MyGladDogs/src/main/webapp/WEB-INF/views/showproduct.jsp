<title>Show one product</title>
<style>
.btn-product{
	width: 100%;
}

</style>
<script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.6.4/angular.min.js"></script>
<script>
	
	var prodet=${proobjstring};
	angular.module('gladdog',[]).controller('gdpcontroller', function($scope){$scope.po=prodet;});
</script>
<jsp:include page="header.jsp"/>
<div class="container" ng-app="gladdog" ng-controller="gdpcontroller">
<label>name is:${sessionScope.UserLoggedIn} </label>
    <div class="row">
    	<div class="col-md-12">
			<div class="col-sm-6 col-md-4" ng-repeat="p in po">
				<div class="thumbnail" style="height: 350px;">
					<img src="resources/proimage/{{p.ProductId}}.jpg" width="200" class="img-responsive">
					<div class="caption">
						<div class="row">
							<div class="col-md-6 col-xs-6">
								<h3>{{p.ProductName}}</h3>
							</div>
							<div class="col-md-6 col-xs-6 price">
								<h3>Rs.{{p.Price}}</h3>
							</div>
						</div>
						<div class="row">
							<div class="col-md-6">
								<a href="moredetails?getpid={{p.ProductId}}" class="btn btn-primary btn-product"><span class="glyphicon glyphicon-info-sign"></span>MoreDetails</a> 
							</div>
							<div class="col-md-6">
								<a href="addtocart?getprodid={{p.ProductId}}" class="btn btn-success btn-product"><span class="glyphicon glyphicon-shopping-cart"></span>Cart</a></div>
						</div>
					</div>
				</div>
			</div>
		</div> 
	</div>
</div>
<jsp:include page="footer.jsp"/>
