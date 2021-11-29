package com.dawjava.entidades;
import java.sql.Date;
import java.time.format.DateTimeFormatter;

public class Categoria {
	static final DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	//Atributos
	
	private int idcategoria;
	private String categoria;

	
	//Constructores
	/**
	 * Constructor por defecto
	 */
	public Categoria() {
		this.idcategoria=0;
		
	}
	/**
	 * Constructor con parametros
	 * @param cat
	 * @param idCategoria
	 * @param categoria
	 */
	public Categoria(int idCategoria,String categoria){
		this.categoria=categoria;
		this.idcategoria=idcategoria;
	}
	//Metodos publicos
	public int getIdcategoria() {
		return idcategoria;
	}
	public void setIdcategoria(int idcategoria) {
		this.idcategoria = idcategoria;
	}
	public String getCategoria() {
		return categoria;
	}
	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}
	/**
	 * Metodo que devuelve la información de Categoria
	 * @return toda la información de Categoria
	 */
	@Override
	public String toString() {
		return "Categoria [idcategoria=" + idcategoria + ", categoria=" + categoria + "]";
	}
	

}