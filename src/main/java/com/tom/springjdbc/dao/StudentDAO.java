package com.tom.springjdbc.dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.tom.springjdbc.bean.Student;

public interface StudentDAO {
	//@Insert("insert into student (name,qq,type,enterDate,school,stId,link,word,TA,source,update_at,create_at) values(#{name},#{qq},#{type},#{enterDate},#{school},#{stId},#{link},#{word},#{tA},#{source},unix_timestamp(now()),unix_timestamp(now()))")
	//@Options(useGeneratedKeys=true,keyProperty="id")
	public int addStudent(Student student) throws Exception;
	//@Update(" update student set name=#{name},qq=#{qq},type=#{type},enterDate=#{enterDate},school=#{school},stId=#{stId},link=#{link},word=#{word},TA=#{tA},source=#{source},update_at=unix_timestamp(now()),create_at=#{create_at} where id = #{id}")
	public int updateStudent(Student student) throws Exception;
	//@Select("select * from student where id = #{id}")
	public Student get(Long id) throws Exception;
	//@Delete("delete from student where id = #{id}")
	public int delStudent(Long id) throws Exception;
	//@Select("select * from student")
    public List<Student> query() throws Exception ;
	//@Select("select * from student where qq=#{qq}")
    public Student selectByQq(String qq) throws Exception;
	//@Select("select * from student where name=#{name}")
    public Student selectByName(String name) throws Exception;
	//@Select("select * from student where stId=#{stId}")
    public Student selectByStId(String stId) throws Exception;
}