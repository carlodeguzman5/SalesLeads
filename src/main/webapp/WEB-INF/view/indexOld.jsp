<!DOCTYPE html>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<html>
<head>

</head>
<body>

<h1>MANUAL INPUT INQUIRY</h1>


<h4>Select Inquiry</h4>
<select id="types">
  <option value="volvo">Volvo</option>
  <option value="saab">Saab</option>
  <option value="opel">Opel</option>
  <option value="audi">Audi</option>
</select>

<input type="text" id="internName"><button onclick="addFromList()">Add</button>



<form>
	<h4>Name:</h4><input type="text" id="name"/>
	<h4>Number:</h4><input type="text" id="number"/>
	<h4>Subject:</h4><input type="text" id="subject"/>
	<h4>Summary:</h4> <textarea rows="4" cols="50" id="test"></textarea>
</form>  

<button onclick="testing()">try me</button>

<p id="output5"></p>
<p id="output1"></p>
<p id="output2"></p>
<p id="output3"></p>
<p id="output4"></p>

<script>
function testing(){

var inputName1 = document.getElementById('name').value;
var inputName2 = document.getElementById('number').value;
var inputName3 = document.getElementById('subject').value;
var inputName4 = document.getElementById('test').value;
var inputName5 = document.getElementById('types').value;

document.write('<h1>SUMMARY OF INPUT</h1><br>');
document.write('<h4 style="display:inline-block">Inquiry Type: &nbsp</h4>' + inputName5 + '</br>');
document.write('<h4 style="display:inline-block">Name: &nbsp</h4>' + inputName1 + '</br>');
document.write('<h4 style="display:inline-block">Contact Number: &nbsp</h4>' + inputName2 + '</br>');
document.write('<h4 style="display:inline-block">Subject: &nbsp</h4>' + inputName3 + '</br>');
document.write('<h4>Summary of Discussion: </h4>' + inputName4);



//This part is summary without clearing screen
//document.getElementById('output5').innerHTML = inputName5;
//document.getElementById('output1').innerHTML = inputName1;
//document.getElementById('output2').innerHTML = inputName2;
//document.getElementById('output3').innerHTML = inputName3;
//document.getElementById('output4').innerHTML = inputName4;

};

var selectionList = document.getElementById('types');

function addFromList(){
	var inquiryTypeToAdd = document.getElementById('internName').value;
	var $inquiryToAdd = document.createElement("option");

	$inquiryToAdd.appendChild(document.createTextNode(inquiryTypeToAdd));
	document.getElementById('types').appendChild($inquiryToAdd);

}

</script>



</body>
</html>

