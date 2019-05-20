<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
	<title>List Customers</title>
	<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/style.css" />
</head>
<body>
	<div id="wrapper">
		<div id="header">
			<h2>CRM - Customer Relationship Manager</h2>
		</div>
	
		<input type="button" value="Add Customer" 
			onclick="window.location.href='showFormForAdd'; return false;"
			class="add-button"
		/>
	
	<div id="container">
		<div id="content">
		
		<table>
			<tr>
				<th>First Name</th>
				<th>Last Name</th>
				<th>Email</th>
				<th>Action</th>
			</tr>
			<c:forEach var="tempCustomer" items="${customers}">
				<c:url var="updateLink" value="/customer/showFormUpdate">
					<c:param name="customerId" value="${tempCustomer.id}" />
				</c:url>
				<tr>
					<td>${tempCustomer.firstName}</td>
					<td>${tempCustomer.lastName}</td>
					<td>${tempCustomer.email}</td>
					<td>
						<a href="${updateLink}">Update</a>
					</td>
				</tr>
			</c:forEach>
		
		
		
		</table>
		
			
		</div>
	</div>

</body>
</html>