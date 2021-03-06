
<%@ include file="dashboard.jsp" %>


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

                <h1>Leads</h1>

                <hr>

					<table class="table table-striped table-bordered table-hover">
                        <tr> 
                            <th>DATE</th> 
                            <th>COMPANY NAME</th> 
                            <th>INQUIRY</th> 
                            <th>SUBJECT</th> 
                            <th>CONTENT</th> 
                            <th>TIMELINE</th> 
                        </tr> 

                        <c:if test="${size >= 0}" >
                            <c:forEach var="i" begin="0" end="${size}">
                                
                                    <tr>        
                                        <td>${dates[i]}</td>
                                        <td>
                                            <form action="showCustomerHistory" method="post">
                                                <input type="text" name="company" value="${companyNames[i]}" hidden="true">
                                                <input class="linkButton" type="submit" value="${companyNames[i]}">
                                            </form>
                                        </td>
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
</body>

</html>
