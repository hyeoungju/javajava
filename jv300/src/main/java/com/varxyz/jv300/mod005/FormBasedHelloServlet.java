package com.varxyz.jv300.mod005;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/mod005/hello.do") /*servlet3.0d부터 가능 개발이 편하다는 장점, 단점은 각 클래스마다 살펴봐야함 요즘추세*/
public class FormBasedHelloServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String DEFAULT_NAME = "World";
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		String name = request.getParameter("userName");
		if(name == null || name.length() == 0) {
			name = DEFAULT_NAME;
		}
		
		String pageTitle = "Hello World";	//html 만들어야한다.
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();	//PrintWriter 는 Writer의 자식
		out.println("<html>");
		out.println("<head><title>" + pageTitle + "</title></head>");
		out.println("<body>");
		out.println("<h3>" + name + "</h3>");
		out.println("</body></html>");	//이렇게 쓰는 것을 presentation 로직
		out.close(); //IO이기 때문에 끝나면 닫는다.
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
