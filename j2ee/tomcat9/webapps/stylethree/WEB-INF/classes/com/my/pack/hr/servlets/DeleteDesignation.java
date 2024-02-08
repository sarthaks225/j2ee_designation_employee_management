package com.my.pack.hr.servlets;
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import com.my.pack.hr.dl.*;
import java.util.*;

public class DeleteDesignation extends HttpServlet
{
public void doGet(HttpServletRequest request,HttpServletResponse response)
{
try
{
response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED);
}catch(Exception e)
{
}
}//function ends

public void doPost(HttpServletRequest request,HttpServletResponse response)
{
try
{
int code=Integer.parseInt(request.getParameter("code"));
PrintWriter pw=response.getWriter();
response.setContentType("text/plain");
DesignationDAO designationDAO;
try
{
designationDAO=new DesignationDAO();
designationDAO.delete(code);
pw.print("Designation deleted.");
}catch(DAOException daoException)
{
System.out.println(daoException.getMessage());
pw.println(daoException.getMessage());
}
 
}catch(Exception e)
{
try
{
response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
}catch(Exception ee)
{
//do nothing
}
}

}//function ends

}//class ends