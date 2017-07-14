package com.tom.springjdbc.daoimpl;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

import com.tom.springjdbc.bean.Student;
import com.tom.springjdbc.dao.StudentDAO;

public class StudentImplDAO extends JdbcDaoSupport implements StudentDAO {
    /*
     * 2
	private DataSource dataSource;
	
	private JdbcTemplate jdbcTemplate;
	
	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}
	*/
	//@Override
	public void addStudent(Student student) throws Exception{
		
		String sql = ""+
					"insert into student "+
					"(id,name,qq,type,enterDate,school,stId,link,word,TA,source,update_at,create_at) "+
					"values(" +
					"?,?,?,?,?,?,?,?,?,?,?,?,?)";
		getJdbcTemplate().update(sql, new Object[] { student.getId(),
				student.getName(),student.getQq(),student.getType(),student.getEnterDate(),
				student.getSchool(),student.getStId(),student.getLink(),student.getWord(),
				student.gettA(),student.getSource(),student.getUpdate_at(),student.getCreate_at()
			});
		
		/*
		 * 2.使用jdbctemplate 没有继承jdbcdaosupport
		jdbcTemplate = new JdbcTemplate(dataSource);
		jdbcTemplate.update(sql, new Object[] { student.getId(),
				student.getName(),student.getQq(),student.getType(),student.getEnterDate(),
				student.getSchool(),student.getStId(),student.getLink(),student.getWord(),
				student.gettA(),student.getSource(),student.getUpdate_at(),student.getCreate_at()
			});
		*/
		/*
		 * 1.不使用jdbctemplate
		 * 
		Connection conn=dataSource.getConnection(); 
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
		*/
	}
	//@Override
	public void updateStudent(Student student) throws Exception{
		
		String sql = ""+
					"update student "+
					"set name=?,qq=?,type=?,enterDate=?,school=?,stId=?,link=?,word=?,TA=?,source=?,update_at=?,create_at=? "+
					"where id=?";
		getJdbcTemplate().update(sql, new Object[] { student.getName(),student.getQq(),
				student.getType(),student.getEnterDate(),student.getSchool(),
				student.getStId(),student.getLink(),student.getWord(),
				student.gettA(),student.getSource(),student.getUpdate_at(),
				student.getCreate_at(),student.getId()
			});
		
		/*
		 * 2
		jdbcTemplate = new JdbcTemplate(dataSource);
		jdbcTemplate.update(sql, new Object[] { student.getName(),student.getQq(),
				student.getType(),student.getEnterDate(),student.getSchool(),
				student.getStId(),student.getLink(),student.getWord(),
				student.gettA(),student.getSource(),student.getUpdate_at(),
				student.getCreate_at(),student.getId()
			});
		*/
		/*
		 * 1
		Connection conn=dataSource.getConnection(); 
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
		*/
	}
	//@Override
	public void delStudent(Long id) throws Exception{
		
		String sql = ""+
					"delete from student "+
					"where id=?";
		
		getJdbcTemplate().update(sql,new Object[] {id});
		
		/*
		 * 2
		jdbcTemplate = new JdbcTemplate(dataSource);
		jdbcTemplate.update(sql,new Object[] {id});
		*/
		/*
		 * 1
		Connection conn=dataSource.getConnection(); 
		PreparedStatement ptmt = conn.prepareStatement(sql);
		ptmt.setLong(1, id);
		ptmt.execute();
		*/
		
	}
	//@Override
	public Student get(Long id) throws Exception{
		
		String sql = ""+
					"select * from student "+
					"where id=?";
		Student student = null;
		
		student = (Student)getJdbcTemplate().queryForObject(sql, new Object[] {id},
				new BeanPropertyRowMapper<Student>(Student.class));
		
		/*
		 * 2
		jdbcTemplate = new JdbcTemplate(dataSource);
		student = (Student)jdbcTemplate.queryForObject(sql, new Object[] {id},
				new BeanPropertyRowMapper<Student>(Student.class));
		*/
		/*
		 * 1
		Connection conn=dataSource.getConnection(); 
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
		*/
		return student;
	}
	//@Override
	public List<Student> query() throws Exception{
		
		String sql = ""+
					"select * from student";
		
		List<Student> sl = getJdbcTemplate().query(sql,new BeanPropertyRowMapper<Student>(Student.class));
		
		/*
		 * 2 List<Student> sl = jdbcTemplate.query(sql,new BeanPropertyRowMapper<Student>(Student.class));
		 */
		
		/*
		 * 1
		Connection conn=dataSource.getConnection(); 
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
		*/
		return sl;
	}
}
