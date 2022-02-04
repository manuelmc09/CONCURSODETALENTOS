package com.dawjava.entidades;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;

public class Grupo extends Candidato {
	static final DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

	//Atributos
	private int idportavoz;
	private Persona portavoz;
	private ArrayList<Persona>componentes=new ArrayList<Persona>();
	//Constructores
	/**
	 * Constructor por defecto
	 */
	public Grupo() {
		super();
		this.componentes=new ArrayList<Persona>();
	}
	/**
	 * Constructor con todos los parametros de la entidad
	 * @param idcantidato
	 * @param idportavoz
	 * @param nombre
	 * @param fechainscripcion
	 * @param componentes
	 */
	public Grupo(int idcandidato,String nombre,String ciudad,LocalDate fechainscripcion,int idportavoz,Persona portavoz,ArrayList<Persona> componentes) {
		super(idcandidato,nombre,ciudad,fechainscripcion);
		this.idportavoz=idportavoz;
		this.componentes=new ArrayList<Persona>();
		
	}
	/**
	 * Constructor copia para los Candidato-bandas
	 * @param bandas
	 */
	public Grupo(Grupo bandas) {
		this.idcandidato = bandas.idcandidato;
		this.nombre = bandas.nombre;
		this.ciudad = bandas.ciudad;
		this.fechainscripcion = bandas.fechainscripcion;
		this.prueba = bandas.prueba;
		this.finalista = bandas.finalista;
		
		this.idportavoz = bandas.idportavoz;
		this.portavoz = bandas.portavoz;
		this.componentes = bandas.componentes;
	}
	
	//Metodos publicos
	public int getIdportavoz() {
		return idportavoz;
	}
	public void setIdportavoz(int idportavoz) {
		this.idportavoz = idportavoz;
	}
	public Persona getPortavoz() {
		return portavoz;
	}
	public void setPortavoz(Persona portavoz) {
		this.portavoz = portavoz;
	}
	public ArrayList<Persona> getComponentes() {
		return componentes;
	}
	public void setComponentes(ArrayList<Persona> componentes) {
		this.componentes = componentes;
	}
	/**
	 * Metodo que muestra toda la información de Grupo
	 * @return informacion de Grupo
	 */
	@Override
	public String toString() {
		return super.toString()+"\nGrupo [idportavoz=" + idportavoz + ", portavoz=" + portavoz + ", componentes=" + componentes + "]";
	}

	
	public static Grupo nuevoCandidatoGrupo() {
		Scanner teclado=new Scanner(System.in);
		Grupo banda= (Grupo)Candidato.nuevoCandidato();
		
		int numcomponentes = 5;
		
		for(int i=0; i<numcomponentes; i++) {
			banda.getComponentes().add(Persona.nuevaPersona());
			
		}
		//Elegir quien de los 5 anteriores será el portavoz
		Persona portavozElegido = null;
		
		
		banda.setPortavoz(portavozElegido);
		banda.setIdportavoz(banda.portavoz.getIdpersona());
		
		System.out.println("Introducir su edad (no obligatorio)");
		
		
		
		return banda;
	}
	
	
	
}
