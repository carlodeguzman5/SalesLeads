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