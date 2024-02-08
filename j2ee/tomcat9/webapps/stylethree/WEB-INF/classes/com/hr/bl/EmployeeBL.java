package com.hr.bl;
import com.hr.dl.*;
import com.hr.beans.*;
import java.util.*;
import java.text.*;
public class EmployeeBL
{

public List<EmployeeBean> getAll()
{
EmployeeDAO employeeDAO;
EmployeeBean employeeBean;
List<EmployeeBean> employeesBean=new LinkedList<>();

try
{
employeeDAO=new EmployeeDAO();
List<EmployeeDTO> employeesDTO=employeeDAO.getAll();
SimpleDateFormat simpleDateFormat=new SimpleDateFormat("dd/MM/yyyy");

for(EmployeeDTO employeeDTO:employeesDTO)
{
employeeBean=new EmployeeBean();
employeeBean.setEmployeeId(employeeDTO.getId());
employeeBean.setName(employeeDTO.getName());
employeeBean.setCode(employeeDTO.getCode());
employeeBean.setTitle(employeeDTO.getTitle());
employeeBean.setDateOfBirth(simpleDateFormat.format(employeeDTO.getDateOfBirth()));
employeeBean.setGender(employeeDTO.getGender());
employeeBean.setIsIndian(employeeDTO.getIsIndian());
employeeBean.setBasicSalary(employeeDTO.getBasicSalary().toPlainString());
employeeBean.setPANNumber(employeeDTO.getPANNumber());
employeeBean.setAadharCardNumber(employeeDTO.getAadharCardNumber());

employeesBean.add(employeeBean);

}

}catch(DAOException daoe)
{
System.out.println(daoe.getMessage());
}
return employeesBean;

}


}
