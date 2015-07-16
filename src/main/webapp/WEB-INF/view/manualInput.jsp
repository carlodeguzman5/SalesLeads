<%@ include file="dashboard.jsp"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<div id="page-wrapper">
	<div class="container-fluid">
		<div class="row">
			<div class="col-lg-12">
				<h1>INQUIRY - MANUAL INPUT</h1>



				<label>Add New Inquiry Type</label>
				<div class="form-horizontal">
					<div class="form-group">
						<form method="post" action="addInquiry">
							<div class="col-sm-6">
								<input type="text" name="newInquiryType" id="newInquiryType"
									class="form-control" placeholder="E.g. Consultation">
							</div>
							<button class="btn btn-md">Add</button>
						</form>
					</div>
				</div>

				<label>Add New Customer Classification</label>
				<div class="form-horizontal">
					<div class="form-group">
						<form method="post" action="addCustomerClassification">
							<div class="col-sm-6">
								<input type="text" name="newCustomerClassification"
									id="newCustomerClassification" class="form-control"
									placeholder="E.g. Telecommunications">
							</div>
							<button class="btn btn-md">Add</button>
						</form>
					</div>
				</div>
				
				

				<div class="form-group formsize theHidden" id="testId">
				
				<%-- 	<form:form method="post" modelAttribute="customer" action="addCustomer">
						<label for="nameInput">Name: </label>
						<form:input path="name" id="nameInput" />
						
						<label for="customerClassificationInput">Customer Classification: </label>
						<form:input path="customerClassification" id="customerClassification" />
						
						<label for="contactNumberInput">Contact Number: </label>
						<form:input path="contactNumber" id="contactNumber" />
						
						<label for="contactPersonInput">Contact Person: </label>
						<form:input path="contactPerson" id="contactPerson" />
						
						<label for="emailInput">Contact Person: </label>
						<form:input path="email" id="email" />
						
						
						
						</form:form> --%>
					
				
					<form:form action="addCustomer" method="post">

						<div class="form-group">
						
						<label>Add New Customer</label>
							<input class="form-control" name="customerName" id="customerName">
						
						<label>Contact Number</label> 
							<input class="form-control" name="contactNumber" id="contactNumber"> 	
							
						<label>Contact Person</label> 
							<input class="form-control" name="contactPerson" id="contactPerson"> 
						
						<label>Email</label> 
							<input class="form-control" name="email" id="email">
							
						
						
							<label>Customer Classification</label> 
								<select class="form-control" name="customerClassification" id="customerClassification">
									<option value="New Classification">New Classification</option>
									<c:forEach var="customerClassification" items="${customerClassifications}">
										<option value='${customerClassification}'>${customerClassification}</option>
									</c:forEach>
								</select>
						</div> 
						<button class="btn btn-md">Add</button>
					</form:form>
				</div>
				
				<form role="form" action="addNewManualInput" method="post">

					<div class="form-group formsize">
						<label>Inquiry Type</label>
						<!-- data-placeholder="
							Choose anInquiry..." -->
							<select class="form-control chosen-select" name="oldInquiryType"
								id="types" onchange="checker.checkInquiry()">
								<option value="New Inquiry">New Inquiry</option>
								<c:forEach var="type" items="${inquiryTypes}">
									<option>${type}</option>
								</c:forEach>
							</select>
						</div>



						<label>Customer Name</label>
						<div class="form-horizontal">
							<div class="form-group">
								<div class="col-sm-6">
									<select data-placeholder="Choose a Customer..."
										class="form-control chosen-select" name="customerName"
										id="customerNameSelect" onchange="checker.checkCustomer()">
										<option value="New Customer">New Customer</option>
										<c:forEach var="companyName" items="${companyNames}">
											<option>${companyName}</option>
										</c:forEach>
									</select>
								</div>
							</div>
						</div>



						<div class="form-group formsize">
							<label>Subject</label> <input class="form-control" name="subject"
								id="subject">
						</div>

						<div class="form-group formsize">
							<label>Text area</label>
							<textarea class="form-control" rows="3" name="text" id="test"></textarea>
						</div>
						<input type="submit" />
					</form>
					<!-- <form>
                            <h4>Name: <input type="text" id="name"/></h4>
                            <h4>Number: <input type="text" id="number"/></h4>
                            <h4>Subject: <input type="text" id="subject"/></h4>
                            <h4>Summary: </h4><textarea rows="4" cols="50" id="test"></textarea>
                        </form>   -->



					<br>

					<h1 id="headText"></h1>
					<p id="output5"></p>
					<p id="output1"></p>
					<p id="output6"></p>
					<p id="output2"></p>
					<p id="output3"></p>
					<p id="output4"></p>
				</div>
				<!-- /.col-lg-12 -->
			</div>
			<!-- /.row -->
		</div>
		<!-- /.container-fluid -->
	</div>

	<script src="<c:url value="/resources/chosen/chosen.jquery.js"/>"></script>

	<script type="text/javascript">
		var config = {
			'.chosen-select' : {},
			'.chosen-select-deselect' : {
				allow_single_deselect : true
			},
			'.chosen-select-no-single' : {
				disable_search_threshold : 10
			},
			'.chosen-select-no-results' : {
				no_results_text : 'Oops, nothing found!'
			},
			'.chosen-select-width' : {
				width : "95%"
			}
		}
		for ( var selector in config) {
			$(selector).chosen(config[selector]);
		}
	</script>