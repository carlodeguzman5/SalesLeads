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

<title>SB Admin 2 - Bootstrap Admin Theme</title>

<script src="<c:url value="/resources/js/timeline.js"/>"></script>

<!-- Timeline CSS -->
<link href="<c:url value="/resources/dist/css/timeline.css" />"
	rel="stylesheet">

<!-- Morris Charts CSS -->
<link
	href="<c:url value="/resources//bower_components/morrisjs/morris.css" />"
	rel="stylesheet">

<!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
<!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
<!--[if lt IE 9]>
        <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
        <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->

</head>

<body onload="testOutput();">

	<div id="wrapper">

		<div id="page-wrapper">
			<div class="row">
				<div class="col-lg-12">
					<h1 class="page-header">Timeline</h1>
				</div>
				<!-- /.col-lg-12 -->
			</div>
			<div class="panel panel-default">
				<div class="panel-heading">
					<i class="fa fa-clock-o fa-fw"></i>Timeline
				</div>
				<!-- /.panel-heading -->
				<div class="panel-body">
					<c:forEach var="i" begin="0" end="${size}">
						<select class="example" hidden="true">
							<option>${titles[i]}</option>
						</select>
						<select class="example" hidden="true">
							<option>${contents[i]}</option>
						</select>
					</c:forEach>
					
					<ul class="timeline" id="timelineId">

					</ul>

					<!-- <textarea id="timelineContentBox"></textarea> -->
					<form action="createEvent" method="post">
						<input type="text" name="companyName" value="${companyName}" hidden="true">
						<input type="text" name="inquiry" value="${inquiry}" hidden="true">
						<input type="text" name="subject" value="${subject}" hidden="true">
						<input type="text" name="content" value="something" hidden="true">
						<input type="text" name="title">
						<input type="text" name="update">
						<input type="submit">
					</form>
					
					<!-- <button onclick="timeLineCreateLeft()">timeline left</button>
					<button onclick="timeLineCreateRight()">timeline right</button> -->
					<!-- <button onclick="testOutput()">testing</button> -->
				</div>
				<!-- /.panel-body -->
			</div>
			<!-- /.panel -->
			<!-- <div>
        		<select class="example">
        			<option>this</option>
        			<option>this is a test</option>
        		</select>
        		<select class="example">
        			<option>is</option>
        			<option>this is a test</option>
        		</select>
        		<select class="example">
        			<option>a</option>
        			<option>this is a test</option>
        		</select>
        		<select class="example">
        			<option>test</option>
        			<option>this is a test</option>
        		</select>
        		<p id="display"></p>
        		
        		<button onclick="testOutput()">testing</button>
        	</div> -->
		</div>
		<!-- /#page-wrapper -->

	</div>
	<!-- /#wrapper -->

</body>

</html>
