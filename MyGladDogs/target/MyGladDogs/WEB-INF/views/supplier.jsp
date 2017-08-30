  <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<script src="https://code.jquery.com/jquery-1.11.1.min.js"></script>
<script src="https://cdn.datatables.net/1.10.4/js/jquery.dataTables.min.js"></script>
<link rel="stylesheet" href="https://cdn.datatables.net/1.10.4/css/jquery.dataTables.min.css">
<title>supplier GladDogs</title>
<style type="text/css">
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
	background-color: #8B4513;
	border: 1px solid rgba(0, 0, 0, 0.1);
	text-align: center;
	
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
<div>
		<form:form class="form-product" modelAttribute="supdetails"
			action="addsupplier" method="post">
			<h3 class="form-product-heading">SUPPLIER DETAILS</h3>
			<c:if test="${!check}">
				<div class="form-group">
					<form:input type="text" name="SupplierId" id="SupplierId"
						class="form-control" path="SupplierId" readonly="true" />
				</div>
			</c:if>
			<div class="form-group">
				<form:input type="text" name="SupplierName" id="SupplierName"
					class="form-control" placeholder="SUPPLIER NAME"
					path="SupplierName" />
			</div>

			<div class="form-group">
				<form:textarea class="form-control textarea-contact" rows="3"
					id="comment" name="FB" placeholder="SUPPLIER ADDRESS"
					required="true" path="SupplierAddress" />
			</div>

			<div class="form-group">
				<form:input type="text" name="SupplierPhonenumber"
					id="SupplierPhonenumber" class="form-control input-lg"
					placeholder="SUPPLIER PHONENUMBER" path="SupplierPhonenumber" />
			</div>

			<div class="form-group">
				<form:input type="text" name="SupplierAlternatePhonenumber"
					id="SupplierAlternatePhonenumber" class="form-control input-lg"
					placeholder="SUPPLIER ALTERNATE PHONENUMBER"
					path="SupplierAlternatePhonenumber" />
			</div>


			<div class="form-group">
				<form:input type="text" name="SupplierEmail-id"
					id="SupplierEmail-id" class="form-control"
					placeholder="SUPPLIER EMAIL-ID" path="SupplierEmailid" />
			</div>

			<div class="col-xs-6 col-sm-6 col-md-6">
				<c:if test="${check}">
					<button class="btn btn-lg btn-primary btn-block" style="margin-left: 110px;" type="submit"
						value="AddSupplier" name="add">AddSupplier</button>
				</c:if>
				<c:if test="${!check}">
					<button class="btn btn-lg btn-primary btn-block" style="margin-left: 110px;" type="submit"
						value="AddSupplier" name="edit">UpdateSupplier</button>
				</c:if>
		</form:form>
	</div>
	<div class="container" ng-controller="gdsupcontroller">
		<table id="table_id" class="table table-condensed table-striped table-hover">
			<thead>
				<tr>
					<td>Supplier Id</td>
					<td>Supplier Name</td>
					<td>Supplier Address</td>
					<td>Supplier Phonenumber</td>
					<td>Supplier AlternatePhonenumber</td>
					<td>Supplier Emailid</td>
					<td>Edit/Remove</td>
				</tr>
			</thead>
			<tbody>
			<c:forEach var="supobj" items="${supobjstring}">
			<tr>
			<c:set var = "id" scope = "session" value = "${supobj.getSupplierId()}"/>
					<td><c:out value="${id}"/></td>
					<td><c:out value="${supobj.getSupplierName()}"/></td>
					<td><c:out value="${supobj.getSupplierAddress()}"/></td>
					<td><c:out value="${supobj.getSupplierPhonenumber()}"/></td>
					<td><c:out value="${supobj.getSupplierAlternatePhonenumber()}"/></td>
					<td><c:out value="${supobj.getSupplierEmailid()}"/></td>
					<td><div class="pull-right">
					<a href="editsupplier?getsid=${id}"><button
							id="editbuttons" type="submit" class="btn">Edit</button></a> <a
						href="removesupplier/${id}"><button
							id="removebuttons" type="button" class="btn">Remove</button></a>
				</div></td>
			</tr>
			</c:forEach>
			</tbody>
		</table>
	</div>
	<div><br/><br/><br/><br/></div>

<jsp:include page="footer.jsp" />
