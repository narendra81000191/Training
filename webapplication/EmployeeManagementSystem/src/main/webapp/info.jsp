<%@ page contentType="text/html;charset=UTF-8" %>
<%@ page import="com.coforge.models.Employee" %>
<%
    Employee emp = (Employee) request.getAttribute("employee");
    if (emp == null) {
%>
    <p>Employee data not available.</p>
<%
        return;
    }
%>
<!DOCTYPE html>
<html>
<head>
    <title>Employee Details</title>
    <style>
        .card { max-width: 520px; margin: 24px auto; padding: 20px; border: 1px solid #ddd; border-radius: 10px; font-family: Arial, sans-serif; }
        .row { display: flex; margin: 10px 0; }
        .label { width: 140px; color: #555; font-weight: bold; }
        .value { flex: 1; color: #111; }
        .actions { margin-top: 18px; }
        .btn { padding: 8px 14px; border: 1px solid #888; background: #f7f7f7; border-radius: 6px; cursor: pointer; text-decoration: none; color: #111; }
    </style>
</head>
<body>
<div class="card">
    <h2>Employee Information</h2>

    <div class="row"><div class="label">ID</div><div class="value"><%= emp.getEid() %></div></div>
    <div class="row"><div class="label">Name</div><div class="value"><%= emp.getEname() %></div></div>
    <div class="row"><div class="label">Salary</div><div class="value"><%= emp.getSalary() %></div></div>
    <div class="row"><div class="label">mobiel</div><div class="value"><%= emp.getMobile() %></div></div>
     <div class="row"><div class="label">email</div><div class="value"><%= emp.getEmail() %></div></div>
      <div class="row"><div class="label">dob</div><div class="value"><%= emp.getDob() %></div></div>
       <div class="row"><div class="label">doj</div><div class="value"><%= emp.getDoj() %></div></div>

    <div class="actions">
        <!-- Only a Back button (client-side), NO Edit link -->
        <button class="btn" onclick="history.back()">Back</button>
    </div>
</div>
</body>
</html>