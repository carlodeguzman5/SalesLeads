function testing(){

var inputName1 = document.getElementById('name').value;
var inputName2 = document.getElementById('number').value;
var inputName3 = document.getElementById('subject').value;
var inputName4 = document.getElementById('test').value;
var inputName5 = document.getElementById('types').value;


// document.write('<h1>SUMMARY OF INPUT</h1><br>');
// document.write('<h4 style="display:inline-block">Inquiry Type: &nbsp</h4>' + inputName5 + '</br>');
// document.write('<h4 style="display:inline-block">Name: &nbsp</h4>' + inputName1 + '</br>');
// document.write('<h4 style="display:inline-block">Contact Number: &nbsp</h4>' + inputName2 + '</br>');
// document.write('<h4 style="display:inline-block">Subject: &nbsp</h4>' + inputName3 + '</br>');
// document.write('<h4>Summary of Discussion: </h4>' + inputName4);

document.getElementById('output5').innerHTML = inputName5;
document.getElementById('output1').innerHTML = inputName1;
document.getElementById('output2').innerHTML = inputName2;
document.getElementById('output3').innerHTML = inputName3;
document.getElementById('output4').innerHTML = inputName4;
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
	var inquiryTypeToAdd = document.getElementById('internName').value;
	var $inquiryToAdd = document.createElement("option");

	$inquiryToAdd.appendChild(document.createTextNode(inquiryTypeToAdd));
	document.getElementById('types').appendChild($inquiryToAdd);
}


var W3CDOM = (document.getElementsByTagName && document.createElement);

window.onload = function () {
	document.forms[0].onsubmit = function () {
		return validate()
	}
}

function validate() {
	validForm = true;
	firstError = null;
	errorstring = '';
	var x = document.forms[0].elements;
	for (var i=0;i<x.length;i++) {
		if (!x[i].value)
			writeError(x[i],'This field is required');
	}
	if (x['email'].value.indexOf('@') == -1)
		writeError(x['email'],'This is not a valid email address');
	if (!W3CDOM)
		alert(errorstring);
	if (firstError)
		firstError.focus();
	if (validForm)
		alert('All data is valid!');
	return false;
}

function writeError(obj,message) {
	validForm = false;
	if (obj.hasError) return;
	if (W3CDOM) {
		obj.className += ' error';
		obj.onchange = removeError;
		var sp = document.createElement('span');
		sp.className = 'error';
		sp.appendChild(document.createTextNode(message));
		obj.parentNode.appendChild(sp);
		obj.hasError = sp;
	}
	else {
		errorstring += obj.name + ': ' + message + '\n';
		obj.hasError = true;
	}
	if (!firstError)
		firstError = obj;
}

function removeError()
{
	this.className = this.className.substring(0,this.className.lastIndexOf(' '));
	this.parentNode.removeChild(this.hasError);
	this.hasError = null;
	this.onchange = null;
}




