package com.hr.servlet;
import com.hr.dl.*;
import com.hr.beans.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class EditDesignation extends HttpServlet
{

public void doGet(HttpServletRequest request,HttpServletResponse response)
{

int code=Integer.parseInt(request.getParameter("code"));
DesignationDAO designationDAO;
DesignationDTO designationDTO;
DesignationBean designationBean;
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
designationDAO=new DesignationDAO();
designationDTO=designationDAO.getByCode(code);

designationBean=new DesignationBean();
designationBean.setCode(code);
designationBean.setTitle(designationDTO.getTitle());

request.setAttribute("designationBean",designationBean);
requestDispatcher=request.getRequestDispatcher("/DesignationEditForm.jsp");
requestDispatcher.forward(request,response);

}catch(DAOException daoe)
{
requestDispatcher=request.getRequestDispatcher("/Designations.jsp");
requestDispatcher.forward(request,response);

}

}catch(Exception e)
{

	// Do nothing

}


}



}