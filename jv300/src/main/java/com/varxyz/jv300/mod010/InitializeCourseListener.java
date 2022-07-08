package com.varxyz.jv300.mod010;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;


@WebListener
public class InitializeCourseListener implements ServletContextListener {

	@Override
    public void contextDestroyed(ServletContextEvent event)  { 
		System.out.println("contextDestroyed() method called");
		
		
		
    }
	
	@Override
    public void contextInitialized(ServletContextEvent event)  { 
		System.out.println("contextInitialized() method called");
		
		ServletContext context = event.getServletContext();
		InputStream is = null;
		BufferedReader reader = null;
		List<String[]> contentList = new ArrayList<>();
		try {
			is = context.getResourceAsStream("/WEB-INF/classes/course_contents.txt");
			reader = new BufferedReader(new InputStreamReader(is)); //decorating pattern
			String record = null;
			while((record = reader.readLine()) !=null) {
				record = escapeHtml(record);
				String[] fields = record.split("\t");
				contentList.add(fields);
			}
			context.setAttribute("contentList", contentList);
			System.out.println("The course contents has been loaded");
		}catch(Exception e) {
			e.printStackTrace();
		}
    }
	
	private String escapeHtml(String line) {
		if(line.length() == 0) {
			return line;
		}
		return line.replace("<", "&lt;").replace(">", "&gt;");
	}
	
}
