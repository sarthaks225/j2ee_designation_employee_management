<%@taglib uri='WEB-INF/mytags/tmtags.tld' prefix='tm'%>
<tm:Module name='EMPLOYEE'/>

<jsp:useBean id='employeeBean' scope='request' class='com.hr.beans.EmployeeBean'/>

<jsp:include page='/MasterPageTopSection.jsp'/>

<script src='/styletwo/js/EmployeeDeleteForm.js'> </script>

<h1>Employee (Delete)</h1><br>

Are you sure to delete ?<br><br>
Name : <b>${employeeBean.name}</b><br>
Designation : <b>${employeeBean.title}</b><br>
Date of birth : <b>${employeeBean.dateOfBirth}</b><br>
Gender : <b>${employeeBean.gender}</b><br>
Nationality : Indian &nbsp<b>${employeeBean.isIndian}</b><br>
Basic Salary : <b>${employeeBean.basicSalary}</b><br>
PAN Number : <b>${employeeBean.getPANNumber()}</b><br>
Aadhar Card Number : <b>${employeeBean.aadharCardNumber}</b><br>
<br>

<form method='post' action='DeleteEmployee.jsp' >
<input type='hidden' id='employeeId' name='employeeId' value='${employeeBean.id}'>
<input type='hidden' id='name' name='name' value='${employeeBean.name}'>
<button type='submit'>Delete</button>
<button type='button' onclick='cancelDelete()'>Cancel</button></form>

<form action='/styletwo/Employees.jsp' id='cancelDelete'> </form>


<jsp:include page='/MasterPageBottomSection.jsp'/>