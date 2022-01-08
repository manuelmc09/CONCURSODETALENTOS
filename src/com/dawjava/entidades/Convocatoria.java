package com.dawjava.entidades;

import java.sql.Date;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Scanner;
import java.util.Set;
import java.util.Iterator;

public class Convocatoria implements Comparable<Convocatoria> {

	static final DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

	// Atributos

	private int idconvocatoria;
	private Date fecha;
	private String lugar;

	// Conjunto de candidatos que actúan en cada convocatoria se codifica mediante
	// un
	// diccionario (Map<k,V) para poder acceder a su nombre artistico (Valor--Value)
	// desde un identificador de candidato (Clave-->Key)
	// No puede haber 2 nombres artisticos repetidos ni 2 candidatos con el mismo
	// nombre artistisco
	// HashMap<key,value>Candidatos
	// Conjunto de candidatos que actúan en cada convocatoria
	// HashMap<key,value>Candidato

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
	}

	/**
	 * Constructor con 4 parametros
	 * 
	 * @param idconvocatoria
	 * @param fecha
	 * @param lugar
	 * @param category
	 */
	public Convocatoria(int idconvocatoria, Date fecha, String lugar, Categoria category) {
		this.idconvocatoria = idconvocatoria;
		this.fecha = fecha;
		this.lugar = lugar;
		this.category = category;
	}

	/**
	 * Constructor con todos los parametros
	 * 
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
	 * 
	 * @param c
	 */
	public Convocatoria(Convocatoria c) {
		this.idconvocatoria = c.idconvocatoria;
		this.fecha = c.fecha;
		this.lugar = c.lugar;
		this.candidatos = c.candidatos;
		this.jueces = c.jueces;
		this.category = c.category;
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
		/*
		 * int compara=getFecha().compareTo(c.getFecha()); if(compara==0) {
		 * compara=getLugar().compareToIgnoreCase(c.getLugar()); } return compara;
		 */
		// En el caso de ordenar/comparar por fecha y luego por lugar de la convocatoria
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
		cadena += "Convocatoria =>" + "\nidconvocatoria:\t" + idconvocatoria + "\nlugar: " + lugar + "\nfecha: "
				+ fecha.toLocalDate().format(dateFormatter) + "\ncategoria: " + category;
		/**
		 * ", candidatos=" + candidatos + ", jueces=" + Arrays.toString(jueces) ;
		 */
		String cadena2 = "";
		Set<Integer> identificadores = candidatos.keySet();
		Iterator it_candidatos = identificadores.iterator();

		while (it_candidatos.hasNext()) {
			// Candidatos c=it_candidatos.next();
			Integer clave = (Integer) it_candidatos.next();
			String nombre_artistico = candidatos.get(clave);

			cadena2 += "\nNombre: " + nombre_artistico;
		}

		String cadena3 = "";
		for (int i = 0; i < jueces.length; i++) {
			System.out.println(jueces[i].getNombre() + jueces[i].getDni());
		}
		return cadena + cadena2 + cadena3;
	}

	/**
	 * Metodo para crear una nueva Convocatoria
	 * 
	 * @return
	 */
	public static Convocatoria nuevaConvocatoria() {
		Scanner teclado = new Scanner(System.in);
		Convocatoria c = new Convocatoria();
		System.out.println("Introducir el lugar de la convocatoria: ");
		c.setLugar(teclado.nextLine());
		System.out.println("Introducir la fecha de la convocatoria (dd/mm/aaa). \nPulse intro para la fecha de hoy: ");
		Date fecha;
		String fechaconvocatoria = teclado.nextLine();
		if (fechaconvocatoria.isEmpty()) {
			fecha = java.sql.Date.valueOf(LocalDate.now());
		} else {
			fecha = java.sql.Date.valueOf(LocalDate.parse(fechaconvocatoria, dateFormatter));
		}

		c.setFecha(fecha);
		return c;
	}

}
