package com.hr.tags;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;


public class GuardTagHandler extends TagSupport
{

public GuardTagHandler()
{
reset();
}

public void reset()
{
	//do nothing
}

public int doStartTag()
{


String userName=(String)pageContext.getAttribute("userName",pageContext.SESSION_SCOPE);
if(userName==null)
{
return super.EVAL_BODY_INCLUDE;
}
return super.SKIP_BODY;
}


public int doEndTag()
{
this.reset();
return super.EVAL_PAGE;
}


}