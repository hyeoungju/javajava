package com.varxyz.jvx330.jdbc.example3;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.varxyz.jvx330.jdbc.Customer;
import com.varxyz.jvx330.jdbc.DataSourceConfig;
import com.varxyz.jvx330.jdbc.example1.AddCustomerDao;

public class CustomerDaoTest {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = 
				new AnnotationConfigApplicationContext(DataSourceConfig.class);
		
		CustomerDao dao = context.getBean("customerDao", CustomerDao.class);
//		findAllCustomers(dao);
//		findCustomerByRegDate(dao);
		findCustomerByEmail(dao);
//		countCustomers(dao);
		context.close();
		
	}
	
	public static void findAllCustomers(CustomerDao dao) {
		System.out.println("[findAllCustomers()]");
		dao.findAllCustomers().forEach(c -> System.out.println(c));
	}
	
	public static void findCustomerByRegDate(CustomerDao dao) {
		System.out.println("[findCustomerByRegDate()]");
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		Date currentDate = null;
		try {
			currentDate = format.parse(format.format(new Date()));
		} catch (Exception e) {
			e.printStackTrace();
		}
		List<Customer> list = dao.findCustomerByRegDate(currentDate);
		for(Customer customer : list) {
			System.out.println(customer);
		}
	}
	
	
	
	public static void findCustomerByEmail(CustomerDao dao) {
		System.out.println("[findCustomerByEmail()]");
		dao.findCustomerByEmail("yubi@java.com");
		System.out.println(dao);
	}
	
}
