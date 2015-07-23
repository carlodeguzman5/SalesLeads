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

                    <h1>Chart page</h1>
                    <select id="numberValue" style="display:none">
                        <option>200</option>
                    </select>

                    <canvas id="buyers" width="600" height="400"></canvas>

                    <script type="text/javascript">

                    var arrays=["Eating", "Drinking", "Sleeping", "Designing", "Coding", "Cycling", "Running"]
                  //    var buyerData = {
                        //  labels : ["January","February","March","April","May","June"],
                        //  datasets : [
                        //      {
                        //          fillColor : "rgba(172,194,132,0.4)",
                        //          strokeColor : "#ACC26D",
                        //          pointColor : "#fff",
                        //          pointStrokeColor : "#9DB86D",
                        //          data : [203,156,99,251,305,247]
                        //      }
                        //  ]
                        // }
                        //============================================
                        var dataValue = document.getElementById('numberValue').value;
                        var buyerData = {
                            labels: arrays,
                            datasets: [
                                {
                                    label: "My First dataset",
                                    fillColor: "rgba(220,220,220,0.2)",
                                    strokeColor: "rgba(220,220,220,1)",
                                    pointColor: "rgba(220,220,220,1)",
                                    pointStrokeColor: "#fff",
                                    pointHighlightFill: "#fff",
                                    pointHighlightStroke: "rgba(220,220,220,1)",
                                    data: [dataValue, 59, 90, 81, 56, 55, 40]
                                },
                                {
                                    label: "My Second dataset",
                                    fillColor: "rgba(151,187,205,0.2)",
                                    strokeColor: "rgba(151,187,205,1)",
                                    pointColor: "rgba(151,187,205,1)",
                                    pointStrokeColor: "#fff",
                                    pointHighlightFill: "#fff",
                                    pointHighlightStroke: "rgba(151,187,205,1)",
                                    data: [28, 48, 40, 19, 96, 27, 100]
                                }
                            ]
                        };
                        //==============================================


                        var buyers = document.getElementById('buyers').getContext('2d');
                        new Chart(buyers).Radar(buyerData);
                    </script>
                 </div>
			</div>
			<!-- /.container-fluid -->
		</div>
		<!-- /#page-wrapper -->

	</div>
	<!-- /#wrapper -->
</body>

</html>