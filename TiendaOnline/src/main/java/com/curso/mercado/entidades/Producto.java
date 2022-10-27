package com.curso.mercado.entidades;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.*;

@Entity
@Table(name="PRODUCTOS")
public class Producto implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id @Column(name="ID_PRODUCTO")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="PRODUCTO_SEQ") //Gestionará la generación de la PK
	@SequenceGenerator(sequenceName="CURSO_SEQ", name="PRODUCTO_SEQ", allocationSize=1) //Se vincula a la secuencia
	private Integer idProducto;
	@Column(name="DESRIPCION")
	private String descripcion;
	@Column(name="PRECIO")
	private double precio;
	@Column(name="STOCK")
	private int stock;
	
	
	public Producto() {
		super();
	}


	public Producto(Integer idProducto, String descripcion, double precio, int stock) {
		super();
		this.idProducto = idProducto;
		this.descripcion = descripcion;
		this.precio = precio;
		this.stock = stock;
	}


	public Integer getIdProducto() {
		return idProducto;
	}


	public void setIdProducto(Integer idProducto) {
		this.idProducto = idProducto;
	}


	public String getDescripcion() {
		return descripcion;
	}


	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}


	public double getPrecio() {
		return precio;
	}


	public void setPrecio(double precio) {
		this.precio = precio;
	}

	
	public int getStock() {
		return stock;
	}
	
	public void setStock(int stock) {
		this.stock = stock;
	}

	@Override
	public String toString() {
		return "Producto [idProducto=" + idProducto + ", descripcion=" + descripcion + ", precio=" + precio + "]";
	}


	@Override
	public int hashCode() {
		return Objects.hash(idProducto);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Producto other = (Producto) obj;
		return Objects.equals(idProducto, other.idProducto);
	}
	
	
	

}
