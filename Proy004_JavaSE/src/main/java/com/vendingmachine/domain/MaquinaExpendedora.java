package com.vendingmachine.domain;

import java.util.ArrayList;

public class MaquinaExpendedora {
	
	//ATRIBUTOS*****************************************************************************************************************************
	private int caja; // Recaudación en céntimos.
	private int creditoIntroducido; // Crédito introducido por el usuario.
	private int capacidadSlot; //Capacidad máxima de cada slot.
	//private Refresco [] refrescos; //Slots con refrescos a vender.
	private ArrayList<Refresco> refrescos;
	
	//CONSTRUCTORES*************************************************************************************************************************
	/**
	 * Método constructor de la máquina expendedora.
	 * @param numeroSlots int que indica el número de slots que tendrá la máquina.
	 * @param capacidadSlot int que indica la capacidad (número de unidades) de los slots (ya que se supone que serán los mismos para todos).
	 */
	public MaquinaExpendedora(int numeroSlots, int capacidadSlot){
		this.caja  = 0;
		this.creditoIntroducido = 0;
		this.capacidadSlot = capacidadSlot;
		this.refrescos = new ArrayList<Refresco>(capacidadSlot);
		/*
		 * for(int i=0; i<numeroSlots; i++) { refrescos[i] = new Refresco(); }
		 */
	}
	
	//MÉTODOS********************************************************************************************************************************
	/**
	 * Método para configurar un slot de referesco.
	 * @param posRefresco int de la posición del refresco.
	 * @param nombre String con el nombre del refersco.
	 * @param precio int precio del refresco en céntimos.
	 */
	public void configurarRefesco(int posRefresco, String nombre, int precio) {
		//Mete los parámetros. Se considera que el stock se llena al máximo.
		Refresco r = new Refresco();
		r.setNombre(nombre);
		r.setPrecio(precio);
		r.setStock(this.capacidadSlot);
		refrescos.add(r);
	}
	
	/**
	 * Método que ejecuta la inserción de una moneda de 5 céntimos.
	 */
	public void meterCredito() {
		//Suma 5 por meterse en monedas de 5
		this.creditoIntroducido += 5;
	}
	
	/**
	 * Método que ejecuta la devolución del cambio.
	 */
	public int devolverCambio() {
		//Pone a 0 ya que se devuelve todo el crédito restante
		int vueltas = this.creditoIntroducido;
		this.creditoIntroducido = 0;
		return vueltas;
	}
	
	/**
	 * Método que repone un refersco a partir de su posición rellenando hasta llenar.
	 * @param posRefresco índice del slot a reponer.
	 * @return int del número de refresco que ha habido que añadir.
	 */
	public int reponerRefresco(int posRefresco) {
		//Calcula cuantos refrescos hay que añadir hasta llenar el slot
		int cantidadRepuesta = this.refrescos.size() - this.refrescos.get(posRefresco).getStock();
		//Pone el slot al máximo.
		this.refrescos.get(posRefresco).setStock(capacidadSlot);
		//Devuelve el número de refescos añadidos para rellenar.
		return cantidadRepuesta;
	}
	
	/**
	 * Método que gestiona la venta de un refesco.
	 * @param posRefresco índice del refesco a vender.
	 * @param creditoIntroducido saldo en céntimos que se ha introducido.
	 * @return boolean que indica el éxito o fracaso de la venta.
	 */
	public boolean venderRefresco(int posRefresco) {
		//Comprueba que el refresco no esté agotado
		if(!refrescoAgotado(posRefresco)) { //this.refrescos.get(posRefresco)
			//Comprueba que hay crédito suficiente para comprar el refesco indicado
			if(this.creditoIntroducido >= this.refrescos.get(posRefresco).getPrecio()) {
				//Comprueba si hay cambios para la cantidad introducida.
				if(this.caja > this.creditoIntroducido - this.refrescos.get(posRefresco).getPrecio()) {
					//Resta un refresco al stock
					this.refrescos.get(posRefresco).setStock(this.refrescos.get(posRefresco).getStock()-1);
					//Se añade el precio del refesco al saldo de la caja.
					this.caja += this.refrescos.get(posRefresco).getPrecio();
					//Devuelve el cambio
					devolverCambio();
					//Devuelve verdadero para confirmar que se ha hecho la venta.
					return true;
				} else {
					//Devuelve falso para informar de que no se ha podido hacer la venta por falta de cambio
					return false;
				}	
			//Devuelve falso para informar de que no se ha podido hacer la venta por falta de crédito.
			} else {
				return false;
			}
		}else {
			//Devuelve falso por no poderse hacer la venta por estar el refresco elegido agotado.
			return false;
		}
	}	

	/**
	 * Método para comprobar si el refresco está agotado.
	 * @param posRefresco índice del refersco a comprobar.
	 * @return boolean que da verdadero si realmente no hay stock del refresco consultado.
	 */
	public boolean refrescoAgotado(int posRefresco) {
		//Comprueba y devuelve resultados segun descrito arriba.
		if(this.refrescos.get(posRefresco).getStock() == 0) {
			return true;
		}else {
			return false;
		}
	}
	
	/**
	 * Método para recaudar. Se descontará toda la caja salvo e saldo especificado que servirá de cambios.
	 * @param saldo int del saldo a dejar en cambios
	 * @return int de la recaudación. Si la caja es inferior al saldo, dará 0.
	 */
	public int recaudar(int saldo) {
		int recaudacion = 0;
		if (this.caja >= saldo) {
			recaudacion = this.caja - saldo;
			this.caja = saldo;
		}
		return recaudacion;
	}
	
	/**
	 * Método que muestra el infome de ventas.
	 * @return String informe de ventas en formato texto.
	 */
	public String mostrarInformeVentas() {
		return "";
	}
	
	/**
	 * Método que devuelve el crédito introducido
	 * @return int del crédito introducido
	 */
	public int getCreditoIntroduzido() {
		return this.creditoIntroducido;
	}
	
	/**
	 * Método que devuelve la caja (recaudación).
	 * @return int de la caja
	 */
	public int getCaja() {
		return this.caja;
	}
	
	/**
	 * Método que que permite configurar el saldo de la caja (de cara a cuanto disponible dejar después de coger la recaudación).
	 * @param saldo
	 */
	public void setCaja(int saldo) {
		this.caja = saldo;
	}
}
