<!DOCTYPE html>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<html lang="en">

<head>

    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">
    
    <meta name="google-signin-scope" content="profile email">
    <meta name="google-signin-client_id" content="402064518382-saojo0fotfnofc719oolpk418mgoonjt.apps.googleusercontent.com">

    <title>SalesLeads</title>

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
		
	<link
		href="<c:url value="/resources/chosen/chosen.css" />"
		rel="stylesheet">

    <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
        <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
        <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->


	    <script src="<c:url value="https://apis.google.com/js/platform.js async defer"/>"></script>
</head>

<body>

    <div class="container">
    	
        <div class="row">
            <div class="col-md-4 col-md-offset-4">
                <div class="login-panel panel panel-default">
                    <div class="panel-heading">
                        <h3 class="panel-title">Please Sign In</h3>
                    </div>
                    <div class="panel-body">
                    	<c:if test="${result}!='valid'">
	                    	<div class="alert alert-danger">
	                            ${result}
	                        </div>
	                    </c:if>
                        <form role="form" action="login" method="post">
                            <fieldset>
                                <div class="form-group">
                                    <input class="form-control" placeholder="Username" name="username" type="text" autofocus>
                                </div>
                                <div class="form-group">
                                    <input class="form-control" placeholder="Password" name="password" type="password" value="">
                                </div>
                                <div class="checkbox">
                                    <label>
                                        <input name="remember" type="checkbox" value="Remember Me">Remember Me
                                    </label>
                                </div>
								<button type="submit" class="btn btn-lg btn-success btn-block">Login</button>
                            </fieldset>
                        </form>

    					<div class="g-signin2" data-onsuccess="onSignIn" data-theme="dark">
							<button type="submit"></button>
						</div>
    					
                    </div>
                </div>
            </div>
        </div>
    </div>
    
				   

    <!-- jQuery -->
    <script src="../bower_components/jquery/dist/jquery.min.js"></script>

    <!-- Bootstrap Core JavaScript -->
    <script src="../bower_components/bootstrap/dist/js/bootstrap.min.js"></script>

    <!-- Metis Menu Plugin JavaScript -->
    <script src="../bower_components/metisMenu/dist/metisMenu.min.js"></script>

    <!-- Custom Theme JavaScript -->
    <script src="../dist/js/sb-admin-2.js"></script>

</body>

<script type="text/javascript">
	function onSignIn(googleUser) {
	  var profile = googleUser.getBasicProfile();
	  console.log('ID: ' + profile.getId()); // Do not send to your backend! Use an ID token instead.
	  console.log('Name: ' + profile.getName());
	  console.log('Image URL: ' + profile.getImageUrl());
	  console.log('Email: ' + profile.getEmail());
	}
</script>

</html>

<!-- 402064518382-saojo0fotfnofc719oolpk418mgoonjt.apps.googleusercontent.com -->
