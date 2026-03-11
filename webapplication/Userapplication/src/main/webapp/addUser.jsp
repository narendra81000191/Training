<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Add User - User Management System</title>
    <style>
        * {
            margin: 0;
            padding: 0;
            box-sizing: border-box;
        }
        
        body {
            font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
            background: linear-gradient(135deg, #667eea 0%, #764ba2 100%);
            min-height: 100vh;
        }
        
        .navbar {
            background: #2c3e50;
            padding: 0;
            box-shadow: 0 2px 5px rgba(0,0,0,0.1);
            position: sticky;
            top: 0;
            z-index: 1000;
        }
        
        .navbar-container {
            display: flex;
            justify-content: space-between;
            align-items: center;
            padding: 0 20px;
            max-width: 1200px;
            margin: 0 auto;
            height: 60px;
        }
        
        .navbar-brand {
            font-size: 24px;
            font-weight: bold;
            color: #ecf0f1;
            text-decoration: none;
        }
        
        .navbar-user {
            color: #bdc3c7;
            font-size: 14px;
        }
        
        .navbar-menu {
            display: flex;
            gap: 15px;
            list-style: none;
            align-items: center;
        }
        
        .navbar-menu button,
        .navbar-menu a {
            background: #3498db;
            color: white;
            border: none;
            padding: 10px 20px;
            border-radius: 5px;
            cursor: pointer;
            text-decoration: none;
            font-size: 14px;
            transition: all 0.3s ease;
            display: inline-block;
        }
        
        .navbar-menu button:hover,
        .navbar-menu a:hover {
            background: #2980b9;
            transform: translateY(-2px);
            box-shadow: 0 5px 15px rgba(0,0,0,0.2);
        }
        
        .navbar-menu button.btn-danger {
            background: #e74c3c;
        }
        
        .navbar-menu button.btn-danger:hover {
            background: #c0392b;
        }
        
        .container {
            max-width: 500px;
            margin: 40px auto;
            padding: 30px;
            background: white;
            border-radius: 10px;
            box-shadow: 0 10px 30px rgba(0,0,0,0.2);
        }
        
        h1 {
            color: #2c3e50;
            text-align: center;
            margin-bottom: 30px;
            font-size: 28px;
        }
        
        .form-group {
            margin-bottom: 20px;
        }
        
        label {
            display: block;
            margin-bottom: 8px;
            color: #2c3e50;
            font-weight: 600;
        }
        
        input[type="text"],
        input[type="email"],
        input[type="password"] {
            width: 100%;
            padding: 12px;
            border: 2px solid #ecf0f1;
            border-radius: 5px;
            font-size: 14px;
            transition: border-color 0.3s ease;
        }
        
        input[type="text"]:focus,
        input[type="email"]:focus,
        input[type="password"]:focus {
            outline: none;
            border-color: #3498db;
            box-shadow: 0 0 5px rgba(52, 152, 219, 0.3);
        }
        
        .button-group {
            display: flex;
            gap: 10px;
            margin-top: 30px;
        }
        
        button {
            flex: 1;
            padding: 12px;
            border: none;
            border-radius: 5px;
            font-size: 16px;
            font-weight: 600;
            cursor: pointer;
            transition: all 0.3s ease;
        }
        
        .btn-submit {
            background: #27ae60;
            color: white;
        }
        
        .btn-submit:hover {
            background: #229954;
            transform: translateY(-2px);
            box-shadow: 0 5px 15px rgba(0,0,0,0.2);
        }
        
        .btn-cancel {
            background: #95a5a6;
            color: white;
        }
        
        .btn-cancel:hover {
            background: #7f8c8d;
            transform: translateY(-2px);
        }
        
        .error {
            background: #fadbd8;
            color: #c0392b;
            padding: 12px;
            border-radius: 5px;
            margin-bottom: 20px;
            border-left: 4px solid #c0392b;
            display: none;
        }
        
        .error.show {
            display: block;
        }
        
        .success {
            background: #d5f4e6;
            color: #27ae60;
            padding: 12px;
            border-radius: 5px;
            margin-bottom: 20px;
            border-left: 4px solid #27ae60;
            display: none;
        }
        
        .success.show {
            display: block;
        }
    </style>
</head>
<body>

<%
    Object user = session.getAttribute("user");
    if (user == null) {
        response.sendRedirect(request.getContextPath() + "/login.jsp");
        return;
    }
%>

<!-- Navbar -->
<nav class="navbar">
    <div class="navbar-container">
        <a href="<%=request.getContextPath()%>/welcome.jsp" class="navbar-brand">🏠 User Management</a>
        
        <ul class="navbar-menu">
            <li><a href="<%=request.getContextPath()%>/welcome.jsp">🏠 Home</a></li>
            <li><a href="<%=request.getContextPath()%>/userList">📋 View Users</a></li>
            <li><span class="navbar-user">User: <%= user %></span></li>
            <li><form action="<%=request.getContextPath()%>/logout" method="POST" style="display:inline;">
                <button type="submit" class="btn-danger">🚪 Logout</button>
            </form></li>
        </ul>
    </div>
</nav>

<!-- Content -->
<div class="container">
    <h1>➕ Add New User</h1>
    
    <%
        String error = (String) request.getAttribute("error");
        String success = (String) request.getAttribute("success");
    %>
    
    <% if (error != null) { %>
    <div class="error show"><%= error %></div>
    <% } %>
    
    <% if (success != null) { %>
    <div class="success show"><%= success %></div>
    <% } %>
    
    <form method="POST" action="<%=request.getContextPath()%>/addUser">
        <div class="form-group">
            <label for="username">Username *</label>
            <input type="text" id="username" name="username" required placeholder="Enter username">
        </div>
        
        <div class="form-group">
            <label for="fullName">Full Name *</label>
            <input type="text" id="fullName" name="fullName" required placeholder="Enter full name">
        </div>
        
        <div class="form-group">
            <label for="email">Email *</label>
            <input type="email" id="email" name="email" required placeholder="Enter email address">
        </div>
        
        <div class="form-group">
            <label for="password">Password *</label>
            <input type="password" id="password" name="password" required placeholder="Enter password">
        </div>
        
        <div class="button-group">
            <button type="submit" class="btn-submit">➕ Add User</button>
            <a href="<%=request.getContextPath()%>/userList" class="btn-cancel" style="text-align: center; text-decoration: none; display: flex; align-items: center; justify-content: center;">❌ Cancel</a>
        </div>
    </form>
</div>

</body>
</html>
