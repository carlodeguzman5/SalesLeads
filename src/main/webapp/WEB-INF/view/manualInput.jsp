
<%@ include file="dashboard.jsp"%>

<body onload="onloader()">
<div id="page-wrapper" >
	<div class="container-fluid">
		<div class="row">
			<div class="col-lg-12">
				<h1>INQUIRY - MANUAL INPUT</h1>
				
						<form role="form" action="addNewManualInput" method="post">
	
						 <div class="form-group formsize" id="inquiry">
                            <label>Inquiry Type</label>
                                <select class="form-control chosen-select" name="oldInquiryType" id="types" onchange="actionChosen()" required>
                                    <option value="">Select</option>
                                    <option>New Inquiry</option>
                                    <c:forEach var="type" items="${inquiryTypes}">
                                        <option>${type}</option>
                                    </c:forEach>
                                </select>
                       	  </div>
	
						  <div class="form-group formsize" id="customerSelection">
                                <label>Customer Name</label>
                                <select data-placeholder="Choose a Customer..." class="form-control chosen-select" name="customerName" id="customerNameSelect" onchange="actionChosen()" required>
                                    <option value="">Select action</option>
                                    <option>New Customer</option>
                                    <c:forEach var="companyName" items="${companyNames}">
                                        <option>${companyName}</option>
                                    </c:forEach>
                                </select>
                          </div>
	
						  <div id="subjectAndTextarea">
	                            <div class="form-group formsize" id="subjectPart">
	                                <label>Subject</label> <input class="form-control" name="subject" id="subject" required>
	                            </div>
	
								<div class="form-group formsize" id="textareaPart">
	                                <label>Summary</label>
	                                <textarea class="form-control" rows="3" name="text" id="test" required></textarea>
                            	</div>
                            <input type="submit" />
                          </div>
                        </form>
                        
				<div class="form-group formsize theHidden" id="customerPart1">
            
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
				
						<form:form action="updateCustomer" method="post" class="form-group formsize" id="customerPart2">
	
								<select class="form-control" name="customerName" id="editCustomerNameSelect" onchange="getCustomerInfo()" required="required" >
									<option value="">Choose a customer</option>
										<c:forEach var="i" begin="0" end="${size}">
											<option value="${contactPersons[i]}+${contactNumbers[i]}+${contactEmails[i]}">${companyNames[i]}</option>
										</c:forEach>
								</select>
							
								
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
				
				<div id="inquiryPart">
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
				<!-- /.col-lg-12 -->
			</div>
			<!-- /.row -->
		</div>
		
		<div id="myModal" class="modal fade" role="dialog">
				<div class="modal-dialog">
					<div class="modal-content">
						<div class="modal-header">
							<button type="button" class="close" data-dismiss="modal">&times;</button>
							<h4 class="modal-title">Edit Contact Person Details</h4>
						</div>
						<div class="modal-body">
							<form class="container-fluid" method="post" action="editContact">
								<label>Contact Person's Name</label>
								<input class="form-control" type="text" name="editContactPersonName" id="editContactPersonName" required readonly="readonly"/>
								<input type="hidden" name="customerName" id="customerName">
								<label>Contact Person's Email</label>
								<input class="form-control" type="email" name="editEmail" id="editEmail" required/>
								<input type="hidden" name="contactEmail" id="contactEmail">
								<label>Contact Person's Contact Number</label>
								<input class="form-control" type="tel" name="editContactNumber" id="editContactNumber" required/>
								<input type="hidden" name="oldContactNumber" id="oldContactNumber">
								<input type="submit" value="Save">
							</form>
						</div>
						<div class="modal-footer">
							<button type="button" class="btn btn-default"
								data-dismiss="modal">Close</button>
						</div>
					</div>
					<form></form>
				</div>
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
</body>