package com.varxyz.jv300.mod003;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Multiple extends HttpServlet{
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
						throws ServletException, IOException {
		String pageTitle = "Multiple";
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.println("<html>");
		out.println("<head><title>" + pageTitle + "</title></head>");
		out.println("<body>");
		out.println("<h3> Welcome to Mutiple</h3>");
		out.println("<tr>");
		for (int i=1; i<10; i++) {
			for (int j=2; j<10; j++) {
				out.println(j+"*" +i+ "=" +i*j);
			}
			out.println("<br>");
		}
		out.println("</tr></body></html>");
		out.close();
	}
}
