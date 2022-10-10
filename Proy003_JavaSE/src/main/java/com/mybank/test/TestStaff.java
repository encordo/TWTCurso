package com.mybank.test;

import com.mybank.staff.*;

public class TestStaff {

	public static void main(String[] args) {
		Empleado cajero = new Empleado("Rosendo Cebolleta",25000);
		Gerente dSucursal = new Gerente("Fulgencio Menéndez",60000,"Fondos de inversión");
		Director dRegional = new Director("Luismi Molina",120000, "Telco", 18000);
		
		System.out.println(cajero.getDetails() + "\n");
		System.out.println(dSucursal.getDetails() + "\n");
		System.out.println(dRegional.getDetails() + "\n");

	}

}
