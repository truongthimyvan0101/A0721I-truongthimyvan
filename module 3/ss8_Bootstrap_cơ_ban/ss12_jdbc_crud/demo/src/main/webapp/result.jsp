<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 1/14/2022
  Time: 5:45 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Title</title>
</head>
<body>
<%
  double numberOne = Double.parseDouble(request.getParameter("numberOne"));
  double numberTwo = Double.parseDouble(request.getParameter("numberTwo"));
  double result = numberOne + numberTwo;
%>
<h2 style="color: blue"><%=result%></h2>
</body>
</html>
