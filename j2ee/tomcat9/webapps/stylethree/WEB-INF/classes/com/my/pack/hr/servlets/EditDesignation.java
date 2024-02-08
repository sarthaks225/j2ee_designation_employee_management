package com.my.pack.hr.servlets;
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import com.my.pack.hr.dl.*;
import java.util.*;

public class EditDesignation extends HttpServlet
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
DesignationDTO designationDTO;
try
{
designationDAO=new DesignationDAO();
designationDTO=designationDAO.getByCode(code);
pw.print("1,"+designationDTO.getTitle());
}catch(DAOException daoException)
{
pw.println("2,"+daoException.getMessage());
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