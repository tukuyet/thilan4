<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
	<title>Phone List</title>
</head>
<body>
<div id="wrapper">
	<header id="header">
		<h1>CodeLean Academy</h1>
		<link type="text/css" rel="stylesheet" href="css/style.css">
	</header>
</div>

<div id="container">
	<div id="content">
		<input type="button" value="Add Phone" onclick="window.location.href='addphone.jsp'; return false;" class="add-phone-button" />

		<table>
			<tr>
				<th>Phone Name</th>
				<th>Brand</th>
				<th>Price</th>
				<th>Description</th>
			</tr>
			<c:forEach var="tempPhone" items="${PHONE_LIST}">
				<tr>
					<td>${tempPhone.phoneName}</td>
					<td>${tempPhone.brand}</td>
					<td>${tempPhone.price}</td>
					<td>${tempPhone.description}</td>
				</tr>
			</c:forEach>
		</table>
	</div>
</div>
</body>
</html>
