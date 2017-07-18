package com.tom.springjdbc.serviceimpl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.tom.springjdbc.bean.Student;
import com.tom.springjdbc.dao.StudentDAO;

public class StudentService {
	ApplicationContext context = new ClassPathXmlApplicationContext("spring-module.xml");				 
	//StudentDAO studentDAO = (StudentDAO) context.getBean("studentDAO");
	SqlSessionFactory sqlSessionFactory = (SqlSessionFactory) context.getBean("sqlSessionFactory");
	SqlSession session = sqlSessionFactory.openSession();
	StudentDAO studentDAO = session.getMapper(StudentDAO.class);
	public int addStudent(Student student) throws Exception{
		
		int result = studentDAO.addStudent(student);
		return result;
	}
	
	public boolean updateStudent(Student student) throws Exception{
		int result = studentDAO.updateStudent(student);
		if(result>0)
			return true;
		else 
			return false;
	}
	public Student selectById(Long id) throws Exception{
		Student st = studentDAO.get(id);
		return st;
				
	}
	public boolean delStudent(Long id) throws Exception{
		int result = studentDAO.delStudent(id);
		if(result>0)
			return true;
		else 
			return false;
	}
    public List<Student> selectAll() throws Exception{
    	List<Student> ls = studentDAO.query();
    	return ls;
    }
    public Student selectByQq(String qq) throws Exception{
    	Student st = studentDAO.selectByQq(qq);
		return st;
    }
    public Student selectByName(String name) throws Exception{
    	Student st = studentDAO.selectByName(name);
		return st;
    }
    public Student selectByStId(String stId) throws Exception{
    	Student st = studentDAO.selectByStId(stId);
		return st;
    }
}
