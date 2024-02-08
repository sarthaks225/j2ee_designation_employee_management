package com.hr.tags;
import com.hr.bl.*;
import javax.servlet.jsp.tagext.*;
import java.io.*;
import java.util.*;
import java.lang.reflect.*;

public class EntityListTagHandler extends BodyTagSupport
{
private String populatorClass;
private String populatorMethod;
private String name;
private int index;
private List list;


public EntityListTagHandler()
{
reset();
}

public void reset()
{
this.populatorClass="";
this.populatorMethod="";
this.name="";
this.list=null;
this.index=0;
}

public void setPopulatorClass(java.lang.String populatorClass)
{
this.populatorClass=populatorClass;
}
public java.lang.String getPopulatorClass()
{
return this.populatorClass;
}
public void setPopulatorMethod(java.lang.String populatorMethod)
{
this.populatorMethod=populatorMethod;
}
public java.lang.String getPopulatorMethod()
{
return this.populatorMethod;
}
public void setName(java.lang.String name)
{
this.name=name;
}
public java.lang.String getName()
{
return this.name;
}

public int doStartTag()
{

if(name==null || name.trim().length()==0) return super.SKIP_BODY;

try
{


Class c=Class.forName(populatorClass);
Object obj=c.newInstance();
Class parameters[]=new Class[0];
Method method=c.getMethod(populatorMethod,parameters);
list=(List)method.invoke(obj);

if(list==null || list.size()==0) return super.SKIP_BODY;

Object bean=list.get(index);

pageContext.setAttribute(name,bean,pageContext.REQUEST_SCOPE);
pageContext.setAttribute("serialNumber",index+1,pageContext.REQUEST_SCOPE);
index++;

}catch(Throwable t)
{
	//some logging act should be done later on (in next styles)
System.out.println(t.getMessage());
return super.SKIP_BODY;

}
return super.EVAL_BODY_INCLUDE;
}

public int doAfterBody()
{

if(list.size()==index) return super.SKIP_BODY;
Object bean=list.get(index);
pageContext.setAttribute(name,bean,pageContext.REQUEST_SCOPE);
pageContext.setAttribute("serialNumber",index+1,pageContext.REQUEST_SCOPE);
index++;

return super.EVAL_BODY_AGAIN;
}

public int doEndTag()
{
reset();
return super.EVAL_PAGE;
}



}