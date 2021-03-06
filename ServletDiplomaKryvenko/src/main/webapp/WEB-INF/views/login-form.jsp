<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="include/header.jsp"%>
<script src='./static/script/jquery-3.6.0.js'></script>


<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<title></title>
	<meta charset="UTF-8" />
	<link href="./static/css/style.css" rel="stylesheet" />
</head>

<body>

<form id="loginForm" action="login" method="post">

	<div class="field">
		<label>Enter your login:</label>
		<div class="input"><input type="text" name="login" value="${login}" /></div>
	</div>
	<div class="field">
		<a href="#" id="forgot">Forgot your password?</a>
		<label>Enter your password:</label>
		<div class="input"><input type="password" name="pass" value="${pass}"  /></div>
	</div>
	<div class="submit">
		<button type="submit" formaction="login">Enter</button>
		<label id="remember"><input name="" type="checkbox" value="" /> Remember me</label>
	</div>

</form>

${message}
</body>
</html>


<%@include file="include/footer.jsp"%>
