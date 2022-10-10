package com.mybank.staff;

public class Empleado {
	private String nombre;
	private double salario;
	
	public Empleado(String nombre, double salario) {
		this.nombre = nombre;
		this.salario = salario;
		
	}
	public String getDetails() {
		return "Nombre: " + this.nombre + "\nSalario: " + this.salario + "€";
	}

}
