<jsp:useBean id='errorBean' scope='request' class='com.hr.beans.ErrorBean'/>
<jsp:useBean id='administratorBean' scope='request' class='com.hr.beans.AdministratorBean'/>
<!DOCTYPE HTML>
<html lang='en'>

<head>
<meta charset='utf-8'>
<title>HR Application</title>

<link rel='stylesheet' type='text/css' href='/stylethree/css/styles.css'>

</head>

<body>
<!-- Main container starts here-->
<div class='main-container'>
<!-- Header starts here-->
<div class='header'>

<img src='/stylethree/images/logo.png'  class='logo'>

<div class='brand-name'>HR Application</div>



</div>

<!-- Header ends here-->


<!-- Content section starts here-->
<div class='content'>


<div style='width:40%; height:auto; margin-top:110px ;margin-bottom:140px;margin-left:400px; margin-right:400px; padding:5px;text-align:left; border:2px solid black;'>
<h1> Login</h1><br>
<span class='error'>
<jsp:getProperty name='errorBean' property='error'/>
</span>

<div style=' margin:20px;padding:7px;text-align:center;border:1px white;'>
<form method='post' action='/stylethree/Login.jsp'>
User Name 
<input type='text' id='userName' name='userName' maxlength='15' size='15' value='${administratorBean.userName}'>
<br><br>
Password &nbsp&nbsp
<input type='password' id='password' name='password' maxlength='15' size='15'>
<br><br>
<button type='submit'>Login</button>
</form>

</div>
</div>


</div>
<!-- Content section ends here-->

<!-- footer starts here-->
<!-- footer starts here-->
<div class='footer'>
&copy; ST Tech 2023-20230
</div>
<!-- footer ends here-->
</div> <!-- Main container ends here-->

</body>

</html>