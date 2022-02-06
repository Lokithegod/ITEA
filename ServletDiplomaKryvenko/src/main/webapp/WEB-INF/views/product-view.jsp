<%--
  Created by IntelliJ IDEA.
  User: Hexxer
  Date: 11.01.2022
  Time: 19:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="include/header.jsp"%>
<script src='./static/script/jquery-3.6.0.js'></script>




<c:forEach items="${productList}" var="element">

    <table>
        <tr><td></td><td id="productname">${element.name}</td></tr>
        <tr><td><img src="./static/images/products/${element.id}.png" width="300px" height="100%"/> </td><td>${element.text}</td></tr>
        <tr><td></td><td id="price">${element.price}</td></tr>
        <td><img src='./static/images/minus.jpg' width="15" height="15" onclick="minus(${element.id})"/>
            <input type="text" id='${element.id}' size="2" value="1"/><img src="./static/images/plus.jpg" width="15" height="15" onclick="plus(${element.id})"/>
            <input type="button" value="rent" name="rent"  onclick="rent(${element.id})"/></td>
     <%--   <tr><td></td><td>${element.price}</td><a href ="./cart?id=${element.id}"><input type="button" value="buy" /></a></tr>               --%>


    </table>
    <br>
</c:forEach>
<script>
    function  getName (name) {
        var nameproduct = name;
    }
function minus(id) {
    document.getElementById(id).value = document.getElementById(id).value - 1;
}

function plus(id) {
    document.getElementById(id).value =+document.getElementById(id).value+ +1;
}
function rent(id) {
  //  var nameproduct = name;
   // var priceproduct = price;
    $.ajax({
       // url: './cart',

        url: './cart',
        type: 'POST',
        action: './product',
        //data: {'id': id, 'numberOfProducts' : document.getElementById(id).value},
        data: {'id': id, 'numberOfProducts' :  document.getElementById(id).value},
        success: function(data){
            document.getElementById("span").innerHTML=""+ data;
            alert('ok');
        }
    });

    //alert(  " rented for : "+document.getElementById(id).value + "hours. Price =");

}
</script>


<%@include file="include/footer.jsp"%>
