package com.hr.beans;
public class AdministratorBean implements java.io.Serializable
{
private String userName;
private String password;

public AdministratorBean()
{
userName="";
password="";
}
public void setUserName(String userName)
{
this.userName=userName;
}

public void setPassword(String password)
{
this.password=password;
}

public String getUserName()
{
return this.userName;
}

public String getPassword()
{
return this.password;
}


}