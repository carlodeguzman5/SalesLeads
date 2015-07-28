
<%@ include file="dashboard.jsp"%>

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
								<select class="form-control chosen-select" name="oldInquiryType" id="types" required>
									<option value="">New Inquiry</option>
									<c:forEach var="type" items="${inquiryTypes}">
										<option>${type}</option>
									</c:forEach>
								</select>
							</div>
	
							<div class="form-group formsize">
								<label>Customer Name</label>
								<select data-placeholder="Choose a Customer..." class="form-control chosen-select" name="customerName" id="customerNameSelect" required>
									<option value="">New Customer</option>
									<c:forEach var="companyName" items="${companyNames}">
										<option>${companyName}</option>
									</c:forEach>
								</select>
							</div>
	
							<div class="form-group formsize">
								<label>Subject</label> <input class="form-control" name="subject" id="subject" required>
							</div>
	
							<div class="form-group formsize">
								<label>Text area</label>
								<textarea class="form-control" rows="3" name="text" id="test" required></textarea>
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
	
								<select class="form-control" name="customerName" id="editCustomerNameSelect" onchange="getCustomerInfo()" required="required" >
									<option value="">Choose a customer</option>
<%-- 									<c:forEach var="companyName" items="${companyNames}"> --%>
<%-- 										<option >${companyName}</option> --%>
<%-- 									</c:forEach> --%>
										<c:forEach var="i" begin="0" end="${size}">
											<option value="${contactPersons[i]}+${contactNumbers[i]}+${contactEmails[i]}">${companyNames[i]}</option>
										</c:forEach>
								</select>
							
								
<!-- 							<div id="editInfoHidden" style="display:none;"> -->
							
<!-- 								<input type="hidden" name="editCustomerName" id="editCustomerName" required> -->
							
<!-- 								<label>New Contact Number</label>  -->
<!-- 									<input class="form-control" name="editContactNumber" id="editContactNumber" required> 	 -->
									
<!-- 								<label>New Contact Person</label>  -->
<!-- 									<input class="form-control" name="editContactPerson" id="editContactPerson" required>  -->
								
<!-- 								<label>New Email</label>  -->
<!-- 									<input type="email" class="form-control" name="editEmail" id="editEmail" required> -->
								
<!-- 								<label>New Customer Classification</label>  -->
<!-- 									<select class="form-control" name="editCustomerClassification" id="editCustomerClassification" required> -->
<!-- 										<option value="">New Classification</option> -->
<%-- 										<c:forEach var="customerClassification" items="${customerClassifications}"> --%>
<%-- 											<option value='${customerClassification}'>${customerClassification}</option> --%>
<%-- 										</c:forEach> --%>
<!-- 									</select> -->
<!-- 							<button class="btn btn-md">Edit</button> -->
<!-- 							</div>  -->
						</form:form>
						
						<br>
						<table id="contacts" class="table table-striped table-bordered table-hover" style="width:100%">
							<tr>
								<th>NAME OF CONTACT PERSON</th>
								<th>CONTACT NUMBER</th>
								<th>E-MAIL ADDRESS</th>
								<th></th>
							</tr>
						</table>
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