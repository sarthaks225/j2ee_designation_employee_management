<%@taglib uri='WEB-INF/mytags/tmtags.tld' prefix='tm'%>
<tm:Module name='DESIGNATION'/> 


<jsp:useBean id='designationBean' scope='request' class='com.hr.beans.DesignationBean'/>
<jsp:useBean id='errorBean' scope='request' class='com.hr.beans.ErrorBean'/>

<script src='/styletwo/js/DesignationAddForm.js'> </script>

<jsp:include page='MasterPageTopSection.jsp'/>


<h1>Designation (Add Designation Module)</h1><br>
<span class='error'>
<jsp:getProperty name='errorBean' property='error'/>
</span>

<form method='post' action='/styletwo/AddDesignation.jsp' onsubmit='return (validateForm(this))'>
Designation <input type='text' id='title' name='title' maxlength='35' size='36' value='${designationBean.title}'>
&nbsp; <span id='titleErrorSection' class='error'> </span>
<tm:FormId/>
<br>
<button type='submit'>Add</button>
<button type='button' onclick='cancelAddition()'>Cancel</button>
</form>

<form action='/styletwo/Designations.jsp' id='cancelAdditionForm'> </form>

<jsp:include page='MasterPageBottomSection.jsp'/>