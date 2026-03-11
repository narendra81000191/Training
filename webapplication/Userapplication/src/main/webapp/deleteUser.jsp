<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false"%>
<%@ page import="com.coforge.User" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Delete User - User Management System</title>
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
        
        .warning-box {
            background: #fadbd8;
            border: 2px solid #c0392b;
            padding: 20px;
            border-radius: 8px;
            margin-bottom: 30px;
        }
        
        .warning-box h3 {
            color: #c0392b;
            margin-bottom: 10px;
        }
        
        .warning-box p {
            color: #922b21;
            line-height: 1.6;
            margin-bottom: 10px;
        }
        
        .user-details {
            background: #eaf2f5;
            padding: 15px;
            border-radius: 5px;
            margin-bottom: 20px;
        }
        
        .user-details p {
            margin-bottom: 8px;
            color: #34495e;
        }
        
        .form-group {
            margin-bottom: 20px;
        }
        
        label {
            display: flex;
            align-items: center;
            gap: 10px;
            color: #2c3e50;
            font-weight: 600;
            cursor: pointer;
        }
        
        input[type="checkbox"] {
            width: 18px;
            height: 18px;
            cursor: pointer;
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
        
        .btn-delete {
            background: #e74c3c;
            color: white;
        }
        
        .btn-delete:hover:not(:disabled) {
            background: #c0392b;
            transform: translateY(-2px);
            box-shadow: 0 5px 15px rgba(0,0,0,0.2);
        }
        
        .btn-delete:disabled {
            background: #95a5a6;
            cursor: not-allowed;
            opacity: 0.6;
        }
        
        .btn-cancel {
            background: #95a5a6;
            color: white;
        }
        
        .btn-cancel:hover {
            background: #7f8c8d;
            transform: translateY(-2px);
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
    
    User deleteUser = (User) request.getAttribute("user");
    if (deleteUser == null) {
        response.sendRedirect(request.getContextPath() + "/userList");
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
    <h1>🗑️ Delete User</h1>
    
    <div class="warning-box">
        <h3>⚠️ Warning: Permanent Deletion</h3>
        <p>You are about to permanently delete the following user from the system:</p>
    </div>
    
    <div class="user-details">
        <p><strong>Username:</strong> <%= deleteUser.getUsername() %></p>
        <p><strong>Full Name:</strong> <%= deleteUser.getFullName() %></p>
        <p><strong>Email:</strong> <%= deleteUser.getEmail() %></p>
    </div>
    
    <form method="POST" action="<%=request.getContextPath()%>/deleteUser" onsubmit="return validateDelete();">
        <input type="hidden" name="username" value="<%= deleteUser.getUsername() %>">
        
        <div class="form-group">
            <label for="confirm">
                <input type="checkbox" id="confirm" name="confirm" value="yes">
                I understand this action cannot be undone
            </label>
        </div>
        
        <div class="button-group">
            <button type="submit" id="deleteBtn" class="btn-delete" disabled>🗑️ Permanently Delete</button>
            <a href="<%=request.getContextPath()%>/userList" class="btn-cancel" style="text-align: center; text-decoration: none; display: flex; align-items: center; justify-content: center;">❌ Cancel</a>
        </div>
    </form>
</div>

<script>
    function validateDelete() {
        const confirm = document.getElementById('confirm').checked;
        if (!confirm) {
            alert('Please confirm that you understand this action cannot be undone.');
            return false;
        }
        return true;
    }
    
    document.getElementById('confirm').addEventListener('change', function() {
        document.getElementById('deleteBtn').disabled = !this.checked;
    });
</script>

</body>
</html>
