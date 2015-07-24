<!DOCTYPE html>

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ include file="dashboard.jsp"%>

<html lang="en">

<head>

<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="">
<meta name="author" content="">

<title>Chart</title>
<script src="<c:url value="/resources/Chart.js-master/Chart.js"/>"></script>
<script src="<c:url value="/resources/Chart.js-master/Chart.min.js"/>"></script>

<script type="text/javascript" src="https://www.google.com/jsapi"></script>

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

                <h1>Customers</h1>
                <hr>
					<table class="table table-striped table-bordered table-hover">
					 	<tr> 
					 		<th>CUSTOMER</th> 
							<th>CONTACT PERSON</th> 
							<th>EMAIL</th> 
							<th>CONTACT NUMBER</th> 
 							<th>COMPANY TYPE</th>
 						</tr> 

 						<c:if test="${size >= 0}" >
	 						<c:forEach var="i" begin="0" end="${size}">
		 						<form action="projectTimeline" method="post">
									<tr>		
										<td>${customers[i]}</td>
										<td>${contactPersons[i]}</td>
										<td>${emails[i]}</td>
										<td>${contactNumbers[i]}</td>
										<td>${companyTypes[i]}</td>
									</tr>	
								</form>
							</c:forEach>
 						 </c:if> 
 						
					
					</table>
				</div>
			</div>
			<!-- /.container-fluid -->
		</div>
		<!-- /#page-wrapper -->

	</div>
	<!-- /#wrapper -->
</body>

</html>