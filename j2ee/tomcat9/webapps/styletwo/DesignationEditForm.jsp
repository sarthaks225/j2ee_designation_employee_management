<%@taglib uri='WEB-INF/mytags/tmtags.tld' prefix='tm'%>

<tm:Module name='DESIGNATION'/>

<jsp:useBean id='designationBean' scope='request' class='com.hr.beans.DesignationBean'/>
<jsp:useBean id='errorBean' scope='request' class='com.hr.beans.ErrorBean'/>

<script src='/styletwo/js/DesignationEditForm.js'> </script>
<jsp:include page='MasterPageTopSection.jsp'/>

<h1>Designation (Edit Designation Module)</h1><br>
<span class='error'>
<jsp:getProperty name='errorBean' property='error'/>
</span>

<form method='post' action='EditDesignation.jsp' onsubmit='return (validateForm(this))'>
Designation <input type='text' id='title' name='title' maxlength='35' size='36' value='${designationBean.title}'>
<input type='hidden' id='code' name='code' value='${designationBean.code}'>
&nbsp; <span id='titleErrorSection' class='error'> </span>
<br>
<button type='submit'>Update</button>
<button type='button' onclick='cancelUpdation()'>Cancel</button>
</form>

<form action='Designations.jsp' id='cancelUpdationForm'> </form>

<jsp:include page='MasterPageBottomSection.jsp'/>