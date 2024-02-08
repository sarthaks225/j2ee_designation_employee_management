package com.hr.servlet;
import javax.servlet.http.*;
import javax.servlet.*;

public class Logout extends HttpServlet
{

public void doPost(HttpServletRequest request,HttpServletResponse response)
{
doPost(request,response);
}

public void doGet(HttpServletRequest request,HttpServletResponse response)
{

try
{
HttpSession httpSession=request.getSession();

httpSession.removeAttribute("userName");

RequestDispatcher requestDispatcher=request.getRequestDispatcher("/LoginForm.jsp");
requestDispatcher.forward(request,response);

}catch(Exception e)
{


}
}


}
