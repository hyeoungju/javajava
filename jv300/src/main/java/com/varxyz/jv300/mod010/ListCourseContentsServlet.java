package com.varxyz.jv300.mod010;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/mod010/list_course_contents.do")
public class ListCourseContentsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static List<String> textLines;

	@SuppressWarnings("unchecked")
	public void init(ServletConfig config) throws ServletException {
		ServletContext context = config.getServletContext();
		List<String[]>contentList = (List<String[]>)context.getAttribute("contentList");
		textLines = tapToSpace(contentList);
	}

	/*public void init() throws ServletException {
		ServletContext context = getServletContext();
		contentList = (List<String[]>)context.getAttribute("contentList");
		contentList = tapToSpace(contentList);
	}*/


	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setAttribute("textLines", textLines);
		request.getRequestDispatcher("list_course_contents.jsp").forward(request, response);
	}
	
	private List<String> tapToSpace(List<String[]> contentList) {
		List<String> lineList = new ArrayList<>();
		if(contentList != null) {
			for(String[] contents : contentList) {
				//empty line 처리
				if(isEmptyLine(contents)) {
					continue;
				}
				for(int i = 0; i <contents.length; i++) {
					if(contents[i].length() == 0) {
						//contents[i] = "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"
						contents[i] = "<span class=\"tab\">";
						contents[contents.length - 1] = contents[contents.length - 1] + "</span>";
					}
				}
			}
		}else {
			lineList.add("no data");
		}
		String line = "";
		for(String[] contents : contentList) {
			for(String s : contents) {
				line += s;
			}
			lineList.add(line);
			line="";
		}
		return lineList;
	}

	private boolean isEmptyLine(String[] contents) {
		return false;
	}

}
