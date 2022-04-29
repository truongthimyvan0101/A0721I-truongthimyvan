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
<c:forEach items="${settings}" var="settings">
    <table>
        <tr>
            <th>Signature</th>
            <th>Language</th>
            <th>Size</th>
            <th>Spam</th>
            <th>Detail</th>
        </tr>
        <tr>
            <td>${settings.signature}</td>
            <td>${settings.language}</td>
            <td>${settings.size}</td>
            <td>${settings.spam}</td>
            <td><a href="/update?signature=${setting.signature}">Update</a></td>
        </tr>
    </table>
</c:forEach>
</body>
</html>
