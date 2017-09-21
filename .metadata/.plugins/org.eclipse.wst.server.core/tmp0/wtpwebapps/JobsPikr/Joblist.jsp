<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Job Openings</title>
</head>

<body>

<form action="JobList" method="post">
	<table>
		<tr>
			<td>Post : </td>
			<td><input type="text" name="post"></td>
		</tr>
		<tr>
			<td>Location : </td>
			<td><input type="text" name="location"></td>
		</tr>
		<tr>
			<td>Salary : </td>
			<td><input type="text" name="salary"></td>
		</tr>
		<tr>
			<td>Experience : </td>
			<td><input type="text" name="exp"></td>
		</tr>
		<tr>
			<td>Description</td>
			<td><input type="text" name="desc"></td>
		</tr>
		<tr>
			<td>&nbsp;</td>
			<td><input type="submit" value="Add"></td>
		</tr>
	</table>
</form>

</body>
</html>