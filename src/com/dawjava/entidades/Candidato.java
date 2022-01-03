package com.dawjava.entidades;

import java.sql.Date;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;

public class Candidato {
	static final DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

	// Atributos

	private int idcandidato;
	private String nombre;
	private String ciudad;
	private Date fechainscripcion;
	private boolean finalista = false;
	private Audicion prueba;

	// Constructores
	/**
	 * Constructor por defecto
	 */

	public Candidato() {
	}

	/**
	 * Constructor con 4 parametros
	 * 
	 * @param idcandidato
	 * @param nombre
	 * @param ciudad
	 * @param fechainscripcion
	 */
	public Candidato(int idcandidato, String nombre, String ciudad, Date fechainscripcion) {
		this.idcandidato = idcandidato;
		this.nombre = nombre;
		this.ciudad = ciudad;
		this.fechainscripcion = fechainscripcion;
	}

	/**
	 * Constructor con todos los parametros
	 * 
	 * @param idcandidato
	 * @param nombre
	 * @param ciudad
	 * @param fechainscripcion
	 * @param finalista
	 *
	 */
	public Candidato(int idcandidato, String nombre, String ciudad, Date fechainscripcion, boolean finalista,
			Audicion prueba) {
		this.idcandidato = idcandidato;
		this.nombre = nombre;
		this.ciudad = ciudad;
		this.fechainscripcion = fechainscripcion;
		this.finalista = finalista;
		this.prueba = prueba;

	}

	/**
	 * Constructor con un parametro de la propia clase Candidato.LLamado constructor
	 * copia
	 * 
	 * @param c
	 */
	public Candidato(Candidato c) {
		this.idcandidato = c.idcandidato;
		this.nombre = c.nombre;
		this.ciudad = c.ciudad;
		this.fechainscripcion = c.fechainscripcion;
		this.finalista = c.finalista;
		this.prueba = c.prueba;

	}

	/**
	 * Constructor con tres parametros
	 * 
	 * @param idcandidato
	 * @param nombre
	 * @param fechainscripcion
	 */

	public Candidato(int idcandidato, String nombre, Date fechainscripcion) {
		this.idcandidato = idcandidato;
		this.nombre = nombre;
		this.fechainscripcion = fechainscripcion;
	}

	// Metodos publicos
	public int getIdcandidato() {
		return idcandidato;
	}

	public void setIdcandidato(int idcandidato) {
		this.idcandidato = idcandidato;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getCiudad() {
		return ciudad;
	}

	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}

	public Date getFechainscripcion() {
		return fechainscripcion;
	}

	public void setFechainscripcion(Date fechainscripcion) {
		this.fechainscripcion = fechainscripcion;
	}

	public boolean isFinalista() {
		return finalista;
	}

	public void setFinalista(boolean finalista) {
		this.finalista = finalista;
	}

	public Audicion getPrueba() {
		return prueba;
	}

	public void setPrueba(Audicion prueba) {
		this.prueba = prueba;
	}

	
	/**
	 * Metodo que retorna toda la información sobre los candidatos
	 * 
	 * @return la información sobre los candidatos
	 */
	@Override
	public String toString() {
		return "Candidato [idcandidato=" + idcandidato + ", nombre=" + nombre + ", ciudad=" + ciudad
				+ ", fechainscripcion=" + fechainscripcion + ", finalista=" + finalista + ", prueba=" + prueba + "]";
	}

	
	

}
