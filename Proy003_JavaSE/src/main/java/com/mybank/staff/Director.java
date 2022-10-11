package com.mybank.staff;

public class Director extends Gerente {
	//ATRS
	private double vehiculoEmpresa;
	//CNRS
	public Director(String nombre, double salario,String departamento, double ve) {
		super(nombre, salario, departamento);
		this.vehiculoEmpresa = ve;
	}
	
	public Director(String nombre,String departamento, double ve) {
		super(nombre,departamento);
		this.vehiculoEmpresa = ve;
	}
	//METS
	public String getDetails() {
		return super.getDetails() + "\nVehículo de empresa: " + this.vehiculoEmpresa;
	}
	
	public void aumentarComision() {
		
	}

}
