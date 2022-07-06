package com.varxyz.jv300.mod004;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ServletConfigTestServlet extends HttpServlet{
	private static final String DEFAULT_SEASONS = "Spring, Summer, Fall, Winter";
	private String[] seasons;
	
	/*@Override
	public void init(ServletConfig config) throws ServletException {
		String season_list = config.getInitParameter("season_list"); //Servlet 의 자기의 메소드니까 객체를 생성안하고 불렀다.
		//season_list 를 <param-name>가 받는다. <param-value>은 default값이지 DEFAULT_SEASONS 이거는 아니다.
		if(season_list == null) {
			season_list = DEFAULT_SEASONS;
		}
		seasons = season_list.split(",");
	}
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.println("<html><body>");
		out.println("<h3>ServletConfigTest</h3>");
		out.println("<ul>"); //html 공부해라
		for(String season : seasons) {
			out.println("<li>" + season + "</li>");
		}
		out.println("</ul>");
		out.println("</body></html>");
		out.close();
	}*/
	
	@Override
	public void init() throws ServletException {
		String season_list = getInitParameter("season_list"); //Servlet 의 자기의 메소드니까 객체를 생성안하고 불렀다.
		//season_list 를 <param-name>가 받는다. <param-value>은 default값이지 DEFAULT_SEASONS 이거는 아니다.
		if(season_list == null) {
			season_list = DEFAULT_SEASONS;
		}
		seasons = season_list.split(",");
	}
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.println("<html><body>");
		out.println("<h3>ServletConfigTest</h3>");
		out.println("<ul>"); //html 공부해라
		for(String season : seasons) {
			out.println("<li>" + season + "</li>");
		}
		out.println("</ul>");
		out.println("</body></html>");
		out.close();
	}
}
