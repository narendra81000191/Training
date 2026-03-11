package com.coforge;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

//@WebServlet("/signup")
//public class Signupservlet extends HttpServlet {
//    private static final long serialVersionUID = 1L;
//
//    @Override
//    protected void doPost(HttpServletRequest request, HttpServletResponse response)
//            throws ServletException, IOException {
//
//        request.setCharacterEncoding("UTF-8");
//
//        String fullName = request.getParameter("fullname");
//        String email    = request.getParameter("email");
//        String phone    = request.getParameter("phone");
//        String password = request.getParameter("password");
//        String confirm  = request.getParameter("confirmPassword");
//
//        // basic validations
//        if (email == null || email.isBlank()) {
//            request.setAttribute("err", "Email is required.");
//            request.getRequestDispatcher("/signup.jsp").forward(request, response);
//            return;
//        }
//        if (!password.equals(confirm)) {
//            request.setAttribute("err", "Passwords do not match.");
//            request.getRequestDispatcher("/signup.jsp").forward(request, response);
//            return;
//        }
//        if (Userdb.USERS.containsKey(email)) {
//            request.setAttribute("err", "Username already exists.");
//            request.getRequestDispatcher("/signup.jsp").forward(request, response);
//            return;
//        }
//
//        // register user
//        Userdb.USERS.put(fullName,password);
//
//        // redirect to login with a success hint (optional)
//        response.sendRedirect(request.getContextPath() + "/login.jsp?signup=success");
//    }
@WebServlet("/signup")
public class Signupservlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");

        String email    = request.getParameter("email");
        String password = request.getParameter("password");
        String confirm  = request.getParameter("confirmPassword");

        if (email != null)    email = email.trim();
        if (password != null) password = password.trim();
        if (confirm != null)  confirm = confirm.trim();

        if (email == null || email.isBlank()) {
            request.setAttribute("err", "Email is required.");
            request.getRequestDispatcher("/signup.jsp").forward(request, response);
            return;
        }
        if (password == null || confirm == null || !password.equals(confirm)) {
            request.setAttribute("err", "Passwords do not match.");
            request.getRequestDispatcher("/signup.jsp").forward(request, response);
            return;
        }
        if (Userdb.USERS.containsKey(email)) {
            request.setAttribute("err", "Username already exists.");
            request.getRequestDispatcher("/signup.jsp").forward(request, response);
            return;
        }

        Userdb.USERS.put(email, password);  // <- SAFE: not null due to checks above
        System.out.println("[Signup] created user: " + email);

        response.sendRedirect(request.getContextPath() + "/login.jsp?signup=success");
    }

    // Optional: show signup page if accessed via GET
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getRequestDispatcher("/signup.jsp").forward(request, response);
    }
}