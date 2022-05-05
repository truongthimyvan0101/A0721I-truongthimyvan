<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: PC
  Date: 06/12/2021
  Time: 8:23 SA
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Setting</title>
</head>
<body>
<h1>Setting</h1>
<table border="1">
    <tr>
        <th>ID</th>
        <th>Language</th>
        <th>Size</th>
        <th>Spam</th>
        <th>Signature</th>
    </tr>
    <c:forEach items="${settings}" var="setting">
        <tr>
            <td>${setting.id}</td>
            <td>${setting.language}</td>
            <td>${setting.size}</td>
            <td>${setting.spam}</td>
            <td>${setting.signature}</td>
            <td>
                <a href="${pageContext.request.contextPath}/setting/view/${setting.id}">View</a>
            </td>
        </tr>
    </c:forEach>

</table>
</body>
</html>
