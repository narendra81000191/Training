<html>
<body>
<h2><%= "Hello World!" %></h2>
<%! int  a=1,b=2; %>
<%= a+b %>
<%! String name = "Ashu"; %>
<%= name %>
<%! String Stuname="ashu", stuID="12345";int age=23; %>
<br><%= "    Name  --->"+ Stuname+" /n stuID  ---->"+ stuID+ "<br>   age-----> "
+age %>></br>
<%! 
int c = 1234;

    String evenOddMessage(int n) {
        return (n % 2 == 0) ? "no is even" : "no is odd";
    }
%>

<!-- Expression: print the result -->
<p><%= evenOddMessage(c) %></p>
</body>
</html>
