function validateForm(frm)
{
var firstInvalidComponent=null;
var valid=true;
var name=frm.name.value.trim();
var nameErrorSection=document.getElementById('nameErrorSection');
nameErrorSection.innerHTML='';
if(name.length==0)
{
    nameErrorSection.innerHTML='Name required';
	firstInvalidComponent=frm.name;
	valid=false;
}


var designationCode=frm.designationCode.value;
var designationCodeErrorSection=document.getElementById('designationCodeErrorSection');

designationCodeErrorSection.innerHTML='';
if(designationCode==-1)
{
    designationCodeErrorSection.innerHTML='Designation required';
	if(firstInvalidComponent==null) firstInvalidComponent=frm.designationCode;
	valid=false;

}

var dateOfBirth=frm.dateOfBirth.value;
var dateOfBirthErrorSection=document.getElementById('dateOfBirthErrorSection');

dateOfBirthErrorSection.innerHTML='';
if(dateOfBirth.length==0)
{
    dateOfBirthErrorSection.innerHTML='Date of birth required';
	if(firstInvalidComponent==null) firstInvalidComponent=frm.dateOfBirth;

	valid=false;
}
var genderErrorSection=document.getElementById('genderErrorSection');
genderErrorSection.innerHTML='';


if(frm.gender[0].checked==false && frm.gender[1].checked==false)
{

	genderErrorSection.innerHTML='Select Gender';
	valid=false;
}

var basicSalary=frm.basicSalary.value.trim();
var basicSalaryErrorSection=document.getElementById('basicSalaryErrorSection');
basicSalaryErrorSection.innerHTML='';
if(basicSalary.length==0)
{
	basicSalaryErrorSection.innerHTML='Salary required';
	if(firstInvalidComponent==null) firstInvalidComponent=frm.basicSalary;

	valid=false;
}
else
{
var v='0123456789.';
var numberOfDots=0;
for(var i=0; i<basicSalary.length; ++i)
{
if(v.indexOf(basicSalary.charAt(i))==-1)
{
		basicSalaryErrorSection.innerHTML='Invalid: only numbers allowed';
		valid=false;
		if(firstInvalidComponent==null) firstInvalidComponent=frm.basicSalary;

		break;
}
if(basicSalary.charAt(i)=='.') 
{
	if(numberOfDots==1)
	{
		basicSalaryErrorSection.innerHTML='Invalid: multile . not allowed';
		valid=false;
		if(firstInvalidComponent==null) firstInvalidComponent=frm.basicSalary;
		break;
	}
	numberOfDots++;
}
}

var dot=basicSalary.indexOf('.');
var numberOfFractions=basicSalary.length-dot-1;
if(dot!=-1 && numberOfFractions>2)
{
	basicSalaryErrorSection.innerHTML='Invalid: number of fractions must be less then 3';
	valid=false;
	if(firstInvalidComponent==null) firstInvalidComponent=frm.basicSalary;

}

}

var panNumber=frm.panNumber.value.trim();
var panNumberErrorSection=document.getElementById('panNumberErrorSection');
panNumberErrorSection.innerHTML='';
if(panNumber.length==0)
{
	panNumberErrorSection.innerHTML='PAN Number required';
	if(firstInvalidComponent==null) firstInvalidComponent=frm.panNumber;
	valid=false;

}

var aadharCardNumber=frm.aadharCardNumber.value.trim();
var aadharCardNumberErrorSection=document.getElementById('aadharCardNumberErrorSection');
aadharCardNumberErrorSection.innerHTML='';
if(aadharCardNumber.length==0)
{
	aadharCardNumberErrorSection.innerHTML='Aadhar card required';
	if(firstInvalidComponent==null) firstInvalidComponent=frm.aadharCardNumber;
	valid=false;

}


if(	firstInvalidComponent!=null) 
{
	firstInvalidComponent.focus();
}
if(valid==false) return false;

return true;
}

function cancelAddition()
{
   
    document.getElementById('cancelAdditionForm').submit();

}