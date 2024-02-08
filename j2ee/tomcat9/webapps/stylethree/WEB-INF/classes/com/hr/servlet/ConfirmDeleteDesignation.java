package com.hr.servlet;
import com.hr.dl.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;

public class ConfirmDeleteDesignation extends HttpServlet
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

try
{
int code=Integer.parseInt(request.getParameter("code"));

PrintWriter pw=response.getWriter();
response.setContentType("text/plain");

DesignationDAO designationDAO=new DesignationDAO();
try
{
String title=designationDAO.getByCode(code).getTitle();


pw.print("1,"+title);
}catch(DAOException daoe)
{
pw.print("0");
}


}catch(Exception e)
{
try
{
response.sendError(response.SC_INTERNAL_SERVER_ERROR);
}catch(IOException ioe)
{

}
}

}

}