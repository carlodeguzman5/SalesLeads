<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ include file="dashboard.jsp" %>
<html lang="en">

<head>

<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="">
<meta name="author" content="">

<title>Lead Page</title>

<style>
.linkButton { 
     background: none;
     border: none;
     color: #0066ff;
     cursor: pointer; 
}
.linkButton:hover{
	text-decoration: underline;
}
</style>

<!-- Bootstrap Core CSS -->
<link
	href="<c:url value="/resources/bower_components/bootstrap/dist/css/bootstrap.min.css" />"
	rel="stylesheet">

<!-- MetisMenu CSS -->
<link
	href="<c:url value="/resources/bower_components/metisMenu/dist/metisMenu.min.css" />"
	rel="stylesheet">

<!-- Custom CSS -->
<link href="<c:url value="/resources/dist/css/sb-admin-2.css" />"
	rel="stylesheet">

<!-- Custom Fonts -->
<link
	href="<c:url value="/resources/bower_components/font-awesome/css/font-awesome.min.css" />"
	rel="stylesheet">

<!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
<!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
<!--[if lt IE 9]>
        <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
        <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->

</head>

<body>

	<div id="wrapper">
		<!-- Page Content -->
		<div id="page-wrapper">
			<div class="container-fluid">
				<div class="row">

                <h1>LEAD PAGE</h1>

                <hr>

					<table class="table table-striped table-bordered table-hover">
					 	<tr> 
					 		<th>DATE</th> 
							<th>NAME</th> 
							<th>COMPANY NAME</th> 
							<th>RATING</th> 
 							<th>INQUIRY</th> 
							<th>SUBJECT</th> 
							<th>CONTENT</th> 
							<th>TIMELINE</th> 
 						</tr> 

 						<c:if test="${size >= 0}" >
	 						<c:forEach var="i" begin="0" end="${size}">
		 						
									<tr>		
										<td>${dates[i]}</td>
										<td>${names[i]}</td>
										<td>
											<form action="showCustomerHistory" method="post">
					 							<input type="text" name="company" value="${companyNames[i]}" hidden="true">
												<input class="linkButton" type="submit" value="${companyNames[i]}">
											</form>
										</td>
										<td><a href="Charts.html">View Rating</a></td>
										<td>${inquiries[i]}</td>
										<td>${subjects[i]}</td>
										<td>${contents[i]}</td>
										<td>
											<form action="projectTimeline" method="post">
					 							<input type="text" name="name" value="${names[i]}" hidden="true">
					 							<input type="text" name="companyName" value="${companyNames[i]}" hidden="true">
					 							<input type="text" name="inquiry" value="${inquiries[i]}" hidden="true">
					 							<input type="text" name="subject" value="${subjects[i]}" hidden="true">
					 							<input type="text" name="content" value="${contents[i]}" hidden="true">
					 							<input type="text" name="content" value="${dates[i]}" hidden="true">
												<input class="linkButton" type="submit" value="Timeline">
											</form>
										</td>
									</tr>	
							</c:forEach>
 						 </c:if> 
 						
					
					</table>
				</div>
				<!-- /.row -->
			</div>
			<!-- /.container-fluid -->
		</div>
		<!-- /#page-wrapper -->

	</div>
	<!-- /#wrapper -->


	<!-- jQuery -->
	<script
		src="<c:url value="/resources/bower_components/jquery/dist/jquery.min.js" />"></script>

	<!-- Bootstrap Core JavaScript -->
	<script
		src="<c:url value="/resources/bower_components/bootstrap/dist/js/bootstrap.min.js"/>">
		
	</script>

	<!-- Metis Menu Plugin JavaScript -->
	<script
		src="<c:url value="/resources/bower_components/metisMenu/dist/metisMenu.min.js"/>"></script>

	<!-- Custom Theme JavaScript -->
	<script src="<c:url value="/resources/dist/js/sb-admin-2.js"/>"></script>

</body>

</html>
