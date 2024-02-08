<%@taglib uri='WEB-INF/mytags/tmtags.tld' prefix='tm' %>

<tm:Guard>
<jsp:forward page='LoginForm.jsp'/>
</tm:Guard>

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



<div class='user-panel'>
<img src='/stylethree/images/userlogo.webp' height='55' style='float:left'>
<div class='user-name'>

${userName}
</div>

<div class='logout'>
<a href='/stylethree/logout'>Logout</a>
</div>

</div>

</div>




<!-- Header ends here-->

<!-- Content section starts here-->
<div class='content'>

<!-- left panel starts here -->
<div id='leftPanel' class='left-panel'>




</div>
<!-- left panel ends here -->


<!-- right panel starts here -->
<div id='rightPanel' class='right-panel'>
