package com.vendingmachine.domain;

public class Refresco {

	//ATRIBUTOS
	private int precio; //El precio en centimos??
	private String nombre; //El nombre
	private int stock; //El stock.
	
	
	//CONSTRUCTORES
	Refresco(){
		this.precio = 0;
		this.nombre = "";
		this.stock = 0;
	}
	Refresco(int precio, String nombre){
		this();
		this.precio = precio;
		this.nombre = nombre;
	}

	//MÉTODOS

	public int getPrecio() {
		return precio;
	}


	public void setPrecio(int precio) {
		this.precio = precio;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public int getStock() {
		return stock;
	}


	public void setStock(int stock) {
		this.stock = stock;
	}
	
}
