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
	var customerInfo = customer.split("=");
	
	if(customerName != ""){
		document.getElementById('editInfoHidden').style.display="initial";
		document.getElementById('editCustomerName').setAttribute("value", customerInfo[0]);
		document.getElementById('editContactNumber').setAttribute("value", customerInfo[1]);
		document.getElementById('editContactPerson').setAttribute("value", customerInfo[2]);
		document.getElementById('editEmail').setAttribute("value", customerInfo[3]);
		document.getElementById('editCustomerClassification').setAttribute("value", customerInfo[4]);
	}
	
	else{
		document.getElementById('editInfoHidden').style.display="none";
	}
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


function actionChosen(){
	var chosenCustomer = document.getElementById('customerNameSelect').value;
	var chosenInquiry = document.getElementById('types').value;

	if (chosenCustomer == "New Customer") {
		console.log(chosenCustomer);
		console.log(chosenInquiry);
		document.getElementById('customerPart1').removeAttribute('style');
		document.getElementById('inquiry').style.display="none";
		document.getElementById('customerSelection').style.display="none";
		document.getElementById('subjectAndTextarea').style.display="none";
	}else if (chosenInquiry == "New Inquiry") {
		console.log(chosenCustomer);
		console.log(chosenInquiry);
		document.getElementById('inquiryPart').removeAttribute('style');
		document.getElementById('inquiry').style.display="none";
		document.getElementById('customerSelection').style.display="none";
		document.getElementById('subjectAndTextarea').style.display="none";
	}
}

function onloader(){

	document.getElementById('customerPart1').style.display="none";
	document.getElementById('customerPart2').style.display="none";
	document.getElementById('inquiryPart').style.display="none";

// document.getElementById('customerPart1').style.display="none";
// document.getElementById('customerPart2').style.display="none";
// document.getElementById('inquiryPart').style.display="none";
// document.getElementById('types').style.display="none";
// document.getElementById('textareaPart').style.display="none";
// document.getElementById('subjectPart').style.display="none";
}