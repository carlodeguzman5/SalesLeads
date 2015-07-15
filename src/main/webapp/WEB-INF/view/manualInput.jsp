<%@ include file="dashboard.jsp" %>

		<div id="page-wrapper">
			<div class="container-fluid">
				<div class="row">
					<div class="col-lg-12">
						<h1>INQUIRY - MANUAL INPUT</h1>

						<div class="form-group formsize">
							<label>Inquiry Type</label>
							<select class="form-control" id="types" onclick="checker.checkInquiry()">
								<option ></option>
								<c:forEach var="type" items="${inquiryTypes}">
							  		<option> ${type} </option>
								</c:forEach>
							</select>
						</div>

						<label>Add New Inquiry Type</label> 
						<div class="form-horizontal">
							<div class="form-group">
								<form method="post" action="addInquiry">
									<div class="col-sm-6"> <input type="text" name="newInquiryType" id="newInquiryType" class="form-control" placeholder="E.g. Consultation"> </div>
									<button class="btn btn-md">Add</button> 
								</form>
							</div>
						</div>

                        <label>Name</label>
						<div class="form-horizontal">
                            <div class="form-group">
                            	<form method="post" action="findCustomer">
	                                <div class="col-sm-6"> <input type="text" class="form-control" name="name" id="name"> </div>
	                                <button class="btn btn-md" onclick="checker.check()" >Search</button>
                                </form>
                            </div>
                        </div>
                            
                        <form role="form">
                            <div class="form-group formsize theHidden" id="testId">
                                <label>Address</label>
                                <input class="form-control" id="address">
                            
                                <label>Contact Number</label>
                                <input class="form-control" id="number">
                            </div>

                            <div class="form-group formsize">
                                <label>Subject</label>
                                <input class="form-control" id="subject">
                            </div>

                            <div class="form-group formsize">
                                <label>Text area</label>
                                <textarea class="form-control" rows="3" id="test"></textarea>
                            </div>

                        </form>
                        <!-- <form>
                            <h4>Name: <input type="text" id="name"/></h4>
                            <h4>Number: <input type="text" id="number"/></h4>
                            <h4>Subject: <input type="text" id="subject"/></h4>
                            <h4>Summary: </h4><textarea rows="4" cols="50" id="test"></textarea>
                        </form>   -->
                        
                        <button onclick="testing()">Submit</button>
                        
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
		<!-- /#page-wrapper -->