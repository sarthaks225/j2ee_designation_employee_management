package com.hr.tags;
import javax.servlet.jsp.tagext.*;
import javax.servlet.jsp.*;
import java.io.*;
import java.util.*;
public class FormIdTagHandler extends TagSupport
{

public FormIdTagHandler()
{
reset();
}

public void reset()
{
	//do nothing
}

public int doStartTag()
{
String formId=UUID.randomUUID().toString();
pageContext.setAttribute(formId,formId,pageContext.SESSION_SCOPE);
JspWriter jspWriter=pageContext.getOut();

try
{
jspWriter.print("<input type='hidden' id='formId' name='formId' value='"+formId+"'>");
}catch(IOException ioe)
{
	//do nothing
}

return super.SKIP_BODY;

}

public int doEndTag()
{
this.reset();
return super.EVAL_PAGE;
}


}