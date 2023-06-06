package com.example.demo.inventory;

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


public class InventoryDao {
	private JdbcTemplate jdbcTemplate;
	
	public InventoryDao(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	//재품 전체 조회
	public List<Inventory> selectAll() {
		List<Inventory>results = jdbcTemplate.query("select * from INVENTORY", 
				new RowMapper<Inventory>() {
					@Override
					public Inventory mapRow(ResultSet rs, int rowNum)throws SQLException{
						Inventory inventory = new Inventory(
									rs.getString("ID"),
									rs.getString("NAME"),
									rs.getInt("price"),
									rs.getInt("count"),
									rs.getInt("expiration_date")
									);
						return inventory;
					}
		});
		return results;
	}
	
	//재품 ID 검색
	public Inventory selectByID(String ID) {
		System.out.print("select ");
		System.out.println(ID);
		
		List<Inventory>results = jdbcTemplate.query("select * from INVENTORY where ID =?", 
				new RowMapper<Inventory>() {
					@Override
					public Inventory mapRow(ResultSet rs, int rowNum)throws SQLException{
						Inventory inventory = new Inventory(
									rs.getString("ID"),
									rs.getString("NAME"),
									rs.getInt("price"),
									rs.getInt("count"),
									rs.getInt("expiration_date")
									);
						return inventory;
					}
		},ID);
		return results.isEmpty()?null:results.get(0);
	}
	/**
	//재품 count 검색
		public int selectByCount(String ID) {
			Inventory results = jdbcTemplate.queryForObject("select COUNT from MEMBER where ID=?", 
					new RowMapper<Inventory>() {
						@Override
						public Inventory mapRow(ResultSet rs, int rowNum)throws SQLException{
							Inventory inventory = new Inventory(
										rs.getString("ID"),
										rs.getInt("count")
									);
							return inventory;
						}
			},ID);
			return results.getCount();
		}
		**/
	//제품 정보 수정
	public void update(Inventory inventory) {
		jdbcTemplate.update("update INVENTORY set NAME=?, PRICE=?, COUNT=?, EXPIRATION_DATE=? "+"where ID=?",inventory.getName(),inventory.getPrice(),inventory.getCount(),inventory.getExpiration_date(),inventory.getID());
	}
	
	//insert 새로운 재품 등록
	public void insert(Inventory inventory) {
		KeyHolder keyHolder = new GeneratedKeyHolder();
		jdbcTemplate.update(
			new PreparedStatementCreator() {
			@Override
			public PreparedStatement createPreparedStatement(Connection con)throws SQLException{
				PreparedStatement pstmt = con.prepareStatement("insert into INVENTORY (ID, NAME, PRICE, COUNT,EXPIRATION_DATE) values (?, ?, ?, ?, ?)", Statement.RETURN_GENERATED_KEYS);
				pstmt.setString(1, inventory.getID());
				pstmt.setString(2, inventory.getName());
				pstmt.setInt(3, inventory.getPrice());
				pstmt.setInt(4, inventory.getCount());
				pstmt.setInt(5, inventory.getExpiration_date());
				
				return pstmt;
			}
		},keyHolder );
	}
	//
	public void delete(Inventory inventory) {
		jdbcTemplate.update("delete from INVENTORY where ID=? and PRICE=? and COUNT=? and EXPIRATION_DATE=?",inventory.getID(),inventory.getPrice(),inventory.getCount(),inventory.getExpiration_date());
	}
}
