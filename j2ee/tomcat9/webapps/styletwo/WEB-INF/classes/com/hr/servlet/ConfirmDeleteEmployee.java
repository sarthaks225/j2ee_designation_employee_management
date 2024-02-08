package com.hr.servlet;
import com.hr.dl.*;
import com.hr.beans.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.*;
import java.text.*;
public class ConfirmDeleteEmployee extends HttpServlet
{

public void doGet(HttpServletRequest request,HttpServletResponse response)
{
EmployeeBean employeeBean;
EmployeeDTO employeeDTO;
EmployeeDAO employeeDAO;
RequestDispatcher requestDispatcher;
HttpSession httpSession=request.getSession();
String userName=(String)httpSession.getAttribute("userName");

int employeeId;

try
{
if(userName==null)
{
requestDispatcher=request.getRequestDispatcher("/LoginForm.jsp");
requestDispatcher.forward(request,response);
return;
}

try
{
String employeeIdString=request.getParameter("employeeId");
if(employeeIdString.trim()==null)
{

requestDispatcher=request.getRequestDispatcher("/Employees.jsp");
requestDispatcher.forward(request,response);
return;

}
try
{
employeeId=Integer.parseInt(employeeIdString);
}catch(NumberFormatException nfe)
{
requestDispatcher=request.getRequestDispatcher("/Designations.jsp");
requestDispatcher.forward(request,response);
return;
}

employeeDAO=new EmployeeDAO();

employeeDTO=employeeDAO.getById(employeeId);
employeeBean=new EmployeeBean();
employeeBean.setId(employeeId);
employeeBean.setName(employeeDTO.getName());
employeeBean.setCode(employeeDTO.getCode());
employeeBean.setTitle(employeeDTO.getTitle());
employeeBean.setDateOfBirth(employeeDTO.getDateOfBirth().toString());
employeeBean.setGender(employeeDTO.getGender());
employeeBean.setIsIndian(employeeDTO.getIsIndian());
employeeBean.setBasicSalary(employeeDTO.getBasicSalary().toString());
employeeBean.setPANNumber(employeeDTO.getPANNumber());
employeeBean.setAadharCardNumber(employeeDTO.getAadharCardNumber());
request.setAttribute("employeeBean",employeeBean);
requestDispatcher=request.getRequestDispatcher("/ConfirmDeleteEmployee.jsp");
requestDispatcher.forward(request,response);
}catch(DAOException exception)
{

	// forward requst to Designations.jsp

requestDispatcher=request.getRequestDispatcher("/Employees.jsp");
requestDispatcher.forward(request,response);

}

}catch(Exception exception)
{
	// do nothing

}


}


}