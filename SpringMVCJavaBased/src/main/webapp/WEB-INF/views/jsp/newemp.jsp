<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Add New Employee</title>

<style>
 
    .error {
        color: #ff0000;
    }
</style>

</head>
<body>
	<h1>Add Employee Details</h1>
	<h3>Registration form :</h3>
	
	
	
	<form:form method="POST" modelAttribute="employee" >
		<form:input path="e_id" id="id" type="hidden"/>
		<table>
			<tr>
				<td><lable for="name">Name : </lable></td>
				<td><form:input path="e_name" id="name" /></td>
				<td><form:errors path="e_name" cssClass="error"/></td>
			</tr>
			<tr>
				<td><label for="role">Role : </label></td>
				<td><form:input path="e_role" id="role"/></td>
				<td><form:errors path="e_role" cssClass="error"/></td>
			</tr>
			<tr>
				<td><label for="emailId">Email Id : </label></td>
				<td><form:input path="e_emailId" id="emailId"/></td>
				<td><form:errors path="e_emailId" cssClass="error"/></td>
			</tr>
			<tr>
				<td><label for="number">Contact No : </label></td>
				<td><form:input path="e_contactNo" id="number"/></td>
				<td><form:errors path="e_contactNo" cssClass="error"/></td>
			</tr>
			<tr>
				<td><label for="address">Address : </label></td>
				<td><form:textarea path="e_address" id="address"/>
				<td><form:errors path="e_address" cssClass="error"/></td>
			</tr>
			<tr>
				<td>
				<c:choose>
					<c:when test="${edit}">
						<input type="submit" value="Update">
					</c:when>
					<c:otherwise>
						<input type="submit" value="Submit">
					</c:otherwise>
				</c:choose>
				</td>
			</tr>
		</table>
	</form:form>
	<br>
	<h3><a href='<c:url value="/emp"/>'>All Employees</a></h3>
</body>
</html>