package com.hr.servlet;
import com.hr.beans.*;
import com.hr.dl.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class UpdateDesignation extends HttpServlet
{

public void doPost(HttpServletRequest request,HttpServletResponse response)
{


HttpSession httpSession=request.getSession();
String userName=(String)httpSession.getAttribute("userName");
RequestDispatcher requestDispatcher;


try
{

if(userName==null)
{
requestDispatcher=request.getRequestDispatcher("/LoginForm.jsp");
requestDispatcher.forward(request,response);
return;
}

DesignationBean designationBean;
DesignationDTO designationDTO;
DesignationDAO designationDAO;

MessageBean messageBean;
ErrorBean errorBean;

try
{
designationBean=(DesignationBean)request.getAttribute("designationBean");
designationDTO=new DesignationDTO();
designationDTO.setCode(designationBean.getCode());
designationDTO.setTitle(designationBean.getTitle());
designationDAO=new DesignationDAO();
designationDAO.update(designationDTO);

messageBean=new MessageBean();
messageBean.setHeading("Designation Updated");
//....  messageBean.setMessage("");

messageBean.setGenerateButtons(true);
messageBean.setButtonOneText("Ok");
messageBean.setButtonOneAction("Designations.jsp");
request.setAttribute("messageBean",messageBean);
requestDispatcher=request.getRequestDispatcher("/Notification.jsp");
requestDispatcher.forward(request,response);

}catch(DAOException daoe)
{
errorBean=new ErrorBean();
errorBean.setError(daoe.getMessage());
request.setAttribute("errorBean",errorBean);
requestDispatcher=request.getRequestDispatcher("/DesignationEditForm.jsp");
requestDispatcher.forward(request,response);
}




}catch(Exception e)
{

// forward to EditDesignation form with error

}



}

}