package com.coforge;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/addUser")
public class AddUserServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession(false);
        
        // Check if user is logged in
        if (session == null || session.getAttribute("user") == null) {
            response.sendRedirect(request.getContextPath() + "/login.jsp");
            return;
        }

        request.getRequestDispatcher("/addUser.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession(false);
        
        // Check if user is logged in
        if (session == null || session.getAttribute("user") == null) {
            response.sendRedirect(request.getContextPath() + "/login.jsp");
            return;
        }

        String username = request.getParameter("username");
        String fullName = request.getParameter("fullName");
        String email = request.getParameter("email");
        String password = request.getParameter("password");

        // Validation
        if (username == null || username.isEmpty() || fullName == null || fullName.isEmpty()
                || email == null || email.isEmpty() || password == null || password.isEmpty()) {
            request.setAttribute("error", "All fields are required!");
            request.getRequestDispatcher("/addUser.jsp").forward(request, response);
            return;
        }

        // Add user to database
        boolean success = Userdb.addUser(username, fullName, email, password);
        
        if (success) {
            request.setAttribute("success", "User added successfully!");
            response.sendRedirect(request.getContextPath() + "/userList");
        } else {
            request.setAttribute("error", "Username already exists!");
            request.getRequestDispatcher("/addUser.jsp").forward(request, response);
        }
    }
}
