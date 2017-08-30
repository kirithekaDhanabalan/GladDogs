<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<title>cart</title>
<style type="text/css">
.table>tbody>tr>td, .table>tfoot>tr>td {
	vertical-align: middle;
}

@media screen and (max-width: 600px) {
	table#cart tbody td .form-control {
		width: 20%;
		display: inline !important;
	}
	.actions .btn {
		width: 36%;
		margin: 1.5em 0;
	}
	.actions .btn-info {
		float: left;
	}
	.actions .btn-danger {
		float: right;
	}
	table#cart thead {
		display: none;
	}
	table#cart tbody td {
		display: block;
		padding: .6rem;
		min-width: 320px;
	}
	table#cart tbody tr td:first-child {
		background: #333;
		color: #fff;
	}
	table#cart tbody td:before {
		content: attr(data-th);
		font-weight: bold;
		display: inline-block;
		width: 8rem;
	}
	table#cart tfoot td {
		display: block;
	}
	table#cart tfoot td .btn {
		display: block;
	}
}

hr.style18 {
	height: 30px;
	border-style: solid;
	border-color: #90BDC3;
	border-width: 2px 0 0 0;
	border-radius: 20px;
}

hr.style18:before {
	display: block;
	content: "";
	height: 30px;
	margin-top: -31px;
	border-style: solid;
	border-color: #90BDC3;
	border-width: 0 0 2px 0;
	border-radius: 20px;
}

.img-center {
	margin-left: 400px;
}
</style>
<jsp:include page="header.jsp" />
<div class="container">
	<div>
		<img src="resources/images/bag1.png" class="img-responsive img-center">
	</div>
	<hr class="style18" />
	<table id="cart" class="table table-hover">
		<thead>
			<tr>
				<th style="width: 50%">Product</th>
				<th style="width: 10%">Price</th>
				<th style="width: 8%">Quantity</th>
				<th style="width: 22%" class="text-center">Subtotal</th>
				<th style="width: 10%"></th>
			</tr>
		</thead>
		<tbody>
		
		<c:forEach var="carobj" items="${carobjstring}"> 
			<tr>
			
				<td data-th="Product">
					<div class="row">
						<div class="col-sm-2 hidden-xs">
							<img src="resources/proimage/${carobj.getProductId()}.jpg"
								class="img-responsive" />
						</div>
						<div class="col-sm-10">
							<h4 class="nomargin"><c:out value="${carobj.getProdname()}"/></h4>
						
						</div>
					</div>
				</td>
				<td data-th="Price"><c:out value="${carobj.getPrice()}"/></td>
				<td data-th="Quantity"><input type="number" min="1" max="10"
					class="form-control text-center" value="1"></td>
				  <td data-th="Subtotal" class="text-center"><c:out value="${carobj.getQuantity()}"/></td>
				<td class="actions" data-th=""><a href="removecategory/${id}">
					<button type="button" class="btn btn-danger">
						<span class="glyphicon glyphicon-trash"></span> Remove
					</button></a>
				</td>
			</tr>
		</tbody>
		</c:forEach>
		<tfoot>
			<tr class="visible-xs">
				<td class="text-center"><strong><c:out value="${carobj.getTotal()}"/></strong></td>
			</tr>
			
		</tbody>
		
</div>

		<tfoot>
			<tr class="visible-xs">
				<%-- <td class="text-center"><strong><c:out value="${carobj.getGrandtotal()}"/></strong></td> --%>
			</tr>


			<tr>
				<td><a href="#" class="btn btn-warning"><i
						class="glyphicon glyphicon-share-alt"></i> Continue Shopping</a></td>
				<td colspan="2" class="hidden-xs"></td>
				<%-- <td class="hidden-xs text-center"><strong><c:out value="${carobj.getGrandtotal()}"/></strong></td> --%>
				<td><a href="addresscart" class="btn btn-success btn-block">Checkout
						<i class="fa fa-angle-right"></i>
				</a></td>
			</tr>
		</tfoot>
		
	</table>

</div>

<jsp:include page="footer.jsp" />

