
<%@page import="com.nagarro.model.Book"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
pageEncoding="ISO-8859-1" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Library Management System</title>
<link
href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
rel="stylesheet"
integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC"
crossorigin="anonymous">
<style>
body {
padding-top: 20px;
}
table{
width: 100%;
border: 1px solid black;
margin-left: 2px;
}
table td{
border: 1.5px solid black;
text-align: center;
}
</style>
</head>
<body>
<div class="row">
<div class="col-9 "
style="text-align: center; width: 500px; margin: 0 auto;">
<legend>
<b> Library Management System</b>
</legend>
</div>


<div class="col-2">
<form action="logout" method="get">
<strong>Welcome ${uname}</strong>
<button type="submit" style="margin-left:5px;" class="btn btn-info btn-sm ">Logout</button>
</form>
</div>


</div>
<hr>
<div class="row" style="margin-top:40px;">
<div class="col-10"
style="text-align: center; width: 300px; margin: 0 auto;">
<legend>
<b><font size="6">Book Listing</font></b>
</legend>


</div>
<div class="col-2">
<a href="addBook"><button type="submit" class="btn btn-primary btn-md ">Add a
Book</button></a>

</div>
</div>
<br>
<div>
<table id="Table" style="margin-top:50px;">
	<thead>
		<tr>
			<td>Book Code</td>
			<td>Book Name</td>
			<td>Author</td>
			<td>Date Added</td>
			<td>Actions</td>
		</tr>
	</thead>
	<tbody>
		<c:forEach var="p" items="${bookArray}" varStatus="status">
			<tr>
				<td>${p.getBookCode() }</td>
			<td>${p.getBookName()}</td>
			<td>${p.getAuthorName()}</td>
			<td>${p.getDate()}</td>
			<td><a href="editBook.jsp?id=${p.getBookCode() }"><button type="button" class="btn btn-success">Edit</button></a>
				<a href="deleteBook?bookCode=${p.getBookCode()}"><button type="button" class="btn btn-warning">Delete</button></a>

			</tr>
			</c:forEach>
	</tbody>

</table>
</div>
</body>
</html>