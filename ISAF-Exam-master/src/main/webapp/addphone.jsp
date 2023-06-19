<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
	<title>Add Phone</title>
	<link type="text/css" rel="stylesheet" href="css/style.css">
	<link type="text/css" rel="stylesheet" href="css/add-student-style.css">
</head>
<body>
<div id="wrapper">
	<div id="header">
		<h2>CodeLean Academy</h2>
	</div>
</div>

<div id="container">
	<h3>Add Phone</h3>
	<form action="PhoneServlet" method="POST">
		<input type="hidden" value="ADD" name="command">
		<table>
			<tbody>
			<tr>
				<td><label>Phone Name:</label></td>
				<td><input type="text" name="phoneName" required></td>
			</tr>
			<tr>
				<td><label>Brand</label></td>
				<td>
					<select name="brand">
						<option value="">Please choose a brand</option>
						<option value="Apple">Apple</option>
						<option value="Samsung">Samsung</option>
						<option value="Nokia">Nokia</option>
						<option value="Others">Others</option>
					</select>
				</td>
			</tr>
			<tr>
				<td><label>Price: </label></td>
				<td><input type="text" name="price" required></td>
			</tr>
			<tr>
				<td><label>Description: </label></td>
				<td><input type="text" name="description" class="description" required></td>
			</tr>
			<tr>
				<td><label></label></td>
				<td><input type="submit" value="Save" class="save"></td>
			</tr>
			</tbody>
			<p>
				<input type="reset" value="Reset form">
			</p>
		</table>
	</form>
	<div style="clear: both"></div>
	<p>
		<a href="PhoneServlet">Back to List</a>
	</p>
</div>
</body>
</html>
