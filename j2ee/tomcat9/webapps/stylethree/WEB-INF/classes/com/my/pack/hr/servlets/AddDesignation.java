package com.my.pack.hr.servlets;
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import com.my.pack.hr.dl.*;
import java.util.*;

public class AddDesignation extends HttpServlet
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
String title=request.getParameter("title");
PrintWriter pw=response.getWriter();
response.setContentType("text/plain");
DesignationDAO designationDAO;
DesignationDTO designationDTO=new DesignationDTO();
designationDTO.setTitle(title);
try
{
designationDAO=new DesignationDAO();
designationDAO.add(designationDTO);
pw.print("added");
}catch(DAOException daoException)
{
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