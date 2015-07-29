<!DOCTYPE html>

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!-- The top of file index.html -->
<html itemscope itemtype="http://schema.org/Article">
	<head>
		
		  <!-- BEGIN Pre-requisites -->
		  <script src="//ajax.googleapis.com/ajax/libs/jquery/1.8.2/jquery.min.js">
		  </script>
		  <script src="https://apis.google.com/js/client:platform.js?onload=start" async defer>
		  </script>
		  <!-- END Pre-requisites -->
		  <script>
		    function start() {
		      gapi.load('auth2', function() {
		        auth2 = gapi.auth2.init({
		          client_id: '402064518382-saojo0fotfnofc719oolpk418mgoonjt.apps.googleusercontent.com',
		          // Scopes to request in addition to 'profile' and 'email'
		          //scope: 'additional_scope'
		        });
		      });
		    }
		  </script>
		  
		  
		<meta charset="utf-8">
		<meta http-equiv="X-UA-Compatible" content="IE=edge">
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<meta name="description" content="">
		<meta name="author" content="">
		
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
			href="<c:url value="/resources/style.css" />"
			rel="stylesheet">
		
		<link
			href="<c:url value="/resources/bower_components/bootstrap-social/bootstrap-social.css" />"
			rel="stylesheet">
		
		<title>SalesLeads</title>
		<script src="<c:url value="resources/js/Manual_Input.js"/>"></script>
		<script src="<c:url value="resources/js/table.js"/>"></script>
	</head>
	
	<body>
		<div class="container">
	        <div class="col-md-12">
	            <div id="backgroundPic">
	                
	            </div>
	        </div>

	        <div class="col-md-12">
	            <div id="loginbtn">
	                <a class="btn btn-block btn-social btn-google-plus" id="signinButton">
	                    <i class="fa fa-google-plus"></i> Sign in with Google
	                </a>
	            </div>
	        </div>
	    </div>
		<!-- <button id="signinButton">Sign in with Google</button> -->
			<script>
			  $('#signinButton').click(function() {
			    // signInCallback defined in step 6.
			    auth2.grantOfflineAccess({'redirect_uri': 'postmessage'}).then(signInCallback);
			  });
			</script>
		<div id="result"></div>
		<script>
			function signInCallback(authResult) {
			  if (authResult['code']) {
			    // Hide the sign-in button now that the user is authorized, for example:
			    $('#signinButton').attr('style', 'display: none');
			
			    // Send the code to the server
			    $.ajax({
			      type: 'POST',
			      url: 'http://localhost:8080/SalesLeads/signIn',
			      contentType: 'application/octet-stream; charset=utf-8',
			      success: function(result) {
			        // Handle or verify the server response.
			        console.log("success");
			        window.location.href = "index.html";
			      },
			      processData: false,
			      data: authResult['code']
			    });
			  } else {
			    // There was an error.
			  }
			}
		</script>
	</body>
</html>