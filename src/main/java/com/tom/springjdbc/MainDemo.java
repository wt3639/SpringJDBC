package com.tom.springjdbc;

import java.io.IOException;
import java.io.InputStream;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.transaction.TransactionConfiguration;

import com.tom.springjdbc.bean.Student;
import com.tom.springjdbc.dao.StudentDAO;
import com.tom.springjdbc.serviceimpl.StudentService;

//@ContextConfiguration(locations = "spring-module.xml") 
//@TransactionConfiguration(transactionManager = "transactionManager", defaultRollback = false) 
public class MainDemo {
	@Autowired
	StudentService studentService;
	
	public static void main(String[] args) {

		
		
		/*
		 * use mybatis
		 */
		/*
		String resource = "mybatis-config.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		SqlSession session = sqlSessionFactory.openSession();
		*/
		
		ApplicationContext context = new ClassPathXmlApplicationContext("spring-module.xml");				 
		//StudentDAO studentDAO = (StudentDAO) context.getBean("studentDAO");
		StudentService studentDAO = (StudentService) context.getBean("studentService");
		//SqlSessionFactory sqlSessionFactory = (SqlSessionFactory) context.getBean("sqlSessionFactory");
		//SqlSession session = sqlSessionFactory.openSession();
		//StudentService studentDAO = session.getMapper(StudentService.class);
		try {
			/*
			for(int i=0;i<100;i++){
				Student student = new Student();
				student.setName("No."+i);
				student.setSchool(""+i+"zhong");
				studentDAO.addStudent(student);
			}*/
			/*
			Student student2 = studentDAO.selectByName("No.22");
			student2.setName("Wo");
			boolean result = studentDAO.updateStudent(student2);
			*/
			Date date = new Date(studentDAO.selectByName("Wo").getUpdate_at());
			System.out.println(date);
			/*
			Student student1 = studentDAO.get(1L);
			System.out.println(student1); 
			Student student = new Student();
			//student.setId(15L);
			student.setName("lianlian");
			student.setSchool("xiada");
			studentDAO.addStudent(student);
			studentDAO.delStudent(25L);
			Student student2 = new Student();
			student2.setId(6L);
			student2.setName("Qii");
			studentDAO.updateStudent(student2);
			List<Student> lS = null;
			lS = studentDAO.query();
			Iterator<Student> iter = lS.iterator();
			while (iter.hasNext()) {
				System.out.println(iter.next());

			}
		*/
			/*
			 * Student student1= (Student)
			 * session.selectOne("com.tom.springjdbc.dao.StudentDAO.get", 1L);
			 * System.out.println(student1); Student student = new Student();
			 * student.setName("lianlian"); student.setSchool("xiada");
			 * session.insert("com.tom.springjdbc.dao.StudentDAO.addStudent",
			 * student);
			 * session.delete("com.tom.springjdbc.dao.StudentDAO.delStudent",
			 * 24L); Student student2 = new Student(); student2.setId(6L);
			 * student2.setName("Qii");
			 * session.update("com.tom.springjdbc.dao.StudentDAO.updateStudent",
			 * student2); List<Student> lS = null; lS =
			 * session.selectList("com.tom.springjdbc.dao.StudentDAO.query");
			 * Iterator iter = lS.iterator(); while(iter.hasNext()){
			 * System.out.println(iter.next());
			 * 
			 * }
			 */
		
		//	session.commit();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("exception caught");
			e.printStackTrace();
		} finally {
			//session.close();
		}

		/*
		 * use jdbcTemplate try {
		 * 
		 * 
		 * 
		 * ApplicationContext context = new
		 * ClassPathXmlApplicationContext("spring-module.xml");
		 * 
		 * StudentDAO studentDAO = (StudentDAO) context.getBean("studentDAO");
		 * Student student = new Student(); student.setName("lucy");
		 * student.setSchool("beida"); studentDAO.addStudent(student); Student
		 * student2 = new Student(); student2.setId(5L); student2.setName("Qi");
		 * studentDAO.updateStudent(student2); studentDAO.delStudent(23L);
		 * Student student1 = studentDAO.get(1L); System.out.println(student1);
		 * List<Student> lS = null; lS = studentDAO.query(); Iterator iter =
		 * lS.iterator(); while(iter.hasNext()){
		 * System.out.println(iter.next());
		 * 
		 * } } catch (Exception e) { // TODO Auto-generated catch block
		 * e.printStackTrace(); }
		 */
	}
}
