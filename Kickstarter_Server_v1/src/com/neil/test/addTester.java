package com.neil.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.neil.hibernate.dao.UserDao;
import com.neil.hibernate.entities.User;
import com.neil.spring.model.LoginDetails;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"/com/neil/spring/hibernate/spring-hibernate.xml"})
public class addTester {

	
	@Autowired
	UserDao udao;
	
	
	@Test
	public void Test1(){
		User user = new User();
		user.setUsername("nillohit");
		user.setPassword("nandi");
		
		UserDao udao = new UserDao();
		System.out.println(udao.createUserHibernate(user));
		
		
		
	}
	
	
	@Test
	public void Test3(){
		User user = new User();
		user.setUsername("nillohit");
		user.setPassword("nandi");
		
		LoginDetails ld = new LoginDetails();
		ld.setPassword("nandi");
		ld.setUsername("nillohit");
		
		UserDao udao = new UserDao();
		System.out.println("Authenticate:  "+udao.authenticateUser(ld));
		
		
		
	}
	
	
	@Test
	public void Test2(){
		User user = new User();
		user.setUsername("rishi");
		user.setPassword("nandi");
		
		Integer id= udao.createUser(user);
		System.out.println("ID======"+id);
		
	}
	
	
	
}
