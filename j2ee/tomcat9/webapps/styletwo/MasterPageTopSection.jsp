<%@taglib uri='WEB-INF/mytags/tmtags.tld' prefix='tm' %>

<tm:Guard>
<jsp:forward page='LoginForm.jsp'/>
</tm:Guard>

<!DOCTYPE HTML>
<html lang='en'>

<head>
<meta charset='utf-8'>
<title>HR Application</title>

<link rel='stylesheet' type='text/css' href='/styletwo/css/styles.css'>

</head>

<body>
<!-- Main container starts here-->
<div class='main-container'>
<!-- Header starts here-->
<div class='header'>

<a href='index.jsp'><img src='/styletwo/images/logo.png'  class='logo'> </a>

<div class='brand-name'>HR Application</div>



<div class='user-panel'>
<img src='/styletwo/images/userlogo.webp' height='55' style='float:left'>
<div class='user-name'>

${userName}
</div>

<div class='logout'>
<a href='/styletwo/logout'>Logout</a>
</div>

</div>

</div>




<!-- Header ends here-->

<!-- Content section starts here-->
<div class='content'>

<!-- left panel starts here -->
<div class='left-panel'>

<tm:If condition='${module==DESIGNATION}'>
<b>Designation</b><br>
</tm:If>

<tm:If condition='${module!=DESIGNATION}'>
<a href='/styletwo/Designations.jsp'>Designations</a><br>
</tm:If>

<tm:If condition='${module==EMPLOYEE}'>
<b>Employees</b><br><br>
</tm:If>

<tm:If condition='${module!=EMPLOYEE}'>
<a href='/styletwo/Employees.jsp'>Employees</a><br><br>
</tm:If>

<tm:If condition='${module!=HOME}'>
<a href='/styletwo/index.jsp'>Home</a>
</tm:If>


</div>
<!-- left panel ends here -->


<!-- right panel starts here -->
<div class='right-panel'>
