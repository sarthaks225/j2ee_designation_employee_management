package com.hr.servlet;
import com.hr.beans.*;
import com.hr.bl.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.util.*;

public class EmployeesJS extends HttpServlet
{

public void doPost(HttpServletRequest request,HttpServletResponse response)
{
doGet(request,response);
}

public void doGet(HttpServletRequest request,HttpServletResponse response)
{

try
{
PrintWriter pw=response.getWriter();
response.setContentType("text/javascript");

/*
the following is very bad idea, hence commented
File file=new File("c:\\j2ee\\tomcat9\\webapps\\styletwo\\WEB-INF\\js\\Employees.js");
*/

ServletContext servletContext=getServletContext();

File file=new File(servletContext.getRealPath("")+File.separator+"js"+File.separator+"employees.js");


RandomAccessFile randomAccessFile=new RandomAccessFile(file,"r");


while(randomAccessFile.getFilePointer()!=randomAccessFile.length())
{
pw.println(randomAccessFile.readLine());
}


List<EmployeeBean> employeesBean=(new EmployeeBL()).getAll();

pw.println("var employee");
int i=0;


for(EmployeeBean employee:employeesBean)
{
	//populating employees in employees array
pw.println("employee=new Employee()");
pw.println("employee.employeeId=\""+employee.getId()+"\"");
pw.println("employee.name=\""+employee.getName()+"\"");
pw.println("employee.designationCode=\""+employee.getCode()+"\"");
pw.println("employee.designation=\""+employee.getTitle()+"\"");
pw.println("employee.dateOfBirth=\""+employee.getDateOfBirth()+"\"");
pw.println("employee.gender=\""+employee.getGender()+"\"");
pw.println("employee.isIndian=\""+employee.getIsIndian()+"\"");
pw.println("employee.basicSalary=\""+employee.getBasicSalary()+"\"");
pw.println("employee.panNumber=\""+employee.getPANNumber()+"\"");
pw.println("employee.aadharCardNumber=\""+employee.getAadharCardNumber()+"\"");
pw.println("employees["+i+"]=employee");
++i;
}


}catch(Exception e)
{


//do nothing


}


}


}