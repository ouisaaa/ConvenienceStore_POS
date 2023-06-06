package com.example.demo.Worker;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;


public class WorkerDao {
private JdbcTemplate jdbcTemplate;
	
	public WorkerDao(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	//직원 리스트 전부 나오게
	public List<Worker> selectAll() {
		List<Worker> results = jdbcTemplate.query("select * from worker",(ResultSet rs, int rowNum) -> {
			Worker worker = new Worker(
					rs.getString("ID"),
					rs.getString("PASSWORD"),
					rs.getString("NAME"),
					rs.getTimestamp("START_DATE").toLocalDateTime(),
					rs.getString("TITLE")
					);
			
					return worker;
		});	
		return results;
	}
	
	//ID 중복 체크
	public Worker selectByID(String ID) {
		System.out.print("select ");
		System.out.println(ID);
		
		List<Worker>results = jdbcTemplate.query("select * from Worker where ID=?", 
				new RowMapper<Worker>() {
					@Override
					public Worker mapRow(ResultSet rs, int rowNum)throws SQLException{
						Worker worker = new Worker(
									rs.getString("ID"),
									rs.getString("PASSWORD"),
									rs.getString("NAME"),
									rs.getTimestamp("start_date").toLocalDateTime(),
									rs.getString("title")
									);
						return worker;
					}
		},ID);
		
		return results.isEmpty()?null:results.get(0);
	}
	//insert 명령
	public void insert(Worker worker) {
		KeyHolder keyHolder = new GeneratedKeyHolder();
		jdbcTemplate.update(
			new PreparedStatementCreator() {
			@Override
			public PreparedStatement createPreparedStatement(Connection con)throws SQLException{
				PreparedStatement pstmt = con.prepareStatement("insert into Worker (ID, PASSWORD, NAME, START_DATE, TITLE) values (?, ?, ?, ?, ?)", Statement.RETURN_GENERATED_KEYS);
				//, Statement.RETURN_GENERATED_KEYS의 파라미터 넣어주는 이유: PreparedStatementCallback; 증상 해결하기 위해

				pstmt.setString(1, worker.getID());
				pstmt.setString(2, worker.getPassword());
				pstmt.setString(3, worker.getName());
				pstmt.setObject(4, worker.getStart_date());
				pstmt.setString(5, worker.getTitle());
				
				return pstmt;
			}
		},keyHolder );
	
	}
	//update 명령
	public void update(Worker worker) {
		jdbcTemplate.update("update WORKER set NAME=?,PASSWORD=?,START_DATE=?, TITLE=? "+"where ID=?",worker.getName(),worker.getPassword(),worker.getStart_date(),worker.getTitle(),worker.getID());
	}
	//delete 명령
	public void delete(String ID) {
		jdbcTemplate.update("delete from WORKER where ID=?",ID);
		
	}
}
