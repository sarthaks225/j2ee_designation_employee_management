package com.hr.servlet;
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import com.hr.dl.*;
import java.util.*;

public class AjaxDesignations extends HttpServlet
{
	public void doGet(HttpServletRequest request,HttpServletResponse response)
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
		
		
			List<DesignationDTO> designations=(new DesignationDAO()).getAll();
			PrintWriter pw=response.getWriter();
			response.setContentType("text/plain");
			int i=0;
			for(DesignationDTO designation:designations)
			{
				++i;
				pw.print(designation.getCode()+","+designation.getTitle());
				if(i<designations.size()) pw.print(",");
				
			}
				
			pw.close();
		}catch(Exception e)
		{
			try
			{
			response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
			
			}catch(IOException ioe)
			{
				//do nothing
			}
		}
		
	}
}