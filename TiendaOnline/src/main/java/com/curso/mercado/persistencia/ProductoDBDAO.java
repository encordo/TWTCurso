package com.curso.mercado.persistencia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.curso.mercado.entidades.Producto;

public class ProductoDBDAO implements GenericDAO<Producto> {
	
	private Connection con;
	
	public ProductoDBDAO(Connection con) {
		this.con = con;
	}

	@Override
	public void add(Producto entidad) {
		//Construye la sentencia
		String sentencia = "INSERT INTO PRODUCTOS (ID_PRODUCTO,DESCRIPCION,PRECIO,STOCK) VALUES(?,?,?,?)";
		try {
			//Nuevo ID
			int id=0;
			//Obtener el id
			id = getLastId(entidad) + 1;
			//La configura y la lanza
			PreparedStatement ps = con.prepareStatement(sentencia);
			ps.setInt(1, id);
			ps.setString(2, entidad.getDescripcion());
			ps.setDouble(3, entidad.getPrecio());
			ps.setInt(4, entidad.getStock());
			ps.executeUpdate();
			System.out.println("Insert OK");
		} catch (SQLException e) {
			//e.printStackTrace();
			//Se deriva la riada de fallos a RuntimeException
			throw new RuntimeException("DB JDBC AP. " + e.getMessage(),e);
		}
		
	}

	@Override
	public List<Producto> getAll() {
		//Construye query
		String consulta = "SELECT * FROM PRODUCTOS ORDER BY ID_PRODUCTO";
		//Inicializa ArrayList de Productos
		ArrayList<Producto> alProductos = new ArrayList<Producto>();
		try {
			//Lanza query
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(consulta);
			//Recoge los resultados en el ArrayList
			while(rs.next()) {
				Producto producto = new Producto();
				producto.setIdProducto(rs.getInt(1));
				producto.setDescripcion(rs.getString(2));
				producto.setPrecio(rs.getDouble(3));
				producto.setStock(rs.getInt(4));
				alProductos.add(producto);
			}
		} catch (SQLException e) {
			//e.printStackTrace();
			//Se deriva la riada de fallos a RuntimeException
			throw new RuntimeException("DB JDBC AP. " + e.getMessage(),e);
		}
		//Lo devuelve
		return alProductos;
	}

	@Override
	public Producto getByID(int id) {
		//Construye query
		String consulta = "SELECT * FROM PRODUCTOS WHERE ID_PRODUCTO = ?";
		Producto producto = null;
		try {
			//Configura las variables y la lanza
			PreparedStatement ps = con.prepareStatement(consulta);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			//Recoge los resultados
			if(rs.next()) {
				producto = new Producto();
				producto.setIdProducto(rs.getInt(1));
				producto.setDescripcion(rs.getString(2));
				producto.setPrecio(rs.getDouble(3));
				producto.setStock(rs.getInt(4));
			}
		} catch (SQLException e) {
			//e.printStackTrace();
			//Se deriva la riada de fallos a RuntimeException
			throw new RuntimeException("DB JDBC AP. " + e.getMessage(),e);
		}
		return producto;
	}

	@Override
	public void delete(int id) {
		//Construye la sentencia
		String sentencia = "DELETE FROM PRODUCTOS WHERE ID_PRODUCTO = ?";
		try {
			//La configura y la lanza
			PreparedStatement ps = con.prepareStatement(sentencia);
			ps.setInt(1, id);
			ps.executeUpdate();
		} catch (SQLException e) {
			//e.printStackTrace();
			//Se deriva la riada de fallos a RuntimeException
			throw new RuntimeException("DB JDBC AP. " + e.getMessage(),e);
		}
		
	}

	@Override
	public void update(Producto entidad) {
		//Construye la sentencia
		String sentencia = "UPDATE PRODUCTOS SET DESCRIPCION=?, PRECIO=?, STOCK=? WHERE ID_PRODUCTO = ?";
		try {
			//La configura y la lanza
			PreparedStatement ps = con.prepareStatement(sentencia);
			ps.setString(1, entidad.getDescripcion());
			ps.setDouble(2, entidad.getPrecio());
			ps.setInt(3, entidad.getStock());
			ps.setInt(4, entidad.getIdProducto());
			ps.executeUpdate();
		} catch (SQLException e) {
			//e.printStackTrace();
			//Se deriva la riada de fallos a RuntimeException
			throw new RuntimeException("DB JDBC AP. " + e.getMessage(),e);
		}
		
	}
	
	private int getLastId(Producto entidad) {
		String consulta = "SELECT MAX(ID_PRODUCTO) FROM PRODUCTOS";
		int lastId = 0;
		try {
			//Lanza query
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(consulta);
			//Recoge los resultados en el ArrayList
			if(rs.next()) {
				lastId = rs.getInt(1);
			}
		} catch (SQLException e) {
			//e.printStackTrace();
			//Se deriva la riada de fallos a RuntimeException
			throw new RuntimeException("DB JDBC AP. " + e.getMessage(),e);
		}
		return lastId;
	}

}
