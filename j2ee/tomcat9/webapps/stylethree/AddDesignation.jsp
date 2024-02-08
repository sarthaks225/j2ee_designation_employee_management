<%@taglib uri='/WEB-INF/mytags/tmtags.tld' prefix='tm'%>

<tm:Guard>
<jsp:forward page='LoginForm.jsp'/>
</tm:Guard>

<tm:FormResubmitted>
<tm:Module name='NOTIFICATION'/>
<jsp:forward page='/notifyFormResubmission'/>
</tm:FormResubmitted>

<tm:Module name='Designation'/>

<jsp:useBean id='designationBean' scope='request' class='com.hr.beans.DesignationBean'/>
<jsp:setProperty name='designationBean' property='*'/>
<jsp:forward page='/addDesignation'/>