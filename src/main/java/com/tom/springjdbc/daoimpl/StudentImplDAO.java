package com.tom.springjdbc.daoimpl;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import com.tom.springjdbc.bean.Student;
import com.tom.springjdbc.dao.StudentDAO;

public class StudentImplDAO implements StudentDAO {
    
	private DataSource DBUtil;
	
	public void setDataSource(DataSource dataSource) {
		this.DBUtil = dataSource;
	}
	
	@Override
	public void addStudent(Student student) throws Exception{
		Connection conn=DBUtil.getConnection(); 
		String sql = ""+
					"insert into student "+
					"(id,name,qq,type,enterDate,school,stId,link,word,TA,source,update_at,create_at) "+
					"values(" +
					"?,?,?,?,?,?,?,?,?,?,?,?,?)";
		PreparedStatement ptmt = conn.prepareStatement(sql);
		
		ptmt.setLong(1, student.getId());
		ptmt.setString(2, student.getName());
		ptmt.setString(3, student.getQq());
		ptmt.setString(4, student.getType());
		ptmt.setString(5, student.getEnterDate());
		ptmt.setString(6, student.getSchool());
		ptmt.setString(7, student.getStId());
		ptmt.setString(8, student.getLink());
		ptmt.setString(9, student.getWord());
		ptmt.setString(10, student.gettA());
		ptmt.setString(11, student.getSource());
		ptmt.setLong(12, student.getUpdate_at());
		ptmt.setLong(13, student.getCreate_at());
		ptmt.execute();
		
	}
	@Override
	public void updateStudent(Student student) throws Exception{
		Connection conn=DBUtil.getConnection(); 
		String sql = ""+
					"update student "+
					"set name=?,qq=?,type=?,enterDate=?,school=?,stId=?,link=?,word=?,TA=?,source=?,update_at=?,create_at=?) "+
					"where id=?";
		PreparedStatement ptmt = conn.prepareStatement(sql);
		
		ptmt.setLong(13, student.getId());
		ptmt.setString(1, student.getName());
		ptmt.setString(2, student.getQq());
		ptmt.setString(3, student.getType());
		ptmt.setString(4, student.getEnterDate());
		ptmt.setString(5, student.getSchool());
		ptmt.setString(6, student.getStId());
		ptmt.setString(7, student.getLink());
		ptmt.setString(8, student.getWord());
		ptmt.setString(9, student.gettA());
		ptmt.setString(10, student.getSource());
		ptmt.setLong(11, student.getUpdate_at());
		ptmt.setLong(12, student.getCreate_at());
		ptmt.execute();
	}
	@Override
	public void delStudent(Long id) throws Exception{
		Connection conn=DBUtil.getConnection(); 
		String sql = ""+
					"delete from student "+
					"where id=?";
		PreparedStatement ptmt = conn.prepareStatement(sql);
		ptmt.setLong(1, id);
		ptmt.execute();
		
	}
	@Override
	public Student get(Long id) throws Exception{
		Connection conn=DBUtil.getConnection(); 
		String sql = ""+
					"select * from student "+
					"where id=?";
		PreparedStatement ptmt = conn.prepareStatement(sql);
		ptmt.setLong(1, id);
		ResultSet rs = ptmt.executeQuery();
		Student student = null;
		while(rs.next()){
			student = new Student();
			student.setId(rs.getLong("id"));
			student.setName(rs.getString("name"));
			student.setQq(rs.getString("qq"));
			student.setType(rs.getString("type"));
			student.setEnterDate(rs.getString("enterDate"));
			student.setSchool(rs.getString("school"));
			student.setStId(rs.getString("stId"));
			student.setLink(rs.getString("link"));
			student.setWord(rs.getString("word"));
			student.settA(rs.getString("TA"));
			student.setSource(rs.getString("source"));
			student.setUpdate_at(rs.getLong("update_at"));
			student.setCreate_at(rs.getLong("create_at"));
		}
		return student;
	}
	@Override
	public List<Student> query() throws Exception{
		Connection conn=DBUtil.getConnection(); 
		String sql = ""+
					"select * from student";
		PreparedStatement ptmt = conn.prepareStatement(sql);
		ResultSet rs = ptmt.executeQuery(sql);
		Student student = null;
		List<Student> sl = new ArrayList<Student>();
		while(rs.next()){
			student = new Student();
			student.setId(rs.getLong("id"));
			student.setName(rs.getString("name"));
			student.setQq(rs.getString("qq"));
			student.setType(rs.getString("type"));
			student.setEnterDate(rs.getString("enterDate"));
			student.setSchool(rs.getString("school"));
			student.setStId(rs.getString("stId"));
			student.setLink(rs.getString("link"));
			student.setWord(rs.getString("word"));
			student.settA(rs.getString("TA"));
			student.setSource(rs.getString("source"));
			student.setUpdate_at(rs.getLong("update_at"));
			student.setCreate_at(rs.getLong("create_at"));
			sl.add(student);
		}
		return sl;
	}
}
