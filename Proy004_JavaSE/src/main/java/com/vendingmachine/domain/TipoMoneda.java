package com.vendingmachine.domain;

public enum TipoMoneda {
	CINCO_CENTS(5),
	DIEZ_CENTS(10),
	VEINTE_CENTS(20),
	CINCUENTA_CENTS(50),
	UN_EURO(100),
	DOS_EUROS(200);
	
	private int valor;
	
	private TipoMoneda(int valor) {
		this.valor = valor;
	}
	
	public int getValor() {
		return this.valor;
	}
}
