<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Add numbers</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
</head>
<body>
<div class= "container mt-5">
		<div class="row justify-content-center">
							<div class="col-md-5">
							 <div class = "card shadow">
							 <div class = "card-header text-center bg-primary  text-light">
							 <h3> Add two numbers</h3>
							 <div class = "card_body">
							 <form><div class ="mb-3">
							 <label class ="form label"> first number</label>
							 <input type="text" class = "from-control" name ="num1" required><br>
							 <label class ="form label"> second number</label>
							 <input type="text" class = "from-control" name ="num2" required><br>
							 <button  class = "btn btn-secondary"> Addition </button>
							 </div>
							  
							 </form>
							 </div>
							 </div>
							 </div>    
							</div>
		</div>
</div>

<%!  int addNums(String n1,String n2){

    if(n1!=null&& n2!=null){
    int res= Integer.parseInt(n1)+Integer.parseInt(n2);
    return res;
       }
    return 0;
  }
    
%>
<div class="row justify-content-center">
<div class = "card-header text-center bg-secondary  text-light" color="green" >

<%String  n1=request.getParameter("num1");
String n2=request.getParameter("num2");

out.println( "sum of "+n1+ "and"+ n2+"=" + addNums(n1,n2)); %>
</div>
</div>

</body>
</html>