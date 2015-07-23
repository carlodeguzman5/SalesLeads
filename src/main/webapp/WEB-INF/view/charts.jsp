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
				<div class="theCharts">
                    <div class="row">
                        <div class="col-lg-12">
                            <h1>Chart page</h1>
                        </div>
                        <div class="col-lg-6">
                            <canvas id="countries" width="600" height="400"></canvas>
                        </div>
                        <div class="col-lg-6">
                                <div >
                                    <h4>Legends:</h4>
                                    <p>Success</p>
                                    <p>On Going</p>
                                    <p>Pending</p>
                                    <p>Discontinued</p>
                                </div>
            
                            <script>
                                // pie chart data
                                var pieData = [
                                    {
                                        value: 20,
                                        color:"#878BB6",
                                        label: 'label1'
                                    },
                                    {
                                        value: 40,
                                        color: "#4ACAB4",
                                        label: 'label2'
                                    },
                                    {
                                        value: 10,
                                        color: "#FF8153",
                                        label: 'label3'
                                    },
                                    {
                                        value: 30,
                                        color: "#FFEA88",
                                        label: 'label5'
                                    }
                                ];
                                // pie chart options
                                var pieOptions = {
                                     segmentShowStroke : false,
                                     animateScale : true
                                }
                                // get pie chart canvas
                                var countries= document.getElementById("countries").getContext("2d");
                                // draw pie chart
                                new Chart(countries).Pie(pieData, pieOptions);
                            </script>
                        </div>
                    </div>
                    
                 </div>

			</div>
			<!-- /.container-fluid -->
		</div>
		<!-- /#page-wrapper -->

	</div>
	<!-- /#wrapper -->
</body>

</html>