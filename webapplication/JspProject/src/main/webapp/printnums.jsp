<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%for (int i=1;i<=15;i++)
	if (i%2==0)
	   out.println(i+"<br>");%>
<%! String fruits[]={"bananan","grapes","apple"};
%>
<%for(String fruit:fruits)
	out.println(fruit+"<br>");%>
	
	
	
<%@ page import ="java.util.Date" %>
<% Date date =new Date(); %>
<%=date %>


</body>
</html>