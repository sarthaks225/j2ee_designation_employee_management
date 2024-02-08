package com.hr.tags;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;

public class ModuleTagHandler extends TagSupport
{
private String name;

public ModuleTagHandler()
{
reset();
}

public void reset()
{
this.name="";
}

public void setName(String name)
{
this.name=name;
}
public String getName()
{
return this.name;
}

public int doStartTag()
{

pageContext.setAttribute("HOME",0,PageContext.REQUEST_SCOPE);
pageContext.setAttribute("DESIGNATION",1,PageContext.REQUEST_SCOPE);
pageContext.setAttribute("EMPLOYEE",2,pageContext.REQUEST_SCOPE);

if(name.equalsIgnoreCase("HOME"))
{
pageContext.setAttribute("module",0,pageContext.REQUEST_SCOPE);
}
else if(name.equalsIgnoreCase("DESIGNATiON"))
{
pageContext.setAttribute("module",1,pageContext.REQUEST_SCOPE);
}
else if(name.equalsIgnoreCase("EMPLOYEE"))
{
pageContext.setAttribute("module",2,pageContext.REQUEST_SCOPE);
}
else 
{
pageContext.setAttribute("module",-1,pageContext.REQUEST_SCOPE);
}


return super.SKIP_BODY;
}

public int doEndTag()
{
reset();
return super.EVAL_PAGE;
}


}