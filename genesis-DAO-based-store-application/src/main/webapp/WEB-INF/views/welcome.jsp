<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page isELIgnored="false"%>
<jsp:useBean id="user" class="com.dailyapp.model.User" scope="request" />
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath()%>/assets/resources/styles/modules.css">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>user landing page</title>
</head>
<body class="form-builder-style" style="font-size: 28px; font-family: sans-serif; color: black; text-align: center;" >
	<H1> Welcome ${user.firstName} </H1>

	<br />
		<table cellpadding="4px" border="2px solid black" background="#999999" align="center">
			<caption>YOUR DETAILS:</caption>
			<tr>
				<td>Email:</td>
				<td>${user.email}</td>
			</tr>
			<tr>
				<td>First Name:</td>
				<td>${user.firstName}</td>
			</tr>
			<tr>
				<td>Last Name:</td>
				<td>${user.lastName}</td>
			</tr>
			<tr>
				<td>Age:</td>
				<td>${user.age}</td>
			</tr>

		</table>
</body>
</html>