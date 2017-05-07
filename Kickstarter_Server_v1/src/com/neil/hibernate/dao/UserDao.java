package com.neil.hibernate.dao;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.neil.hibernate.entities.User;
import com.neil.hibernate.utilities.HibernateUtil;
import com.neil.spring.model.LoginDetails;

@Repository
public class UserDao {
	
	
//	@Autowired
//	private HibernateTemplate template;
	
	
	
	
		public Integer createUser(User user) {
			try{
				Session session=HibernateUtil.getSession();
				Transaction tx=session.beginTransaction();
				session.save(user);
				tx.commit();
				session.close();
			}catch(Exception e){
				e.printStackTrace();
			}
			return user.getUserID();
		}
		
		
		public boolean authenticateUser(LoginDetails ld) {
			
			User user = new User();
			user.setUsername(ld.getUsername());
			user.setPassword(ld.getPassword());
			
			boolean flag=false;
			try{
				String sqlQuery="select USER_ID,USER_NAME,PASSWORD FROM user where USER_NAME=? AND PASSWORD=? LIMIT 1";	
				
				Session session= HibernateUtil.getSession();
				Query query= session.createSQLQuery(sqlQuery);
				query.setString(0, ld.getUsername());
				query.setString(1, ld.getPassword());

				Object[] ob=(Object[]) query.uniqueResult();
				System.out.println(ob);
				System.out.println(ob[0]);
				System.out.println(ob[1]);
				System.out.println(ob[2]);

				if(ld.getUsername().equals(ob[1])&&ld.getPassword().equals(ob[2])){
					System.out.println("Valid User");
					flag=true;
				}
		
			}
			catch(Exception e){
				e.printStackTrace();

			}
		
			return flag;	
			}
		
	
	
	public Integer createUserHibernate(User user) {
		try{
			Session session=HibernateUtil.getSession();
			Transaction tx=session.beginTransaction();
			session.save(user);
			tx.commit();
			session.close();
		}catch(Exception e){
			e.printStackTrace();
		}
		return user.getUserID();
	}

}
