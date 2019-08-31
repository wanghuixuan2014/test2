package com.cy.java.oop.abs;
import java.sql.Connection;

import javax.sql.DataSource;

import com.alibaba.druid.pool.DruidDataSource;
import com.mchange.v2.c3p0.ComboPooledDataSource;
import com.zaxxer.hikari.HikariDataSource;
public class TestInterface01 {
	public static void main(String[] args) throws Exception{
		//DataSource (javax.sql.*)
		//com.alibaba
		DataSource ds = newDruidDataSouce();
		//ds=newC3P0DataSource();
		ds=newHiKariCPDataSource();
		Connection conn=//java.sql.* 
		ds.getConnection();//com.mysql.jdbc.*
		System.out.println(conn);
	}
	//HikariCP 号称世界上最快的连接池
	public static DataSource newHiKariCPDataSource() {
		HikariDataSource ds=new HikariDataSource();
		ds.setDriverClassName("com.mysql.jdbc.Driver");
		ds.setJdbcUrl("jdbc:mysql:///jtsys?serverTimezone=GMT%2B8");
		ds.setUsername("root");
		ds.setPassword("root");
		return ds;
	}
	//c3p0
    private static DataSource newC3P0DataSource() throws Exception{
    	ComboPooledDataSource ds=
    	new ComboPooledDataSource();
    	ds.setDriverClass("com.mysql.jdbc.Driver");
    	ds.setJdbcUrl("jdbc:mysql:///jtsys?serverTimezone=GMT%2B8");
    	ds.setUser("root");
    	ds.setPassword("root");
    	return ds;
    }
    //druid
	private static DataSource newDruidDataSouce() {
		DruidDataSource ds=new DruidDataSource();
		ds.setDriverClassName("com.mysql.jdbc.Driver");
		ds.setUrl("jdbc:mysql:///jtsys?serverTimezone=GMT%2B8");
		ds.setUsername("root");
		ds.setPassword("root");
		return ds;
	}
}
