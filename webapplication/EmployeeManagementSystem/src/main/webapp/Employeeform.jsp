<%-- 
 
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
									<a href="Employeeservlet?action=edit&eid<%=emp.getEid() %>" class="btn btn-success">Edit</a>
									<a href="Employeeservlet?action=delete&eid<%=emp.getEid() %>" class="btn btn-danger" onClick="return('Confirm do you want to delete?')">Delete</a>
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
 --%>
 
  
<%@page import="com.coforge.models.Employee"%>
<%@page import="java.time.LocalDate"%>
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
		Employee emp = (Employee) request.getAttribute("employee");

		boolean editMode= emp!=null;
		System.out.println(emp);
	%>
	<div class="container mt-4">
		<div class="card shadow">
			<div class="card-header bg-dark text-white ">
				<h3><%= editMode?"Edit Employee":"Add Employee" %></h3>
			</div>
			<div class="card-body">
				<form action="Employeeservlet" method="post">
					<input type="hidden" name="eid" value=<%=editMode?emp.getEid():""%>' >
					<div class="mb-3">
						<label class="form-label" >Employee Name:</label>
						<input type="text" class="form-control" name="ename" value='<%=editMode?emp.getEname():""%>' />
					</div>
					<div class="mb-3">
						<label class="form-label" >Employee Salary:</label>
						<input type="text" class="form-control" name="salary" value='<%=editMode?emp.getSalary():""%>' />
					</div>
					<div class="mb-3">
						<label class="form-label" >Employee Email:</label>
						<input type="email" class="form-control" name="email" value='<%=editMode?emp.getEmail():""%>' />
					</div>
					<div class="mb-3">
						<label class="form-label" >Employee Mobile Number:</label>
						<input type="tel" class="form-control" name="mobile" value='<%=editMode?emp.getMobile():""%>' />
					</div>
					<div class="mb-3">
						<label class="form-label" >Employee DOJ:</label>
						<input type="text" class="form-control" name="doj" value='<%=editMode?emp.getDoj():""%>' />
					</div>
					<div class="mb-3">
						<label class="form-label" >Employee DOB:</label>
						<input type="text" class="form-control" name="dob" value='<%=editMode?emp.getDob():""%>' />
					</div>
					<button type="submit" class="btn btn-success" >
						<%= editMode?"Edit Employee":"Save Employee" %>
					</button>
					<br>
					
<a href="home.jsp"
           class="btn btn-secondary">Back</a>

				</form>
			</div>
		</div>
	</div>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
</body>
</html>