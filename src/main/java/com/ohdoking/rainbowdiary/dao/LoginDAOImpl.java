package com.ohdoking.rainbowdiary.dao;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import com.ohdoking.rainbowdiary.model.User;

@Repository("loginDAO")
public class LoginDAOImpl implements LoginDAO{
     
			 
       @Resource(name="sessionFactory")
       protected SessionFactory sessionFactory;

       public void setSessionFactory(SessionFactory sessionFactory) {
              this.sessionFactory = sessionFactory;
       }
      
       protected Session getSession(){
//              return sessionFactory.openSession();
              Session sess = sessionFactory.getCurrentSession();
              if (sess == null) {
                     sess = sessionFactory.openSession();
              }
              
              return sess;
       }

       public boolean checkLogin(String userName, String userPassword){
			System.out.println("In Check login");
			Session session = sessionFactory.openSession();
			boolean userFound = false;
			//Query using Hibernate Query Language
			String SQL_QUERY =" from User as o where o.userId=? and o.password=?";
			Query query = session.createQuery(SQL_QUERY);
			query.setParameter(0,userName);
			query.setParameter(1,userPassword);
			List list = query.list();

			if ((list != null) && (list.size() > 0)) {
				userFound= true;
			}

			session.close();
			return userFound;              
       }

	public void registerUser(String userName, String userPassword, String name) {
		// TODO Auto-generated method stub
		User user = new User();
		user.setUserId(userName);
		user.setPassword(userPassword);
		user.setName(name);
		
		Session session=getSession();
		   Transaction trans=session.beginTransaction();
		   session.save(user);
		   trans.commit();
		
		
	}
}