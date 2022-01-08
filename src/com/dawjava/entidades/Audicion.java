package com.dawjava.entidades;

import java.sql.Date;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

import com.dawjava.entidades.Categoria;

public class Audicion {
	static final DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	// Atributos
	private int idaudicion;
	private float puntuacionmedia = 0.0F;
	private String lugar;
	private static java.time.LocalDateTime fechahora;
	// java.sql.Date ff=Date.valueOf(fechahora.toString());
	private Candidato aspirante;
	private Tribunal[] jurado = new Tribunal[3];
	private Categoria categoria;
	private Convocatoria convocatoria;

	// Constructores
	/**
	 * Constructor por defecto
	 */
	public Audicion() {

	}

	/**
	 * Constructor con 3 parametros
	 * 
	 * @param idaudicion
	 * @param aspirante
	 * @param jurado
	 */
	public Audicion(int idaudicion, Candidato aspirante, Tribunal[] jurado) {
		this.idaudicion = idaudicion;
		this.aspirante = aspirante;
		this.jurado = jurado;
	}

	/**
	 * Constructor con todos los parametros
	 * 
	 * @param idaudicion
	 * @param puntuacionmedia
	 * @param lugar
	 * @param fechahora
	 * @param aspirante
	 * @param jurado
	 * @param categoria
	 * @param convocatoria
	 */
	public Audicion(int idaudicion, float puntuacionmedia, String lugar, LocalDateTime fechahora, Candidato aspirante,
			Tribunal[] jurado, Categoria idcategoria, Convocatoria idconvocatoria) {
		this.idaudicion = idaudicion;
		this.puntuacionmedia = puntuacionmedia;
		this.lugar = lugar;
		this.fechahora = fechahora;
		this.aspirante = aspirante;
		this.jurado = jurado;
		this.categoria = idcategoria;
		this.convocatoria = idconvocatoria;
	}

	/**
	 * Constructor copia para las Audiciones
	 * 
	 * @param prueba
	 */
	public Audicion(Audicion prueba) {
		this.idaudicion = prueba.idaudicion;
		this.puntuacionmedia = prueba.puntuacionmedia;
		this.lugar = prueba.lugar;
		this.fechahora = fechahora;
		this.aspirante = prueba.aspirante;
		int i = 0;
		for (Tribunal t : prueba.jurado) {
			this.jurado[i] = new Tribunal(t);
			i++;
		}
		this.jurado = prueba.jurado;
		this.categoria = prueba.categoria;
		this.convocatoria = prueba.convocatoria;

	}

	// Metodos publicos
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

	public Candidato getAspirante() {
		return aspirante;
	}

	public void setAspirante(Candidato aspirante) {
		this.aspirante = aspirante;
	}

	public Tribunal[] getJurado() {
		return jurado;
	}

	public void setJurado(Tribunal[] jurado) {
		this.jurado = jurado;
	}

	public java.time.LocalDateTime getFechahora() {
		return fechahora;
	}

	public void setFechahora(java.time.LocalDateTime fechahora) {
		this.fechahora = fechahora;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	public Convocatoria getConvocatoria() {
		return convocatoria;
	}

	public void setConvocatoria(Convocatoria convocatoria) {
		this.convocatoria = convocatoria;
	}

	/**
	 * Metodo para ver toda la información de la Audicion
	 * 
	 * @return toda la información de la Audición
	 */
	@Override
	public String toString() {
		return "Audicion [idaudicion=" + idaudicion + ", puntuacionmedia=" + puntuacionmedia + ", lugar=" + lugar
				+ ", fechahora=" + fechahora + ", aspirante=" + aspirante + ", jurado=" + Arrays.toString(jurado)
				+ ", categoria=" + categoria + ", convocatoria=" + convocatoria + "]";
	}

	public static Audicion nuevaAudicion() {
		Audicion a = new Audicion();
		Scanner teclado = new Scanner(System.in);

		System.out.println("Introduzca lugar de la audicion: ");
		a.setLugar(teclado.nextLine());
		System.out.println("Introduzca fecha y hora de la audicion (dd/mm/aaaa).\n Pulse intro para la fecha de hoy: ");
		String fecha = teclado.nextLine();
		//Date fechahora;
		if (fecha.isEmpty())
			fechahora = LocalDateTime.now();
		else
			fechahora = LocalDateTime.parse(fecha, dateFormatter);
		a.setFechahora(fechahora);
		
		System.out.println("Indicar a que categoria pertenece la audicion: ");
		Categoria cat=new Categoria();
		String category=teclado.nextLine();
		cat.setCategoria(category);
		//Sin terminar....
		return null;

	}
}
