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

<c:choose>
    <c:when test="${insert =='true'}">
        ${registration_message}. Welcome!
    </c:when>
    <c:otherwise>
<form id="registrationform" action="registration" method="post">
    <table>
        <tr><td>login</td><td><input type='text' name='login' /></td></tr>
        <tr><td>password</td><td><input type='password' name='password'/></td></tr>
        <tr><td>re-password</td><td><input type='password' name='re_password'/></td></tr>
        <tr><td>name</td><td><input type='text' name='name'/></td></tr>
        <tr><td>gender</td><td>M<input type='radio' name='gender' value='male'/>F<input type='radio' name='gender' value='female' /></td></tr>
        <tr><td>email</td><td><input type='text' name='email'/></td></tr>
        <tr><td>address</td><td><select  name='address' >
            <option value='DNR'>DNR</option>
            <option value='LNR'>LNR</option>
            <option value='Crimea'>Crimea</option>
        </select>
        </td></tr>
        <tr><td>i agree to instal amigobrowser</td><td><input type='checkbox' name='agree' /></td></tr>
        <tr><td></td><td><input type='submit' value='SEND' formaction="registration"/></td></tr>
        <tr><td>${registration_message}</td></tr>

        <!--<tr><td>name</td><td><input type='text' name='name' /></td></tr>


            <input type='submit' value='SEND' />-->
    </table>
</form>
    </c:otherwise>
</c:choose>
</body>
</html>


<%@include file="include/footer.jsp"%>
