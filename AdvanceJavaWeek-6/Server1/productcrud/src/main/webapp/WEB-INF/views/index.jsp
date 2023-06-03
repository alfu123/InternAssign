<html>
<head>
<%@include file="./base.jsp"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	Object str=session.getAttribute("current-user");
%>
<style>
table{
border: 2px solid black;
}
</style>
</head>
<body>

<div style="clear: both">
		<h3 style="float: left">    </h3>
		<h5 style="float: right">
			Hi <%=	 str.toString().toUpperCase() %>,

			<form action="logout" method="post" class="form1">
				<input type="submit" value="Logout">

			</form>
			</div>

	<div class="container mt-3">
		<div class=" row">
			<div class="col-md-12">
				<h1 class="text-center mb-3">Welcome to Product App</h1>

				<table class="table">
					<thead>
						<tr>
							<th scope="col">Book Code</th>
							<th scope="col">Book Name</th>
							<th scope="col">Book Author</th>
						
							<th scope="col">Date</th>
							<th scope="col">Action</th>
						</tr>
					</thead>
					<tbody>

						<c:forEach items="${products}" var="p">
							<tr>
								<th scope="row">${p.id}</th>
								<td>${p.name}</td>
								<td>${p.description}</td>
						
								<td>${p.date}</td>
	                            <td><a href="delete/${p.id}"><button>delete</button></a>
	                             <a href="update/${p.id}"><button>update</button></a> </td>
							</tr>
						</c:forEach>


		

					<tbody>
				</table>
				<div class="container text-center">
			<a href="${pageContext.request.contextPath }/welcome-product" class="btn btn-outline-danger">  Back </a>
			
			
					<a href="${pageContext.request.contextPath }/add-product" class="btn btn-outline-success">  Add</a>

				</div>

			</div>

		</div>

	</div>
</body>
</html>
