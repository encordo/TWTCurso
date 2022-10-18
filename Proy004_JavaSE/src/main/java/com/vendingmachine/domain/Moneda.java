package com.vendingmachine.domain;

public class Moneda {
	
	private TipoMoneda tipo;
	
	private Moneda(TipoMoneda tipo) {
		this.tipo = tipo;
	}
	
	public TipoMoneda getValor() {
		return this.tipo;
	}
	
	public static Moneda getValidMoneda(TipoMoneda tipo) {
		return new Moneda(tipo);
	}
}
