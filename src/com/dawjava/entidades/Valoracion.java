package com.dawjava.entidades;

import java.util.LinkedHashMap;

public class Valoracion {
	// Atributos
	private int idpuntuacion;
	private int puntuacion = 0;
	private boolean especial = false;
	private LinkedHashMap<Audicion, Integer> valoraciones = new LinkedHashMap<Audicion, Integer>();

	/**
	 * Constructor por defecto
	 */
	public Valoracion() {
		this.valoraciones = new LinkedHashMap<Audicion, Integer>();
	}

	/**
	 * Constructor con todos los parametros
	 * 
	 * @param idpuntuacion
	 * @param puntuacion
	 * @param especial
	 * @param puntuaciones
	 */
	public Valoracion(int idpuntuacion, int puntuacion, boolean especial,
			LinkedHashMap<Audicion, Integer> puntuaciones) {
		this.idpuntuacion = idpuntuacion;
		this.puntuacion = puntuacion;
		this.especial = especial;
		this.valoraciones = puntuaciones;
	}

	/**
	 * Constructor copia para la Puntuación
	 * 
	 * @param nota
	 */

	public Valoracion(Valoracion nota) {
		this.idpuntuacion = nota.idpuntuacion;
		this.puntuacion = nota.puntuacion;
		this.especial = nota.especial;
		this.valoraciones = nota.valoraciones;
	}

	// Metodos publicos

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
		return valoraciones;
	}

	public void setPuntuaciones(LinkedHashMap<Audicion, Integer> puntuaciones) {
		this.valoraciones = puntuaciones;
	}

	/**
	 * Muestra toda la información de Puntuacion
	 * 
	 * @return la información de la Puntuación
	 */
	@Override
	public String toString() {
		return "Puntuacion [idpuntuacion=" + idpuntuacion + ", puntuacion=" + puntuacion + ", especial=" + especial
				+ ", puntuaciones=" + valoraciones + "]";
	}

}
