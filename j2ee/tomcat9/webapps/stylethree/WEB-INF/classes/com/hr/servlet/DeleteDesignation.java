package com.hr.servlet;
import java.io.*;
import com.hr.dl.*;
import javax.servlet.*;
import javax.servlet.http.*;
public class DeleteDesignation extends HttpServlet
{

public void doGet(HttpServletRequest request,HttpServletResponse response)
{

try
{
response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED);
}catch(Exception e)
{
	//do nothing
}

}

public void doPost(HttpServletRequest request,HttpServletResponse response)
{
DesignationDAO designationDAO;

try
{
designationDAO=new DesignationDAO();
int code=Integer.parseInt(request.getParameter("code"));

DesignationDTO designationDTO=designationDAO.getByCode(code);
designationDAO.delete(code);

PrintWriter pw=response.getWriter();
response.setContentType("text/plain");

pw.print("Designation ("+designationDTO.getTitle()+") removed");

}catch(Exception e)
{


}

}

}

