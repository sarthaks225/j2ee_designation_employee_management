<%@taglib uri='/WEB-INF/mytags/tmtags.tld' prefix='tm'%>

<tm:Guard>
<jsp:forward page='LoginForm.jsp'/>
</tm:Guard>


<tm:Module name='DESIGNATION'/>
<jsp:useBean class='com.hr.beans.DesignationBean' id='designationBean' scope='request'/>
<jsp:setProperty name='designationBean' property='*'/>
<jsp:forward page='/deleteDesignation'/>