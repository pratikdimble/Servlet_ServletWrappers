package com.pratik.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class StudentRegistrationServlet
 */
public class StudentRegistrationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
		protected void doPost(HttpServletRequest request, HttpServletResponse response) 
								throws ServletException, IOException {
		response.setContentType("image/jpg");
		
		PrintWriter out = response.getWriter();

		String sid = request.getParameter("sid");
		String sname = request.getParameter("sname");
		String semail = request.getParameter("semail");

		out.println("<html>");
		out.println("<body>");
		out.println("<h2><center>Pratik Softwares</center></h2>");
		out.println("<h3>Student Registration Details</h2>");
		out.println("<table border='1'>");
		out.println("<tr><td>Student Id</td><td>"+sid+"</td></tr>");
		out.println("<tr><td>Student Name</td><td>"+sname+"</td></tr>");
		out.println("<tr><td>Student Email</td><td>"+semail+"</td></tr>");
		out.println("</table></body></html>");

		}
	}

