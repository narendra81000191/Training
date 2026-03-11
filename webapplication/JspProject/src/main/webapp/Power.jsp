<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Power of Number</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
</head>
<body>
<div class= "container mt-5">
		<div class="row justify-content-center">
							<div class="col-md-5">
							 <div class = "card shadow">
							 <div class = "card-header text-center bg-primary  text-light">
							 <h3> power of number</h3>
							 <div class = "card_body">
							 <form><div class ="mb-3">
							 <label class ="form label"> number</label>
							 <input type="text" class = "from-control" name ="num1" required><br>
							 <label class ="form label"> power</label>
							 <input type="text" class = "from-control" name ="pow" required><br>
							 <button  class = "btn btn-secondary"> RESULT </button>
							 </div>
							  
							 </form>
							 </div>
							 </div>
							 </div>    
							</div>
		</div>
</div>
<%!  double  powO(String n1,String n2){

    if(n1!=null&& n2!=null){
    double res= (Math.pow(Double.parseDouble(n1),Double.parseDouble(n2)));
    return res;
       }
    return 0;
  }
    
%>

<%String  n1=request.getParameter("num1");
String n2=request.getParameter("pow");

out.println( "power of "+n1+ "to "+ n2+"=" + powO(n1,n2)); %>
