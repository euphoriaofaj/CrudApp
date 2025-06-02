<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 5/28/2025
  Time: 2:17 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Users</title>
</head>
<body>
<h2>User Form</h2>
<%--@elvariable id="newUser" type="newUser"--%>
<form:form modelAttribute="newUser" method="post" action="${pageContext.request.contextPath}/users">
    <form:hidden path="id"/>
    <p>First Name: <form:input path="firstName"/></p>
    <p>Last Name: <form:input path="lastName"/></p>
    <p>Email: <form:input path="email"/></p>
    <input type="submit" value="Save"/>
</form:form>

<h2>All Users</h2>
<table border="1">
    <tr>
        <th>ID</th><th>First Name</th><th>Last Name</th><th>Email</th><th>Actions</th>
    </tr>
    <c:forEach items="${users}" var="user">
        <tr>
            <td>${user.id}</td>
            <td>${user.firstName}</td>
            <td>${user.lastName}</td>
            <td>${user.email}</td>
            <td>
                <a href="${pageContext.request.contextPath}/users/edit/${user.id}">Edit</a>
                <a href="${pageContext.request.contextPath}/users/delete/${user.id}">Delete</a>
            </td>
        </tr>
    </c:forEach>
</table>
</body>
</html>

