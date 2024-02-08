package com.hr.servlet;
import com.hr.beans.*;
import com.hr.dl.*;
import javax.servlet.*;
import javax.servlet.http.*;
public class DeleteDesignation extends HttpServlet
{

public void doGet(HttpServletRequest request,HttpServletResponse response)
{
try
{
RequestDispatcher requestDispatcher;
requestDispatcher=request.getRequestDispatcher("/Designations.jsp");
requestDispatcher.forward(request,response);
}catch(Exception e)
{

}
}

public void doPost(HttpServletRequest request,HttpServletResponse response)
{
DesignationBean designationBean;
DesignationDAO designationDAO;
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
designationBean=(DesignationBean)request.getAttribute("designationBean");
designationDAO=new DesignationDAO();
designationDAO.delete(designationBean.getCode());

requestDispatcher=request.getRequestDispatcher("Notification.jsp");
messageBean=new MessageBean();
messageBean.setHeading("Designation ("+designationBean.getTitle()+") deleted");
messageBean.setGenerateButtons(true);
messageBean.setButtonOneText("Ok");
messageBean.setButtonOneAction("Designations.jsp");
request.setAttribute("messageBean",messageBean);
requestDispatcher=request.getRequestDispatcher("/Notification.jsp");
requestDispatcher.forward(request,response);

}catch(DAOException daoe)
{
System.out.println(daoe.getMessage());
	// forward requst to Designations.jsp
requestDispatcher=request.getRequestDispatcher("/Designations.jsp");
requestDispatcher.forward(request,response);

}


}catch(Exception exception)
{
 	// do nothing
}


}



}

