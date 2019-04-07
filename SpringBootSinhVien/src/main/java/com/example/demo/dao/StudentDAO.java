package com.example.demo.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.demo.entities.StudentInfo;

@Repository
@Transactional
public class StudentDAO {
	@Autowired
	 private SessionFactory sessionFactory;
     
   public StudentDAO() {
   }
   public List<StudentInfo> listStudent() {
		String sql = "select * from student_info, student WHERE student_info.student_id = student.student_id";
	      Session session = this.sessionFactory.getCurrentSession();
	      Query<StudentInfo> query = session.createNativeQuery(sql, StudentInfo.class);
	    
	    	  return query.getResultList();	      	    
      }
	
   public boolean insertStudent(String id, String studentCode, String studentName, String birthday, String address, String averagScore) {
		String sqlSudent ="INSERT INTO student VALUES (NULL,'"+ studentName +"','"+ studentCode +"')";
		String sqlSudentInfo ="INSERT INTO student_info VALUES (NULL,'"+ id +"','"+ address +"','"+ averagScore +"','"+ birthday +"')";
	    Session session = this.sessionFactory.getCurrentSession();
	    Query<?> query = session.createNativeQuery(sqlSudent);
	    Query<?> query1 = session.createNativeQuery(sqlSudentInfo);
	    if(query.executeUpdate() > 0 && query1.executeUpdate() > 0)
	    	  return true;
	      else 
	    	return false;			
   }
   
}
