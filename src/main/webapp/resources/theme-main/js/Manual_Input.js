var dataName = ['adrian', 'carlo'];
var isExisting = false;

var checker = {
	checkCustomer:function(){
//		var inputName1 = document.getElementById('name').value;
//
//		for(var p in dataName){
//			if(inputName1 == dataName[p]){
//				isExisting = true;
//				break;
//			}
//			else{
//				isExisting = false;
//			}
//		}
	
//		var isExisting = '<c:out value="${isExisting}"/>'
//		console.log(isExisting);
//		
//		if (isExisting) {
//			document.getElementById('testId').style.display="none";
//
//		}
//		if (!isExisting) {
//			document.getElementById('testId').style.display="initial";
//			document.getElementById('number').style.width="50%";
//			document.getElementById('address').style.width="50%";
//		};
		
		var customerName =  document.getElementById('customerNameSelect').value;
		
		if(customerName != "New Customer"){
			document.getElementById('testId').style.display="none";
			document.getElementById("customerName").setAttribute("customerName", oldId);
		}
		
		else{
			document.getElementById('testId').style.display="initial";
			document.getElementById('customerName').style.width="50%";
			document.getElementById('contactNumber').style.width="50%";
			document.getElementById('contactPerson').style.width="50%";
			document.getElementById('email').style.width="50%";
		}
	},
	
	checkInquiry:function(){
		var inquiryType =  document.getElementById('types').value;
		
		if(inquiryType != "New Inquiry"){
			document.getElementById('newInquiryType').readOnly = true;
		}
		
		else{
			document.getElementById('newInquiryType').readOnly = false;
		}
	},
};

function getCustomerInfo(){
	var customerName = document.getElementById('editCustomerNameSelect').value;
	var customer = document.getElementById('editCustomerNameSelect').value;
	console.log(customer);
	var customerInfo = customer.split("+");
	var contactNames = customerInfo[0];
	var contactNumbers = customerInfo[1];
	var contactEmails = customerInfo[2];
	
	var table = document.getElementById("contacts");
	
	var counter = 0;
	if(customerName != ""){
		counter = table.rows.length-1;
		while(counter>0){
			table.deleteRow(counter);
			counter--;
		}
		
		var name = contactNames.split("=");
		var number = contactNumbers.split("=");
		var email = contactEmails.split("=");
		
		for(counter=1 ; counter<name.length; counter++){
			var row = table.insertRow(counter);
			var cell1 = row.insertCell(0);
			var cell2 = row.insertCell(1);
			var cell3 = row.insertCell(2);
			var cell4 = row.insertCell(3);
			cell1.innerHTML = name[counter];
			cell2.innerHTML = number[counter];
			cell3.innerHTML = email[counter];
			cell4.innerHTML = '<button id="addBtn" onclick="getInfo()" type="button" name="editValues" value="'+name[counter]+'='+number[counter]+'='+email[counter]+'"><i class="fa fa-edit"></i> Edit</button>';
		}
	}
	
	else{
		counter = table.rows.length-1;
		while(counter>0){
			table.deleteRow(counter);
			counter--;
		}
	}
	
};

function getInfo(){
	console.log(document.getElementById("addBtn").value);
	var contactInfo = document.getElementById("addBtn").value.split("=");
	
	document.getElementById("editContactPersonName").setAttribute("value", contactInfo[0]);
	document.getElementById("editContactNumber").setAttribute("value", contactInfo[1]);
	document.getElementById("editEmail").setAttribute("value", contactInfo[2]);
	
	document.getElementById("customerName").setAttribute("value", document.getElementById("editCustomerNameSelect").value);
	document.getElementById("oldContactNumber").setAttribute("value", contactInfo[1]);
	document.getElementById("contactEmail").setAttribute("value", contactInfo[2]);
	
	$("#myModal").modal();
};

function testing(){

var inputName1 = document.getElementById('name').value;
var inputName2 = document.getElementById('number').value;
var inputName3 = document.getElementById('subject').value;
var inputName4 = document.getElementById('test').value;
var inputName5 = document.getElementById('types').value;
var inputName6 = document.getElementById('address').value;
// document.write('<h1>SUMMARY OF INPUT</h1><br>');
// document.write('<h4 style="display:inline-block">Inquiry Type: &nbsp</h4>' + inputName5 + '</br>');
// document.write('<h4 style="display:inline-block">Name: &nbsp</h4>' + inputName1 + '</br>');
// document.write('<h4 style="display:inline-block">Contact Number: &nbsp</h4>' + inputName2 + '</br>');
// document.write('<h4 style="display:inline-block">Subject: &nbsp</h4>' + inputName3 + '</br>');
// document.write('<h4>Summary of Discussion: </h4>' + inputName4);


document.getElementById('output5').innerHTML = 'Inquiry Type: ' + inputName5;
document.getElementById('output1').innerHTML = 'Name: ' + inputName1;
document.getElementById('output6').innerHTML = 'Address: ' + inputName6;
document.getElementById('output2').innerHTML = 'Contact Number: ' + inputName2;
document.getElementById('output3').innerHTML = 'Subject: ' + inputName3;
document.getElementById('output4').innerHTML = 'Content: ' + inputName4;
document.getElementById('headText').innerHTML = ('SUMMARY');



};

function testing2(){

var inputName1 = document.getElementById('name').value;
var inputName3 = document.getElementById('subject').value;
var inputName4 = document.getElementById('test').value;

document.getElementById('output1').innerHTML = 'Name: ' + inputName1;
document.getElementById('output3').innerHTML = 'Subject: ' + inputName3;
document.getElementById('output4').innerHTML = 'Content: ' + inputName4;
document.getElementById('headText').innerHTML = ('SUMMARY');
};

var selectionList = document.getElementById('types');

function addFromList(){
	var inquiryTypeToAdd = document.getElementById('newInquiryType').value;
	var $inquiryToAdd = document.createElement("option");

	$inquiryToAdd.appendChild(document.createTextNode(inquiryTypeToAdd));
	document.getElementById('types').appendChild($inquiryToAdd);

};

var editor = {
	passer:function(){
		newEdit = 
		document.getElementById('messageContent').innerHTML = document.getElementById('Editor').value;
	},
};


