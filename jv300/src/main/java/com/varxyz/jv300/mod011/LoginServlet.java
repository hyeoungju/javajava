package com.varxyz.jv300.mod011;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.varxyz.jv300.mod011.UserService;


@WebServlet("/mod011/login") //확장자를 안적었음, 이건 요즘 추세...선생님의 방식
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private UserService userService;
	
	public void init() {
		userService = new UserService(new UserDao());
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		request.getRequestDispatcher("login.jsp").forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		String userId = request.getParameter("userId");
		String passwd = request.getParameter("passwd");
		
		//요청 파라메터 검증
		//...
		if(!userService.isValidUser(userId, passwd)) { //아큐먼트나 리턴이 boolean일때 is?
			request.getRequestDispatcher("login.jsp").forward(request, response);
			return;
		}
		HttpSession session = request.getSession(true);
		session.setAttribute("userId", userId);
		response.sendRedirect("mypage"); //controller, forward랑sendRedirect의 차이점? session 보관후 sendRedirect
		//하게되면..sendRedirect는 주소가 바뀌기 때문에..?
		
	}

}
