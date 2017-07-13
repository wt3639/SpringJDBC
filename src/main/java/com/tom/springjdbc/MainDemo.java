package com.tom.springjdbc;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.tom.springjdbc.bean.Student;
import com.tom.springjdbc.dao.StudentDAO;



public class MainDemo {
	  public static void main( String[] args ) {
		    try {
				
					ApplicationContext context = new ClassPathXmlApplicationContext("spring-module.xml");
					 
				    StudentDAO studentDAO = (StudentDAO) context.getBean("studentDAO");
				    Student student = new Student();
				    student.setName("jack");
				    student.setSchool("qinghua");
				    studentDAO.addStudent(student);
				    studentDAO.delStudent(11L);
				    Student student1 = studentDAO.get(1L);
				    System.out.println(student1);
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
}
}
