<%@taglib uri='/WEB-INF/mytags/tmtags.tld' prefix='tm'%>

<tm:Guard>
<jsp:forward page='LoginForm.jsp'/>
</tm:Guard>


<tm:Module name='EMPLOYEE'/>
<jsp:useBean class='com.hr.beans.EmployeeBean' id='employeeBean' scope='request'/>
<jsp:setProperty name='employeeBean' property='*'/>
<jsp:forward page='/deleteEmployee'/>