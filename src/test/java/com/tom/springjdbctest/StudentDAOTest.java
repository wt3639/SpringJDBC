package com.tom.springjdbctest;

import static org.junit.Assert.*;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import com.tom.springjdbc.bean.Student;
import com.tom.springjdbc.dao.StudentDAO;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring-module.xml") 
@TransactionConfiguration(transactionManager = "transactionManager", defaultRollback = true)  
 
public class StudentDAOTest extends AbstractTransactionalJUnit4SpringContextTests{
	
	@Autowired  
	private StudentDAO studentDAO; 
	/*
	ApplicationContext context = new ClassPathXmlApplicationContext("spring-module.xml");				 
	SqlSessionFactory sqlSessionFactory = (SqlSessionFactory) context.getBean("sqlSessionFactory");
	SqlSession session = sqlSessionFactory.openSession();
	StudentDAO studentDAO = session.getMapper(StudentDAO.class);
	*/
	@Test
	 @Transactional    
	 
	public void testGet() throws Exception {
		Student student1 = studentDAO.get(1L);
		Assert.assertEquals("id:1 name:刘佳义 school:河北科技大学 qq:1060015371",student1.toString()); 
		
	}
	@Test
	@Transactional   //标明此方法需使用事务  

	public void testUpdate() throws Exception{
		Student student2 = new Student();
		student2.setId(6L);
		student2.setName("Wo");
		studentDAO.updateStudent(student2);
		Student student3 = studentDAO.get(6L);
		Assert.assertEquals("Wo",student3.getName());
	}
	
	@Test
    @Transactional   //标明此方法使用事务

	public void testDelete() throws Exception  {
		studentDAO.delStudent(6L);
		Assert.assertEquals(null,studentDAO.get(6L));
	}
	
	@Test
	@Transactional
	public void testAdd() throws Exception{
		Student student = new Student();
		//student.setId(35L);
		student.setName("lianlian");
		student.setSchool("xiada");
		studentDAO.addStudent(student);
		Assert.assertEquals("lianlian",studentDAO.get(43L).getName());
	}
	
}
