package com.mybank.staff;

public class Empleado {
	//CONS
	public static final double SALARIO_BASE = 15000.0;
	//ATRS
	private String nombre;
	private double salario;
	//CNTS
	public Empleado(String nombre, double salario) {
		this.nombre = nombre;
		this.salario = (salario >= SALARIO_BASE ? salario : SALARIO_BASE);
	}
	
	public Empleado(String nombre) {
		this.nombre = nombre;
		this.salario = Empleado.SALARIO_BASE;
	}
	//METS
	
	public String getDetails() {
		return "Nombre: " + this.nombre + "\nSalario: " + this.salario + "€";
	}

}
