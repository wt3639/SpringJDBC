package com.tom.springjdbctest.servicetest;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.tom.springjdbc.basetest.BaseTest;
import com.tom.springjdbc.bean.Student;
import com.tom.springjdbc.serviceimpl.StudentService;

public class ServiceTest extends BaseTest{
	
	@Autowired
	StudentService studentService;
	
	@Test
	 @Transactional    
	 
	public void testGet() throws Exception {
		Student student1 = studentService.selectById(1L);
		Assert.assertEquals("id:1 name:������ school:�ӱ��Ƽ���ѧ qq:1060015371",student1.toString()); 
		
	}
	@Test
	@Transactional   //�����˷�����ʹ������  

	public void testUpdate() throws Exception{
		Student student2 = new Student();
		student2.setId(6L);
		student2.setName("Wo");
		boolean result = studentService.updateStudent(student2);
		Assert.assertEquals(true,result);
	}
	
	@Test
   @Transactional   //�����˷���ʹ������

	public void testDelete() throws Exception  {
		boolean result =studentService.delStudent(16L);
		Assert.assertEquals(true,result);
	}
	
	@Test
	@Transactional
	public void testAdd() throws Exception{
		Student student = new Student();
		//student.setId(35L);
		student.setName("datian");
		student.setSchool("xiada");
		student.setQq("2333333");
		studentService.addStudent(student);
		Assert.assertEquals("datian",studentService.selectByQq("2333333").getName());
	}
	
	@Test
	@Transactional
	public void testSelectByName() throws Exception{
		
		Student student =studentService.selectByName("No.7777");
		Assert.assertEquals("7777zhong", student.getSchool());
	}
	
	@Test
	@Transactional
	public void testSelectByStId() throws Exception{
		
		Student student =studentService.selectByStId("38");
		Assert.assertEquals("������", student.getName());
	}

}
