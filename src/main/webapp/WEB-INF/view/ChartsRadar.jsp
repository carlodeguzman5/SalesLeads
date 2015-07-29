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
                            <h1>Leads Status Pie Chart</h1>
                        </div>
                        <canvas id="buyers" width="600" height="400"></canvas>

                        <script type="text/javascript">

                            
                            var buyerData = {
                                labels: ["Success", "Discontinue", "On Going", "Pending"],
                                datasets: [
                                    {
                                        label: "My First dataset",
                                        fillColor: "rgba(220,220,220,0.2)",
                                        strokeColor: "rgba(220,220,220,1)",
                                        pointColor: "rgba(220,220,220,1)",
                                        pointStrokeColor: "#fff",
                                        pointHighlightFill: "#fff",
                                        pointHighlightStroke: "rgba(220,220,220,1)",
                                        data: [30, 59, 90, 81]
                                    },
                                ]
                            };
                        

                            var buyers = document.getElementById('buyers').getContext('2d');
                            new Chart(buyers).Radar(buyerData);
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