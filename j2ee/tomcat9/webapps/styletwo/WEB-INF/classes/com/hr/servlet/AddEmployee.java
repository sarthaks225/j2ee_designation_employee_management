package com.hr.servlet;
import com.hr.dl.*;
import com.hr.beans.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.math.*;
import java.util.*;
import java.text.*;

public class AddEmployee extends HttpServlet
{
	public void doPost(HttpServletRequest request,HttpServletResponse response)
	{
		doGet(request,response);	
	}
	
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
					
		String name="";
		int code=0;
		String title;
		Date dateOfBirth=null;
		String gender="";
		Boolean isIndian=false;
		BigDecimal basicSalary=null;
		String panNumber="";
		String aadharCardNumber="";

		
			EmployeeDAO employeeDAO=new EmployeeDAO();
			DesignationDAO designationDAO=new DesignationDAO();
			EmployeeBean employeeBean=(EmployeeBean)request.getAttribute("employeeBean");
			
			name=employeeBean.getName();
			code=Integer.parseInt(request.getParameter("designationCode"));
			
			SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
			dateOfBirth=sdf.parse(request.getParameter("dateOfBirth"));
			
			gender=employeeBean.getGender();
			if(request.getParameter("isIndian")==null) isIndian=false;
			else isIndian=true;
			basicSalary=new BigDecimal(employeeBean.getBasicSalary());
			panNumber=employeeBean.getPANNumber();
			aadharCardNumber=employeeBean.getAadharCardNumber();
				/*
				for debuging
				System.out.println("name: "+name);
				System.out.println("code: "+code);
				System.out.println("dateOfBirth: "+dateOfBirth);
				System.out.println("gender: "+gender);
				System.out.println("isIndian: "+isIndian);
				System.out.println("basicSalary: "+basicSalary);
				System.out.println("panNumber: "+panNumber);
				System.out.println("aadharCardNumber: "+aadharCardNumber);
				*/
			/*validations
			1. designaiton code should exist
			2. aadhar pan number should not exist
			*/
			// validations ...
			
			boolean codeExists,panNumberExists,aadharCardNumberExists;
			codeExists=designationDAO.codeExists(code);
			panNumberExists=employeeDAO.panNumberExists(panNumber);
			aadharCardNumberExists=employeeDAO.aadharCardNumberExists(aadharCardNumber);
			
			if(codeExists==false || panNumberExists==true || aadharCardNumberExists==true)
			{
				if(codeExists==false)
				{
					ErrorBean designationCodeErrorBean=new ErrorBean();
					designationCodeErrorBean.setError("Invalid Designation");
					request.setAttribute("designationCodeErrorBean",designationCodeErrorBean);
				}
				if(panNumberExists==true)
				{
					ErrorBean panNumberErrorBean=new ErrorBean();
					panNumberErrorBean.setError("PAN number already alloted");
					request.setAttribute("panNumberErrorBean",panNumberErrorBean);
				}
				if(aadharCardNumberExists==true)
				{
					ErrorBean aadharCardNumberErrorBean=new ErrorBean();
					aadharCardNumberErrorBean.setError("Aadhar card number already alloted");
					request.setAttribute("aadharCardNumberErrorBean",aadharCardNumberErrorBean);
				}
					
				requestDispatcher=request.getRequestDispatcher("/EmployeeAddForm.jsp");
				requestDispatcher.forward(request,response);
				return;
			}
			
			EmployeeDTO employee=new EmployeeDTO();
			employee.setName(name);
			employee.setCode(code);
			employee.setDateOfBirth(dateOfBirth);
			employee.setGender(gender);
			employee.setIsIndian(isIndian);
			employee.setBasicSalary(basicSalary);
			employee.setPANNumber(panNumber);
			employee.setAadharCardNumber(aadharCardNumber);
			
			employeeDAO.add(employee);
			
			MessageBean messageBean=new MessageBean();
			messageBean.setHeading("Employee (Add Module)");
			messageBean.setMessage("Employee added, add More ?");
			messageBean.setGenerateButtons(true);
			messageBean.setGenerateTwoButtons(true);
			messageBean.setButtonOneText("Yes");
			messageBean.setButtonTwoText("No");
			messageBean.setButtonOneAction("EmployeeAddForm.jsp");
			messageBean.setButtonTwoAction("Employees.jsp");
			request.setAttribute("messageBean",messageBean);
			requestDispatcher=request.getRequestDispatcher("/Notification.jsp");
			requestDispatcher.forward(request,response);
			
			
		}catch(DAOException daoe)
		{
			System.out.println(daoe.getMessage());
			
		}catch(Exception e)
		{
			System.out.println(e.getMessage());
			
		}
	
	
	}
	
	
}