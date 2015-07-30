<%@ include file="dashboard.jsp" %>

<div id="page-wrapper">
            <div class="row">
                <div class="col-lg-12">
                    <h1 class="page-header">UPDATES</h1>
                </div>
                <!-- /.col-lg-12 -->
            </div>
            <!-- /.row -->
            <div class="row">
                <div class="col-lg-6">
                    <div class="panel panel-info">
                        <div class="panel-heading">
                            <b>LATEST INQUIRIES</b>
                        </div>
                        <div class="panel-body">
							<table class="table table-striped table-bordered table-hover">
								<tr>
									<th>DATE</th>
									<th>CUSTOMER NAME</th>
									<th>CUSTOMER CLASSIFICATION</th>
								</tr>
								<c:if test="${customerInquirySize>=0}">
									<c:forEach var="i" begin="0" end="${customerInquirySize}">
										<c:if test="${i<10}">
											<tr>
												<td>${date[i]}</td>
												<td>${customerNames[i]}</td>
												<td>${customerClassification[i]}</td>
											</tr>
										</c:if>
									</c:forEach>
								</c:if>
							</table>
                        </div>
                    </div>
                </div>
                <!-- /.col-lg-4 -->
                <div class="col-lg-6">
                    <div class="panel panel-info">
                        <div class="panel-heading">
                            <b>TOP INQUIRIES</b>
                        </div>
                        <div class="panel-body">
                            <table class="table table-striped table-bordered table-hover">
								<tr>
									<th>INQUIRY TYPE</th>
									<th>COUNT</th>
								</tr>
								<c:if test="${inquirySize>=0}">
									<c:forEach var="i" begin="0" end="${inquirySize}">
										<c:if test="${i<10}">
											<tr>
												<td>${inquiryTypes[i]}</td>
												<td>${count[i]}</td>
											</tr>
										</c:if>
									</c:forEach>
								</c:if>
							</table>
						</div>
					</div>
                </div>
                <!-- /.col-lg-4 -->
            </div>
            <!-- /.row -->
            
        </div>
        <!-- /#page-wrapper -->
    </div>
    <!-- /#wrapper -->