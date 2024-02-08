package com.hr.servlet;
import com.hr.dl.*;
import java.util.*;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class GetEmployeeAddView extends HttpServlet
{
public void doGet(HttpServletRequest request,HttpServletResponse response)
{

try
{
List<DesignationDTO> designations;
DesignationDAO designationDAO;
designationDAO=new DesignationDAO();
designations=designationDAO.getAll();

PrintWriter pw=response.getWriter();
response.setContentType("text/html");


pw.println("<!DOCTYPE HTML>");
pw.println("<html lang='en'>");
pw.println("<head>");
pw.println("<meta charset='utf-8'>");
pw.println("<title>Add Employee</title>");
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
pw.println("function cancelAddition()");
pw.println("{");
pw.println("document.getElementById('cancelAdditionForm').submit();");
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
pw.println("<h1>Employee (Add Employee Module)</h1><br>");
pw.println("<form  method='post' action='/styleone/addEmployee' onsubmit='return (validateForm(this))'>");
pw.println("<table>");
pw.println("<tr>");
pw.println("<td>Name</td>");
pw.println("<td><input type='text' id='name' name='name' maxlength='50' size='36'>");
pw.println("&nbsp; <span id='nameErrorSection' style='color:rgb(255, 0, 0)'> </span>");
pw.println("</td>");
pw.println("</tr>");
pw.println("<tr>");
pw.println("<td>Designation </td>");
pw.println("<td><select id='designationCode' name='designationCode'>");
pw.println("<option value='-1'>&lt Select Designation &gt</option>");

String title;
int code;
for(DesignationDTO designation:designations)
{
title=designation.getTitle();
code=designation.getCode();
pw.println("<option value='"+code+"'> "+title+"</option>");
}

pw.println("</select>");
pw.println("&nbsp; <span id='designationCodeErrorSection' style='color:rgb(255, 0, 0)'> </span>");
pw.println("</td>");
pw.println("</tr>");
pw.println("<tr>");
pw.println("<td>Date of birth</td>");
pw.println("<td><input type='date' id='dateOfBirth' name='dateOfBirth' value='1990-01-01'>");
pw.println("&nbsp; <span id='dateOfBirthErrorSection' style='color:rgb(255, 0, 0)'> </span>");
pw.println("</td>");
pw.println("</tr>");
pw.println("<tr>");
pw.println("<td>Gender</td>");
pw.println("<td> <input type='radio' id='male' name='gender' value='m'> Male");
pw.println("&nbsp &nbsp <input type='radio' id='female' name='gender' value='f'> Female");
pw.println("&nbsp; <span id='genderErrorSection' style='color:rgb(255, 0, 0)'> </span>");
pw.println("</td>");
pw.println("</tr>");
pw.println("<tr>");
pw.println("<td>Is Indian?</td>");
pw.println("<td>");
pw.println("<input type='checkbox' id='isIndian' name='isIndian'>");
pw.println("</td>");
pw.println("</tr>");
pw.println("<tr>");
pw.println("<td>Basic Salary </td>");
pw.println("<td><input type='text' id='basicSalary' name='basicSalary' maxlength='10' size='16' style='text-align:right'>");
pw.println("&nbsp; <span id='basicSalaryErrorSection' style='color:rgb(255, 0, 0)'> </span>");
pw.println("</td>");
pw.println("</tr>");
pw.println("<tr>");
pw.println("<td>PAN Number</td>");
pw.println("<td><input type='text' id='panNumber' name='panNumber' maxlength='15' size='16' >");
pw.println("&nbsp; <span id='panNumberErrorSection' style='color:rgb(255, 0, 0)'> </span>");
pw.println("</td>");
pw.println("</tr>");
pw.println("<tr>");
pw.println("<td>Aadhar Card Number</td>");
pw.println("<td><input type='text' id='aadharCardNumber' name='aadharCardNumber' maxlength='15' size='16' >");
pw.println("&nbsp; <span id='aadharCardNumberErrorSection' style='color:rgb(255, 0, 0)'> </span>");
pw.println("</td>");
pw.println("</tr>");
pw.println("<tr>");
pw.println("<td colspan='2'><button type='submit'>Add</button>");
pw.println("&nbsp &nbsp &nbsp<button type='button' onclick='cancelAddition()'>Cancel</button></td>");
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
pw.println("<form action='/styleone/employeesView' id='cancelAdditionForm'> </form>");
pw.println("</body>");
pw.println("</html>");





}catch(Exception e)
{
System.out.println(e.getMessage());
}


}

public void doPost(HttpServletRequest request,HttpServletResponse response)
{
doGet(request,response);
}


}

