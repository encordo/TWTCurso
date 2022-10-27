package com.curso.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public final class PoolConexiones {
	private String url = "jdbc:oracle:thin:@localhost:49161:xe";
	/*
	 * private String usr = "system"; private String clave = "oracle";
	 */
	private String usr = "HR";
	private String clave = "hr";

	public PoolConexiones() {
		//1-Carga del driver y gestión de sus excepciones
		try {
	
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("cargó ok");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			throw new RuntimeException("No cargó el driver ");
		}
		
	}
	
	public Connection getConnection() {
		Connection con;
		try {
			con = DriverManager.getConnection(url, usr, clave);
			System.out.println("Conectado con " + usr);
		}catch(SQLException e) {
			//Se deriva la riada de fallos a RuntimeException
			throw new RuntimeException("DB JDBC AP. " + e.getMessage(),e);
		}
		return con;
	}
}
