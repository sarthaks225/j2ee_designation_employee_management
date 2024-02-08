package com.hr.servlet;
import com.hr.dl.*;
import com.hr.beans.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class ConfirmDeleteDesignation extends HttpServlet
{

public void doGet(HttpServletRequest request,HttpServletResponse response)
{

DesignationBean designationBean;
DesignationDTO designationDTO;
DesignationDAO designationDAO;
RequestDispatcher requestDispatcher;
HttpSession httpSession=request.getSession();
String userName=(String)httpSession.getAttribute("userName");

int code;

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
String codeString=request.getParameter("code");
if(codeString.trim()==null)
{

requestDispatcher=request.getRequestDispatcher("/Designations.jsp");
requestDispatcher.forward(request,response);
return;

}

try
{
code=Integer.parseInt(codeString);
}catch(NumberFormatException nfe)
{
requestDispatcher=request.getRequestDispatcher("/Designations.jsp");
requestDispatcher.forward(request,response);
return;
}


designationDAO=new DesignationDAO();

designationDTO=designationDAO.getByCode(code);

designationBean=new DesignationBean();
designationBean.setCode(code);
designationBean.setTitle(designationDTO.getTitle());

request.setAttribute("designationBean",designationBean);
requestDispatcher=request.getRequestDispatcher("/ConfirmDeleteDesignation.jsp");
requestDispatcher.forward(request,response);

}catch(DAOException exception)
{

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