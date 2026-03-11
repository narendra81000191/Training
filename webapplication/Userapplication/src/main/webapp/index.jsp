<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>First Web App</title>
</head>
<body>
    <h1>First Web App</h1>

    <p>
        <a href="<%=request.getContextPath()%>/login.jsp">Sign in</a>
    </p>
    <p>
        <a href="<%=request.getContextPath()%>/signup.jsp">Sign up</a>
    </p>
</body>
</html>