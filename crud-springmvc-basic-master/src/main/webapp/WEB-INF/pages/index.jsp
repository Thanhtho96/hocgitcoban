<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%--
  Created by IntelliJ IDEA.
  User: DangKhoa
  Date: 4/20/2018
  Time: 2:12 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <h1>Add member</h1>


    <table border="2" width="70%" cellpadding="2">
        <tr>
            <th>Id</th>
            <th>Name</th>
            <th>Salary</th>
            <th>Designation</th>
        </tr>
        <c:forEach var="employee" items="${employees}">
            <tr>
                <td>${employee.id}</td>
                <td>${employee.name}</td>
                <td>${employee.salary}</td>
                <td>${employee.designation}</td>
            </tr>
        </c:forEach>
    </table>

    <form:radiobuttons path="members" items="${members}"/>
    <a href="/home/testparam?mvc">param</a><a href="/home/scope">Scope</a>
</body>
</html>
