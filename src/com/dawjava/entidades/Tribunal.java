package com.dawjava.entidades;

import java.util.ArrayList;

public class Tribunal {
	// Atributos
	private int idtribunal;
	private String nombre;
	private String email;
	private String dni;
	private String telefono;
	private ArrayList<Audicion> castings = new ArrayList<Audicion>();

	// Constructores
	/**
	 * Constructor por defecto
	 */
	public Tribunal() {

	}

	/**
	 * Constructor con todos los parametros
	 * 
	 * @param idtribunal
	 * @param nombre
	 * @param email
	 * @param dni
	 * @param telefono
	 * @param castings
	 */
	public Tribunal(int idtribunal, String nombre, String email, String dni, String telefono,
			ArrayList<Audicion> castings) {
		this.idtribunal = idtribunal;
		this.nombre = nombre;
		this.email = email;
		if (dni.length() > 9)
			throw new IllegalArgumentException();
		this.dni = dni;
		this.telefono = telefono;
		this.castings = new ArrayList<Audicion>();
	}

	/**
	 * Constructor copia de Tribunal
	 * 
	 * @param jueces
	 */
	public Tribunal(Tribunal jueces) {
		this.idtribunal = jueces.idtribunal;
		this.nombre = jueces.nombre;
		this.email = jueces.email;
		this.dni = jueces.dni;
		this.telefono = jueces.telefono;
		if (Tribunal.class.isInstance(jueces)) {
			this.castings = ((Tribunal) jueces).getCastings();
			this.idtribunal = ((Tribunal) jueces).getIdtribunal();
		} else {
			this.castings = new ArrayList<Audicion>();
		}
	}

	// metodos publicos
	public int getIdtribunal() {
		return idtribunal;
	}

	public void setIdtribunal(int idtribunal) {
		this.idtribunal = idtribunal;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public ArrayList<Audicion> getCastings() {
		return castings;
	}

	public void setCastings(ArrayList<Audicion> castings) {
		this.castings = castings;
	}

	/**
	 * Metodo que devuelve toda la información de Tribunal
	 * 
	 * @return informacion para el Tribunal
	 */
	@Override
	public String toString() {
		return "Tribunal [idtribunal=" + idtribunal + ", nombre=" + nombre + ", email=" + email + ", dni=" + dni
				+ ", telefono=" + telefono + ", castings=" + castings + "]";
	}

	/**
	 * Función que marca el orden de importación/exportación de los campos básicos
	 * de un Tribunal: idtribunal|nombre|email|dni|telefono
	 * 
	 * @return idtribunal|nombre|email|dni|telefono
	 */
	public String data() {
		String ret;
		ret = this.idtribunal + "|" + this.nombre + "|" + this.email + "|" + this.dni + "|" + this.telefono;
		return ret;
	}
}
