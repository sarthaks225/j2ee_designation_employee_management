package com.my.pack.hr.servlets;
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import com.my.pack.hr.dl.*;
import java.util.*;

public class Designations extends HttpServlet
{
public void doPost(HttpServletRequest request,HttpServletResponse response)
{
try
{
response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED);
}catch(Exception e)
{
}
}//function ends

public void doGet(HttpServletRequest request,HttpServletResponse response)
{
try
{
PrintWriter pw=response.getWriter();
response.setContentType("text/plain");
DesignationDAO designationDAO=new DesignationDAO();
List<DesignationDTO> designations=designationDAO.getAll();
int i=0;
for(DesignationDTO designation:designations)
{
pw.print(designation.getCode()+","+designation.getTitle());
i++;
if(i<designations.size()) pw.print(",");
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