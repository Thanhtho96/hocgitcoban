<%--
  Created by IntelliJ IDEA.
  User: DangKhoa
  Date: 4/21/2018
  Time: 10:41 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>All Scope</title>
</head>
<body>
    <h2>Test Scope </h2>
    EL: ${status}<br>
    Request: ${requestScope.status}<br>
    Session: ${sessionScope.status}<br>
    Application: ${applicationScope.status}<br>
</body>
</html>
