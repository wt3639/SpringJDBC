package com.tom.springjdbc.serviceimpl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tom.springjdbc.bean.Student;
import com.tom.springjdbc.dao.StudentDAO;
import com.tom.springjdbc.service.IStudentService;

@Service
public class StudentService implements IStudentService{
	@Autowired  
	StudentDAO studentDAO;
	
	   
	public int addStudent(Student student) throws Exception{
		//Long time = new Date().getTime();
		//student.setCreate_at(time);
		//student.setUpdate_at(time);
		int result = studentDAO.addStudent(student);
		return result;
	}
	 
	public boolean updateStudent(Student student) throws Exception{
		//student.setUpdate_at(new Date().getTime());
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
