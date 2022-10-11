package com.mybank.staff;

public class Gerente extends Empleado {
	//ATRS
	private String departamento;
	//CNRS
	public Gerente(String nombre, double salario, String departamento) {
		super(nombre, salario);
		this.departamento=departamento;
	}
	
	public Gerente(String nombre, String departamento) {
		super(nombre);
		this.departamento = departamento;
	}
	//METS
	public String getDetails() {
		return super.getDetails() + "\nDepartamento: " + this.departamento;
	}

}
