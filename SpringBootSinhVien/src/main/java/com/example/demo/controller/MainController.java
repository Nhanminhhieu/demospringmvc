package com.example.demo.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.dao.StudentDAO;
import com.example.demo.dao.UserDAO;
import com.example.demo.entities.Student;
import com.example.demo.entities.StudentInfo;
import com.example.demo.entities.User;

@Controller
public class MainController {
	
	@RequestMapping(value = { "/","Login" }, method = RequestMethod.GET)
	    public String pageLogin() {
	 	     return "Login";
	    }
	  @Autowired
	   private UserDAO userDAO;
	   @Autowired
	   private StudentDAO studentDAO;
	    @RequestMapping(value = "/ListStudent", method = RequestMethod.POST)
	    public String pageListStudent(Model model, @RequestParam("user_name") String userName, @RequestParam("password_user") String passwordUser) {
	    	if(userDAO.checkUserAccount(userName,passwordUser)) {
	    	 User userAccount = userDAO.selectUserAcount(userName, passwordUser);
	    	 
	    	 List<StudentInfo> listStudent = studentDAO.listStudent();
	    		 model.addAttribute("liststudent", listStudent);
	    	 model.addAttribute("user_name", userAccount.getUserName());
	   	     return "ListStudent";
	    	}	 
	    	else
	    		return "Register";
	    }
	    @RequestMapping(value = "/Logout", method = RequestMethod.GET)
	    public String pageLogout() {
	 	     return "Login";
	    }
		@RequestMapping(value = { "Register" }, method = RequestMethod.GET)
	    public String pageRegister() {
	 	     return "Register";
	    }
		@RequestMapping(value = { "/Register" }, method = RequestMethod.POST)
	    public String pageRegisterAccount(@RequestParam("user_name") String userName, @RequestParam("password_user") String passwordUser, @RequestParam("password_user_confirm") String passwordUserConfirm) {
			userDAO.insertUser(userName, passwordUser, passwordUserConfirm);
	 	     return "Register";
	    }
		@RequestMapping(value = { "/AddStudent" }, method = RequestMethod.GET)
	    public String pageRegisterStudent() {
	 	     return "RegisterStudent";
	    }
		@RequestMapping(value = { "/save" }, method = RequestMethod.POST)
	    public String pageRegisterAccount(Model model, @ModelAttribute("student") Student student) {
			 //model.addAttribute("test", student.getStudentName());
	 	     return "Register";
	    }
		
}
