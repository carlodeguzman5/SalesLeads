function createPanel(){
	var panelSize = document.createElement('div');
	panelSize.className = 'col-lg-4';
	var panelType = document.createElement('div');
	panelType.className = 'panel panel-default';

	var panelHeading = document.createElement('div');
	panelHeading.className = 'panel-heading';
	var content = document.createTextNode('hello');
	panelHeading.appendChild(content);

	var panelBody = document.createElement('div');
	panelBody.className = 'panel-body';
	

	var panelFooter = document.createElement('div');
	panelFooter.className = 'panel-footer';
	


	panelType.appendChild(panelHeading);
	panelType.appendChild(panelBody);
	panelType.appendChild(panelFooter);
	panelSize.appendChild(panelType);

	document.getElementById('panelMain').appendChild(panelSize);
};

function timeLineCreateLeft(){

		var timelinePanelHolder = document.createElement('li');

		var timelineBadge = document.createElement('div');
		timelineBadge.className = 'timeline-badge';
		var timelineIcon = document.createElement('i');
		timelineIcon.className = 'fa fa-check';
		timelineBadge.appendChild(timelineIcon);


		var timelinePanel = document.createElement('div');
		timelinePanel.className = 'timeline-panel';

		var timelineHeading = document.createElement('div');
		timelineHeading.className = 'timeline-heading';
		var timelineHeadingTag = document.createElement('h4');
		timelineHeadingTag.className = 'timeline-title';
		var timelineHeadingTagContent = document.createTextNode('LOREM IPZUM');
		timelineHeadingTag.appendChild(timelineHeadingTagContent);
		timelineHeading.appendChild(timelineHeadingTag);

		var timelineBody = document.createElement('div');
		timelineBody.className = 'timeline-body';
		var timelineBodyContent = document.getElementById('timelineContentBox').value;
		var timelineBodyContentHolder = document.createTextNode(timelineBodyContent);
		timelineBody.appendChild(timelineBodyContentHolder);

		timelinePanel.appendChild(timelineHeading);
		timelinePanel.appendChild(timelineBody);

		timelinePanelHolder.appendChild(timelineBadge);
		timelinePanelHolder.appendChild(timelinePanel);

		document.getElementById('timelineId').insertBefore(timelinePanelHolder, document.getElementById('timelineId').childNodes[0]);

}

function timeLineCreateRight(){

		var timelinePanelHolder = document.createElement('li');
		timelinePanelHolder.className = 'timeline-inverted';

		var timelineBadge = document.createElement('div');
		timelineBadge.className = 'timeline-badge';
		var timelineIcon = document.createElement('i');
		timelineIcon.className = 'fa fa-check';
		timelineBadge.appendChild(timelineIcon);


		var timelinePanel = document.createElement('div');
		timelinePanel.className = 'timeline-panel';

		var timelineHeading = document.createElement('div');
		timelineHeading.className = 'timeline-heading';
		var timelineHeadingTag = document.createElement('h4');
		timelineHeadingTag.className = 'timeline-title';
		var timelineHeadingTagContent = document.createTextNode('LOREM IPZUM');
		timelineHeadingTag.appendChild(timelineHeadingTagContent);
		timelineHeading.appendChild(timelineHeadingTag);

		var timelineBody = document.createElement('div');
		timelineBody.className = 'timeline-body';
		var timelineBodyContent = document.getElementById('timelineContentBox').value;
		var timelineBodyContentHolder = document.createTextNode(timelineBodyContent);
		timelineBody.appendChild(timelineBodyContentHolder);

		timelinePanel.appendChild(timelineHeading);
		timelinePanel.appendChild(timelineBody);

		timelinePanelHolder.appendChild(timelineBadge);
		timelinePanelHolder.appendChild(timelinePanel);

		document.getElementById('timelineId').insertBefore(timelinePanelHolder, document.getElementById('timelineId').childNodes[0]);

}

