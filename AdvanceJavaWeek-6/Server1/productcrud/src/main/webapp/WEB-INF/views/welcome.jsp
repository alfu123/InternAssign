<?xml version="1.0" encoding="UTF-8"?>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%
	Object str=session.getAttribute("current-user");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style>
body {
	
	margin: 5px;
	padding: 5px;
}

.form1 {
	margin: 5px;
	padding: 5px;
}

#section {
	width: 90%;
	padding: 2%;
	display: table;
}

#section ul li {
	display: table-cell;
}

#section ul li a {
	vertical-align: middle;
	text-align: center;
}

#section ul li a img {
	vertical-align: middle;
	text-align: center;
}
</style>

</head>
<body>

<div style="clear: both">
		<h3 style="float: left">Wecome to our Library</h3>
		<h5 style="float: right">
			Hi <%=	 str.toString().toUpperCase() %>,

			<form action="logout" method="post" class="form1">
				<input type="submit" value="Logout">

			</form>
			</div>

	

	<br>
	<br>
	<br>
	<br>
	<br>
	<div align="center">
	
				<a href="index-product" class="btn btn-outline-danger"><button> VIEW Books </button> </a> &nbsp;&nbsp;&nbsp;
				<a href="add-product" class="btn btn-outline-danger">  <button>  ADD Books</button> </a>

</div>

</body>
</html>