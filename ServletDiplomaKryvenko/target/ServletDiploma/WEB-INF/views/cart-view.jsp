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
<%--<c:forEach var="type" items="${productMap}">
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
    </c:forEach>    --%>

<c:forEach items="${productsListInCart}" var="element">

    <table>
        <tr><td></td><td id="productname">${element.name}</td></tr>
        <tr><td><img src="./static/images/products/${element.id}.png" width="300px" height="100%"/> </td><td>${element.text}</td></tr>
        <tr><td></td><td id="price">${element.price}</td></tr>
            <%--   <tr><td></td><td>${element.price}</td><a href ="./cart?id=${element.id}"><input type="button" value="buy" /></a></tr>               --%>


    </table>
    <br>
</c:forEach>

<input type="button" value="Заказать" onclick="get()"/>



</body>
</html>
<script>
    function get(json)
    {
        var obj = JSON.parse(json);
        return obj.id;
    }

</script>

<%@include file="include/footer.jsp"%>
