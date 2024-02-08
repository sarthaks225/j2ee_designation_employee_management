package com.hr.servlet;
import javax.servlet.*;
import javax.servlet.http.*;
import com.hr.beans.*;
import com.hr.dl.*;


public class Login extends HttpServlet
{

public void doPost(HttpServletRequest request,HttpServletResponse response)
{
AdministratorBean administratorBean;
AdministratorDTO administratorDTO;
AdministratorDAO administratorDAO;
RequestDispatcher requestDispatcher;
try
{
administratorBean=(AdministratorBean)request.getAttribute("administratorBean");

String userName=administratorBean.getUserName();
String password=administratorBean.getPassword();

administratorDAO=new AdministratorDAO();
try
{
administratorDTO=administratorDAO.getByUserName(userName);

if(administratorDTO.getPassword().equals(password)==true)
{
HttpSession httpSession=request.getSession();
httpSession.setAttribute("userName",userName);

request.setAttribute("administratorBean",administratorBean);
requestDispatcher=request.getRequestDispatcher("/index.jsp");
requestDispatcher.forward(request,response);
}
else
{


ErrorBean errorBean=new ErrorBean();
errorBean.setError("Incorrect password");

request.setAttribute("errorBean",errorBean);
request.setAttribute("userName",userName);
requestDispatcher=request.getRequestDispatcher("/LoginForm.jsp");
requestDispatcher.forward(request,response);
}


}catch(DAOException daoe)
{
	// forword with error message and AdministratorBean to LoginForm.jsp

ErrorBean errorBean=new ErrorBean();
errorBean.setError(daoe.getMessage());

request.setAttribute("errorBean",errorBean);
request.setAttribute("userName",userName);
requestDispatcher=request.getRequestDispatcher("/LoginForm.jsp");
requestDispatcher.forward(request,response);

}


}catch(Exception e)
{
	// do nothing

}



}


}