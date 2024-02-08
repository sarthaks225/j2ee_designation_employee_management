package com.hr.tags;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.util.*;
import com.hr.beans.*;
import com.hr.dl.*;



public class DesignationsTagHandler extends BodyTagSupport
{
private List<DesignationBean> designationBeans;
int index;

public DesignationsTagHandler()
{
reset();
}

public void reset()
{

index=0;
if(designationBeans!=null)
{
designationBeans.clear();
designationBeans=null;
}

}


public int doStartTag()
{
List<DesignationDTO> dlDesignations;
try
{
dlDesignations=(new DesignationDAO()).getAll();
}catch(DAOException daoe)
{
return super.SKIP_BODY;
}

if(dlDesignations.size()==0) return SKIP_BODY;
designationBeans=new ArrayList<>();
DesignationBean designationBean;
for(DesignationDTO designationDTO:dlDesignations)
{
designationBean=new DesignationBean();
designationBean.setCode(designationDTO.getCode());
designationBean.setTitle(designationDTO.getTitle());
designationBeans.add(designationBean);
}

index=0;
designationBean=designationBeans.get(index);

pageContext.setAttribute("designationBean",designationBean,pageContext.REQUEST_SCOPE);
pageContext.setAttribute("serialNumber",(index+1),pageContext.REQUEST_SCOPE);
index++;

return EVAL_BODY_INCLUDE;
}

public int doAfterBody()
{

if(index==designationBeans.size())
{
return SKIP_BODY;
}

DesignationBean designationBean;
designationBean=designationBeans.get(index);
pageContext.setAttribute("designationBean",designationBean,pageContext.REQUEST_SCOPE);
pageContext.setAttribute("serialNumber",(index+1),pageContext.REQUEST_SCOPE);
index++;
return EVAL_BODY_AGAIN;
}


public int doEndTag()
{
reset();
return EVAL_PAGE;

}




}