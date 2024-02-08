<%@taglib uri='/WEB-INF/mytags/tmtags.tld' prefix='tm'%>
<script>
var employee;
<tm:EntityList populatorClass='com.hr.bl.EmployeeBL' populatorMethod='getAll' name='employeeBean'>
	//populating employees in employees array
employee=new Employee();
employee.employeeId="${employeeBean.id}";
employee.name="${employeeBean.name}";
employee.designationCode="${employeeBean.code}";
employee.designation="${employeeBean.title}";
employee.dateOfBirth="${employeeBean.dateOfBirth}";
employee.gender="${employeeBean.gender}";
employee.isIndian="${employeeBean.isIndian}";
employee.basicSalary="${employeeBean.basicSalary}";
employee.panNumber="${employeeBean.getPANNumber()}";
employee.aadharCardNumber="${employeeBean.aadharCardNumber}";
employees[${serialNumber}-1]=employee;
</tm:EntityList>
</script>