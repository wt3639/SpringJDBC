package com.tom.springjdbc;

import java.io.IOException;
import java.io.InputStream;
import java.util.Iterator;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.tom.springjdbc.bean.Student;
import com.tom.springjdbc.dao.StudentDAO;



public class MainDemo {
	  public static void main( String[] args ) throws IOException {
		 /*
		  * use mybatis
		  */
		  String resource = "mybatis-config.xml";
		  InputStream inputStream = Resources.getResourceAsStream(resource);
		  SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		  SqlSession session = sqlSessionFactory.openSession();
		    	try {
		    	  Student student1= (Student) session.selectOne("com.tom.springjdbc.studentMapper.selectStudent", 1L);
		    	  System.out.println(student1);
		    	  Student student = new Student();
				  student.setName("lianlian");
			      student.setSchool("xiada");
		    	  session.insert("com.tom.springjdbc.studentMapper.insertStudent",student);
		    	  session.delete("com.tom.springjdbc.studentMapper.deleteStudent", 24L);
		    	  Student student2 = new Student();
				  student2.setId(6L);
				  student2.setName("Qii");
		    	  session.update("com.tom.springjdbc.studentMapper.updateStudent",student2);
		    	  List<Student> lS = null;
				    lS = session.selectList("com.tom.springjdbc.studentMapper.selectAllStudent");
				    Iterator iter = lS.iterator();
				    while(iter.hasNext()){
				    	System.out.println(iter.next());
				    	
				    }
		    	} finally {
		    	  session.close();
		    	}
		  
		    	
		    	/*
		    	 * use jdbcTemplate
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
			}*/
}
}
