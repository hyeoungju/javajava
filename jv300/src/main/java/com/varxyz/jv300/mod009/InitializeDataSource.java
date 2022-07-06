package com.varxyz.jv300.mod009;

import java.io.InputStream;
import java.util.Properties;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;


@WebListener
public class InitializeDataSource implements ServletContextListener {
	private static final String JDBC_FILE_PATH = "/WEB-INF/classes/jdbc.properties";

    public void contextDestroyed(ServletContextEvent event)  { 
        
    }

    public void contextInitialized(ServletContextEvent event)  { 
    	 ServletContext context = event.getServletContext();
         InputStream is = null;
         try {
			is = context.getResourceAsStream(JDBC_FILE_PATH);
			Properties prop = new Properties();
			prop.load(is);
			
			String jdbcDriver = prop.getProperty("jdbc.dirver");
			String jdbcUrl = prop.getProperty("jdbc.url");
			String userName= prop.getProperty("jdbc.username");
			String password = prop.getProperty("jdbc.password");

			Datasource dataSource = new Datasource(jdbcDriver, jdbcUrl, userName, password);
			
			NamingService namingService = NamingService.getInstance();
			namingService.setAttribute("dataSource", dataSource);
			
			System.out.println("dataSource has been initialized");
			//connetion을 저장한것보단 dataSource를 저장하는게 더 잘한것..
			
		} catch (Exception e) {
			e.printStackTrace();
		}
    }
	
}
