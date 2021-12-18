package com.dawjava.entidades;

import java.util.LinkedHashMap;

public class Valoracion {
	//Atributos
	private int idpuntuacion;
	private int puntuacion;
	private boolean especial;
	private LinkedHashMap<Audicion,Integer>puntuaciones=new LinkedHashMap<Audicion,Integer>();
	
	/**
	 * Constructor por defecto
	 */
	public Valoracion() {
		this.idpuntuacion=0;
		this.puntuacion=0;
		this.especial=false;
		this.puntuaciones=new LinkedHashMap<Audicion,Integer>();
	}
	/**
	 * Constructor con todos los parametros 
	 * @param idpuntuacion
	 * @param puntuacion
	 * @param especial
	 * @param puntuaciones
	 */
	public Valoracion(int idpuntuacion,int puntuacion,boolean especial,LinkedHashMap<Audicion,Integer>puntuaciones) {
		this.idpuntuacion=idpuntuacion;
		this.puntuacion=puntuacion;
		this.especial=especial;
		this.puntuaciones=new LinkedHashMap<Audicion,Integer>();
	}
	/**
	 * Constructor copia para la Puntuación
	 * @param nota
	 */
	
	public Valoracion(Valoracion nota) {
		this.idpuntuacion=nota.idpuntuacion;
		this.puntuacion=nota.puntuacion;
		this.especial=nota.especial;
		this.puntuaciones=nota.puntuaciones;
	}
	
	
	//Metodos publicos


	public int getIdpuntuacion() {
		return idpuntuacion;
	}


	public void setIdpuntuacion(int idpuntuacion) {
		this.idpuntuacion = idpuntuacion;
	}


	public int getPuntuacion() {
		return puntuacion;
	}


	public void setPuntuacion(int puntuacion) {
		this.puntuacion = puntuacion;
	}


	public boolean isEspecial() {
		return especial;
	}


	public void setEspecial(boolean especial) {
		this.especial = especial;
	}


	public LinkedHashMap<Audicion, Integer> getPuntuaciones() {
		return puntuaciones;
	}


	public void setPuntuaciones(LinkedHashMap<Audicion, Integer> puntuaciones) {
		this.puntuaciones = puntuaciones;
	}
	/**
	 * Muestra toda la información de Puntuacion
	 * @return la información de la Puntuación
	 */
	@Override
	public String toString() {
		return "Puntuacion [idpuntuacion=" + idpuntuacion + ", puntuacion=" + puntuacion + ", especial=" + especial
				+ ", puntuaciones=" + puntuaciones + "]";
	} 

	
}
