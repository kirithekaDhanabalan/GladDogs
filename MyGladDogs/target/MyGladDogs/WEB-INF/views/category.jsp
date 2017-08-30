<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<script src="https://code.jquery.com/jquery-1.11.1.min.js"></script>
<script src="https://cdn.datatables.net/1.10.4/js/jquery.dataTables.min.js"></script>
<link rel="stylesheet" href="https://cdn.datatables.net/1.10.4/css/jquery.dataTables.min.css">
<title>Category GladDogs</title>
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
	background-color: #8B4513;
	border: 1px solid rgba(0, 0, 0, 0.1);
	text-align: center; . form-control { position : relative;
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

.
#btn-block {
	background-color: white;
	color: black;
	padding-left: 500px;
}

#btn-block:hover {
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
<div style="background-image: url('http://wallpapercave.com/wp/7CkMTVd.jpg'); background-repeat: no-repeat;">
	<div>
		<c:if test="${check}">
			<form:form class="form-product" modelAttribute="catdetails"
				action="addcategory" method="POST">
				<h3 class="form-product-heading">CATEGORY DETAILS</h3>


					<div class="form-group">
					<form:input type="text" name="CategoryName" id="CategoryName"
						class="form-control" placeholder="CATEGORY NAME"
						path="CategoryName" />
				</div>
				<div class="form-group">
					<form:textarea class="form-control textarea-contact" rows="3"
						id="comment" name="Category" placeholder="CATEGORY DESCRIPTION"
						required="true" path="CategoryDescription" />
				</div>
				<div class="col-xs-6 col-sm-6 col-md-6">
					<button class="btn btn-lg btn-primary btn-block" style="margin-left: 110px;" type="submit">AddCategory</button>
				</div>
			</form:form>
		</c:if>
		<c:if test="${!check}">
			<form:form class="form-product" modelAttribute="catdetails"
				action="updatecategory" method="POST">
				<h3 class="form-product-heading">CATEGORY DETAILS</h3>
				<div class="form-group">
					<form:input readonly="true" type="text" name="CategoryId"
						id="CategoryId" class="form-control" placeholder="Category Id"
						path="CategoryId" />
				</div>
				<div class="form-group">
					<form:input type="text" name="CategoryName" id="CategoryName"
						class="form-control" placeholder="CATEGORY NAME"
						path="CategoryName" />
				</div>
				<div class="form-group">
					<form:textarea class="form-control textarea-contact" rows="3"
						id="comment" name="Category" placeholder="CATEGORY DESCRIPTION"
						required="true" path="CategoryDescription" />
				</div>
				<div class="col-xs-6 col-sm-6 col-md-6">
					<button class="btn btn-lg btn-primary btn-block" style="margin-left: 110px;" type="submit">UpdateCategory</button>
				</div>
			</form:form>
		</c:if>
	</div>
	<div class="container" style="margin-top: 40px;">
		<table id="table_id" class="table table-condensed table-striped table-hover">
			<thead style="text-align: center;">
				<tr>
					<td>Category Id</td>
					<td>Category Name</td>
					<td>Category Description</td>
					<td>Edit/Remove</td>
				</tr>
			</thead>
			<tbody>
			<c:forEach var="catobj" items="${catobjstring}">
					<tr>
					 	<c:set var = "id" scope = "session" value = "${catobj.getCategoryId()}"/>
						<td><c:out value="${id}"/></td>
						<td><c:out value="${catobj.getCategoryName()}"/></td>
						<td><c:out value="${catobj.getCategoryDescription()}"/></td>
						<td><div class="pull-right">
								<a href="editcategory?getcid=${id}"><button
										id="editbuttons" type="submit" class="btn">Edit</button></a> <a
									href="removecategory/${id}"><button
										id="removebuttons" type="button" class="btn">Remove</button></a>
							</div></td>
					</tr>
				</c:forEach>

			</tbody>
		</table>
	</div>
	<jsp:include page="footer.jsp" />