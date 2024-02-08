package com.hr.servlet;
import com.hr.dl.*;
import java.util.*;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.math.*;
import java.text.*;
public class EditEmployee extends HttpServlet
{
public void doGet(HttpServletRequest request,HttpServletResponse response)
{

try
{
List<DesignationDTO> designations;
DesignationDAO designationDAO;
designationDAO=new DesignationDAO();
designations=designationDAO.getAll();

EmployeeDAO employeeDAO=new EmployeeDAO();

PrintWriter pw=response.getWriter();
response.setContentType("text/html");
int id;
try
{
id=Integer.parseInt(request.getParameter("employeeId"));
}catch(NumberFormatException nfe)
{
sendBackViewPage(response);
return;
}

EmployeeDTO employee=employeeDAO.getById(id);
String name=employee.getName();
int designationCode=employee.getCode();
String designationTitle=employee.getTitle();
java.util.Date dateOfBirth=employee.getDateOfBirth();
String gender=employee.getGender();
boolean isIndian=employee.getIsIndian();
BigDecimal basicSalary=employee.getBasicSalary();
String panNumber=employee.getPANNumber();
String aadharCardNumber=employee.getAadharCardNumber();


pw.println("<!DOCTYPE HTML>");
pw.println("<html lang='en'>");
pw.println("<head>");
pw.println("<meta charset='utf-8'>");
pw.println("<title>Edit Employee</title>");
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
pw.println("<h1>Employee (Edit Employee Module)</h1><br>");
pw.println("<form  method='post' action='/styleone/updateEmployee' onsubmit='return (validateForm(this))'>");
pw.println("<table>");
pw.println("<tr>");
pw.println("<input type='hidden' id='employeeId' name='employeeId' value='"+id+"'>");
pw.println("<td>Name</td>");		
pw.println("<td><input type='text' id='name' name='name' maxlength='50' size='36' value='"+name+"'>");
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
if(code==designationCode) pw.println("<option selected value='"+code+"'> "+title+"</option>");
else pw.println("<option value='"+code+"'> "+title+"</option>");
}

pw.println("</select>");
pw.println("&nbsp; <span id='designationCodeErrorSection' style='color:rgb(255, 0, 0)'> </span>");
pw.println("</td>");
pw.println("</tr>");
pw.println("<tr>");
pw.println("<td>Date of birth</td>");
SimpleDateFormat sdf=new SimpleDateFormat("yyyy-mm-dd");
pw.println("<td><input type='date' id='dateOfBirth' name='dateOfBirth' value='"+dateOfBirth+"'>");
pw.println("&nbsp; <span id='dateOfBirthErrorSection' style='color:rgb(255, 0, 0)'> </span>");
pw.println("</td>");
pw.println("</tr>");
pw.println("<tr>");
pw.println("<td>Gender</td>");
if(gender.equalsIgnoreCase("M")==true) pw.println("<td> <input checked type='radio' id='male' name='gender' value='m'> Male");
else pw.println("<td> <input type='radio' id='male' name='gender' value='m'> Male");
if(gender.equalsIgnoreCase("F")==true) pw.println("&nbsp &nbsp <input checked type='radio' id='female' name='gender' value='f'> Female");
else pw.println("&nbsp &nbsp <input type='radio' id='female' name='gender' value='f'> Female");

pw.println("&nbsp; <span id='genderErrorSection' style='color:rgb(255, 0, 0)'> </span>");
pw.println("</td>");
pw.println("</tr>");
pw.println("<tr>");
pw.println("<td>Is Indian?</td>");
pw.println("<td>");
if(isIndian==true) pw.println("<input checked type='checkbox' id='isIndian' name='isIndian'>");
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
pw.println("<td><input type='text' id='panNumber' name='panNumber' maxlength='15' size='16' value='"+panNumber+"'>");
pw.println("&nbsp; <span id='panNumberErrorSection' style='color:rgb(255, 0, 0)'> </span>");
pw.println("</td>");
pw.println("</tr>");
pw.println("<tr>");
pw.println("<td>Aadhar Card Number</td>");
pw.println("<td><input type='text' id='aadharCardNumber' name='aadharCardNumber' maxlength='15' size='16' value='"+aadharCardNumber+"'>");
pw.println("&nbsp; <span id='aadharCardNumberErrorSection' style='color:rgb(255, 0, 0)'> </span>");
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





}catch(Exception e)
{
sendBackViewPage(response);
}


}

public void doPost(HttpServletRequest request,HttpServletResponse response)
{
doGet(request,response);
}


private void sendBackViewPage(HttpServletResponse response)
{


EmployeeDTO employeeDTO;
EmployeeDAO employeeDAO;
List<EmployeeDTO> employeesDTO;



try
{
PrintWriter pw;
employeeDAO=new EmployeeDAO();
employeesDTO=employeeDAO.getAll();

pw=response.getWriter();
response.setContentType("text/html");


pw.println("<!DOCTYPE HTML>");
pw.println("<html lang='en'>");
pw.println("<head>");
pw.println("<meta charset='utf-8'>");
pw.println("<title>Employee View</title>");
pw.println("<script>");
pw.println("function Employee()");
pw.println("{");
pw.println("this.employeeId=0;");
pw.println("this.name=\"\";");
pw.println("this.designationCode=0;");
pw.println("this.designation=\"\";");
pw.println("this.dateOfBirth=\"\";");
pw.println("this.gender=\"\";");
pw.println("this.isIndian=true;");
pw.println("this.basicSalary=0;");
pw.println("this.panNumber=\"\";");
pw.println("this.aadharCardNumber=\"\";");
pw.println("}");

pw.println("var rowSelected=null;");
pw.println("var employees=[];");

for(int i=0; i<employeesDTO.size(); ++i)
{
employeeDTO=employeesDTO.get(i);
pw.println("var employee=new Employee();");
pw.println("employee.employeeId"+"="+employeeDTO.getId()+";");
pw.println("employee.name"+"='"+employeeDTO.getName()+"';");
pw.println("employee.designationCode"+"='"+employeeDTO.getCode()+"';");
pw.println("employee.designation"+"='"+employeeDTO.getTitle()+"';");
pw.println("employee.dateOfBirth"+"='"+employeeDTO.getDateOfBirth()+"';");
pw.println("employee.gender"+"='"+employeeDTO.getGender()+"';");
pw.println("employee.isIndian"+"="+employeeDTO.getIsIndian()+";");
pw.println("employee.basicSalary"+"="+employeeDTO.getBasicSalary()+";");
pw.println("employee.panNumber"+"='"+employeeDTO.getPANNumber()+"';");
pw.println("employee.aadharCardNumber"+"='"+employeeDTO.getAadharCardNumber()+"';");
pw.println("employees["+i+"]"+"=employee;");
}

pw.println("function selectEmployee(row,employeeId)");
pw.println("{");

pw.println("if(rowSelected!=null)");
pw.println("{");
pw.println("rowSelected.style.background='white';");
pw.println("rowSelected.style.color='black';");
pw.println("}");
pw.println("rowSelected=row;");
pw.println("row.style.background='#D9A190';");
pw.println("row.style.color='#000E3C';");
pw.println("for(var i=0; i<employees.length; ++i)");
pw.println("{");
pw.println("if(employees[i].employeeId==employeeId)");
pw.println("{");
pw.println("break;");
pw.println("}");
pw.println("}");
pw.println("var emp=employees[i];");
pw.println("document.getElementById('detailPanel_employeeId').innerHTML=employees[i].employeeId;");
pw.println("document.getElementById('detailPanel_name').innerHTML=employees[i].name;");
pw.println("document.getElementById('detailPanel_designation').innerHTML=employees[i].designation;");
pw.println("document.getElementById('detailPanel_dateOfBirth').innerHTML=employees[i].dateOfBirth;");
pw.println("document.getElementById('detailPanel_gender').innerHTML=employees[i].gender;");
pw.println("if(emp.isIndian) document.getElementById('detailPanel_isIndian').innerHTML=\"Yes\";");
pw.println("else document.getElementById('detailPanel_isIndian').innerHTML=\"NO\";");
pw.println("document.getElementById('detailPanel_basicSalary').innerHTML=employees[i].basicSalary;");
pw.println("document.getElementById('detailPanel_panNumber').innerHTML=employees[i].panNumber;");
pw.println("document.getElementById('detailPanel_aadharCardNumber').innerHTML=employees[i].aadharCardNumber;");
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
pw.println("<b>Employees</b><br>");
pw.println("<a href='/styleone/index.html'> Home</a><br>");
pw.println("</div>");
pw.println("<!-- left panel ends here -->");
pw.println("<!-- right panel starts here -->");
pw.println("<div style='height:65vh; margin-left:105px;margin-right:5px;margin-top:5px;margin-bottom:5px; padding:5px; border:1px solid black'>");
pw.println("<div style='height:40vh; margin-left:15px;margin-right:10px;margin-top:5px;margin-bottom:5px; padding:5px; overflow:scroll;border:1px solid black'>");
pw.println("<table border='1'>");
pw.println("<thead>");
pw.println("<tr>");
pw.println("<th colspan='6' style='text-align:right; padding:5px'>");
pw.println("<a href='/styleone/getEmployeeAddForm'>Add New Employee<a>");
pw.println("</th>");
pw.println("</tr>");
pw.println("<tr>");
pw.println("<th style='width:80px;text-align:center'>S.No</th>");
pw.println("<th style='width:150px;text-align:center'>Employee Id</th>");
pw.println("<th style='width:150px;text-align:center'>Employee Name</th>");
pw.println("<th style='width:150px;text-align:center'>Designation</th>");
pw.println("<th style='width:100px;text-align:center'>Edit</th>");
pw.println("<th style='width:100px;text-align:center'>Delete</th>");
pw.println("</tr>");
pw.println("</thead>");
pw.println("<tbody>");

for(int i=0,j=1; i<employeesDTO.size(); ++i,++j)
{
employeeDTO=employeesDTO.get(i);
pw.println("<tr style='cursor:pointer;' onclick='selectEmployee(this,"+employeeDTO.getId()+")'>");
pw.println("<td style='text-align:right'>"+j+".</td>");
pw.println("<td style='text-align:center'>"+employeeDTO.getId()+"</td>");
pw.println("<td style='text-align:center'>"+employeeDTO.getName()+"</td>");
pw.println("<td style='text-align:center'>"+employeeDTO.getTitle()+"</td>");
pw.println("<td style='text-align:center'><a href='/styleone/editEmployee?employeeId="+employeeDTO.getId()+"'>edit</a></td>");
pw.println("<td style='text-align:center'><a href='/styleone/confirmDeleteEmployee?employeeId="+employeeDTO.getId()+"'>delete</a></td>");
pw.println("</tr>");
}

pw.println("</tbody>");
pw.println("</table>");
pw.println("</div>");
pw.println("<div style='height:20vh; margin-left:15px;margin-right:10px;margin-top:5px;margin-bottom:5px; padding:5px; border:1px solid black'>");
pw.println("<label style='margin-left:50px; font-size:20px; background:#8D7171; color:white; padding-left:10px; padding-right:10px'>Details</label>");
pw.println("<table border='0' width='100%' style='padding:0px; margin-top:25px'>");
pw.println("<tr>");
pw.println("<td>Employee ID : <span id='detailPanel_employeeId' style='margin-right:30px'></span></td>");
pw.println("<td>Name : <span id='detailPanel_name' style='margin-right:30px'></span></td>");
pw.println("<td>Designation : <span id='detailPanel_designation' style='margin-right:30px'></span></td>");
pw.println("</tr>");
pw.println("<tr>");
pw.println("<td>Date Of Birth : <span id='detailPanel_dateOfBirth' style='margin-right:30px'></span></td>");
pw.println("<td>Gender : <span id='detailPanel_gender' style='margin-right:30px'></span></td>");
pw.println("<td>Is Indian : <span id='detailPanel_isIndian' style='margin-right:30px'></span></td>");
pw.println("</tr>");
pw.println("<tr>");
pw.println("<td>Salary : <span id='detailPanel_basicSalary' style='margin-right:30px'></span></td>");
pw.println("<td>PAN Number: <span id='detailPanel_panNumber' style='margin-right:30px'></span></td>");
pw.println("<td>Aadhar Card Number: <span id='detailPanel_aadharCardNumber' style='margin-right:30px'></span></td>");
pw.println("</tr>");
pw.println("</table>");
pw.println("</div>");
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





}catch(Exception e)
{
System.out.println("Exception invoked form employeesView");
System.out.println(e.getMessage());
}

}

}

