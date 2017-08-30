  <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<script src="https://code.jquery.com/jquery-1.11.1.min.js"></script>
<script src="https://cdn.datatables.net/1.10.4/js/jquery.dataTables.min.js"></script>
<link rel="stylesheet" href="https://cdn.datatables.net/1.10.4/css/jquery.dataTables.min.css">
<title>product GladDogs</title>
<style type="text/css">
.list-group-item {
	overflow: hidden;
	margin: 3px;
	border-radius: 3px;
}

#removebuttons {
	color: #ffffff;
	background-color: #e57373;
}

#removebuttons:HOVER {
	color: #ffffff;
	background-color: #e53935;
}

#editbuttons {
	color: #ffffff;
	background: linear-gradient(to bottom, #aed581 50%, #9ccc65 50%);
}

#editbuttons:HOVER {
	color: #ffffff;
	background: linear-gradient(to bottom, #9ccc65 50%, #8bc34a 50%);
}

.form-product {
	max-width: 580px;
	padding: 15px 35px 45px;
	margin: 0 auto;
	background-color: brown;
	border: 1px solid rgba(0, 0, 0, 0.1);
	text-align: center;
	
	.
	form-signin-heading
	.checkbox
	{
	margin-bottom
	:
	30px;
}

.checkbox {
	font-weight: bolder;
	text-align: center;
}

.form-control {
	position: relative;
	font-size: 16px;
	height: auto;
	padding: 10px;
	@
	include
	box-sizing(border-box);
	&:
	focus
	{
	z-index
	:
	2;
}

}
input[type="text"] {
	margin-bottom: -1px;
	border-bottom-left-radius: 0;
	border-bottom-right-radius: 0;
}

input[type="password"] {
	margin-bottom: 20px;
	border-top-left-radius: 0;
	border-top-right-radius: 0;
}

}
.btn-block {
	background-color: white;
	color: black;
}

.btn-block:hover {
	color: #8B4513;
	background-color: #000000;
	border-color: #53A3CD;
}

.button {
	font-weight: 400px;
	font-size: 18px;
	font-weight: bold;
}
</style>
<script>
$(document).ready(function () {
    $('#table_id').dataTable({
       "pagingType": "full_numbers",
       "lengthMenu": [[2,5,10, -1], [2,5,10, "All"]],
     });
});
</script>
<jsp:include page="header.jsp" />
<div style="background-image: url('http://wallup.net/wp-content/uploads/2016/01/196605-dog-animals-nature-landscape-windy-Border_Collie-748x468.jpg');">
<div ng-controller="gdcontroller">
	<form:form class="form-product" modelAttribute="prodetails" action="addproduct" enctype="multipart/form-data">
				<h3 class="form-product-heading">PRODUCT DETAILS</h3>
				<c:if test="${!check}">
				<div class="form-group">
					<form:input type="text" name="ProductId" id="ProductId"
						class="form-control" path="ProductId" />
				</div>
				</c:if>
				<div class="form-group">
					<form:input type="text" name="ProductName" id="ProductName"
						class="form-control" placeholder="PRODUCT NAME" path="ProductName" />
				</div>

				<div class="form-group">
					<form:textarea class="form-control textarea-contact" rows="3"
						id="comment" name="description" placeholder="PRODUCT DESCRIPTION"
						required="true" path="ProductDescription" />
				</div>

				<div class="form-group">
					<form:input type="text" name="Price" id="Price"
						class="form-control" placeholder="PRICE"
						path="Price" />
				</div>

				<div class="form-group">
					<form:input type="text" name="Quantity" id="Quantity"
						class="form-control" placeholder="QUANTITY"
						path="Quantity" />
				</div>

				<div class="form-group">
					<form:select path="CategoryName" class="form-control">
					<c:forEach items="${catobjstring}" var="x">
						<c:set var="name" value="${x.getCategoryName()}"/>
						<form:option value="${name}">${name}</form:option>
					</c:forEach>
					</form:select>
				</div>
				<div class="form-group">
					<form:select path="SupplierName" class="form-control">
					<c:forEach var="sname" items="${supobjstring}">
						<c:set var="sn" value="${sname.getSupplierName()}"/>
						<form:option value="${sn}">${sn}</form:option>
						
					</c:forEach>
					</form:select>
				</div>
				<div class="form-group">
					<form:input type="file" path="PImage" class="form-control" />
				</div>
				<c:if test="${check}">
 			<div class="col-xs-6 col-sm-6 col-md-6">
					<form:button class="btn btn-lg btn-primary btn-block" style="margin-left: 110px;" type="submit" name="addpro">AddProduct</form:button>
				</div>
				</c:if>
				<c:if test="${!check}">
				<div class="col-xs-6 col-sm-6 col-md-6">
					<form:button class="btn btn-lg btn-primary btn-block" style="margin-left: 110px;" type="submit" name="editpro">UpdateProduct</form:button>
				</div>
		
		</c:if>
			</form:form>
</div>
						<div class="container" ng-controller="gdcontroller">
		    <table id="table_id"class="table table-condensed table-striped table-hover">
			<thead>
				<tr>
					<td>Product Image</td>
					<td>Product Id</td>
					<td>Product Name</td>
					<td>Product Description</td>
					<td>Price</td>
					<td>Quantity</td>
					<td>Supplier Name</td>
					<td>Category Name</td>
					<td>Edit/Remove</td>
				</tr>
			</thead>
			<tbody>
				 <c:forEach var="proobj" items="${proobjstring}"> 
				 <tr>
			<c:set var = "id" scope = "session" value = "${proobj.getProductId()}"/>
			       <td><img alt="" src="resources/proimage/${id}.jpg" width="200"></td>
					<td><c:out value="${id}"/></td>
					<td><c:out value="${Proobj.getProductName()}"/></td>
					<td><c:out value="${proobj.getProductDescription()}"/></td>
					<td><c:out value="${proobj.getPrice()}"/></td>
					<td><c:out value="${proobj.getQuantity()}"/></td>
					<td><c:out value="${proobj.getSupplierName()}"/></td>
					<td><c:out value="${proobj.getCategoryName()}"/></td>
					<td><div class="pull-right"> 
					<a href="editproduct?getcid=${id}"><button
								id="editbuttons" type="submit" class="btn">Edit</button></a> <a
							href="removeproduct/${id}"><button
								id="removebuttons" type="button" class="btn">Remove</button></a>   
		   	</div></td>
			</tr>
			</c:forEach>
			</tbody>
	</table>
	</div>
<jsp:include page="footer.jsp"/>