<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 5/28/2025
  Time: 2:17 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<html>
<head>
    <title>User Form</title>
</head>
<body>
<h2>User Form</h2>
<%--@elvariable id="user" type="user"--%>
<form:form modelAttribute="user" method="post" action="${pageContext.request.contextPath}/users/${user.id == null ? 'add' : 'edit'}">
    <form:hidden path="id"/>
    <p>First Name: <form:input path="firstName"/></p>
    <p>Last Name: <form:input path="lastName"/></p>
    <p>Email: <form:input path="email"/></p>
    <input type="submit" value="Submit"/>
</form:form>
</body>
</html>
