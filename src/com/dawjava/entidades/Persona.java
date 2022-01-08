package com.dawjava.entidades;

import java.util.ArrayList;
import java.util.Scanner;

public class Persona {
	// Atributos
	private int idpersona;
	private String nombre;
	private String email;
	private String dni;
	private String telefono;

	// Constructores
	/**
	 * Constructor por defecto
	 */
	public Persona() {

	}

	/**
	 * Constructor copia con los parametros para crear un objeto Persona
	 * 
	 * @param p
	 */
	public Persona(Persona p) {
		this.idpersona = p.idpersona;
		this.nombre = p.nombre;
		this.email = p.email;
		this.dni = p.dni;
		this.telefono = p.telefono;
	}

	/**
	 * Constructor con todos los parametros
	 * 
	 * @param idpersona
	 * @param nombre
	 * @param email
	 * @param dni
	 * @param telefono
	 */
	public Persona(int idpersona, String nombre, String email, String dni, String telefono) {
		this.idpersona = idpersona;
		this.nombre = nombre;
		this.email = email;
		if (dni.length() > 9)
			throw new IllegalArgumentException();
		this.dni = dni;
		this.telefono = telefono;
	}

	// Metodos publicos
	public int getIdpersona() {
		return idpersona;
	}

	public void setIdpersona(int idpersona) {
		this.idpersona = idpersona;
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

	/**
	 * Metodo que devuelve toda la información de Persona
	 * 
	 * @return información sobre las personas que forman los candidatos(Individuales
	 *         o Grupos)
	 */
	@Override
	public String toString() {
		return "Persona [idpersona=" + idpersona + ", nombre=" + nombre + ", email=" + email + ", dni=" + dni
				+ ", telefono=" + telefono + "]";
	}

	/**
	 * Metodo para crear un objeto Persona
	 * 
	 * @return
	 */
	public static Persona nuevaPersona() {
		Scanner teclado = new Scanner(System.in);
		Persona p = new Persona();
		System.out.println("Introducir su nombre personal");

		p.setNombre(teclado.nextLine());
		System.out.println("Introducir su dni ");
		p.setDni(teclado.nextLine());
		System.out.println("Introducir su email ");
		p.setEmail(teclado.nextLine());
		System.out.println("Introducir un telefono de contacto (no obligatorio pero si recomendable)");
		p.setTelefono(teclado.nextLine());
		return p;

	}

}
