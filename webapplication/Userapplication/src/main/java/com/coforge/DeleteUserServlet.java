package com.coforge;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/deleteUser")
public class DeleteUserServlet extends HttpServlet {
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
        request.getRequestDispatcher("/deleteUser.jsp").forward(request, response);
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
        String confirm = request.getParameter("confirm");

        // Verify confirmation
        if (confirm == null || !confirm.equals("yes")) {
            response.sendRedirect(request.getContextPath() + "/userList");
            return;
        }

        // Delete user from database
        Userdb.deleteUser(username);
        response.sendRedirect(request.getContextPath() + "/userList");
    }
}
