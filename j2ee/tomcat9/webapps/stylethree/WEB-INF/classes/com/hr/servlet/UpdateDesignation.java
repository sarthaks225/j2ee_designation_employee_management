package com.hr.servlet;
import java.io.*;
import com.hr.dl.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class UpdateDesignation extends HttpServlet
{

public void doGet(HttpServletRequest request,HttpServletResponse response)
{

try
{
response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED);
}catch(IOException ioe)
{
	//DO NOTHING
}


}

public void doPost(HttpServletRequest request,HttpServletResponse response)
{

try
{
DesignationDAO designationDAO=new DesignationDAO();
DesignationDTO designationDTO=new DesignationDTO();

int code=Integer.parseInt(request.getParameter("code"));
String title=request.getParameter("title");
title=title.trim();

PrintWriter pw=response.getWriter();
response.setContentType("text/plain");

if(title.length()==0)
{
pw.print("0,");
pw.print("Title required");
return;
}

designationDTO.setCode(code);
designationDTO.setTitle(title);

designationDAO.update(designationDTO);

pw.print("1,");
pw.print("Designation title updated");
}catch(DAOException daoe)
{

try
{
PrintWriter pw=response.getWriter();
response.setContentType("text/plain");

pw.print("0,");
pw.print(daoe.getMessage());
}catch(Exception e)
{

}


}
catch(Exception e)
{

}


}

}