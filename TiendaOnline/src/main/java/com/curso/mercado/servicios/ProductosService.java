package com.curso.mercado.servicios;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

import com.curso.db.PoolConexiones;
import com.curso.mercado.entidades.Producto;
import com.curso.mercado.persistencia.GenericDAO;
import com.curso.mercado.persistencia.ProductoDBDAO;
import com.curso.mercado.persistencia.ProductoInMemoryDAO;

public class ProductosService {
	
	private GenericDAO<Producto> dao;
	
	public ProductosService() {
		PoolConexiones pc = new PoolConexiones();
		this.dao = new ProductoDBDAO(pc.getConnection());
		
	}
	
	public void darAltaUnProducto(Producto p) {
		//Validar no null
		if(p == null) {
			System.out.println("No se ha pasado producto");
		//Validar descripcion	
		} else if(p.getDescripcion().equals("")){
			System.out.println("No hay descripción");
		//Validar precio
		} else if(p.getPrecio()==0) {
			System.out.println("No tiene precio");
		} else {
			dao.add(p);
		}
	}
	
	public List<Producto> dameTodosLosProductos(){
		return dao.getAll();
	}
}
