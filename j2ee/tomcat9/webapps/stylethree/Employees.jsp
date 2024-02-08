<%@taglib uri='WEB-INF/mytags/tmtags.tld' prefix='tm' %>

<tm:Module name='EMPLOYEE'/>

<jsp:include page='MasterPageTopSection.jsp'/>

<link rel='stylesheet' type='text/css' href='/styletwo/css/employees.css'>
<script src='/styletwo/js/Employees.js'> </script>
<pre>   *Problem in Add New Employee- can not retriew info from servlet for desingnation,date,gender,isIndian to jsp
    So can not make edit Employee.
</pre>
<div class='employee-grid'>
<table border='1' id='employeeGridTable'>
<thead>
<tr>
<th colspan='6' class='employee-grid-header'>
<a href='/styletwo/EmployeeAddForm.jsp'>Add New Employee<a>
</th>
</tr>
<tr>
<th class='employee-grid-sno-column-title'>S.No</th>
<th class='employee-grid-id-column-title'>Employee Id</th>
<th class='employee-grid-name-column-title'>Employee Name</th>
<th class='.employee-grid-designation-column-title'>Designation</th>
<th class='employee-grid-edit-column-title'>Edit</th>
<th class='employee-grid-delete-column-title'>Delete</th>
</tr>
</thead>
<tbody>


<tr style='cursor:pointer;' >
<td style='text-align:right' placeHolderId='serialNumber'></td>
<td style='text-align:center' placeHolderId='employeeId'></td>
<td style='text-align:center' placeHolderId='name'></td>
<td style='text-align:center' placeHolderId='designation'></td>
<td style='text-align:center' placeHolderId='editOption'></td>
<td style='text-align:center' placeHolderId='deleteOption'></td>
</tr>


</tbody>
</table>
</div>
<div style='height:20vh; margin-left:15px;margin-right:10px;margin-top:5px;margin-bottom:5px; padding:5px; border:1px solid black'>
<label style='margin-left:50px; font-size:20px; background:#8D7171; color:white; padding-left:10px; padding-right:10px'>Details</label>
<table border='0' width='100%' style='padding:0px; margin-top:25px'>
<tr>
<td>Employee ID : <span id='detailPanel_employeeId' style='margin-right:30px'></span></td>
<td>Name : <span id='detailPanel_name' style='margin-right:30px'></span></td>
<td>Designation : <span id='detailPanel_designation' style='margin-right:30px'></span></td>
</tr>
<tr>
<td>Date Of Birth : <span id='detailPanel_dateOfBirth' style='margin-right:30px'></span></td>
<td>Gender : <span id='detailPanel_gender' style='margin-right:30px'></span></td>
<td>Is Indian : <span id='detailPanel_isIndian' style='margin-right:30px'></span></td>
</tr>
<tr>
<td>Salary : <span id='detailPanel_basicSalary' style='margin-right:30px'></span></td>
<td>PAN Number: <span id='detailPanel_panNumber' style='margin-right:30px'></span></td>
<td>Aadhar Card Number: <span id='detailPanel_aadharCardNumber' style='margin-right:30px'></span></td>
</tr>
</table>
</div>


<jsp:include page='/MasterPageBottomSection.jsp'/>