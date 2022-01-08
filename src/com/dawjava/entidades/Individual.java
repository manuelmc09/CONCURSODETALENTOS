package com.dawjava.entidades;

import java.sql.Date;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Individual extends Candidato {
	static final DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

	//Atributos
	private int edad;
	private Persona persona;
	//Constructores
	/**
	 * Constructor por defecto
	 */
	public Individual() {
		super();
		this.edad=0;
	}
	/**
	 * Constructor con 3 parametros
	 * @param candidato
	 * @param idcantidato
	 * @param edad
	 */
	public Individual(int idcandidato,String nombre,String ciudad,Date fechainscripcion,int edad) {
		super(idcandidato,nombre,ciudad, fechainscripcion);
		if(edad<0)
			throw new IllegalArgumentException();
		this.edad=edad;
	}
	/**
	 * Constructor copia para el candidatos-Individual-solista
	 * @param solista
	 * @param edad
	 */
	public Individual(Candidato solista,int edad) {
		super(solista);
		this.edad=edad;
		 
	}
	//Metodos publicos
	public int getEdad() {
		return edad;
	}
	public void setEdad(int edad) {
		this.edad = edad;
	}
	/**
	 * Metodo que nos devuelve toda la informacion del candidato Individual
	 * @retun informacion sobre el solista(Candidato indidual)
	 */
	@Override
	public String toString() {
		return super.toString()+"Individual [edad=" + edad + "]";
	}
	
	public static Individual nuevoCandidatoIndividual() {
		Scanner teclado=new Scanner(System.in);
		Individual solista=new Individual();
		System.out.println("Introducir su edad (no obligatorio)");
		solista.setEdad(teclado.nextInt());
		return solista;
	}

}
