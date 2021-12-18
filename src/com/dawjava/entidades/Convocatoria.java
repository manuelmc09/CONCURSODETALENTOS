package com.dawjava.entidades;

import java.sql.Date;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class Convocatoria {

	static final DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

	// Atributos
	private int idconvocatoria;
	private Date fecha;
	private String lugar;
	
	//Conjunto de candidatos que actúan en cada convocatoria HashMap<key,value>Candidatos
	HashMap<Integer, String>Candidatos;
	//Campo para las 3 personas que forman el tribunal de cada convocatoria
	Tribunal[]jueces=new Tribunal[3];
	//Campo para determinar a que Categoria pertenecen cada audicion de esa convocatoria
	Categoria category;
	
	

}
