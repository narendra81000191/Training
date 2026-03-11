package com.coforge;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/editUser")
public class EditUserServlet extends HttpServlet {
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

        String username = request.getParameter("username");
        
        if (username == null || username.isEmpty()) {
            response.sendRedirect(request.getContextPath() + "/userList");
            return;
        }

        User user = Userdb.getUserByUsername(username);
        
        if (user == null) {
            response.sendRedirect(request.getContextPath() + "/userList");
            return;
        }

        request.setAttribute("user", user);
        request.getRequestDispatcher("/editUser.jsp").forward(request, response);
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
                || email == null || email.isEmpty()) {
            request.setAttribute("error", "Name and email are required!");
            request.setAttribute("user", Userdb.getUserByUsername(username));
            request.getRequestDispatcher("/editUser.jsp").forward(request, response);
            return;
        }

        // Update user in database
        boolean success = Userdb.updateUser(username, fullName, email, password);
        
        if (success) {
            response.sendRedirect(request.getContextPath() + "/userList");
        } else {
            request.setAttribute("error", "User not found!");
            request.getRequestDispatcher("/editUser.jsp").forward(request, response);
        }
    }
}
