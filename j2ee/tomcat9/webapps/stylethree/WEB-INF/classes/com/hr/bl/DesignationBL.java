package com.hr.bl;
import com.hr.dl.*;
import com.hr.beans.*;
import java.util.*;

public class DesignationBL
{

public List<DesignationBean> getAll()
{
DesignationDAO designationDAO;
List<DesignationDTO> designationsDTO;
DesignationBean designationBean;
List<DesignationBean> designationsBean=new LinkedList<>();

try
{
designationDAO=new DesignationDAO();
designationsDTO=designationDAO.getAll();

for(DesignationDTO designationDTO:designationsDTO)
{
designationBean=new DesignationBean();
designationBean.setCode(designationDTO.getCode());
designationBean.setTitle(designationDTO.getTitle());
designationsBean.add(designationBean);
}


}catch(DAOException daoe)
{

System.out.println(daoe.getMessage());
}

return designationsBean;
}



}