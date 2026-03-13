package com.coforge;


import java.io.IOException;
import jakarta.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.*;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
 
@WebFilter(urlPatterns = {"/homeservlet","/profileservlet","/dashboardservlet"})
public class Authentication implements Filter {
 
	public void doFilter(ServletRequest request,
			ServletResponse response,
			FilterChain chain)
			throws IOException, ServletException {
 
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse res = (HttpServletResponse) response;
 
		HttpSession session = req.getSession(false);
 
		boolean loggedIn = (session != null &&
		                   session.getAttribute("email") != null);
 
		if(loggedIn) {
 
			chain.doFilter(request, response);
 
		} else {
 
			res.sendRedirect("login.jsp");
		}
	}
}