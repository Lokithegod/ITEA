<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
</div>



<div id="sidebar">
    <table border=1>
        <tr>
            <td width="252" align="left">
                <font color=white>
                    Вы авторизировались как ${user_name} <br />
                    В вашей корзине :<span id="span">
                    <c:choose>
                    <c:when test="${numberOfProducts== null}">
                        0
                    </c:when>
                    <c:otherwise>
                        ${numberOfProducts}
                    </c:otherwise>
                </c:choose></span> товаров.
                </font>
            </td>
        </tr>
    </table>
    <h2>Боковое меню</h2>
    <ul>
        <li><a href="./product?category=crossover">Sport Crossower</a></li>
        <li><a href="./product?category=sedan">Sport Car</a></li>
        <li><a href="./product?category=boost">Boosted Cars</a></li>
        <li><a href="registration.php">Регистрация</a></li>
        <li><a href="login.php">Вход</a></li>
        <li><a href="cart.php">Корзина</a></li>
    </ul>
</div>
</div>
</div>
</div>
</div>
<div id="footer">
    <p>Copyright (c) by Бондаренко Антон</p>
</div>
<!-- end #footer -->
</body>
</html>