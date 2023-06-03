<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
		<%@ page import="java.io.*,java.util.*, javax.servlet.*,java.text.*,java.sql.Connection,java.sql.DriverManager,java.sql.PreparedStatement,java.sql.ResultSet,java.sql.Statement" %>
	<%ResultSet resultset =null;%>
	
<%
	Object str=session.getAttribute("current-user");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<%@include file="./base.jsp"%>

</head>
<body>

	<div style="clear: both">
		<h3 style="float: left"></h3>
		<h5 style="float: right">
			Hi
			<%=	 str.toString().toUpperCase() %>,

			<form action="${pageContext.request.contextPath }/logout"
				method="post" class="form1">
				<input type="submit" value="Logout">

			</form>
	</div>
	<div class="container mt-3">

		<div class="row">

			<div class="col-md-6 offset-md-3">

				<h1 class="text-center mb-3">Update Book Details</h1>

				<form action="${pageContext.request.contextPath}/handle-product"
					method="post">
					<input type="hidden" value="${product.id}" name="id" />
					<div class="form-group">
						<label for="name">Book Name</label> <input type="text"
							class="form-control" id="name" aria-describedby="emailHelp"
							. name="name" value="${product.name}"
							placeholder="Enter the product name here">

					</div>
					<br>

					<div class="form-group">

						<label for="description">Book Author &nbsp; &nbsp;</label> 
						<br>
							<%
    try{
//Class.forName("com.mysql.jdbc.Driver").newInstance();
Connection connection = 
         DriverManager.getConnection
            ("jdbc:mysql://localhost/tshirt?user=root&password=root");

       Statement statement = connection.createStatement() ;

       resultset =statement.executeQuery("select * from author") ;
%>


  
        <select id="description" name="description">
        <%  while(resultset.next()){ %>
            <option><%= resultset.getString(2)%></option>
        <% } %>
        </select>


<%
//**Should I input the codes here?**
        }
        catch(Exception e)
        {
             out.println("wrong entry"+e);
        }
%>


					</div>
					<br>
			


				
					<%
         Date date = new Date();
					  String dateToStr = DateFormat.getDateInstance().format(date);  
         //out.print( "<h2 align = \"center\">" +date.toString()+"</h2>");
      %>

					<div class="form-group">

						<label for="date">Date</label> <input type="text"
							placeholder="Enter Product date" name="date" class="form-control"
							id="date" value="<%=dateToStr%>">



					</div>

					<div class="container text-center">

						<a href="${pageContext.request.contextPath }/index-product"
							class="btn btn-outline-danger">Back</a>

						<button type="submit" class="btn btn-primary">Add</button>

					</div>

				</form>

			</div>
		</div>
	</div>
</body>
</html>