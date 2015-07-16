
function test () {
	var test1 = document.createElement('p');
	var test2 = document.createTextNode('testing');
	test1.appendChild(test2);
	document.getElementById('title').appendChild(test1);
}

function addNewThing () {
	var newRow = document.createElement('tr');

	var newDataName = document.createElement('td');
	var newDataNameContent = document.createTextNode('Globe');
	newDataName.appendChild(newDataNameContent);

	var newDataClass = document.createElement('td');
	var newDataClassContent = document.createTextNode('Telecom');
	newDataClass.appendChild(newDataClassContent);

	var newDataInquiry = document.createElement('td');
	var newDataInquiryContent = document.createTextNode('Education');
	newDataInquiry.appendChild(newDataInquiryContent);

	var newDataEmail = document.createElement('td');
	var newDataEmailContent = document.createTextNode('adriankimadame03@gmail.com');
	newDataEmail.appendChild(newDataEmailContent);

	var newDataSubject = document.createElement('td');
	var newDataSubjectContent = document.createTextNode('hello');
	newDataSubject.appendChild(newDataSubjectContent);

	var newDataSummary = document.createElement('td');
	var newDataSummaryContent = document.createTextNode('view');
	newDataSummary.appendChild(newDataSummaryContent);

	
	newRow.appendChild(newDataName);
	newRow.appendChild(newDataClass);
	newRow.appendChild(newDataInquiry);
	newRow.appendChild(newDataEmail);
	newRow.appendChild(newDataSubject);
	newRow.appendChild(newDataSummary);

	document.getElementById('tableBody').appendChild(newRow);
}
