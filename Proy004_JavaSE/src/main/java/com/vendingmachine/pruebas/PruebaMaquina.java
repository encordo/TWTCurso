package com.vendingmachine.pruebas;

import com.vendingmachine.domain.MaquinaExpendedora;

public class PruebaMaquina {

	public static void main(String[] args) {
		//Genera la máquina y la inicializa: 8 refrescos a 18 unidades por referesco.
		MaquinaExpendedora me = new MaquinaExpendedora(8, 32);
		String [] catalogo = {"Coca Cola","Coca Cola Zero","Coca Cola sin cafeina","Fanta Naranja",
							  "Fanta Limón", "Sprite", "Mountain Dew"};
		for(int i = 0; i<catalogo.length; i++) {
			me.configurarRefesco(i, catalogo[i], 90);
		}
		//El agua aparte por ser más barata.
		me.configurarRefesco(7, "Agua", 50);
		//
		me.setCaja(500);
		
		//Simulación de una compra
		//Introduce 15 monedas
		for(int i=0; i<15; i++) {
			me.meterCredito();
			System.out.println("Moneda metida, Saldo:" + me.getCreditoIntroduzido());
		}
		//Escoge Coca Cola. Fallará por saldo insuficiente
		if(me.venderRefresco(0)){
			System.out.println("¡Gracias por su compra!");
		} else {
			System.out.println("Credito introducido insuficente");
		}
		//introduce las 3 monedas restantes.
		for(int i=0; i<3; i++) {
			me.meterCredito();
			System.out.println("Moneda metida, Saldo:" + me.getCreditoIntroduzido());
		}
		//Escoge Coca Cola. Tendrá exito
		if(me.venderRefresco(0)){
			System.out.println("¡Gracias por su compra!");
		} else {
			System.out.println("Credito introducido insuficente");
		}
		System.out.println("Caja: " + me.getCaja());
	}

}
