<%@taglib uri='WEB-INF/mytags/tmtags.tld' prefix='tm' %>

<tm:Module name='DESIGNATION'/>

<jsp:include page='MasterPageTopSection.jsp'/>

<script>
	function populateDesignations()
	{
		var xmlHttpRequest=new XMLHttpRequest();
		xmlHttpRequest.onreadystatechange=function(){
			if(this.readyState==4)
			{
				if(this.status==200)
				{
					var responseData=this.responseText;
					var splits=responseData.split(",");
					
					var gridTable=document.getElementById("designationGridTable");
					var tableBody=gridTable.getElementsByTagName("tbody")[0];
									
					var tableRow=tableBody.getElementsByTagName("tr")[0];
					tableRow.remove();
					var tableRow;
					var sn=1;
					
					for(var i=0; i<splits.length; i+=2)
					{
						dynamicRow=tableRow.cloneNode(true);
						tableBody.appendChild(dynamicRow);
						dynamicRowCells=dynamicRow.getElementsByTagName("td");
						
						dynamicRowCells[0].innerHTML=sn;
						dynamicRowCells[1].innerHTML=splits[i+1];
						dynamicRowCells[2].getElementsByTagName("a")[0].href="/stylethree/editDesignation?code="+splits[i];
						dynamicRowCells[3].getElementsByTagName("a")[0].href="/stylethree/confirmDeleteDesignation?code="+splits[i];
						sn++;
					}
				}
			}
			
		}
		
		xmlHttpRequest.open("GET",'ajaxDesignations',true);
		xmlHttpRequest.send();
		
	}
	window.addEventListener('load',populateDesignations);
</script>



<table border='1' id='designationGridTable'>
<thead>
<tr>
<th colspan='4' style='text-align:right; padding:5px'>
<a href='/stylethree/DesignationAddForm.jsp'>Add new designation<a>
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

<tr>
<td style='text-align:right'></td> 
<td style='text-align:center'></td>
<td style='text-align:center'><a href=''>edit</a></td>
<td style='text-align:center'><a href=''>delete</a></td>
</tr>


</tbody>
</table>



<jsp:include page='MasterPageBottomSection.jsp'/>