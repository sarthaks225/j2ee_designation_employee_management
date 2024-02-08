package com.hr.servlet;
import java.io.*;
import java.util.*;
import com.hr.dl.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class ConfirmDeleteEmployee extends HttpServlet
{
public void doGet(HttpServletRequest request,HttpServletResponse response)
{

try
{
int id=0;
PrintWriter pw=response.getWriter();
response.setContentType("text/html");
try
{
id=Integer.parseInt(request.getParameter("employeeId"));
}catch(NumberFormatException nfe)
{
	sendBackViewPage(response);
	return;
}

EmployeeDAO employeeDAO;
try
{

employeeDAO=new EmployeeDAO();
EmployeeDTO employeeDTO=employeeDAO.getById(id);


pw.println("<!DOCTYPE HTML>");
pw.println("<html lang='en'>");

pw.println("<head>");
pw.println("<meta charset='utf-8'>");
pw.println("<title>Delete Employee</title>");

pw.println("<script>");

pw.println("function cancelDeletion()");
pw.println("{");
pw.println("document.getElementById('cancelDeletionForm').submit();");
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

pw.println("<h1>Designation (Delete Module)</h1><br>");
pw.println("<form method='post' action='/styleone/deleteEmployee'>");
pw.println("<input type='hidden' id='employeeId' name='employeeId' value='"+id+"' >");
pw.println("<br>");
pw.println("<b>Are you want to delete employee?</b><br>");
pw.println("<button type='submit'>Yes</button>");
pw.println("<button type='button' onclick='cancelDeletion()'>NO</button>");
pw.println("</form>");

pw.println("<br>");
pw.println("Name : <b>"+employeeDTO.getName()+"</b><br>");
pw.println("Designation : <b>"+employeeDTO.getTitle()+"</b><br>");
pw.println("Date of birth : <b>"+employeeDTO.getDateOfBirth()+"</b><br>");
pw.println("Gender : <b>"+employeeDTO.getGender()+"</b><br>");
if(employeeDTO.getIsIndian()==true) pw.println("Nationality : <b>Indian</b><br>");
else pw.println("Nationality : <b>Not an Indian</b><br>");
pw.println("Basic Salary : <b>"+employeeDTO.getBasicSalary()+"</b><br>");
pw.println("PAN Number : <b>"+employeeDTO.getPANNumber()+"</b><br>");
pw.println("Aadhar Card Number : <b>"+employeeDTO.getAadharCardNumber()+"</b><br>");



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

pw.println("<form action='/styleone/employeesView' id='cancelDeletionForm'> </form>");

pw.println("</body>");


pw.println("</html>");




}catch(DAOException e)
{
 sendBackViewPage(response);
	return;

}


}catch(Exception e)
{
System.out.println(e.getMessage());
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