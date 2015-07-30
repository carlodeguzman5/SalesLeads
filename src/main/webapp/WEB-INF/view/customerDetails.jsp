<%@ include file="dashboard.jsp" %>
<div id="wrapper">
	<div id="page-wrapper">
		<div class="container-fluid">
			<div class="row">
				<h1>CUSTOMER HISTORY</h1>
				<hr>
					<table class="table table-striped table-bordered table-hover">
						<tr> 
							<th>DATE</th> 
							<th>INQUIRY TYPE</th> 
							<th>SUBJECT</th> 
							<th>MESSAGE</th> 
							<th>STATUS</th> 
					 	</tr> 
					
					 	<c:if test="${size >= 0}" >
							 	<c:forEach var="i" begin="0" end="${size}">
					 				<tr>
									 	<td>${date[i]}</td>
									 	<td>${inquiryType[i]}</td>	
									 	<td>${subject[i]}</td>
									 	<td>${message[i]}</td>
									 	<td>${status[i]}</td>		
									</tr>			
								</c:forEach>
					 	</c:if> 
					</table>
				</div>
			</div>
		</div>
</div>