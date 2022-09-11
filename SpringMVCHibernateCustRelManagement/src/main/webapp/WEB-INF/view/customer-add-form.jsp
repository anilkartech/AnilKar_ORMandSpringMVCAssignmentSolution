<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>

<html>

<head>
<title>Customer Add Form</title>
<link rel="stylesheet" type="text/css"
	href="<c:url value="/resources/css/customer-add-form.css"/>">
</head>

<body>
	<div class="container">
		<h2>Save Customer</h2>
		<form:form method="post" action="save" modelAttribute="customer">
			<table>
				<tr>
					<td>First Name:</td>
					<td><form:input type="text" path="firstName" /></td>
				</tr>
				<tr>
					<td>Last Name:</td>
					<td><form:input type="text" path="lastName" /></td>
				</tr>
				<tr>
					<td>Email:</td>
					<td><form:input type="text" path="email" /></td>
				</tr>
				<tr>
					<td></td>
					<td><input type="submit" value="Save" /></td>
				</tr>
			</table>
		</form:form>
		<br /> <a href="list">Back to List</a>
	</div>
</body>

</html>