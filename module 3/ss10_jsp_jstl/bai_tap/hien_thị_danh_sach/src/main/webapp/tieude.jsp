<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 1/5/2022
  Time: 7:33 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Detail</title>
</head>
<body>
<table style="width: 500px" border="1">
    <tr>
        <th>Name</th>
        <th>Ngày Sinh</th>
        <th>Địa Chỉ</th>
        <th>Anh</th>
    </tr>
    <c:forEach var="product" items="${productList}">
        <tr>
            <td>${product.name}</td>
            <td> ${product.dateOfBirth}</td>
            <td>${product.address}</td>
        </tr>
    </c:forEach>
</table>

</body>
</html>
