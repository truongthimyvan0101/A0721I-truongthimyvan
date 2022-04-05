<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 1/14/2022
  Time: 4:56 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>$Title$</title>
</head>
<body>
<%--  C1:--%>
<%--  <form method="get" action="/sum_servlet">--%>

<%--C2: --%>
<%--  <form method="get" action="/result.jsp">--%>

<%--C3: --%>
<form method="post" action="/sum_servlet">
  <p>Num 1: </p>
  <input type="text" name="numberOne">
  <p>Num 2: </p>
  <input type="text" name="numberTwo">
  <button type="submit">Add</button>
</form>
</body>
</html>

