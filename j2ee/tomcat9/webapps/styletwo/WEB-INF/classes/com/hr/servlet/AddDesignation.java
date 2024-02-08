package com.hr.servlet;
import com.hr.dl.*;
import com.hr.beans.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class AddDesignation extends HttpServlet
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

designationBean=(DesignationBean)request.getAttribute("designationBean");
DesignationDTO designationDTO=new DesignationDTO();
designationDTO.setTitle(designationBean.getTitle());

DesignationDAO designationDAO=new DesignationDAO();
try
{
designationDAO.add(designationDTO);

designationBean.setCode(designationDTO.getCode());

MessageBean messageBean=new MessageBean();
messageBean.setHeading("Designation (Add Module)");
messageBean.setMessage("Designation added, add More ?");
messageBean.setGenerateButtons(true);
messageBean.setGenerateTwoButtons(true);
messageBean.setButtonOneText("Yes");
messageBean.setButtonTwoText("No");
messageBean.setButtonOneAction("DesignationAddForm.jsp");
messageBean.setButtonTwoAction("Designations.jsp");

request.setAttribute("messageBean",messageBean);
requestDispatcher=request.getRequestDispatcher("/Notification.jsp");

requestDispatcher.forward(request,response);


}catch(DAOException daoe)
{
ErrorBean errorBean=new ErrorBean();
errorBean.setError(daoe.getMessage());

request.setAttribute("errorBean",errorBean);
requestDispatcher=request.getRequestDispatcher("/DesignationAddForm.jsp");
requestDispatcher.forward(request,response);

}


}catch(Exception exception)
{

requestDispatcher=request.getRequestDispatcher("Error.jsp");

try
{
requestDispatcher.forward(request,response);
}catch(Exception e)
{
	// do nothing
}

}


}



}