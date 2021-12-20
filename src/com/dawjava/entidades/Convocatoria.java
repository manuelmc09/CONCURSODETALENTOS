package com.dawjava.entidades;

import java.sql.Date;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Iterator;

public class Convocatoria implements Comparable<Convocatoria> {

	static final DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

	// Atributos

	private int idconvocatoria;
	private Date fecha;
	private String lugar;

	// Conjunto de candidatos que actúan en cada convocatoria
	// HashMap<key,value>Candidatos

	private LinkedHashMap<Integer, String> candidatos = new LinkedHashMap<Integer, String>();
	// Campo para las 3 personas que forman el tribunal de cada convocatoria

	private Tribunal[] jueces = new Tribunal[3];
	// Campo para determinar a que Categoria pertenecen cada audicion de esa
	// convocatoria

	private Categoria category;

	// Constructores

	/**
	 * Constructor con parametros
	 */
	public Convocatoria() {
		this.idconvocatoria = 0;
	}

	/**
	 * Constructor con 4 parametros
	 * @param idconvocatoria
	 * @param fecha
	 * @param lugar
	 * @param candidatos
	 */
	public Convocatoria(int idconvocatoria, Date fecha, String lugar, LinkedHashMap<Integer, String> candidatos) {
		this.idconvocatoria = idconvocatoria;
		this.fecha = fecha;
		this.lugar = lugar;
		this.candidatos = candidatos;
	}

	/**
	 * Constructor con todos los parametros
	 * @param idconvocatoria
	 * @param fecha
	 * @param lugar
	 * @param candidatos
	 * @param jueces
	 * @param category
	 */
	public Convocatoria(int idconvocatoria, Date fecha, String lugar, LinkedHashMap<Integer, String> candidatos,
			Tribunal[] jueces, Categoria category) {
		this.idconvocatoria = idconvocatoria;
		this.fecha = fecha;
		this.lugar = lugar;
		this.candidatos = candidatos;
		this.jueces = jueces;
		this.category = category;
	}
	
	/**
	 * Constructor con un parametro, constructor-copia de la propia clase
	 * @param c
	 */
	public Convocatoria(Convocatoria c) {
		this.idconvocatoria=c.idconvocatoria;
		this.fecha=c.fecha;
		this.lugar=c.lugar;
		this.candidatos=c.candidatos;
		this.jueces=c.jueces;
		this.category=c.category;
	}

	// Metodos publicos

	public int getIdconvocatoria() {
		return idconvocatoria;
	}

	public void setIdconvocatoria(int idconvocatoria) {
		this.idconvocatoria = idconvocatoria;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public String getLugar() {
		return lugar;
	}

	public void setLugar(String lugar) {
		this.lugar = lugar;
	}

	public LinkedHashMap<Integer, String> getCandidatos() {
		return candidatos;
	}

	public void setCandidatos(LinkedHashMap<Integer, String> candidatos) {
		this.candidatos = candidatos;
	}

	public Tribunal[] getJueces() {
		return jueces;
	}

	public void setJueces(Tribunal[] jueces) {
		this.jueces = jueces;
	}

	public Categoria getCategory() {
		return category;
	}

	public void setCategory(Categoria category) {
		this.category = category;
	}

	/**
	 * @paramc c Convocatoria con la que se pretende compara
	 * @return 0 si las convocatorias se celebran en la misma fecha, y -1 si la
	 *         fecha de esta convocatoria es anterior a la de la convocatoria c y 1
	 *         en caso contrario
	 */
	@Override
	public int compareTo(Convocatoria c) {
		return this.getFecha().compareTo(c.getFecha());
		/*int compara=getFecha().compareTo(c.getFecha());
		if(compara==0) {
			compara=getLugar().compareToIgnoreCase(c.getLugar());
		}
		return compara;*/
		//En el caso de ordenar/comparar por fecha y luego por lugar de la convocatoria
	}

	/**
	 * Metodo que devuelve toda la información de la convocatoria
	 * 
	 * @return informacion relativa a la convocatoria
	 */
	@Override
	public String toString() {
		final DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		String cadena = "";
		cadena += "Convocatoria =>\nidconvocatoria:\t" + idconvocatoria + "\nlugar: " + lugar + "\nfecha: "
				+ fecha.toLocalDate().format(dateFormatter) + "\ncategoria: " + category;
		/**
		 * ", candidatos=" + candidatos + ", jueces=" + Arrays.toString(jueces) ;
		 */
		String cadena2 = "";
		Iterator<Candidatos> it_candidatos=((Object) this.getCandidatos()).iterator();
		
		while(it_candidatos.hasNext()) {
			
		}

		return cadena;
	}

}
