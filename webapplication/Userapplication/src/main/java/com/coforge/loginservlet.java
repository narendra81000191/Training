package com.coforge;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

//@WebServlet("/login")
//public class loginservlet extends HttpServlet {
//    private static final long serialVersionUID = 1L;
//
//    @Override
//    protected void doPost(HttpServletRequest request, HttpServletResponse response)
//            throws ServletException, IOException {
//
//        request.setCharacterEncoding("UTF-8");
//        String uname = request.getParameter("fullName");
//        String pass  = request.getParameter("password");
//
//        //String stored = Userdb.USERS.get(uname);
//        if (!Userdb.USERS.containsKey(uname)) {
//            // success: create session and go to welcome
//        	//Userdb.USERS.put(uname, pass);
//            HttpSession session = request.getSession(true);
//            session.setAttribute("user", uname);
//            response.sendRedirect("/welcome.jsp");
//        } else {
//            // failure: show error on login page
//            request.setAttribute("err", "Invalid credentials. Login failed.");
//            request.getRequestDispatcher("/login.jsp").forward(request, response);
//        }
//    }
//}
@WebServlet("/login")
public class loginservlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");
       
        String email = request.getParameter("email");
        String pass  = request.getParameter("pwd");
        System.out.println(email+"   "+pass);
        if (email != null) email = email.trim();
        if (pass  != null) pass  = pass.trim();

        // Validate input first (prevents NPE and bad redirects)
        if (email == null || email.isBlank() || pass == null || pass.isBlank()) {
            request.setAttribute("err", "Email and password are required.");
            request.getRequestDispatcher("/login.jsp").forward(request, response);
            return;
        }

        // Try to authenticate using username or email
        boolean authenticated = false;
        String username = null;
        
        // Check if authentication is by username
        if (Userdb.authenticate(email, pass)) {
            authenticated = true;
            username = email;
        } else {
            // Check if authentication is by email (find username by email)
            for (User u : Userdb.getAllUsers()) {
                if (u.getEmail().equals(email) && u.getPassword().equals(pass)) {
                    authenticated = true;
                    username = u.getUsername();
                    break;
                }
            }
        }
        
        if (authenticated) {
            request.getSession(true).setAttribute("user", username);
            response.sendRedirect(request.getContextPath() + "/welcome.jsp");
        } else {
            request.setAttribute("err", "Invalid credentials. Login failed.");
            request.getRequestDispatcher("/login.jsp").forward(request, response);
        }
    }



    // Optional: show login page if accessed via GET
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getRequestDispatcher("/login.jsp").forward(request, response);
    }
}