package com.dawjava.entidades;

import java.sql.Date;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;

public class Candidatos {
	static final DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");


	// Atributos
	private int idcandidato;
	private String nombre;
	private String ciudad;
	private Date fechainscripcion;
	private boolean finalista=false;
	
	

	// Constructores
	/**
	 * Constructor por defecto
	 */
	public Candidatos() {	
		
	}
	
	/**
	 * Constructor con 4 parametros
	 * @param idcandidato
	 * @param nombre
	 * @param ciudad
	 * @param fechainscripcion
	 */
	public Candidatos(int idcandidato,String nombre,String ciudad,Date fechainscripcion) {
		this.idcandidato=idcandidato;
		this.nombre=nombre;
		this.ciudad=ciudad;
		this.fechainscripcion=fechainscripcion;
	}

	/**
	 * Constructor con todos los parametros
	 * @param idcandidato
	 * @param nombre
	 * @param ciudad
	 * @param fechainscripcion
	 * @param finalista
	 *
	 */
	public Candidatos(int idcandidato,String nombre,String ciudad,Date fechainscripcion,boolean finalista) {
		this.idcandidato=idcandidato;
		this.nombre=nombre;
		this.ciudad=ciudad;
		this.fechainscripcion=fechainscripcion;
		this.finalista=finalista;
		
		
	}
	/**
	 * Constructor con un parametro de la propia clase Candidatos.LLamado constructor copia
	 * @param c
	 */
	public Candidatos(Candidatos c) {
		this.idcandidato=c.idcandidato;
		this.nombre=c.nombre;
		this.ciudad=c.ciudad;
		this.fechainscripcion=c.fechainscripcion;
		this.finalista=c.finalista;
		
		
	}
	/**
	 * Constructor con tres parametros
	 * @param idcandidato
	 * @param nombre
	 * @param fechainscripcion
	 */

	public Candidatos(int idcandidato, String nombre,Date fechainscripcion) {
		this.idcandidato=idcandidato;
		this.nombre=nombre;
		this.fechainscripcion=fechainscripcion;
	}

	//Metodos publicos
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


	/**
	 * Metodo que retorna toda la información sobre los candidatos
	 * @return la información sobre los candidatos
	 */
	@Override
	public String toString() {
		return "Candidatos [idcandidato=" + idcandidato + ", nombre=" + nombre + ", ciudad=" + ciudad
				+ ", fechainscripcion=" + fechainscripcion + ", finalista=" + finalista + ", prueba=" +  "]";
	}
	
	
	
}
