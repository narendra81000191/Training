<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Login</title>
</head>
<body>

<%
    String err = (String) request.getAttribute("err");
    String justSignedUp = request.getParameter("signup");
    if ("success".equals(justSignedUp)) {
%>
    <p style="color:green;">Signup successful. Please login.</p>
<%
    }
    if (err != null) {
%>
    <p style="color:red;"><%= err %></p>
<%
    }
%>

<form action="<%=request.getContextPath()%>/login" method="post">
    <label>Username (email or id):</label>
    <input type="text" name="email" required><br>

    <label>Password:</label>
    <input type="password" name="pwd" required><br>

    <button type="submit">Login</button>
</form>

<p><a href="<%=request.getContextPath()%>/signup.jsp">Create an account</a></p>
<p><a href="<%=request.getContextPath()%>/index.jsp">Home</a></p>
</body>
</html>