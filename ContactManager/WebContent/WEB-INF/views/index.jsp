<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<style>
table, th, td {
	border: 1px solid black;
}

th, td {
	padding: 10px;
}
</style>
<meta charset="ISO-8859-1">
<title>Contact Manager</title>
</head>
<body>
	<div align="center">
		<h1>Contact List</h1>
		<table>
			<tr>
				<th>Contact ID</th>
				<th>Name</th>
				<th>Email</th>
				<th>Address</th>
				<th>Phone</th>
				<th>Action</th>
			</tr>
			<c:forEach items="${listcontact}" var="contact">
				<tr>
					<td>${contact.id}</td>
					<td>${contact.name}</td>
					<td>${contact.email}</td>
					<td>${contact.address}</td>
					<td>${contact.phone}</td>
				</tr>
			</c:forEach>

		</table>

	</div>
</body>
</html>