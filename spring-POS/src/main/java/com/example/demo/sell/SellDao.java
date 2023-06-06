package com.example.demo.sell;

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

import com.example.demo.inventory.Inventory;

public class SellDao {
private JdbcTemplate jdbcTemplate;
	
	public SellDao(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	//재품 전체 조회
	public List<Sell> selectAll() {
		List<Sell>results = jdbcTemplate.query("select * from INVENTORY", 
				new RowMapper<Sell>() {
					@Override
					public Sell mapRow(ResultSet rs, int rowNum)throws SQLException{
						Sell sell = new Sell(
									rs.getString("ID"),
									rs.getString("NAME"),
									rs.getInt("price"),
									rs.getInt("count")
									);
						return sell;
					}
		});
		return results;
	}
	//재품 ID 검색
	public Sell selectByID(String ID) {
		System.out.print("select ");
		System.out.println(ID);
		
		List<Sell>results = jdbcTemplate.query("select * from INVENTORY where ID =?", 
				new RowMapper<Sell>() {
					@Override
					public Sell mapRow(ResultSet rs, int rowNum)throws SQLException{
						Sell sell = new Sell(
									rs.getString("ID"),
									rs.getString("NAME"),
									rs.getInt("price"),
									rs.getInt("count")
									);
						return sell;
					}
		},ID);
		System.out.println(results.get(0));
		return results.isEmpty()?null:results.get(0);
	}
	//제품 name 검색
	public Sell selectByName(String name) {
		System.out.print("select ");
		System.out.println(name);
		
		List<Sell>results = jdbcTemplate.query("select * from INVENTORY where NAME =?", 
				new RowMapper<Sell>() {
					@Override
					public Sell mapRow(ResultSet rs, int rowNum)throws SQLException{
						Sell sell = new Sell(
									rs.getString("ID"),
									rs.getString("NAME"),
									rs.getInt("price"),
									rs.getInt("count")
									);
						return sell;
					}
		},name);
		return results.isEmpty()?null:results.get(0);
	}
		//제품 정보 수정
		public void update(Sell sell) {
			jdbcTemplate.update("update INVENTORY set NAME=?, PRICE=?, COUNT=? "+"where ID=?",sell.getName(),sell.getPrice(),sell.getCount(), sell.getID());
		}
		
		//insert 통계 내역 추가
		public void insert(Statistics sell) {
			KeyHolder keyHolder = new GeneratedKeyHolder();
			jdbcTemplate.update(
				new PreparedStatementCreator() {
				@Override
				public PreparedStatement createPreparedStatement(Connection con)throws SQLException{
					PreparedStatement pstmt = con.prepareStatement("insert into STATISTICS (ID, NAME, PRICE, COUNT, SELLPRICE, SELLDATE) values (?, ?, ?, ?, ?, ?)", Statement.RETURN_GENERATED_KEYS);
					pstmt.setString(1, sell.getID());
					pstmt.setString(2, sell.getName());
					pstmt.setInt(3, sell.getPrice());
					pstmt.setInt(4, sell.getCount());
					pstmt.setInt(5, sell.getSellPrice());
					pstmt.setObject(6, sell.getSellDate());
					
					return pstmt;
				}
			},keyHolder );
		}
		//
		public void delete(Sell sell) {
			jdbcTemplate.update("delete from INVENTORY where ID=? and PRICE=? and COUNT=?",sell.getID(),sell.getPrice(),sell.getCount());
		}
}
