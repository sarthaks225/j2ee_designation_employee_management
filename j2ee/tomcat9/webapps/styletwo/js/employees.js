function Employee()
{
this.employeeId=0;
this.name="";
this.designationCode=0;
this.designation="";
this.dateOfBirth="";
this.gender="";
this.isIndian=true;
this.basicSalary="";
this.panNumber="";
this.aadharCardNumber="";
}
var rowSelected=null;
var employees=[];

function selectEmployee(row,employeeId)
{
if(rowSelected!=null)
{
rowSelected.style.background='white';
rowSelected.style.color='black';
}
rowSelected=row;
row.style.background='#D9A190';
row.style.color='#000E3C';
for(var i=0; i<employees.length; ++i)
{
if(employees[i].employeeId==employeeId)
{
break;
}
}
var emp=employees[i];
document.getElementById('detailPanel_employeeId').innerHTML=employees[i].employeeId;
document.getElementById('detailPanel_name').innerHTML=employees[i].name;
document.getElementById('detailPanel_designation').innerHTML=employees[i].designation;
document.getElementById('detailPanel_dateOfBirth').innerHTML=employees[i].dateOfBirth;
document.getElementById('detailPanel_gender').innerHTML=employees[i].gender;
if(emp.isIndian) document.getElementById('detailPanel_isIndian').innerHTML="Yes";
else document.getElementById('detailPanel_isIndian').innerHTML="NO";
document.getElementById('detailPanel_basicSalary').innerHTML=employees[i].basicSalary;
document.getElementById('detailPanel_panNumber').innerHTML=employees[i].panNumber;
document.getElementById('detailPanel_aadharCardNumber').innerHTML=employees[i].aadharCardNumber;
}

function createDynamicRowClickHandler(dynamicRow,employeeId)
{
return function()
{
selectEmployee(dynamicRow,employeeId);
};
}


function populateEmployeesGridTable()
{

var employeesGridTable=document.getElementById("employeeGridTable");
var employeesGridTableBody=employeesGridTable.getElementsByTagName("tbody")[0];
var employeesGridTableBodyRowTemplate=employeesGridTableBody.getElementsByTagName("tr")[0];
employeesGridTableBodyRowTemplate.remove();

var dynamicRow;
var dynamicRowCells;
var cellTemplate;
var placeHolder;

for(var k=0; k<employees.length; k++)
{
dynamicRow=employeesGridTableBodyRowTemplate.cloneNode(true);
employeesGridTableBody.appendChild(dynamicRow);
dynamicRowCells=dynamicRow.getElementsByTagName("td");

for(var i=0; i<dynamicRowCells.length; ++i)
{
cellTemplate=dynamicRowCells[i];
placeHolder=cellTemplate.getAttribute("placeHolderId");
switch(placeHolder)
{

case "serialNumber":
	cellTemplate.innerHTML=(k+1);
	break;
case "employeeId":
	cellTemplate.innerHTML=employees[k].employeeId;
	break;
case "name":
	cellTemplate.innerHTML=employees[k].name;
	break;
case "designationCode":
	cellTemplate.innerHTML=employees[k].designationCode;
	break;
case "designation":
	cellTemplate.innerHTML=employees[k].designation;
	break;
case "dateOfBirth":
	cellTemplate.innerHTML=employees[k].dateOfBirth;
	break;
case "gender":
	cellTemplate.innerHTML=employees[k].gender;
	break;
case "isIndian":
	cellTemplate.innerHTML=employees[k].isIndian;
	break;
case "basicSalary":
	cellTemplate.innerHTML=employees[k].basicSalary;
	break;
case "panNumber":
	cellTemplate.innerHTML=employees[k].panNumber;
	break;
case "aadharCardNumber":
	cellTemplate.innerHTML=employees[k].aadharCardNumber;
	break;
case "editOption":
	cellTemplate.innerHTML="<a href='/styletwo/editEmployee?employeeId="+employees[k].employeeId+"'>Edit</a>";
	break;
case "deleteOption":
	cellTemplate.innerHTML="<a href='/styletwo/confirmDeleteEmployee?employeeId="+employees[k].employeeId+"'>Delete</a>";
	break;
}

dynamicRow.onclick=createDynamicRowClickHandler(dynamicRow,employees[k].employeeId);
}

}

}
window.addEventListener('load',populateEmployeesGridTable);



