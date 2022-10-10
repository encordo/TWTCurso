package com.mybank.staff;

public class Director extends Gerente {
	private double vehiculoEmpresa;

	public Director(String nombre, double salario,String departamento, double ve) {
		super(nombre, salario, departamento);
		// TODO Auto-generated constructor stub
		this.vehiculoEmpresa = ve;
	}
	
	public String getDetails() {
		return super.getDetails() + "\nVehículo de empresa: " + this.vehiculoEmpresa;
	}
	
	public void aumentarComision() {
		
	}

}
