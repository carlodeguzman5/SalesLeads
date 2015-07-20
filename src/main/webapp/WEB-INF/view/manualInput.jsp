
<%@ include file="dashboard.jsp"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<div id="page-wrapper">
	<div class="container-fluid">
		<div class="row">
			<div class="col-lg-12">
				<h1>INQUIRY - MANUAL INPUT</h1>

				<ul class="nav nav-tabs">
					<li class="active"><a data-toggle="tab" href="#addNewType">Inquiry</a></li>
					<li class="dropdown">
						<a data-toggle="dropdown" class="dropdown-toggle" href="#">Customer<b class="caret"></b></a>
			            <ul class="dropdown-menu">
			                <li><a data-toggle="tab" href="#addNewCustomer">Add Customer</a></li>
			                <li><a data-toggle="tab" href="#editCustomer">Edit Customer Information</a></li>
			            </ul>
					</li>
					<li><a data-toggle="tab" href="#inquiry">New Types</a></li>
				</ul>
				<div class="tab-content">
				<div id="addNewType"  class="tab-pane fade in active">
						<form role="form" action="addNewManualInput" method="post">
	
						<div class="form-group formsize">
							<label>Inquiry Type</label>
							<!-- data-placeholder="
								Choose anInquiry..." -->
								<select class="form-control chosen-select" name="oldInquiryType" id="types" onchange="checker.checkInquiry()">
									<option value="New Inquiry">New Inquiry</option>
									<c:forEach var="type" items="${inquiryTypes}">
										<option>${type}</option>
									</c:forEach>
								</select>
							</div>
	
							<div class="form-group formsize">
								<label>Customer Name</label>
								<select data-placeholder="Choose a Customer..." class="form-control chosen-select" name="customerName" id="customerNameSelect" onchange="checker.checkCustomer()">
									<option value="New Customer">New Customer</option>
									<c:forEach var="companyName" items="${companyNames}">
										<option>${companyName}</option>
									</c:forEach>
								</select>
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
					
				</div>
				
				
				<div id="addNewCustomer" class="tab-pane fade">
					<div class="form-group formsize theHidden" id="testId">
			
						<form:form action="addCustomer" method="post">
	
							<div class="form-group">
							
							<label>Customer Name</label>
								<input class="form-control" name="customerName" id="customerName" required>
							
							<label>Contact Number</label> 
								<input class="form-control" name="contactNumber" id="contactNumber" required> 	
								
							<label>Contact Person</label> 
								<input class="form-control" name="contactPerson" id="contactPerson" required> 
							
							<label>Email</label> 
								<input type="email" class="form-control" name="email" id="email" required>
								
							<label>Customer Classification</label> 
									<select class="form-control" name="customerClassification" id="customerClassification" required>
										<option value="">New Classification</option>
										<c:forEach var="customerClassification" items="${customerClassifications}">
											<option value='${customerClassification}'>${customerClassification}</option>
										</c:forEach>
									</select>
							</div> 
							<button class="btn btn-md">Add</button>
						</form:form>
					</div>
				</div>
				
				<div id="editCustomer" class="tab-pane fade">
						<form:form action="updateCustomer" method="post" class="form-group formsize" >
	
								<select class="form-control" name="customerName" id="editCustomerNameSelect" onchange="checker.getCustomerInfo()" required="required" >
									<option value="">Choose a customer</option>
									<c:forEach var="companyName" items="${company}">
										<option>${companyName.name}</option>
									</c:forEach>
								</select>
							
							
							<div id="editInfoHidden" style="display:none;">
								
								<label>New Contact Number</label> 
									<input class="form-control" name="contactNumber" id="editContactNumber" required> 	
									
								<label>New Contact Person</label> 
									<input class="form-control" name="contactPerson" id="editContactPerson" required> 
								
								<label>New Email</label> 
									<input type="email" class="form-control" name="email" id="editEmail" required>
								
								<label>New Customer Classification</label> 
									<select class="form-control" name="customerClassification" id="editCustomerClassification" required>
										<option value="">New Classification</option>
										<c:forEach var="customerClassification" items="${customerClassifications}">
											<option value='${customerClassification}'>${customerClassification}</option>
										</c:forEach>
									</select>
							<button class="btn btn-md">Edit</button>
							</div> 
						</form:form>
				</div>
				
				<div id="inquiry" class="tab-pane fade">
					
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
				</div>
				</div>
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