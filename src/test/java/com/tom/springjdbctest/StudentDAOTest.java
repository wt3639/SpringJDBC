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

import com.tom.springjdbc.basetest.BaseTest;
import com.tom.springjdbc.bean.Student;
import com.tom.springjdbc.dao.StudentDAO;
import com.tom.springjdbc.service.IStudentService;
import com.tom.springjdbc.serviceimpl.StudentService;


 
public class StudentDAOTest extends BaseTest{
	
	@Autowired  
	private StudentDAO studentDAO; 

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
		studentDAO.delStudent(16L);
		Assert.assertEquals(null,studentDAO.get(16L));
	}
	
	@Test
	@Transactional
	public void testAdd() throws Exception{
		Student student = new Student();
		//student.setId(35L);
		student.setName("datian");
		student.setSchool("xiada");
		student.setQq("2333333");
		studentDAO.addStudent(student);
		Assert.assertEquals("datian",studentDAO.selectByQq("2333333").getName());
	}
	
	@Test
	@Transactional
	public void testSelectByName() throws Exception{
		
		Student student =studentDAO.selectByName("No.11");
		Assert.assertEquals("11zhong", student.getSchool());
	}
	
	@Test
	@Transactional
	public void testSelectByStId() throws Exception{
		
		Student student =studentDAO.selectByStId("38");
		Assert.assertEquals("刘佳义", student.getName());
	}
	
}
