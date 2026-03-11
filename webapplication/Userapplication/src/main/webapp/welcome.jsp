<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Welcome</title>
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
        
        /* Navbar Styles */
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
        
        .navbar-menu a {
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
        
        .navbar-menu button.btn-success {
            background: #27ae60;
        }
        
        .navbar-menu button.btn-success:hover {
            background: #229954;
        }
        
        /* Container */
        .container {
            max-width: 1200px;
            margin: 40px auto;
            padding: 20px;
            background: white;
            border-radius: 10px;
            box-shadow: 0 10px 30px rgba(0,0,0,0.2);
        }
        
        h1 {
            color: #2c3e50;
            text-align: center;
            margin-bottom: 30px;
            font-size: 32px;
        }
        
        .welcome-message {
            background: linear-gradient(135deg, #667eea 0%, #764ba2 100%);
            color: white;
            padding: 20px;
            border-radius: 8px;
            text-align: center;
            font-size: 18px;
            margin-bottom: 30px;
        }
        
        .info-section {
            background: #ecf0f1;
            padding: 20px;
            border-radius: 8px;
            margin-top: 20px;
            border-left: 4px solid #3498db;
        }
        
        .info-section h3 {
            color: #2c3e50;
            margin-bottom: 10px;
        }
        
        .info-section p {
            color: #555;
            line-height: 1.6;
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
            <li><a href="<%=request.getContextPath()%>/userList">📋 View Users</a></li>
            <li><a href="<%=request.getContextPath()%>/addUser" class="btn-success">➕ Add User</a></li>
            <li><span class="navbar-user">User: <%= user %></span></li>
            <li><form action="<%=request.getContextPath()%>/logout" method="POST" style="display:inline;">
                <button type="submit" class="btn-danger">🚪 Logout</button>
            </form></li>
        </ul>
    </div>
</nav>

<!-- Content -->
<div class="container">
    <h1>Welcome to User Management System</h1>
    
    <div class="welcome-message">
        Welcome, <%= user %>! You have successfully logged in.
    </div>
    
    <div class="info-section">
        <h3>📌 Quick Navigation</h3>
        <p>Use the navbar above to:</p>
        <ul style="margin-left: 20px; margin-top: 10px;">
            <li><strong>View Users</strong> - See all registered users in the system</li>
            <li><strong>Add User</strong> - Create a new user account</li>
            <li><strong>Logout</strong> - Exit the application</li>
        </ul>
    </div>
    
    <div class="info-section">
        <h3>📚 Available Features</h3>
        <p>This User Management System allows you to:</p>
        <ul style="margin-left: 20px; margin-top: 10px;">
            <li><strong>Create (C)</strong> - Add new users to the system</li>
            <li><strong>Read (R)</strong> - View user details and full user list</li>
            <li><strong>Update (U)</strong> - Edit existing user information</li>
            <li><strong>Delete (D)</strong> - Remove users from the system</li>
        </ul>
    </div>
</div>

</body>
</html>