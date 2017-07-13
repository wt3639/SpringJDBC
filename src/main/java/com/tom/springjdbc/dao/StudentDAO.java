package com.tom.springjdbc.dao;

import java.util.List;

import com.tom.springjdbc.bean.Student;

public interface StudentDAO {
	public void addStudent(Student student) throws Exception;
	public void updateStudent(Student student) throws Exception;
	public Student get(Long id) throws Exception;
	public void delStudent(Long id) throws Exception;
    public List<Student> query() throws Exception ;

}