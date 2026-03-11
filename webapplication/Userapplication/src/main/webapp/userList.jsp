<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false"%>
<%@ page import="java.util.Collection" %>
<%@ page import="com.coforge.User" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>User List - User Management System</title>
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
        
        .navbar-menu button.btn-success {
            background: #27ae60;
        }
        
        .navbar-menu button.btn-success:hover {
            background: #229954;
        }
        
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
        
        table {
            width: 100%;
            border-collapse: collapse;
            margin-top: 20px;
        }
        
        thead {
            background: #34495e;
            color: white;
        }
        
        th {
            padding: 15px;
            text-align: left;
            font-weight: 600;
        }
        
        td {
            padding: 12px 15px;
            border-bottom: 1px solid #ecf0f1;
        }
        
        tbody tr:hover {
            background: #f8f9fa;
        }
        
        .action-buttons {
            display: flex;
            gap: 10px;
        }
        
        .btn {
            padding: 8px 15px;
            border: none;
            border-radius: 4px;
            cursor: pointer;
            text-decoration: none;
            font-size: 12px;
            transition: all 0.3s ease;
            display: inline-block;
        }
        
        .btn-edit {
            background: #3498db;
            color: white;
        }
        
        .btn-edit:hover {
            background: #2980b9;
        }
        
        .btn-delete {
            background: #e74c3c;
            color: white;
        }
        
        .btn-delete:hover {
            background: #c0392b;
        }
        
        .btn-home {
            background: #95a5a6;
            color: white;
        }
        
        .btn-home:hover {
            background: #7f8c8d;
        }
        
        .empty-message {
            text-align: center;
            color: #7f8c8d;
            padding: 40px;
            font-size: 16px;
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
    <h1>📋 All Users</h1>
    
    <%
        java.util.Collection<User> users = (java.util.Collection<User>) request.getAttribute("users");
        if (users != null && !users.isEmpty()) {
    %>
    <table>
        <thead>
            <tr>
                <th>Username</th>
                <th>Full Name</th>
                <th>Email</th>
                <th>Actions</th>
            </tr>
        </thead>
        <tbody>
            <%
                for (User u : users) {
            %>
            <tr>
                <td><%= u.getUsername() %></td>
                <td><%= u.getFullName() %></td>
                <td><%= u.getEmail() %></td>
                <td>
                    <div class="action-buttons">
                        <a href="<%=request.getContextPath()%>/editUser?username=<%=u.getUsername()%>" class="btn btn-edit">✏️ Edit</a>
                        <a href="<%=request.getContextPath()%>/deleteUser?username=<%=u.getUsername()%>" class="btn btn-delete">🗑️ Delete</a>
                    </div>
                </td>
            </tr>
            <%
                }
            %>
        </tbody>
    </table>
    <%
        } else {
    %>
    <div class="empty-message">
        <p>No users found in the system.</p>
    </div>
    <%
        }
    %>
    
</div>

</body>
</html>
