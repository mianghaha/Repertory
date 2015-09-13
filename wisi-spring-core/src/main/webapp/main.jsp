<%@ page language="java" pageEncoding="utf-8"%>
<%@ page isELIgnored="false"%> 
<!DOCTYPE HTML>
<html>
<head>
    <title>Account Manager</title>
	<meta http-equiv=Content-Type content="text/html;charset=utf-8">	
</head>

<body>
<script language="javascript">
var str = document.location.href;
str = str.replace("Index.html","");
str = str + "login/index.html";
alert(str);
document.location.href = str;
</script>
</body>
</html>
