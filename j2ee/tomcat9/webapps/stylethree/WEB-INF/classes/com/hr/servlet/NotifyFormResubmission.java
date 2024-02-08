package com.hr.servlet;
import com.hr.beans.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class NotifyFormResubmission extends HttpServlet
{

public void doPost(HttpServletRequest request,HttpServletResponse response)
{

try
{
HttpSession httpSession=request.getSession();
String userName=(String)httpSession.getAttribute("userName");
RequestDispatcher requestDispatcher;
if(userName==null)
{
requestDispatcher=request.getRequestDispatcher("/LoginForm.jsp");
requestDispatcher.forward(request,response);
return;
}


MessageBean messageBean=new MessageBean();

messageBean.setHeading("Notification");
messageBean.setMessage("Forms are not to be resubmitted");
messageBean.setGenerateButtons(true);
messageBean.setButtonOneText("OK");
messageBean.setButtonOneAction("index.jsp");

request.setAttribute("messageBean",messageBean);
requestDispatcher=request.getRequestDispatcher("/Notification.jsp");
requestDispatcher.forward(request,response);
}catch(Exception e)
{

}
}

}