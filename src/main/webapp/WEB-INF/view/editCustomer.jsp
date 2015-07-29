<%@ include file="dashboard.jsp" %>


<div id="page-wrapper" >
	<div class="container-fluid">
		<div class="row">
			<div class="col-lg-12">
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
				</div>
			</div>
			</div>
		</div>
	</div>
</div>