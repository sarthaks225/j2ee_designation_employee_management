package com.hr.servlet;
import java.io.*;
import java.util.*;
import java.math.*;
import com.hr.dl.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.text.*;

public class UpdateEmployee extends HttpServlet
{

public void doGet(HttpServletRequest request,HttpServletResponse response)
{
int employeeId=0;
String name="";
int code=0;
String title;
Date dateOfBirth=null;
String gender="";
String isIndian="";
BigDecimal basicSalary=null;
String panNumber="";
String aadharCardNumber="";

try
{
EmployeeDAO employeeDAO=new EmployeeDAO();
DesignationDAO designationDAO=new DesignationDAO();
PrintWriter pw=response.getWriter();
response.setContentType("text/html");

employeeId=Integer.parseInt(request.getParameter("employeeId"));
name=request.getParameter("name");
code=Integer.parseInt(request.getParameter("designationCode"));
SimpleDateFormat sdf=new SimpleDateFormat("yyyy-mm-dd");
dateOfBirth=sdf.parse(request.getParameter("dateOfBirth"));
gender=request.getParameter("gender");
isIndian=request.getParameter("isIndian");
if(isIndian==null) isIndian="off";
basicSalary=new BigDecimal(request.getParameter("basicSalary"));
panNumber=request.getParameter("panNumber");
aadharCardNumber=request.getParameter("aadharCardNumber");

EmployeeDTO employee=new EmployeeDTO();
EmployeeDTO employeeDTO=null;
List<DesignationDTO> designations;
designations=designationDAO.getAll();

/*validations
1. designaiton code should exist
2. aadhar pan number should not exist
*/

try  // validations ...
{
boolean codeExists,panNumberExists,aadharCardNumberExists;

codeExists=designationDAO.codeExists(code);

try
{
employeeDTO=employeeDAO.getByPANNumber(panNumber);
if(employeeDTO.getId()==employeeId) panNumberExists=false;
else panNumberExists=true;
}catch(DAOException e)
{
panNumberExists=false;
}

try
{
employeeDTO=employeeDAO.getByAadharCardNumber(aadharCardNumber);
if(employeeDTO.getId()==employeeId) aadharCardNumberExists=false;
else aadharCardNumberExists=true;
}catch(DAOException e)
{
aadharCardNumberExists=false;
}


if(codeExists==false || panNumberExists==true || aadharCardNumberExists==true)
{


pw.println("<!DOCTYPE HTML>");
pw.println("<html lang='en'>");
pw.println("<head>");
pw.println("<meta charset='utf-8'>");
pw.println("<title>Update Employee</title>");
pw.println("<script>");
pw.println("function validateForm(frm)");
pw.println("{");
pw.println("var firstInvalidComponent=null;");
pw.println("var valid=true;");
pw.println("var name=frm.name.value.trim();");
pw.println("var nameErrorSection=document.getElementById('nameErrorSection');");
pw.println("nameErrorSection.innerHTML='';");
pw.println("if(name.length==0)");
pw.println("{");
pw.println("nameErrorSection.innerHTML='Name required';");
pw.println("firstInvalidComponent=frm.name;");
pw.println("valid=false;");
pw.println("}");
pw.println("var designationCode=frm.designationCode.value;");
pw.println("var designationCodeErrorSection=document.getElementById('designationCodeErrorSection');");
pw.println("designationCodeErrorSection.innerHTML='';");
pw.println("if(designationCode==-1)");
pw.println("{");
pw.println("designationCodeErrorSection.innerHTML='Designation required';");
pw.println("if(firstInvalidComponent==null) firstInvalidComponent=frm.designationCode;");
pw.println("valid=false;");
pw.println("}");
pw.println("var dateOfBirth=frm.dateOfBirth.value;");
pw.println("var dateOfBirthErrorSection=document.getElementById('dateOfBirthErrorSection');");
pw.println("dateOfBirthErrorSection.innerHTML='';");
pw.println("if(dateOfBirth.length==0)");
pw.println("{");
pw.println("dateOfBirthErrorSection.innerHTML='Date of birth required';");
pw.println("if(firstInvalidComponent==null) firstInvalidComponent=frm.dateOfBirth;");
pw.println("valid=false;");
pw.println("}");
pw.println("var genderErrorSection=document.getElementById('genderErrorSection');");
pw.println("genderErrorSection.innerHTML='';");
pw.println("if(frm.gender[0].checked==false && frm.gender[1].checked==false)");
pw.println("{");
pw.println("genderErrorSection.innerHTML='Select Gender';");
pw.println("valid=false;");
pw.println("}");
pw.println("var basicSalary=frm.basicSalary.value.trim();");
pw.println("var basicSalaryErrorSection=document.getElementById('basicSalaryErrorSection');");
pw.println("basicSalaryErrorSection.innerHTML='';");
pw.println("if(basicSalary.length==0)");
pw.println("{");
pw.println("basicSalaryErrorSection.innerHTML='Salary required';");
pw.println("if(firstInvalidComponent==null) firstInvalidComponent=frm.basicSalary;");
pw.println("valid=false;");
pw.println("}");
pw.println("else");
pw.println("{");
pw.println("var v='0123456789.';");
pw.println("var numberOfDots=0;");
pw.println("for(var i=0; i<basicSalary.length; ++i)");
pw.println("{");
pw.println("if(v.indexOf(basicSalary.charAt(i))==-1)");
pw.println("{");
pw.println("basicSalaryErrorSection.innerHTML='Invalid: only numbers allowed';");
pw.println("valid=false;");
pw.println("if(firstInvalidComponent==null) firstInvalidComponent=frm.basicSalary;");
pw.println("break;");
pw.println("}");
pw.println("if(basicSalary.charAt(i)=='.')");
pw.println("{");
pw.println("if(numberOfDots==1)");
pw.println("{");
pw.println("basicSalaryErrorSection.innerHTML='Invalid: multile . not allowed';");
pw.println("valid=false;");
pw.println("if(firstInvalidComponent==null) firstInvalidComponent=frm.basicSalary;");
pw.println("break;");
pw.println("}");
pw.println("numberOfDots++;");
pw.println("}");
pw.println("}");
pw.println("var dot=basicSalary.indexOf('.');");
pw.println("var numberOfFractions=basicSalary.length-dot-1;");
pw.println("if(dot!=-1 && numberOfFractions>2)");
pw.println("{");
pw.println("basicSalaryErrorSection.innerHTML='Invalid: number of fractions must be less then 3';");
pw.println("valid=false;");
pw.println("if(firstInvalidComponent==null) firstInvalidComponent=frm.basicSalary;");
pw.println("}");
pw.println("}");
pw.println("var panNumber=frm.panNumber.value.trim();");
pw.println("var panNumberErrorSection=document.getElementById('panNumberErrorSection');");
pw.println("panNumberErrorSection.innerHTML='';");
pw.println("if(panNumber.length==0)");
pw.println("{");
pw.println("panNumberErrorSection.innerHTML='PAN Number required';");
pw.println("if(firstInvalidComponent==null) firstInvalidComponent=frm.panNumber;");
pw.println("valid=false;");
pw.println("}");
pw.println("var aadharCardNumber=frm.aadharCardNumber.value.trim();");
pw.println("var aadharCardNumberErrorSection=document.getElementById('aadharCardNumberErrorSection');");
pw.println("aadharCardNumberErrorSection.innerHTML='';");
pw.println("if(aadharCardNumber.length==0)");
pw.println("{");
pw.println("aadharCardNumberErrorSection.innerHTML='Aadhar card required';");
pw.println("if(firstInvalidComponent==null) firstInvalidComponent=frm.aadharCardNumber;");
pw.println("valid=false;");
pw.println("}");
pw.println("if(	firstInvalidComponent!=null)");
pw.println("{");
pw.println("firstInvalidComponent.focus();");
pw.println("}");
pw.println("if(valid==false) return false;");
pw.println("return true;");
pw.println("}");
pw.println("function cancelUpdate()");
pw.println("{");
pw.println("document.getElementById('cancelUpdateForm').submit();");
pw.println("}");
pw.println("</script>");
pw.println("</head>");
pw.println("<body>");
pw.println("<!-- Main container starts here-->");
pw.println("<div style='width:50hw;height:auto;border:1px solid black'>");
pw.println("<!-- Header starts here-->");
pw.println("<div style='margin:5px;width:90hw;height:auto;border:1px solid black'>");
pw.println("<a href='/styleone/index.html'><img src='/styleone/images/logo.png' style='float:left'></a>");
pw.println("<div style='margin-top:7px;margin-bottom:7px; font-size:30pt;'>HR Application</div>");
pw.println("</div>");
pw.println("<!-- Header ends here-->");
pw.println("<!-- Content section starts here-->");
pw.println("<div style='width:50hw; height:70vh; margin:5px; border:1px solid black'>");
pw.println("<!-- left panel starts here -->");
pw.println("<div style='height:65vh;margin:5px;padding:5px; float:left; border:1px solid black'>");
pw.println("<a href='/styleone/designationsView'> Designations</a><br>");
pw.println("<b> Employees</b><br>");
pw.println("<a href='/styleone/index.html'> Home</a><br>");
pw.println("</div>");
pw.println("<!-- left panel ends here -->");
pw.println("<!-- right panel starts here -->");
pw.println("<div style='height:65vh; margin-left:105px;margin-right:5px;margin-top:5px;margin-bottom:5px; padding:5px;border:1px solid black'>");
pw.println("<h1>Employee (Update Employee Module)</h1><br>");
pw.println("<form  method='post' action='/styleone/updateEmployee' onsubmit='return (validateForm(this))'>");
pw.println("<table>");
pw.println("<tr>");

pw.println("<input type='hidden' id='employeeId' name='employeeId' value='"+employeeId+"'>");

pw.println("<td>Name</td>");
pw.println("<td><input type='text' id='name' name='name' maxlength='50' size='36' value='"+name+"'>");
pw.println("&nbsp; <span id='nameErrorSection' style='color:rgb(255, 0, 0)'> </span>");
pw.println("</td>");
pw.println("</tr>");
pw.println("<tr>");
pw.println("<td>Designation </td>");
pw.println("<td><select id='designationCode' name='designationCode'>");
pw.println("<option value='-1'>&lt Select Designation &gt</option>");


for(DesignationDTO designation:designations)
{
title=designation.getTitle();

if(code!=designation.getCode())
{
pw.println("<option value='"+code+"'> "+title+"</option>");
}
else
{
pw.println("<option selected value='"+code+"'> "+title+"</option>");
}
}

pw.println("</select>");
if(codeExists==false)
{
pw.println("&nbsp; <span id='designationCodeErrorSection' style='color:rgb(255, 0, 0)'>Invalid designaion </span>");
}
else
{
pw.println("&nbsp; <span id='designationCodeErrorSection' style='color:rgb(255, 0, 0)'> </span>");
}
pw.println("</td>");
pw.println("</tr>");
pw.println("<tr>");
pw.println("<td>Date of birth</td>");
pw.println("<td><input type='date' id='dateOfBirth' name='dateOfBirth' value='"+sdf.format(dateOfBirth)+"'>");
pw.println("&nbsp; <span id='dateOfBirthErrorSection' style='color:rgb(255, 0, 0)'> </span>");
pw.println("</td>");
pw.println("</tr>");
pw.println("<tr>");
pw.println("<td>Gender</td>");

if(gender.equalsIgnoreCase("m")==true) pw.println("<td> <input checked type='radio'  id='male' name='gender' value='m'> Male");
else pw.println("<td> <input type='radio' id='male' name='gender' value='m'> Male");
if(gender.equalsIgnoreCase("f")==true) pw.println("&nbsp &nbsp <input checked type='radio'  id='female' name='gender' value='f'> Female");
else pw.println("&nbsp &nbsp <input type='radio' id='female' name='gender' value='f'> Female");

pw.println("&nbsp; <span id='genderErrorSection' style='color:rgb(255, 0, 0)'> </span>");
pw.println("</td>");
pw.println("</tr>");
pw.println("<tr>");
 pw.println("<td>Is Indian?</td>");
pw.println("<td>");
if(isIndian.equalsIgnoreCase("on")) pw.println("<input checked type='checkbox' id='isIndian' name='isIndian'>");
else pw.println("<input type='checkbox' id='isIndian' name='isIndian'>");

pw.println("</td>");
pw.println("</tr>");
pw.println("<tr>");
pw.println("<td>Basic Salary </td>");
pw.println("<td><input type='text' id='basicSalary' name='basicSalary' maxlength='10' size='16' style='text-align:right' value='"+basicSalary.toPlainString()+"'>");
pw.println("&nbsp; <span id='basicSalaryErrorSection' style='color:rgb(255, 0, 0)'> </span>");
pw.println("</td>");
pw.println("</tr>");
pw.println("<tr>");
pw.println("<td>PAN Number</td>");
pw.println("<td><input type='text' id='panNumber' name='panNumber' maxlength='15' size='16' value='"+panNumber+"' >");
if(panNumberExists==true) pw.println("&nbsp; <span id='panNumberErrorSection' style='color:rgb(255, 0, 0)'>PAN Number already alloted </span>");
else pw.println("&nbsp; <span id='panNumberErrorSection' style='color:rgb(255, 0, 0)'> </span>");
pw.println("</td>");
pw.println("</tr>");
pw.println("<tr>");
pw.println("<td>Aadhar Card Number</td>");
pw.println("<td><input type='text' id='aadharCardNumber' name='aadharCardNumber' maxlength='15' size='16' value='"+aadharCardNumber+"' >");

if(aadharCardNumberExists==true) pw.println("&nbsp; <span id='aadharCardNumberErrorSection' style='color:rgb(255, 0, 0)'>Aadhar Card Number already alloted</span>");
else pw.println("&nbsp; <span id='aadharCardNumberErrorSection' style='color:rgb(255, 0, 0)'> </span>");
pw.println("</td>");
pw.println("</tr>");
pw.println("<tr>");
pw.println("<td colspan='2'><button type='submit'>Update</button>");
pw.println("&nbsp &nbsp &nbsp<button type='button' onclick='cancelUpdate()'>Cancel</button></td>");
pw.println("</tr>");
pw.println("</table>");
pw.println("</form>");
pw.println("</div>");
pw.println("<!-- right panel ends here -->");
pw.println("</div>");
pw.println("<!-- Content section ends here-->");
pw.println("<!-- footer starts here-->");
pw.println("<div style='width:50hw; height:auto; margin:5px;text-align:center; border:1px solid black'>");
pw.println("&copy; ST Tech 2023-20230");
pw.println("</div>");
pw.println("<!-- footer ends here-->");
pw.println("</div> <!-- Main container ends here-->");
pw.println("<form action='/styleone/employeesView' id='cancelUpdateForm'> </form>");
pw.println("</body>");
pw.println("</html>");



return;


}


}catch(DAOException daoe)
{
System.out.println(daoe.getMessage());
return;
}
	// validations end .....



employee.setId(employeeId);
employee.setName(name);
employee.setCode(code);
employee.setDateOfBirth(dateOfBirth);
employee.setGender(gender);
if(isIndian.equalsIgnoreCase("on"))employee.setIsIndian(true);
else employee.setIsIndian(false);
employee.setBasicSalary(basicSalary);
employee.setPANNumber(panNumber);
employee.setAadharCardNumber(aadharCardNumber);




try
{
employeeDAO.update(employee);


pw.println("<!DOCTYPE HTML>");
pw.println("<html lang='en'>");

pw.println("<head>");
pw.println("<meta charset='utf-8'>");
pw.println("<title>HR Application</title>");
pw.println("</head>");

pw.println("<body>");
pw.println("<!-- Main container starts here-->");
pw.println("<div style='width:50hw;height:auto;border:1px solid black'>");
pw.println("<!-- Header starts here-->");
pw.println("<div style='margin:5px;width:90hw;height:auto;border:1px solid black'>");

pw.println("<img src='/styleone/images/logo.png' style='float:left'>");
pw.println("<div style='margin-top:7px;margin-bottom:7px; font-size:30pt;'>HR Application</div>");

pw.println("</div>");
pw.println("<!-- Header ends here-->");

pw.println("<!-- Content section starts here-->");
pw.println("<div style='width:50hw; height:70vh; margin:5px; border:1px solid black'>");

pw.println("<!-- left panel starts here -->");
pw.println("<div style='height:65vh;margin:5px;padding:5px; float:left; border:1px solid black'>");
pw.println("<a href='/styleone/designationsView'> Designations</a><br>");
pw.println("<a href='/styleone/employeesView'> Employees</a><br>");

pw.println("</div>");
pw.println("<!-- left panel ends here -->");
pw.println("<!-- right panel starts here -->");

pw.println("<div style='height:65vh; margin-left:105px;margin-right:5px;margin-top:5px;margin-bottom:5px; padding:5px;border:1px solid black'>");
pw.println("<h1>Employee Updated</h1><br>");
			//..........changes begin.......

						

pw.println("<form action='/styleone/employeesView'>");
pw.println("<button type='submit'>Ok</button>");
pw.println("</form>");
pw.println("</div>");
pw.println("<!-- right panel ends here -->");


pw.println("</div>");
pw.println("<!-- Content section ends here-->");

pw.println("<!-- footer starts here-->");
pw.println("<div style='width:50hw; height:auto; margin:5px;text-align:center; border:1px solid black'>");
pw.println("&copy; ST Tech 2023-20230");
pw.println("</div>");
pw.println("<!-- footer ends here-->");
pw.println("</div> <!-- Main container ends here-->");

pw.println("</body>");


pw.println("</html>");



}catch(DAOException daoe)
{
System.out.println("2. "+daoe.getMessage());

}





}catch(Exception e)
{
System.out.println("1. "+e.getMessage());

}

}

public void doPost(HttpServletRequest request,HttpServletResponse response)
{
doGet(request,response);
}

}