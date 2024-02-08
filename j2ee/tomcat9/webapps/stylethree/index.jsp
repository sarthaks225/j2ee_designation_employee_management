<%@taglib uri='WEB-INF/mytags/tmtags.tld' prefix='tm'%>

<script>

function leftPanelView(designation,employee,home)
{
	
	var designationSpan=document.getElementById("designationSpan");
	var employeeSpan=document.getElementById("employeeSpan");
	var homeSpan=document.getElementById("homeSpan");
	designationSpan.innerHTML="";
	employeeSpan.innerHTML="";
	homeSpan.innerHTML="";
	
	if(designation==true)
	{
		var designationLink=document.createElement("a");
		designationLink.id='designationLink';
		designationLink.setAttribute('href','javascript:designations()');
		designationLink.textContent="Designation"
		designationSpan.appendChild(designationLink);
		
	}
	else
	{
		var designationLink=document.createElement("b");
		designationLink.textContent="Designation";
		designationSpan.appendChild(designationLink);
		
	}
	if(employee==true)
	{
		var employeeLink=document.createElement("a");
		employeeLink.id='employeeLink';
		employeeLink.setAttribute('href','javascript:employees()');
		employeeLink.textContent="Employees"
		employeeSpan.appendChild(employeeLink);
	}
	else
	{
		var employeeLink=document.createElement("b");
		employeeLink.textContent='Employees';
		employeeSpan.appendChild(employeeLink);
		
	}
	
	if(home==true)
	{
		var homeLink=document.createElement("a");
		homeLink.id='homeLink';
		homeLink.setAttribute('href','javascript:welcome()');
		homeLink.textContent="Home"
		homeSpan.appendChild(homeLink);
	}
}

function welcome()
{
	var rightPanel=document.getElementById("rightPanel");
	var leftPanel=document.getElementById("leftPanel");
	rightPanel.innerHTML="";
	
	var heading=document.createElement("h1");
	var textNode=document.createTextNode("Welcome");
	heading.appendChild(textNode);
	rightPanel.appendChild(heading);
	
	var designationSpan=document.createElement("span");
	designationSpan.id='designationSpan';
	
	var employeeSpan=document.createElement("span");
	employeeSpan.id="employeeSpan";
	
	var homeSpan=document.createElement("span");
	homeSpan.id="homeSpan"
	
	
	leftPanel.appendChild(designationSpan);
	var br=document.createElement("br");
	leftPanel.appendChild(br);
	
	leftPanel.appendChild(employeeSpan);
	br=document.createElement("br");
	leftPanel.appendChild(br);
	
	leftPanel.appendChild(homeSpan);
	br=document.createElement("br");
	leftPanel.appendChild(br);
	
	leftPanelView(true,true,false);
	
}

function designations()
{
	
	var rightPanel=document.getElementById("rightPanel");
	rightPanel.innerHTML="";

	leftPanelView(false,true,true);
	
	var table=document.createElement("table");
	table.id="designationGridTable";
	table.border="1";
	rightPanel.appendChild(table);
	
	var thead=document.createElement("thead");
	table.appendChild(thead);
	
	addDesignationLinkRow=document.createElement("tr");
	thead.appendChild(addDesignationLinkRow);
	
	addDesignationLinkCell=document.createElement("th");
	addDesignationLinkCell.setAttribute("colspan",'4');
	addDesignationLinkCell.style.textAlign="right";
	addDesignationLinkCell.style.padding="5px";
	addDesignationLinkRow.appendChild(addDesignationLinkCell);
	
	addDesignationLink=document.createElement("a");
	addDesignationLink.textContent="Add New Designation";
	addDesignationLink.setAttribute("href",'javascript:addDesignation()');
	addDesignationLinkCell.appendChild(addDesignationLink);
	
	headingRow=document.createElement("tr");
	thead.appendChild(headingRow);
	
	serialNumberCell=document.createElement("th");
	serialNumberCell.classList.add("text-align:center");
	serialNumberCell.style.width="80px";
	serialNumberCell.textContent="S.NO";
	headingRow.appendChild(serialNumberCell);
		
	designationTitleCell=document.createElement("th");
	designationTitleCell.classList.add("text-align:center");
	designationTitleCell.style.width="150px";
	designationTitleCell.textContent="Designation";
	headingRow.appendChild(designationTitleCell);
	
	editCell=document.createElement("th");
	editCell.classList.add("text-align:center");
	editCell.style.width="100px";
	editCell.textContent="Edit";
	headingRow.appendChild(editCell);
	
	deleteCell=document.createElement("th");
	deleteCell.classList.add("text-align:center");
	deleteCell.style.width="100px";
	deleteCell.textContent="Delete";
	headingRow.appendChild(deleteCell);
	
	tbody=document.createElement("tbody");
	table.appendChild(tbody);
	
	tableRow=document.createElement("tr");
	tbody.appendChild(tableRow);
	
	serialNumberDataCell=document.createElement("td");
	serialNumberDataCell.style.textAlign='right';
	tableRow.appendChild(serialNumberDataCell);
	
	designationTitleDataCell=document.createElement("td");
	designationTitleDataCell.style.textAlign='center';
	tableRow.appendChild(designationTitleDataCell);
	
	designationEditCell=document.createElement("td");
	designationEditCell.style.textAlign='center';
	tableRow.appendChild(designationEditCell);
	editLinkCell=document.createElement("a");
	editLinkCell.setAttribute("href"," ");
	editLinkCell.textContent="Edit";
	designationEditCell.appendChild(editLinkCell);

	
	designationDeleteCell=document.createElement("td");
	designationDeleteCell.style.textAlign='center';
	tableRow.appendChild(designationDeleteCell);
	deleteLinkCell=document.createElement("a");
	deleteLinkCell.setAttribute("href"," ");
	deleteLinkCell.textContent="Delete";
	designationDeleteCell.appendChild(deleteLinkCell);
	
		
	var xmlHttpRequest=new XMLHttpRequest();
	xmlHttpRequest.onreadystatechange=function(){
		if(this.readyState==4)
		{
			if(this.status==200)
			{
				var responseData=this.responseText;
				var splits=responseData.split(",");
				
				var gridTable=document.getElementById("designationGridTable");
				var tableBody=gridTable.getElementsByTagName("tbody")[0];
								
				var tableRow=tableBody.getElementsByTagName("tr")[0];
				tableRow.remove();
				var tableRow;
				var sn=1;
				
				for(var i=0; i<splits.length; i+=2)
				{
					dynamicRow=tableRow.cloneNode(true);
					tableBody.appendChild(dynamicRow);
					dynamicRowCells=dynamicRow.getElementsByTagName("td");
					
					dynamicRowCells[0].innerHTML=sn;
					dynamicRowCells[1].innerHTML=splits[i+1];
					dynamicRowCells[2].getElementsByTagName("a")[0].setAttribute("href","javascript:editDesignation("+splits[i]+")");
					dynamicRowCells[3].getElementsByTagName("a")[0].setAttribute("href","javascript:confirmDeleteDesignation("+splits[i]+")");
					sn++;
				}
			}
		}
		
	}
		
	xmlHttpRequest.open("GET",'ajaxDesignations',true);
	xmlHttpRequest.send();
		
}


function addDesignation()
{
	rightPanel=document.getElementById("rightPanel");
	rightPanel.innerHTML="";
	
	heading=document.createElement("h1");
	heading.textContent="Designation (Add Designation Module)";
	rightPanel.appendChild(heading);
	rightPanel.appendChild(document.createElement("br"));
	
	designationLabel=document.createElement("textNode");
	designationLabel.textContent="Designation";
	rightPanel.appendChild(designationLabel);
	
	errorSection=document.createElement("textNode");
	errorSection.classList.add("error");
	
	inputTitle=document.createElement("input");
	inputTitle.setAttribute("type","text");
	rightPanel.appendChild(inputTitle);
	errorSection=document.createElement("textNode");
	errorSection.classList.add("error");
	rightPanel.appendChild(errorSection);
	rightPanel.appendChild(document.createElement("br"));
	
	addButton=document.createElement("button");
	addButton.textContent="Add";
	
	addButton.onclick=function(){
		
		var title=inputTitle.value;
		title.trim();
		if(title.length==0)
		{
			inputTitle.focus();
			errorSection.textContent="title required"
			return;
		}
		dataToSend="title="+encodeURI(title);
		
		xmlHttpRequest=new XMLHttpRequest();
		xmlHttpRequest.onreadystatechange=function(){
			if(this.readyState==4)
			{
				if(this.status==200)
				{
					responseData=this.responseText;
					dataSplits=responseData.split(",");
					if(dataSplits[0].localeCompare("1")==0)
					{
						notification(dataSplits[1]);
						return;
					}
					else
					{
						errorSection.textContent=dataSplits[1];
						inputTitle.focus();
						return;
					}	
				}
			}
			
		};
		
		xmlHttpRequest.open("POST","addDesignation",true);
		xmlHttpRequest.setRequestHeader("Content-Type","application/x-www-form-urlencoded");
		xmlHttpRequest.send(dataToSend);
		
		
		
	};
	
	rightPanel.appendChild(addButton);
	
	cancelButton=document.createElement("button");
	cancelButton.textContent="Cancel";
	cancelButton.setAttribute("onclick","javascript:designations()");
	rightPanel.appendChild(cancelButton);
	
}


function editDesignation(code)
{
	rightPanel=document.getElementById("rightPanel");
	rightPanel.innerHTML="";
	message=document.createElement("h1");
	
	message.textContent="Designation (Edit Designation Module)";
	rightPanel.appendChild(message);
	
	errorSection=document.createElement("textNode");
	errorSection.classList.add("error");
	rightPanel.appendChild(errorSection);
	rightPanel.appendChild(document.createElement("br"));
	
	designationTextNode=document.createElement("textNode");
	designationTextNode.textContent="Desigantion";
	rightPanel.appendChild(designationTextNode);
	
	designationTextField=document.createElement("input");
	designationTextField.setAttribute("type","text");
	rightPanel.appendChild(designationTextField);
	rightPanel.appendChild(document.createElement("br"));
	
	xmlHttpRequest=new XMLHttpRequest();
	dataToSend="code="+encodeURI(code);
	xmlHttpRequest.onreadystatechange=function(){
		if(this.readyState==4)
		{
			if(this.status==200)
			{
				responseData=this.responseText;
				dataSplits=responseData.split(",");
				if(dataSplits[0].localeCompare("1")==0)
				{
					designationTextField.value=dataSplits[1];
				}
				else
				{
					alert("something unexpected 404");
					designations();
					return;
				}
			}
		}
		
		
	};
	
	xmlHttpRequest.open("POST","editDesignation",true);
	xmlHttpRequest.setRequestHeader("Content-Type","application/x-www-form-urlencoded");
	xmlHttpRequest.send(dataToSend);
	
	updateButton=document.createElement("button");
	cancelButton=document.createElement("button");
	
	updateButton.onclick=function(){
		dataToSend="code="+encodeURI(code)+"&title="+encodeURI(designationTextField.value);
		xmlHttpRequest.onreadystatechange=function(){
			if(this.readyState==4)
			{
				if(this.status==200)
				{
					responseData=this.responseText;
					dataSplits=responseData.split(",");
					if(dataSplits[0].localeCompare("1")==0)
					{
						notification(dataSplits[1]);
					}
					else
					{
						errorSection.textContent=dataSplits[1];
						
					}
				}
			}
		};
		
		xmlHttpRequest.open("POST","updateDesignation",true);
		xmlHttpRequest.setRequestHeader("Content-Type","application/x-www-form-urlencoded");
		xmlHttpRequest.send(dataToSend);
	};
	updateButton.textContent="Update";
	rightPanel.appendChild(updateButton);
	
	cancelButton.textContent="Cancel";
	cancelButton.setAttribute("onclick","javascript:designations()");
	rightPanel.appendChild(cancelButton);
}

function confirmDeleteDesignation(code)
{
	//alert("confirm delete desigantion invoked");
	rightPanel=document.getElementById("rightPanel");	
	rightPanel.innerHTML="";
	
	var heading=document.createElement("h1");
	heading.textContent="Designation (Delete)"
	rightPanel.appendChild(heading);
	rightPanel.appendChild(document.createElement("br"));
		
	xmlHttpRequest=new XMLHttpRequest();
	var dataToSend;
	var responseData;
	var responseDataSplits;
	title=document.createElement("b")
	dataToSend="code="+encodeURI(code);
	xmlHttpRequest.onreadystatechange=function(){
		if(this.readyState==4)
		{
			if(this.status==200)
			{
				responseData=this.responseText;
				responseDataSplits=responseData.split(",");
				if(responseDataSplits[0].localeCompare("1")==0)
				{
					title.textContent=responseDataSplits[1];
				}
				else
				{
					alert("error 4.1");
					//do nothing
					return;
				}
			}
			else 
			{
				alert("something unexpected happend");
				return;
			}
			
		}
		
	}
	
	xmlHttpRequest.open('POST','confirmDeleteDesignation',true);
	xmlHttpRequest.setRequestHeader('Content-Type','application/x-www-form-urlencoded');
	xmlHttpRequest.send(dataToSend);
	
	
	var message=document.createElement("textNode");
	rightPanel.appendChild(title);
	rightPanel.appendChild(document.createElement("br"));
	message.textContent="Are you sure to delete?";
	rightPanel.appendChild(message);
	rightPanel.appendChild(document.createElement("br"));
	
	
	deleteButton=document.createElement("button");
	deleteButton.textContent="Delete";
	
	deleteButton.onclick=function(){
		alert("delete button clicked");
		dataToSend="code="+encodeURI(code);
		//xmlHttpRequest=new XMLHttpRequest();
		var xmlHttpRequest=new XMLHttpRequest();
		xmlHttpRequest.onreadystatechange=function(){
			if(this.readyState=4)
			{
				if(this.status=200)
				{
					responseData=this.responseText;
					notification(responseData);
				}
				else
				{
					alert("error 4.2");
					return;
				}
			}
		};
		xmlHttpRequest.open('POST','deleteDesignation',true,);
		xmlHttpRequest.setRequestHeader('Content-Type','application/x-www-form-urlencoded');
		xmlHttpRequest.send(dataToSend);
	};
	rightPanel.appendChild(deleteButton);
	
	cancelButton=document.createElement("button");
	cancelButton.setAttribute("onclick", "javascript:designations()");	
	cancelButton.textContent="Cancel"
	rightPanel.appendChild(cancelButton);
	
	
	
}

function notification(responseData)
{
	
	leftPanelView(false,false,true); 
	rightPanel=document.getElementById("rightPanel");
	rightPanel.innerHTML="";
	message=document.createElement("h1");
	message.textContent=responseData;
	if(responseData.length==0) message.textContent="designation alloted to employee can not remove";
	else message.textContent=responseData;
	rightPanel.appendChild(message);
	rightPanel.appendChild(document.createElement("br"));
	okButton=document.createElement("button");
	okButton.textContent="Ok"
	okButton.setAttribute("onclick","javascript:designations()");
	rightPanel.appendChild(okButton);
}


function employees()
{
	
	alert("call for employees arrived not writing code to save time");
	
	var rightPanel=document.getElementById("rightPanel");
	rightPanel.innerHTML="";
	leftPanelView(true,false,true);
}





window.addEventListener("load",welcome);


</script>


<jsp:include page='/MasterPageTopSection.jsp'/>


<jsp:include page='/MasterPageBottomSection.jsp'/>
