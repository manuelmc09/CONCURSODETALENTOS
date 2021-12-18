package com.dawjava.entidades;

import java.util.ArrayList;
import java.util.Arrays;

public class Audicion {
	//Atributos
	private int idaudicion;
	private float puntuacionmedia;
	private String lugar;
	private Candidatos aspirante;
	private Tribunal[] jurado;
	private Categoria idcategoria;
	private Convocatoria idconvocatoria;
	
	//Constructores
	/**
	 * Constructor por defecto
	 */
	public Audicion() {
		this.idaudicion=0;
		this.puntuacionmedia=0;
		this.lugar="";
		this.aspirante=null;
		this.jurado=new Tribunal[3];
		this.idcategoria=null;
		this.idconvocatoria=null;
	}
	
	/**
	 * Constructor con 3 parametros
	 * @param idaudicion
	 * @param aspirante
	 * @param jurado
	 */
	public Audicion(int idaudicion,Candidatos aspirante,Tribunal[]jurado) {
		this.idaudicion=idaudicion;
		this.puntuacionmedia=puntuacionmedia;
		this.lugar=lugar;
		this.aspirante=aspirante;
		this.jurado=jurado;
	}
	/**
	 * Constructor con todos los parametros
	 * @param idaudicion
	 * @param puntuacionmedia
	 * @param lugar
	 * @param aspirante
	 * @param jurado
	 * @param idcategoria
	 * @param idconvocatoria
	 */
	public Audicion(int idaudicion,float puntuacionmedia,String lugar,Candidatos aspirante,Tribunal[]jurado,Categoria idcategoria,Convocatoria idconvocatoria) {
		this.idaudicion=idaudicion;
		this.puntuacionmedia=puntuacionmedia;
		this.lugar=lugar;
		this.aspirante=aspirante;
		this.jurado=jurado;
		this.idcategoria=idcategoria;
		this.idconvocatoria=idconvocatoria;
	}
	/**
	 * Constructor copia para las Audiciones
	 * @param prueba
	 */
	public Audicion(Audicion prueba) {
		this.idaudicion=prueba.idaudicion;
		this.puntuacionmedia=prueba.puntuacionmedia;
		this.lugar=prueba.lugar;
		this.aspirante=prueba.aspirante;
		this.jurado=prueba.jurado;
		this.idcategoria=prueba.idcategoria;
		this.idconvocatoria=prueba.idconvocatoria;
		
	}
	
	//Metodos publicos
	public int getIdaudicion() {
		return idaudicion;
	}

	public void setIdaudicion(int idaudicion) {
		this.idaudicion = idaudicion;
	}

	public float getPuntuacionmedia() {
		return puntuacionmedia;
	}

	public void setPuntuacionmedia(float puntuacionmedia) {
		this.puntuacionmedia = puntuacionmedia;
	}

	public String getLugar() {
		return lugar;
	}

	public void setLugar(String lugar) {
		this.lugar = lugar;
	}

	public Candidatos getAspirante() {
		return aspirante;
	}

	public void setAspirante(Candidatos aspirante) {
		this.aspirante = aspirante;
	}

	public Tribunal[] getJurado() {
		return jurado;
	}

	public void setJurado(Tribunal[] jurado) {
		this.jurado = jurado;
	}
	
	
	public Categoria getIdcategoria() {
		return idcategoria;
	}

	public void setIdcategoria(Categoria idcategoria) {
		this.idcategoria = idcategoria;
	}
	

	public Convocatoria getIdconvocatoria() {
		return idconvocatoria;
	}

	public void setIdconvocatoria(Convocatoria idconvocatoria) {
		this.idconvocatoria = idconvocatoria;
	}

	/**
	 * Metodo para ver toda la información de la Audicion
	 * @return toda la información de la Audición
	 */

	@Override
	public String toString() {
		return "Audicion [idaudicion=" + idaudicion + ", puntuacionmedia=" + puntuacionmedia + ", lugar=" + lugar
				+ ", aspirante=" + aspirante + ", jurado=" + Arrays.toString(jurado) +"idcategoria="+ idcategoria+"idconvocatoria="+idconvocatoria+"]";
	}
	
	
	
	
	

}
