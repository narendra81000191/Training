<%@page import="com.coforge.models.Employee"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
 
</head>
<body>
	<%
		List<Employee> employeeList=(List<Employee>) request.getAttribute("empList");
	%>
	<div class="container mt-4">
		<div class="card shadow">
			<div class="card-header bg-primary text-white">
				<h1>Employee List</h1>
				<a href="Employeeservlet?action=new" class="btn btn-success" >Add Employee</a>
				<a href="home.jsp" class="btn btn-warning" >Home</a>
			


			</div>
			
						
<div class="card shadow-sm mb-4">
    <div class="card-body">
 
        <form action="Employeeservlet" method="get" class="row g-2 align-items-center">
            <input type="hidden" name="action" value="search">
 
            <div class="col-md-6 col-lg-5">
                <div class="input-group input-group-lg">
                    <span class="input-group-text bg-white">
                       ->
                    </span>
                    <input type="text"
                           name="keyword"
                           class="form-control"
                           placeholder="Search by Name or Mobile"
                           value="${param.keyword}">
                </div>
            </div>
 
            <div class="col-auto">
                <button type="submit" class="btn btn-primary btn-lg px-4">
                    Search
                </button>
            </div>
 
            <div class="col-auto">
                <a href="Employeeservlet?action=list"
                   class="btn btn-outline-secondary btn-lg px-4">
                    Clear
                </a>
            </div>
        </form>
 
    </div>
</div>
 
			<div class="card-body" >
				<table class="table table-bordered table-striped align-middle" >
					<thead class="table-dark">
						<tr>
							<th>Employee Id</th>
							<th>Employee Name</th>
							<th>Employee Salary</th>
							<th>Employee Email</th>
							<th>Employee Mobile</th>
							<th>Employee DOJ</th>
							<th>Employee DOB</th>
							<th>Actions</th>
						</tr>
					</thead>
					<tbody>
						<%
							if(employeeList!=null && !employeeList.isEmpty() ) {
								for(Employee emp:employeeList){
						%>
							<tr>
								<td><%= emp.getEid() %> </td>
								<td><%= emp.getEname() %> </td>
								<td><%= emp.getSalary() %> </td>
								<td><%= emp.getEmail() %> </td>
								<td><%= emp.getMobile() %> </td>
								<td><%= emp.getDoj() %> </td>
								<td><%= emp.getDob() %> </td>
								<td>
									<a href="Employeeservlet?action=edit&eid=<%=emp.getEid() %>" class="btn btn-success">Edit</a>
									<a href="Employeeservlet?action=delete&eid=<%=emp.getEid() %>" class="btn btn-danger" onClick="return('Confirm do you want to delete?')">Delete</a>
									<a href="Employeeservlet?action=info&eid=<%=emp.getEid() %>" class="btn btn-secondary" onClick="return('Confirm do you want to delete?')">info</a>
									
									
								</td>
							</tr>
						<% }} else { %>
								<tr>
									<td colspan="8">No Employees found</td>
								</tr>
						<% } %>
					</tbody>
				</table>
			</div>
		</div>
	</div>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
</body>
</html>