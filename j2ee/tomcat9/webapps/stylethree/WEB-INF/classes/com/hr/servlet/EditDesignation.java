package com.hr.servlet;
import java.io.*;
import com.hr.dl.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class EditDesignation extends HttpServlet
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
DesignationDTO designationDTO;

int code=Integer.parseInt(request.getParameter("code"));
designationDTO=designationDAO.getByCode(code);

PrintWriter pw=response.getWriter();
response.setContentType("text/plain");

pw.print("1,");
pw.print(designationDTO.getTitle());
}catch(DAOException daoe)
{

}
catch(Exception e)
{

}


}


}