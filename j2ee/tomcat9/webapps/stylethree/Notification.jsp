<%@taglib uri='/WEB-INF/mytags/tmtags.tld' prefix='tm'%>

<jsp:useBean id='messageBean' scope='request' class='com.hr.beans.MessageBean'/>

<script src='/styletwo/js/DesignationAddForm.js'> </script>

<jsp:include page='MasterPageTopSection.jsp'/>


<h1>${messageBean.heading}</h1><br>
${messageBean.message}

<tm:If condition='${messageBean.generateButtons}'>

<table>
<tr>
<td>
<form action='/styletwo/<%=messageBean.getButtonOneAction()%>'>
<button type='submit'>${messageBean.buttonOneText}</button>
</form>
</td>

<tm:If condition='${messageBean.generateTwoButtons}'>

<td>
<form action='/styletwo/<%=messageBean.getButtonTwoAction()%>'>
<button type='submit'>${messageBean.buttonTwoText}</button>
</form>
</td>

</tm:If>

</tr>
</table>

</tm:If>

<jsp:include page='MasterPageBottomSection.jsp'/>