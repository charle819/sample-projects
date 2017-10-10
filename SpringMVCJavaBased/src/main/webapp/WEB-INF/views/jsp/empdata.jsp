<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Employee Data</title>
</head>
<body>
	<h1>Employee Data</h1>
	<h3>List of all employees</h3>
	<h2 align="center">${error}</h2>
	<table border="1">
		<tr>
			<th>Id</th>
			<th>Name</th>
			<th>Role</th>
			<th>EmailId</th>
			<th>Contact No</th>
			<th>Address</th>
			<th>Action</th>
		</tr>
		<c:forEach var="e" items="${allEmployees}">
			<tr>
				<td>${e.e_id}</td>
				<td>${e.e_name}</td>
				<td>${e.e_role}</td>
				<td>${e.e_emailId}</td>
				<td>${e.e_contactNo}</td>
				<td>${e.e_address}</td>
				<td><a href='<c:url value="/emp/update/${e.e_id}"/>'> Update </a><a href='<c:url value="/emp/delete/${e.e_id}"/>'> Delete </a></td>
			</tr>
		</c:forEach>
	</table>
	
	<br>
	<h3><a href='<c:url value="/newemp"/>'>Add New Employee</a></h3>
	
</body>
</html>