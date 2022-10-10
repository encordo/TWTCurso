package com.mybank.staff;

public class Gerente extends Empleado {
	private String departamento;

	public Gerente(String nombre, double salario, String departamento) {
		super(nombre, salario);
		// TODO Auto-generated constructor stub
		this.departamento=departamento;
	}
	
	public String getDetails() {
		return super.getDetails() + "\nDepartamento: " + this.departamento;
	}

}
