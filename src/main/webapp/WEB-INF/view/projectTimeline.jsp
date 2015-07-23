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

<%-- <script src="<c:url value="/resources/js/timeline.js"/>"></script> --%>

<script>

function testOutput(){

	var x = document.getElementsByClassName("example");
	var y = document.getElementsByClassName("titleHeader");
	var z = document.getElementsByClassName("date");
	
	for(var i = 0; i<x.length ; i++){
		console.log(x[i].value);
		
		console.log(y[i].value);
		
		console.log(z[i].value);
	}


	for(var i = 0; i<x.length ; i++){
		var timelinePanelHolder = document.createElement('li');
		timelinePanelHolder.className = 'timeline-inverted';

		var timelineBadge = document.createElement('div');
		timelineBadge.className = 'timeline-badge';
		var timelineIcon = document.createElement('i');
		timelineIcon.className = 'fa fa-check';
		timelineBadge.appendChild(timelineIcon);
		
		
		var timelineFooter = document.createElement('div')
		timelineFooter.classname = "timeline-footer";
		var timelineFooterContent = document.createTextNode(z[i].value);
		timelineFooter.appendChild(timelineFooterContent);


		var timelinePanel = document.createElement('div');
		timelinePanel.className = 'timeline-panel';

		var timelineHeading = document.createElement('div');
		timelineHeading.className = 'timeline-heading';
		var timelineHeadingTag = document.createElement('h4');
		timelineHeadingTag.className = 'timeline-title';
		var timelineHeadingTagContent = document.createTextNode(y[i].value);
		timelineHeadingTag.appendChild(timelineHeadingTagContent);
		timelineHeading.appendChild(timelineHeadingTag);

		var timelineBody = document.createElement('div');
		timelineBody.className = 'timeline-body';
		var timelineBodyContent = x[i].value;
		var timelineBodyContentHolder = document.createTextNode(timelineBodyContent);
		timelineBody.appendChild(timelineBodyContentHolder);

		timelinePanel.appendChild(timelineHeading);
		timelinePanel.appendChild(timelineBody);
		timelinePanel.appendChild(timelineFooter);
		
		timelinePanelHolder.appendChild(timelineBadge);
		timelinePanelHolder.appendChild(timelinePanel);
		

		document.getElementById('timelineId').insertBefore(timelinePanelHolder, document.getElementById('timelineId').childNodes[0]);
	}
}
</script>

<!-- Timeline CSS -->
<link href="<c:url value="/resources/dist/css/timeline.css" />"
	rel="stylesheet">

<!-- Morris Charts CSS -->
<link
	href="<c:url value="/resources/bower_components/morrisjs/morris.css" />"
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
			<div class="row page-header">
				<div class="col-lg-6">
					<h1>${companyName}: ${subject}</h1>
					<h5>Project Status: ${status} </h5>
				</div>
				<div class="input-group col-lg-6" style="margin-top:28px">
					<form action="customizeNotification" method="post">
						<input type="text" name="companyName" value="${companyName}" hidden="true">
						<input type="text" name="inquiry" value="${inquiry}" hidden="true">
						<input type="text" name="subject" value="${subject}" hidden="true">
<!-- 					    <input type="text" name="amount" class="form-control"  placeholder="Notify after"> -->
						<span class="input-group-btn">
					    	<select class="form-control" style="width:40%" name="amount" id="amount" required>
					    		<option value="">amount</option>
					    		<c:forEach var="i" begin="1" end="100">
					    			<option>${i}</option>
					    		</c:forEach>
						    </select>
					    	<select class="form-control"  style="width:40%" name="unit" required>
<!-- 					    		<option value="">unit</option> -->
<!-- 					    		<option>hrs</option> -->
					    		<option>days</option>
						    </select>
					    	<button class="btn btn-default" type="submit">Set</button>
					    </span>
					    					    
				    </form>
			    	<form action="updateStatus" method="post">
			    	
			    		<input type="text" name="companyName" value="${companyName}" hidden="true">
						<input type="text" name="inquiry" value="${inquiry}" hidden="true">
						<input type="text" name="subject" value="${subject}" hidden="true">
					    
					    <span class="input-group-btn">
					    	<label>Status</label>
					    	<select class="form-control" style="width:70%" name="status" id="status" onchange="this.form.submit()">
					    		<option value="PENDING">PENDING</option>
					    		<option value="ONGOING">ONGOING</option>
					    		<option value="SUCCESS">SUCCESS</option>
					    		<option value="DISCONTINUED">DISCONTINUED</option>
						    </select>
					    </span>
				    </form>
				    
				</div>
				
				<!-- /.col-lg-12 -->
			</div>
			<div class="panel panel-default">
				<!-- /.panel-heading -->
				<div class="panel-body">
					<div class="form-group">
						<form id="eventForm" action="createEvent" method="post">
							<input type="text" name="companyName" value="${companyName}" hidden="true">
							<input type="text" name="inquiry" value="${inquiry}" hidden="true">
							<input type="text" name="subject" value="${subject}" hidden="true">
							<input type="text" name="content" value="something" hidden="true">
							<div class='container-fluid'>
								<label>Event</label><input class="form-control" type="text" name="title">
								<label>Summary</label><textarea class="form-control" name="update" form="eventForm"></textarea>
								<label>Date</label><input class="form-control" type="date" name="date"></textarea>
								<input class="btn btn-md" type="submit">
							</div>
						</form>
					</div>
						
						<select class="titleHeader" hidden="true">
								<option>Initial Inquiry</option>
						</select>
						<select class="example" hidden="true">
							<option></option>
						</select>
						<select class="date" hidden="true">
								<option>${startDate}</option>
						</select>
				
					<c:if test="${size >= 0}">
					
						<c:forEach var="i" begin="0" end="${size}">
							<select class="titleHeader" hidden="true">
								<option>${titles[i]}</option>
							</select>
							<select class="example" hidden="true">
								<option>${contents[i]}</option>
							</select>
							<select class="date" hidden="true">
								<option>${dates[i]}</option>
							</select>
						</c:forEach>
					
					</c:if>
					
					<ul class="timeline" id="timelineId">

					</ul>

				
					
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
