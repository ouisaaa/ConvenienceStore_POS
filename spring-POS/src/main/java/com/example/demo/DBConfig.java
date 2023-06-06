package com.example.demo;

import org.apache.tomcat.jdbc.pool.DataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.example.demo.Worker.WorkerDao;
import com.example.demo.Worker.WorkerDeleteService;
import com.example.demo.Worker.WorkerModifyService;
import com.example.demo.Worker.WorkerRegisterService;
import com.example.demo.inventory.InventoryDao;
import com.example.demo.inventory.InventoryDeleteService;
import com.example.demo.inventory.InventoryModifyService;
import com.example.demo.inventory.InventoryRegisterService;
import com.example.demo.sell.SellDao;
import com.example.demo.sell.SellSearchService;
import com.example.demo.sell.SellStatisticsRegister;

@Configuration
public class DBConfig {
	@Bean(destroyMethod = "close")
	public DataSource dataSource() {
		DataSource ds = new DataSource();
		ds.setDriverClassName("com.mysql.cj.jdbc.Driver");
		ds.setUrl("jdbc:mysql://localhost/spring_pos?characterEncoding=utf8&serverTimezone=UTC");
		ds.setUsername("root");
		ds.setPassword("1234");
		ds.setInitialSize(2);
		ds.setMaxActive(10);
		ds.setTestWhileIdle(true);
		ds.setMinEvictableIdleTimeMillis(60000 * 3);
		ds.setTimeBetweenEvictionRunsMillis(10 * 1000);
		return ds;
	}
	//직원 관리
	@Bean
	public WorkerDao workerDao() {
		return new WorkerDao(dataSource());
	}
	@Bean
	public WorkerRegisterService workerRegisterService() {
		return new WorkerRegisterService(workerDao());
	}
	@Bean
	public WorkerModifyService workerModifyService() {
		return new WorkerModifyService(workerDao());
	}
	@Bean
	public WorkerDeleteService workerDeleteService() {
		return new WorkerDeleteService(workerDao());
	}
	//재고관리
	@Bean
	public InventoryDao inventoryDao() {
		return new InventoryDao(dataSource());
	}
	@Bean
	public InventoryRegisterService inventoryRegisterService() {
		return new InventoryRegisterService(inventoryDao());
	}
	@Bean
	public InventoryModifyService inventoryModifyService() {
		return new InventoryModifyService(inventoryDao());
	}
	@Bean
	public InventoryDeleteService inventoryDeleteService() {
		return new InventoryDeleteService(inventoryDao());
	}
	//Sell 관리
	@Bean
	public SellDao sellDao() {
		return new SellDao(dataSource());
	}
	@Bean
	public SellSearchService sellSearchService() {
		return new SellSearchService(sellDao());
	}
	@Bean
	public SellStatisticsRegister sellStatisticsRegister() {
		return new SellStatisticsRegister(sellDao());
	}
}
