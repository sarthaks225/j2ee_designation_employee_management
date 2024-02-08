<%@taglib uri='WEB-INF/mytags/tmtags.tld' prefix='tm' %>

<tm:Module name='DESIGNATION'/>

<jsp:include page='MasterPageTopSection.jsp'/>

<table border='1'>
<thead>
<tr>
<th colspan='4' style='text-align:right; padding:5px'>
<a href='/styletwo/DesignationAddForm.jsp'>Add new designation<a>
</th>
</tr>
<tr>
<th style='width:80px;text-align:center'>S.No</th> 
<th style='width:150px;text-align:center'>Designation</th>
<th style='width:100px;text-align:center'>Edit</th>
<th style='width:100px;text-align:center'>Delete</th>
</tr>
</thead>

<tbody>
<tm:EntityList populatorClass='com.hr.bl.DesignationBL' populatorMethod='getAll' name='bean'>
<tr>
<td style='text-align:right'>${serialNumber}</td> 
<td style='text-align:center'>${bean.title}</td>
<td style='text-align:center'><a href='/styletwo/editDesignation?code=${bean.code}'>edit</a></td>
<td style='text-align:center'><a href='/styletwo/confirmDeleteDesignation?code=${bean.code}'>delete</a></td>
</tr>
</tm:EntityList>

</tbody>
</table>


<jsp:include page='MasterPageBottomSection.jsp'/>