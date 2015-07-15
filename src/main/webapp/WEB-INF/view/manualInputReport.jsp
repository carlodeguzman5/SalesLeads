<%@ include file="dashboard.jsp" %>

<div id="page-wrapper">
			<div class="container-fluid">
				<div class="row">
					<div class="col-lg-12">
						<h1>MANUAL INPUT INQUIRY FOR SALES</h1>

						<form role="form">
							<div class="form-group formsize">
								<label>Name</label> <input class="form-control" id="name">
								<p class="help-block">Example block-level help text here.</p>
							</div>
							<div class="form-group formsize">
								<label>Subject</label> <input class="form-control" id="subject">
								<p class="help-block">Example block-level help text here.</p>
							</div>
							<div class="form-group formsize" id="test">
								<label>Text area</label>
								<textarea class="form-control" rows="3"></textarea>
							</div>
						</form>

						<button onclick="testing2()">try me</button>

						<br>

						<h1 id="headText"></h1>
						<p id="output1"></p>
						<p id="output3"></p>
						<p id="output4"></p>
					</div>
					<!-- /.col-lg-12 -->
				</div>
				<!-- /.row -->
			</div>
			<!-- /.container-fluid -->
		</div>