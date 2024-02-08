package com.hr.servlet;
import com.hr.dl.*;
import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class DeleteDesignation extends HttpServlet
{
public void doGet(HttpServletRequest request,HttpServletResponse response)
{
DesignationDAO designationDAO=null;
int code=0;
PrintWriter pw=null;

try
{

pw=response.getWriter();

response.setContentType("text/html");

try
{
code=Integer.parseInt(request.getParameter("code"));
}catch(NumberFormatException nfe)
{
System.out.println("code number format exception invoked from servlet UpdateDesignation");

	sendBackViewPage(response);
	return;
}


designationDAO=new DesignationDAO();
designationDAO.delete(code);


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
pw.println("<h1>Designation deleted</h1><br>");
			//..........changes begin.......
pw.println("<form action='/styleone/designationsView'>");
pw.println("<button type='submit'>Ok</button>");
pw.println("</form>");
						//..........changes ends.......

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
pw.println("<h1>Notification</h1><br>");
pw.println("<b>Unable to delete designation, as it has been alloted to employee</\b><br>");
			//..........changes begin.......
pw.println("<form action='/styleone/designationsView'>");
pw.println("<button type='submit'>Ok</button>");
pw.println("</form>");
						//..........changes ends.......

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

private void sendBackViewPage(HttpServletResponse response)
{

System.out.println("sendBackView page invoked from servlet UpdateDesignation...");
try
{
System.out.println("DesignationView page request invoked");
DesignationDAO designationDAO;
List<DesignationDTO> designations;

designationDAO=new DesignationDAO();
designations=designationDAO.getAll();

PrintWriter pw=response.getWriter();
response.setContentType("text/html");


pw.println("<!DOCTYPE HTML>");
pw.println("<html lang='en'>");

pw.println("<head>");
pw.println("<meta charset='utf-8'>");
pw.println("<title>Designaiton View</title>");
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
pw.println("<b>Designations</b><br>");
pw.println("<a href='/styleone/employeesView'> Employees</a><br>");
pw.println("<a href='/styleone/index.html'> Home</a><br>");

pw.println("</div>");
pw.println("<!-- left panel ends here -->");
pw.println("<!-- right panel starts here -->");

pw.println("<div style='height:65vh; margin-left:105px;margin-right:5px;margin-top:5px;margin-bottom:5px; padding:5px; overflow:scroll;border:1px solid black'>");

pw.println("<table border='1'>");
pw.println("<thead>");

pw.println("<tr>");
pw.println("<th colspan='4' style='text-align:right; padding:5px'>");
pw.println("<a href='/styleone/addDesignation.html'>Add new designation<a>");
pw.println("</th>");
pw.println("</tr>");

pw.println("<tr>");
pw.println("<th style='width:80px;text-align:center'>S.No</th> ");
pw.println("<th style='width:150px;text-align:center'>Designation</th>");
pw.println("<th style='width:100px;text-align:center'>Edit</th>");
pw.println("<th style='width:100px;text-align:center'>Delete</th>");
pw.println("</tr>");

pw.println("</thead>");

DesignationDTO designationDTO;
int code;
String title;
int sno=0;
for(int i=0; i<designations.size(); ++i)
{
++sno;
designationDTO=designations.get(i);
code=designationDTO.getCode();
title=designationDTO.getTitle();
pw.println("<tr>");
pw.println("<td style='text-align:right'>"+sno+".</td> ");
pw.println("<td style='text-align:center'>"+title+"</td>");
pw.println("<td style='text-align:center'><a href='/styleone/editDesignation?code="+code+"'>edit</a></td>");
pw.println("<td style='text-align:center'><a href='/styleone/deleteDesignation?code="+code+"'>delete</a></td>");
pw.println("</tr>");
}

pw.println("<tbody>");

pw.println("</tbody>");

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


}catch(DAOException e)
{
System.out.println(e.getMessage()); //remove it after testing
}
catch(Exception e)
{
System.out.println(e.getMessage());
}




}

}