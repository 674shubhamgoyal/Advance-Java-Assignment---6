
<%@page import="com.nagarro.service.impl.*"%>
<%@page import="com.nagarro.model.Author"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>AddProduct</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC"
	crossorigin="anonymous">
<style>
body {
	padding-top: 20px;
}

.details {
	margin-left: 100px
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
				<strong>Welcome Back</strong>
				<button type="submit" class="btn btn-primary btn-sm ">Logout</button>
			</form>
		</div>
	</div>
	<hr>
	<div class="row">
		<div class="col-10"
			style="text-align: center; width: 300px; margin: 0 auto;">
			<legend>
				<b><font size="5">Add Book Details</font></b>
			</legend>
		</div>
		<div class="container-fluid details" style="margin-top: 20px;">
			<div class="row">
				<form action="addBook" method="post"
					enctype="application/x-www-form-urlencoded">
					<div class="form-group row mb-3">
						<label for="inputbookcode" class="col-sm-2 col-form-label">Book
							Code</label>
						<div class="col-sm-4">
							<input type="text" class="form-control" name="bookId" required>
						</div>
					</div>
					<div class="form-group row mb-3">
						<label for="inputName" class="col-sm-2 col-form-label">Book
							Name</label>
						<div class="col-sm-4">
							<input type="text" class="form-control" name="bookName" required>
						</div>
					</div>
					<div class="form-group row mb-3">
						<label for="inputauthor" class="col-sm-2 col-form-label">Author</label>
						<div class="col-sm-4">
							<select name="author">
								<c:forEach var="p" items="${authorList}" varStatus="status">
								<option>${p.getAuthorName()}</option>
								</c:forEach>
							</select>
						</div>
					</div>
					<div class="form-group row mb-3">
						<label for="inputdate" class="col-sm-2 col-form-label">Added
							on</label>
						<div class="col-sm-4">
							<input id="date" readonly="readonly" name="date"
								value=<%
	long millis=System.currentTimeMillis(); 
	String date=new java.sql.Date(millis)+""; %>
								<%=date %>>
						</div>
					</div>
					<div>
						<button type="submit" class="btn btn-primary btn-md ">Add
							Book</button>
					</div>
				</form>
			</div>
		</div>
	</div>
</body>
</html>

