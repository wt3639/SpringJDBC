package com.tom.springjdbc.service;

import java.util.List;

import com.tom.springjdbc.bean.Student;

public interface IStudentService {
	public int addStudent(Student student) throws Exception;
	public boolean updateStudent(Student student) throws Exception;
	public Student selectById(Long id) throws Exception;
	public boolean delStudent(Long id) throws Exception;
    public List<Student> selectAll() throws Exception ;
    public Student selectByQq(String qq) throws Exception;
    public Student selectByName(String name) throws Exception;
    public Student selectByStId(String stId) throws Exception;
}
