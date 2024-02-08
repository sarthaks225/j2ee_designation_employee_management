package com.hr.tags;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import javax.servlet.http.*;

public class FormResubmittedTagHandler extends TagSupport
{

public FormResubmittedTagHandler()
{
reset();
}

public void reset()
{
	//do nothing
}

public int doStartTag()
{
HttpServletRequest request=(HttpServletRequest)pageContext.getRequest();
String formId=request.getParameter("formId");

if(formId==null)
{
return super.EVAL_BODY_INCLUDE;
}

String formIdInSession=(String)pageContext.getAttribute(formId,pageContext.SESSION_SCOPE);
if(formIdInSession==null)
{
return super.EVAL_BODY_INCLUDE;
}

if(formIdInSession.equalsIgnoreCase(formId))
{
pageContext.removeAttribute(formId,pageContext.SESSION_SCOPE);
return super.SKIP_BODY;
}
else
{
return super.EVAL_BODY_INCLUDE;
}


}

public int doEndTag()
{
reset();
return super.EVAL_PAGE;
}


}