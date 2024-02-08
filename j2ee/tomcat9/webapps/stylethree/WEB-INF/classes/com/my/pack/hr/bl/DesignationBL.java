package com.my.pack.hr.bl;
import com.my.pack.hr.dl.*;
import com.my.pack.hr.beans.*;
import java.util.*;

public class DesignationBL
{
public List<DesignationBean> getAll()
{
List<DesignationBean> designations=new LinkedList<>();
try
{
DesignationDAO designationDAO=new DesignationDAO();
List<DesignationDTO> dlDesignations=designationDAO.getAll();
DesignationBean designationBean;
for(DesignationDTO dlDesignation:dlDesignations)
{
designationBean=new DesignationBean();
designationBean.setTitle(dlDesignation.getTitle());
designationBean.setCode(dlDesignation.getCode());
designations.add(designationBean);
}
}catch(DAOException daoException)
{
System.out.println(daoException.getMessage());
}
return designations;
}//funtion ends

}//class ends 