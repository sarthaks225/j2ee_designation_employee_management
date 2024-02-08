<%@taglib uri='/WEB-INF/mytags/tmtags.tld' prefix='tm'%>

<tm:Guard>
<jsp:forward page='LoginForm.jsp'/>
</tm:Guard>

<tm:FormResubmitted>
<tm:Module name='NOTIFICATION'/>
<jsp:forward page='/notifyFormResubmission'/>
</tm:FormResubmitted>

<tm:Module name='EMPLOYEE'/>

<jsp:useBean id='employeeBean' scope='request' class='com.hr.beans.EmployeeBean'/>
<jsp:setProperty name='employeeBean' property='*'/>
<jsp:forward page='/addEmployee'/>