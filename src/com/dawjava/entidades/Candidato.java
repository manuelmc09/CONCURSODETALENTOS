package com.dawjava.entidades;

import java.sql.Date;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

import com.dawjava.util.Utilidades;

public class Candidato {
	static final DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

	// Atributos

	protected int idcandidato;
	protected String nombre;
	protected String ciudad;
	protected java.time.LocalDate fechainscripcion;
	protected boolean finalista = false;
	protected Audicion prueba;

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
	public Candidato(int idcandidato, String nombre, String ciudad, LocalDate fechainscripcion) {
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
	public Candidato(int idcandidato, String nombre, String ciudad, java.time.LocalDate fechainscripcion,
			boolean finalista, Audicion prueba) {
		this.idcandidato = idcandidato;
		this.nombre = nombre;
		this.ciudad = ciudad;
		this.fechainscripcion = fechainscripcion;
		this.finalista = finalista;
		this.prueba = prueba;

	}

	public Candidato(int idcandidato, String nombre, String ciudad, java.time.LocalDate fechainscripcion,
			boolean finalista) {
		this.idcandidato = idcandidato;
		this.nombre = nombre;
		this.ciudad = ciudad;
		this.fechainscripcion = fechainscripcion;
		this.finalista = finalista;
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

	public java.time.LocalDate getFechainscripcion() {
		return fechainscripcion;
	}

	public void setFechainscripcion(java.time.LocalDate fechainscripcion) {
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

	/**
	 * Metodo que crea un nuevo Candidato
	 * 
	 * @return Candidato c
	 */
	public static Candidato nuevoCandidato() {
		Scanner teclado = new Scanner(System.in);
		Candidato candidato = new Candidato();
		System.out.println("Introduzca su nombre artistico ");
		candidato.setNombre(teclado.nextLine());
		System.out.println("Introducir el nombre de su ciudad ");
		candidato.setCiudad(teclado.nextLine());
		candidato.setFechainscripcion(Utilidades.leerFecha());

		return candidato;
	}

}
