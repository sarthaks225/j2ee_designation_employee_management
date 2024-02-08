package com.hr.beans;
import java.math.*;
import java.util.*;

public class EmployeeBean implements java.io.Serializable
{
private int employeeId;
private String name;
private int code;
private String title;
private String dateOfBirth;
private String gender;
private boolean isIndian;
private String basicSalary;
private String panNumber;
private String aadharCardNumber;

public EmployeeBean()
{
this.employeeId=0;
this.name="";
this.code=0;
this.title="";
this.dateOfBirth=null;
this.gender="";
this.isIndian=false;
this.basicSalary=null;
this.panNumber="";
this.aadharCardNumber="";
}
public void setEmployeeId(int employeeId)
{
this.employeeId=employeeId;
}
public int getEmployeeId()
{
return this.employeeId;
}

public void setId(int employeeId)
{
this.employeeId=employeeId;
}
public int getId()
{
return this.employeeId;
}

public void setName(java.lang.String name)
{
this.name=name;
}
public java.lang.String getName()
{
return this.name;
}
public void setCode(int code)
{
this.code=code;
}
public int getCode()
{
return this.code;
}
public void setTitle(java.lang.String title)
{
this.title=title;
}
public java.lang.String getTitle()
{
return this.title;
}
public void setDateOfBirth(String dateOfBirth)
{
this.dateOfBirth=dateOfBirth;
}
public String getDateOfBirth()
{
return this.dateOfBirth;
}
public void setGender(java.lang.String gender)
{
this.gender=gender;
}

public boolean isMale()
{
return this.gender.equalsIgnoreCase("m");
}
public boolean isFemale()
{
return this.gender.equalsIgnoreCase("f");
}


public java.lang.String getGender()
{
return this.gender;
}
public void setIsIndian(boolean isIndian)
{
this.isIndian=isIndian;
}
public boolean getIsIndian()
{
return this.isIndian;
}
public void setBasicSalary(String basicSalary)
{
this.basicSalary=basicSalary;
}
public String getBasicSalary()
{
return this.basicSalary;
}
public void setPANNumber(java.lang.String panNumber)
{
this.panNumber=panNumber;
}
public java.lang.String getPANNumber()
{
return this.panNumber;
}
public void setAadharCardNumber(java.lang.String aadharCardNumber)
{
this.aadharCardNumber=aadharCardNumber;
}
public java.lang.String getAadharCardNumber()
{
return this.aadharCardNumber;
}



}