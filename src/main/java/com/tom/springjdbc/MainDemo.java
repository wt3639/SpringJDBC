package com.tom.springjdbc;

import java.util.Iterator;
import java.util.List;

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
				    student.setName("lucy");
				    student.setSchool("beida");
				    studentDAO.addStudent(student);
				    Student student2 = new Student();
				    student2.setId(5L);
				    student2.setName("Qi");
				    studentDAO.updateStudent(student2);
				    studentDAO.delStudent(23L);
				    Student student1 = studentDAO.get(1L);
				    System.out.println(student1);
				    List<Student> lS = null;
				    lS = studentDAO.query();
				    Iterator iter = lS.iterator();
				    while(iter.hasNext()){
				    	System.out.println(iter.next());
				    }
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
}
}
