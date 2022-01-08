package com.dawjava.entidades;

import java.sql.Date;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

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
	public Grupo(int idcandidato,String nombre,String ciudad,Date fechainscripcion,int idportavoz,Persona portavoz,ArrayList<Persona> componentes) {
		super(idcandidato,nombre,ciudad,fechainscripcion);
		this.idportavoz=idportavoz;
		this.componentes=new ArrayList<Persona>();
		
	}
	/**
	 * Constructor copia para los Candidato-bandas
	 * @param bandas
	 */
	public Grupo(Candidato bandas) {
		super(bandas);
		 if (Grupo.class.isInstance(bandas)) {
	            this.componentes = ((Grupo) bandas).getComponentes();
	            this.idportavoz = ((Grupo) bandas).getIdportavoz();
	            
	        } else {
	            this.componentes = new ArrayList<Persona>();
	        }
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

	
	
	
}
