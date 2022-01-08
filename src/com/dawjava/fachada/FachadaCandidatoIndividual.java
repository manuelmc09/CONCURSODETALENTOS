package com.dawjava.fachada;

import com.dawjava.dao.CandidatoDAO;
import com.dawjava.dao.IndividualDAO;
import com.dawjava.dao.PersonaDAO;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.dawjava.util.ConexionBD;
import com.dawjava.entidades.Candidato;
import com.dawjava.entidades.Individual;
import com.dawjava.entidades.Persona;

import com.dawjava.dao.CandidatoDAO;

public class FachadaCandidatoIndividual {

	private Connection conexion;
	private PreparedStatement ps;
	private ResultSet rs;

	boolean correcto = false;
	Scanner teclado = new Scanner(System.in);

	public FachadaCandidatoIndividual(int opcion) {
		System.out.println("\n-----------------------------------------");
		System.out.println("\tCandidato Individual");
		System.out.println("----------------------------------------\n");

		System.out.println("A continuación introduzca los datos que se solicitan para REGISTRAR su INSCRIPCION ");
		CandidatoDAO cdao = new CandidatoDAO(conexion);
		Candidato candidato = new Candidato();
		candidato.nuevoCandidato();

		/**
		 * Introduce los campos del Candidato en la tabla candidato de la BD.Da error al
		 * conectar con la BD. try { cdao.insertarCandidato(candidato); } catch
		 * (SQLException e) { // TODO Auto-generated catch block e.printStackTrace(); }
		 */

		/**
		 * Creamos un objecto CandidatoDAO para utilizar el metodo. El metodo
		 * filtrarporNombre nos buscaria en la BD el nombre del Candidato introducido.
		 * Si existe volveria informaria y se volveria a pedir al usuario por teclado .
		 * do {
		 * 
		 * correcto = c.filtrarporNombre(teclado.nextLine()); if (!correcto) {
		 * System.out. println("Error al introducir el nombre artistico. Este nombre ya
		 * existe en la B.D." ); } } while (!correcto);
		 */

		System.out.println("\nLos siguientes datos personales son obligatorios para formalizar la inscripción.\n");
		System.out.println(
				"Sus datos serán tratados de tal manera que se garantice su seguridad y la confidencialidad de los mismos \n");
		Persona individuo = new Persona();
		PersonaDAO pdao = new PersonaDAO(conexion);
		individuo.nuevaPersona();
		//pdao.insertarPersona(individuo);

		Individual solista = new Individual();
		IndividualDAO idao = new IndividualDAO(conexion);
		solista.nuevoCandidatoIndividual();
		//idao.insertarCandidatoIndividual(solista);

		// cargar los datos introducidos en la BD
		// CandidatoDAO c1 = new CandidatoDAO(conexion);

	}

}
