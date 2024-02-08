<%@taglib uri='WEB-INF/mytags/tmtags.tld' prefix='tm'%>
<tm:Module name='DESIGNATION'/>

<jsp:useBean id='designationBean' scope='request' class='com.hr.beans.DesignationBean'/>

<jsp:include page='/MasterPageTopSection.jsp'/>

<script src='/styletwo/js/DesignationDeleteForm.js'> </script>


<h1>Designation (Delete)</h1><br>

Are you sure to delete (${designationBean.title}) ?
<br>

<form method='post' action='DeleteDesignation.jsp' >
<input type='hidden' id='code' name='code' value='${designationBean.code}'>
<input type='hidden' id='title' name='title' value=${designationBean.title}>
<button type='submit'>Delete</button>
<button type='button' onclick='cancelDelete()'>Cancel</button></form>

<form action='/styletwo/Designations.jsp' id='cancelDelete'> </form>


<jsp:include page='/MasterPageBottomSection.jsp'/>