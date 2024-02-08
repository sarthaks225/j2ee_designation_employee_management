package com.my.pack.hr.bl;
import com.my.pack.hr.dl.*;
import com.my.pack.hr.beans.*;
import java.util.*;
import java.text.*;

public class EmployeeBL
{
public List<EmployeeBean> getAll()
{
List<EmployeeBean> employees=new LinkedList<>();
try
{
EmployeeDAO employeeDAO=new EmployeeDAO();
List<EmployeeDTO> dlEmployees=employeeDAO.getAll();
EmployeeBean employeeBean;
SimpleDateFormat simpleDateFormat=new SimpleDateFormat("dd/MM/yyyy");
for(EmployeeDTO dlEmployee:dlEmployees)
{
employeeBean=new EmployeeBean();
employeeBean.setName(dlEmployee.getName());
employeeBean.setEmployeeId(dlEmployee.getEmployeeId());
employeeBean.setGender(dlEmployee.getGender());
employeeBean.setDesignationCode(dlEmployee.getDesignationCode());
employeeBean.setDesignation(dlEmployee.getDesignation());
employeeBean.setDateOfBirth(simpleDateFormat.format(dlEmployee.getDateOfBirth()));
employeeBean.setIsIndian(dlEmployee.getIsIndian());
employeeBean.setBasicSalary(dlEmployee.getBasicSalary().toPlainString());
employeeBean.setAadharCardNumber(dlEmployee.getAadharCardNumber());
employeeBean.setPanNumber(dlEmployee.getPANNumber());
employeeBean.setName(dlEmployee.getName());

employees.add(employeeBean);
}
}catch(DAOException daoException)
{
System.out.println(daoException.getMessage());
}
return employees;
}//funtion ends

}//class ends 