<%@taglib uri='WEB-INF/mytags/tmtags.tld' prefix='tm'%>
<jsp:useBean id='employeeBean' scope='request' class='com.hr.beans.EmployeeBean'/>
<jsp:useBean id='designationCodeErrorBean' scope='request' class='com.hr.beans.ErrorBean'/>
<jsp:useBean id='panNumberErrorBean' scope='request' class='com.hr.beans.ErrorBean'/>
<jsp:useBean id='aadharCardNumberErrorBean' scope='request' class='com.hr.beans.ErrorBean'/>

<tm:Module name='EMPLOYEE'/>
<jsp:include page='MasterPageTopSection.jsp'/>
<script src='/styletwo/js/EmployeeAddForm.js'> </script>
<!-- right panel starts here -->

<div class='content'>

<h1>Employee (Add Employee Module)</h1><br>

<form  method='post' action='/styletwo/AddEmployee.jsp' onsubmit='return (validateForm(this))'>
<tm:FormId/>
<table>
<tr>
<td>Name</td> 
<td><input type='text' id='name' name='name' maxlength='50' size='36' value='${employeeBean.name}'>
&nbsp; <span id='nameErrorSection' class='error''> </span>
</td>
</tr>

<tr>
<td>Designation </td>
<td><select id='designationCode' name='designationCode' value=''>
<option value='-1'>&lt Select Designation &gt</option>

<tm:EntityList populatorClass='com.hr.bl.DesignationBL' populatorMethod='getAll' name='designation'>

<option value='${designation.code}'> ${designation.title}</option>

</tm:EntityList>


</select>
&nbsp; <span id='designationCodeErrorSection' class='error''> <jsp:getProperty name='designationCodeErrorBean' property='error'/>
 </span>
</td>
</tr>

<tr>
<td>Date of birth</td>
<td><input type='date' id='dateOfBirth' name='dateOfBirth' > 
&nbsp; <span id='dateOfBirthErrorSection' class='error''> </span>
</td>
</tr>

<tr>
<td>Gender</td>
<td> <input type='radio' id='male' name='gender' value='m'> Male
&nbsp &nbsp <input type='radio' id='female' name='gender' value='f'> Female
&nbsp; <span id='genderErrorSection' class='error''> </span>
</td>
</tr>

<tr>
<td>Is Indian?</td>
<td>
<input type='checkbox' id='isIndian' name='isIndian' >
</td>
</tr>

<tr>
<td>Basic Salary </td>
<td><input type='text' id='basicSalary' name='basicSalary' maxlength='10' size='16' style='text-align:right' value='${employeeBean.basicSalary}'> 
&nbsp; <span id='basicSalaryErrorSection' class='error''> </span>

</td>
</tr>

<tr>
<td>PAN Number</td>
<td><input type='text' id='panNumber' name='PANNumber' maxlength='15' size='16' value='${employeeBean.getPANNumber()}' > 
&nbsp; <span id='panNumberErrorSection' class='error''> ${panNumberErrorBean.error}</span>

</td>
</tr>
<tr>
<td>Aadhar Card Number</td>
<td><input type='text' id='aadharCardNumber' name='aadharCardNumber' maxlength='15' size='16' value='${employeeBean.aadharCardNumber}'> 
&nbsp; <span id='aadharCardNumberErrorSection' class='error''> <jsp:getProperty name='aadharCardNumberErrorBean' property='error'/>
 </span>

</td>
</tr>

<tr>
<td colspan='2'><button type='submit'>Add</button>
&nbsp &nbsp &nbsp<button type='button' onclick='cancelAddition()'>Cancel</button></td>
</tr>
</table>

</form>

</div>
<!-- right panel ends here -->


<form action='/styletwo/Employees.jsp' id='cancelAdditionForm'></form>

<jsp:include page='MasterPageBottomSection.jsp'/>


