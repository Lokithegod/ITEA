<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="include/header.jsp"%>
<script src='./static/script/jquery-3.6.0.js'></script>

<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <title>Cart</title>
    <link href="style.css" rel="stylesheet" type="text/css" media="screen" />
    <script type="text/javascript" src="jquery-1.6.2.min.js"></script>
    <script type="text/javascript" src="jquery.poptrox-0.1.js"></script>
</head>
<body>
<c:forEach var="type" items="${productMap}">
    <table>

        <script>
            var id  = getIdFromJson(${type.key});
            //var name
            //var price
            //var count
        </script>
        <tr><td></td><img src="./static/images/products/${id}.png"/><td></td></tr>
        <tr><td></td>  Key is ${type.key}<td></td></tr>
        <tr><td></td> Value is ${type.value}<td></td></tr>


    </table>
    </c:forEach>

</body>
</html>
<script>
    function getIdFromJson(json)
    {
        var obj = JSON.parse(json);
        return obj.id;
    }

</script>

<%@include file="include/footer.jsp"%>
