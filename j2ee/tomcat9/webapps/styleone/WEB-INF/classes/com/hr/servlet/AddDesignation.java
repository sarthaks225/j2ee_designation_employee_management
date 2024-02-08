package com.hr.servlet;
import com.hr.dl.*;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class AddDesignation extends HttpServlet
{
public void doGet(HttpServletRequest request,HttpServletResponse response)
{
DesignationDAO designationDAO=null;
DesignationDTO designationDTO=null;
String title="";
PrintWriter pw=null;

try
{
pw=response.getWriter();

response.setContentType("text/html");
title=request.getParameter("title");

designationDAO=new DesignationDAO();
designationDTO=new DesignationDTO();
designationDTO.setTitle(title);

designationDAO.add(designationDTO);


		//..............same as index.html...........
pw.println("<!DOCTYPE HTML>");
pw.println("<html lang='en'>");

pw.println("<head>");
pw.println("<meta charset='utf-8'>");
pw.println("<title>HR Application</title>");
pw.println("</head>");

pw.println("<body>");
pw.println("<!-- Main container starts here-->");
pw.println("<div style='width:50hw;height:auto;border:1px solid black'>");
pw.println("<!-- Header starts here-->");
pw.println("<div style='margin:5px;width:90hw;height:auto;border:1px solid black'>");

pw.println("<img src='/styleone/images/logo.png' style='float:left'>");
pw.println("<div style='margin-top:7px;margin-bottom:7px; font-size:30pt;'>HR Application</div>");

pw.println("</div>");
pw.println("<!-- Header ends here-->");

pw.println("<!-- Content section starts here-->");
pw.println("<div style='width:50hw; height:70vh; margin:5px; border:1px solid black'>");

pw.println("<!-- left panel starts here -->");
pw.println("<div style='height:65vh;margin:5px;padding:5px; float:left; border:1px solid black'>");
pw.println("<a href='/styleone/designationsView'> Designations</a><br>");
pw.println("<a href='/styleone/employeesView'> Employees</a><br>");

pw.println("</div>");
pw.println("<!-- left panel ends here -->");
pw.println("<!-- right panel starts here -->");

pw.println("<div style='height:65vh; margin-left:105px;margin-right:5px;margin-top:5px;margin-bottom:5px; padding:5px;border:1px solid black'>");
pw.println("<h1>Designation Added</h1><br>");
			//..........changes begin.......
pw.println("<h3>Want to add more designation?</h3><br>");
pw.println("<table>");
pw.println("<tr>");
pw.println("<td>");
pw.println("<form action='/styleone/addDesignation.html'>");
pw.println("<button type='submit'>Yes</button>");
pw.println("</form>");
pw.println("</td>");
						//..........changes ends.......

pw.println("<td>");
pw.println("<form action='/styleone/designationsView'>");
pw.println("<button type='submit'>NO</button>");
pw.println("</form>");
pw.println("</td>");
pw.println("</tr>");
pw.println("</table>");
pw.println("</div>");
pw.println("<!-- right panel ends here -->");


pw.println("</div>");
pw.println("<!-- Content section ends here-->");

pw.println("<!-- footer starts here-->");
pw.println("<div style='width:50hw; height:auto; margin:5px;text-align:center; border:1px solid black'>");
pw.println("&copy; ST Tech 2023-20230");
pw.println("</div>");
pw.println("<!-- footer ends here-->");
pw.println("</div> <!-- Main container ends here-->");

pw.println("</body>");


pw.println("</html>");





}catch(Exception e)
{

			//.....same as addDesignation.html code........
pw.println("<!DOCTYPE HTML>");
pw.println("<html lang='en'>");


pw.println("<head>");
pw.println("<meta charset='utf-8'>");
pw.println("<title>Add Designation</title>");

pw.println("<script>");

pw.println("function validateForm(frm)");
pw.println("{");


					//..... changes in script for designationAddException span section........
pw.println("var designationAddException=document.getElementById('designationAddException');");
pw.println("designationAddException.innerHTML='';");

pw.println("var title=frm.title.value.trim();");

pw.println("var titleErrorSection=document.getElementById('titleErrorSection');");

pw.println("titleErrorSection.innerHTML='';");

pw.println("if(title.length==0)");
pw.println("{");
pw.println("    titleErrorSection.innerHTML='Title required';");
pw.println("    frm.title.focus();");
pw.println("    return false;");
pw.println("}");
pw.println("return true;");
pw.println("}");
pw.println("</script>");

pw.println("</head>");

pw.println("<body>");
pw.println("<!-- Main container starts here-->");
pw.println("<div style='width:50hw;height:auto;border:1px solid black'>");
pw.println("<!-- Header starts here-->");
pw.println("<div style='margin:5px;width:90hw;height:auto;border:1px solid black'>");

pw.println("<a href='/styleone/index.html'><img src='/styleone/images/logo.png' style='float:left'></a>");
pw.println("<div style='margin-top:7px;margin-bottom:7px; font-size:30pt;'>HR Application</div>");

pw.println("</div>");
pw.println("<!-- Header ends here-->");

pw.println("<!-- Content section starts here-->");
pw.println("<div style='width:50hw; height:70vh; margin:5px; border:1px solid black'>");

pw.println("<!-- left panel starts here -->");
pw.println("<div style='height:65vh;margin:5px;padding:5px; float:left; border:1px solid black'>");
pw.println("<b> Designations</b><br>");
pw.println("<a href='/styleone/employeesView'> Employees</a><br>");
pw.println("<a href='/styleone/index.html'> Home</a><br>");

pw.println("</div>");
pw.println("<!-- left panel ends here -->");
pw.println("<!-- right panel starts here -->");

pw.println("<div style='height:65vh; margin-left:105px;margin-right:5px;margin-top:5px;margin-bottom:5px; padding:5px;border:1px solid black'>");

pw.println("<h1>Designation (Add Module)</h1><br>");

							//..... changes for designationAddException span section........
pw.println("<span id='designationAddException' style='color:red'>"+e.getMessage()+"</span><br>");

pw.println("<form action='/styleone/addDesignation' onsubmit='return (validateForm(this))'>");

							//change in input section for value='+title+'
pw.println("Designation <input type='text' id='title' name='title' value='"+title+"'maxlength='35' size='36'>");
pw.println("&nbsp; <span id='titleErrorSection' style='color:rgb(255, 0, 0)'> </span>");
pw.println("<br>");
pw.println("<button type='submit'>Add</button>");
pw.println("</form>");
							
pw.println("</div>");
pw.println("<!-- right panel ends here -->");

pw.println("</div>");
pw.println("<!-- Content section ends here-->");

pw.println("<!-- footer starts here-->");
pw.println("<div style='width:50hw; height:auto; margin:5px;text-align:center; border:1px solid black'>");
pw.println("&copy; ST Tech 2023-20230");
pw.println("</div>");
pw.println("<!-- footer ends here-->");
pw.println("</div> <!-- Main container ends here-->");

pw.println("</body>");


pw.println("</html>");


}


}

public void doPost(HttpServletRequest request,HttpServletResponse response)
{
doGet(request,response);
}

}