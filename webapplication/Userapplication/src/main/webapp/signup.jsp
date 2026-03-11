<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Signup</title>
</head>
<body>

<%
    String err = (String) request.getAttribute("err");
    if (err != null) {
%>
    <p style="color:red;"><%= err %></p>
<%
    }
%>

<form action="<%=request.getContextPath()%>/signup" method="post">
    <label>Full Name</label>
    <input type="text" name="fullname" placeholder="Enter your name" required><br>

    <label>Email</label>
    <input type="email" name="email" placeholder="Enter your email" required><br>

    <label>Phone Number</label>
    <input type="tel" name="phone" placeholder="Enter phone number" required><br>

    <label>Password</label>
    <input type="password" name="password" placeholder="Create password" required><br>

    <label>Confirm Password</label>
    <input type="password" name="confirmPassword" placeholder="Re-enter password" required><br>

    <button type="submit">Create Account</button>
</form>

<p>Already have an account?
   <a href="<%=request.getContextPath()%>/login.jsp">Login</a>
</p>
<p><a href="<%=request.getContextPath()%>/index.jsp">Home</a></p>
</body>
</html>