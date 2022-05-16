<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>
<html>
<style>
table {
	margin: auto;
	border-spacing: 0 15px;
	background-color: #eaf4f4;
	width: 70%;
}

thead {
	color: #0740ae;
	justify-content: left;
	background-color: #c4cbe5;
	text-align: left;
}

tfoot {
	color: black;
	justify-content: right;
	background-color: #c4cbe5;
	text-align: right;
}

tbody {
	background-color: #eaf4f4;
}

.required:before {
	content: " *";
	color: red;
}

tr, td {
	padding: 12px;
}

.button {
	border: 2px solid blue;
}
</style>
<!-- Required meta tags -->
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">

<!-- Bootstrap CSS -->
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3"
	crossorigin="anonymous">
<body>
<%
response.setHeader("Cache-control","no-cache,no-store,must-revalidate");
response.setHeader("pragma", "no-cache");
response.setDateHeader ("Expires", 0);
%>
<table>
		<thead>
			<tr>
				<th
					style="border-top: #87aef8; border-bottom: #87aef8; border-left: #c4cbe5; border-right: #c4cbe5; border-width: 2px; border-style: solid;"
					colspan="2"><b><h3>
							Login<b>
						</h3></th>
			</tr>
		</thead>
		<tbody>
			<form action="login" method="post">
				<tr>
					<td>Username:</td>
					<td class="required"><input style="width: 50%" type="text"
						name="username" required></td>
				</tr>
			<tr>
				<td>Password:</td>
				<td class="required"><input style="width: 50%" type="password"
					name="password" required>
					</td>
			</tr>
			
			<tr>
				<td></td>
				<td colspan="2"><a href="">Forgotten your password?</a></td>

			</tr>
			
		</tbody>

		<tfoot>

			<tr>

				<th
					style="border-top: #87aef8; border-bottom: #87aef8; border-left: #c4cbe5; border-right: #c4cbe5; border-width: 2px; border-style: solid;"
					colspan="2"><input class="button" type="submit" name="submit"
					value="Login>>"></th>


			</tr>
		</tfoot>
		</form>
	</table>

</body>
</html>
