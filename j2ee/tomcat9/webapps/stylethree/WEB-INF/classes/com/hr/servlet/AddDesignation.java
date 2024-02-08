package com.hr.servlet;
import com.hr.dl.*;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class AddDesignation extends HttpServlet
{

public void doGet(HttpServletRequest request,HttpServletResponse response)
{
try
{
response.sendError(response.SC_METHOD_NOT_ALLOWED);
}catch(IOException ioe)
{

}

}

public void doPost(HttpServletRequest request,HttpServletResponse response)
{

try
{

String title=request.getParameter("title").trim();

PrintWriter pw=response.getWriter();
response.setContentType("text/plain");
if(title.length()==0)
{
pw.print("0,Title Required");
}

try
{
DesignationDAO designationDAO=new DesignationDAO();
DesignationDTO designationDTO=new DesignationDTO();
designationDTO.setTitle(title);
designationDAO.add(designationDTO);
pw.print("1,"+"Designation added");
}catch(DAOException daoe)
{
pw.print("0,"+daoe.getMessage());
}
}catch(Exception e)
{

}

}
}