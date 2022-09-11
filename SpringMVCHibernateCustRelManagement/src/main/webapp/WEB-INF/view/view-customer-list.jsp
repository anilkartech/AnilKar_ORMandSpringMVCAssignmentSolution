<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Customer List</title>
<link rel="stylesheet" type="text/css"
	href="<c:url value="/resources/css/view-customer-list.css"/>">
<script src="<c:url value="/resources/js/view-customer-list.js"/>"></script>
</head>
<body>
	<div class="container">
		<h1>CUSTOMER RELATIONSHIP MANAGEMENT</h1>
		<br /> <br /> <a class="btn" href="showFormForAdd">Add Customer</a>
		<br />
		<table id="customers">
			<tr>
				<th>First Name</th>
				<th>Last Name</th>
				<th>Email</th>
				<th>Action</th>
			</tr>
			<c:forEach items="${customerList}" var="customer">
				<tr>
					<td>${customer.firstName}</td>
					<td>${customer.lastName}</td>
					<td>${customer.email}</td>
					<td><a href="showFormForUpdate?customerId=${customer.id}">Update</a>
						| <a id="deletelink" onclick="confirmDeleteDialog(${customer.id})">Delete</a></td>
				</tr>
			</c:forEach>
		</table>
	</div>
</body>
</html>