package com.hr.servlet;
import com.hr.beans.*;
import com.hr.dl.*;
import javax.servlet.*;
import javax.servlet.http.*;
public class DeleteEmployee extends HttpServlet
{

public void doGet(HttpServletRequest request,HttpServletResponse response)
{
try
{
RequestDispatcher requestDispatcher;
requestDispatcher=request.getRequestDispatcher("/Employees.jsp");
requestDispatcher.forward(request,response);
}catch(Exception e)
{

}
}

public void doPost(HttpServletRequest request,HttpServletResponse response)
{
EmployeeBean employeeBean;
EmployeeDAO employeeDAO;
RequestDispatcher requestDispatcher;
MessageBean messageBean;

HttpSession httpSession=request.getSession();
String userName=(String)httpSession.getAttribute("userName");
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
employeeBean=(EmployeeBean)request.getAttribute("employeeBean");
employeeDAO=new EmployeeDAO();
employeeDAO.delete(employeeBean.getEmployeeId());

requestDispatcher=request.getRequestDispatcher("Notification.jsp");
messageBean=new MessageBean();
messageBean.setHeading("Employee :("+employeeBean.getName()+") deleted");
messageBean.setGenerateButtons(true);
messageBean.setButtonOneText("Ok");
messageBean.setButtonOneAction("Employees.jsp");
request.setAttribute("messageBean",messageBean);
requestDispatcher=request.getRequestDispatcher("/Notification.jsp");
requestDispatcher.forward(request,response);

}catch(DAOException daoe)
{
System.out.println(daoe.getMessage());
	// forward requst to Employees.jsp
requestDispatcher=request.getRequestDispatcher("/Employees.jsp");
requestDispatcher.forward(request,response);

}


}catch(Exception exception)
{
 	// do nothing
}


}



}

