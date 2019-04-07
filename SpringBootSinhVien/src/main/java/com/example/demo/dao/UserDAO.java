package com.example.demo.dao;



import javax.transaction.Transactional;

import org.hibernate.query.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.demo.entities.User;

@Repository
@Transactional
public class UserDAO {
	@Autowired
	 private SessionFactory sessionFactory;
      
    public UserDAO() {
    }
   
	public User selectUserAcount(String userName, String passwordUser) {
		String sql = "select * from user where user.user_name ='" + userName + "' and user.password = '" + passwordUser + "'";
	      Session session = this.sessionFactory.getCurrentSession();
	      Query<User> query = session.createNativeQuery(sql, User.class);
	      try {
	    	  return query.getSingleResult();
	      }
		  catch (Exception e) {
			// TODO: handle exception
			  return null;
		}
       }
	public Boolean checkUserAccount (String userName, String passwordUser) {
		String sql = "select * from user where user.user_name ='" + userName + "' and user.password = '" + passwordUser + "'";
	      Session session = this.sessionFactory.getCurrentSession();
	      Query<User> query = session.createNativeQuery(sql, User.class);
	      		try {
	      			query.getSingleResult();
	      			return true;
	      		}
	      		catch (Exception e) {
					return false;
				}
     }
	public Boolean insertUser(String userName, String passwordUser, String passwordUserConfirm) {
		if(passwordUser.equals(passwordUserConfirm))
		{
			String sql ="INSERT INTO user VALUES (NULL,'" + userName + "', '" + passwordUser + "')"; // lỗ hổng injection;
		      Session session = this.sessionFactory.getCurrentSession();
		      Query<?> query = session.createNativeQuery(sql);
		      if(query.executeUpdate() > 0)
		    	  return true;
		      else 
		    	return false;			
		}
		return false;
	}
}