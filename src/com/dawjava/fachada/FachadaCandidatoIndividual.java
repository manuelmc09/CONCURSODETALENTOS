package com.dawjava.fachada;

import com.dawjava.dao.CandidatoDAO;

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

	Individual solista = new Individual();
	Candidato candidato=new Candidato();
	Persona individuo = new Persona();
	CandidatoDAO c;
	Scanner teclado = new Scanner(System.in);

	

	public FachadaCandidatoIndividual(int opcion) {
		System.out.println("A continuación introduzca los datos que se solicitan para REGISTRAR su INSCRIPCION ");
		System.out.println("Introduzca su nombre artistico ");
		candidato.setNombre(teclado.nextLine());
		//c.filtrarporNombre(candidato.setNombre(teclado.nextLine()));
		System.out.println("Introducir el nombre de su ciudad ");
		candidato.setCiudad(teclado.nextLine());
		System.out.println("\nLos siguientes datos personales son obligatorios para formalizar la inscripción.\n");
		System.out.println(
				"Sus datos serán tratados de tal manera que se garantice su seguridad y la confidencialidad de los mismos \n");
		System.out.println("Introducir su nombre personal");
		individuo.setNombre(teclado.nextLine());
		System.out.println("Introducir su dni ");
		individuo.setDni(teclado.nextLine());
		System.out.println("Introducir su email ");
		individuo.setEmail(teclado.nextLine());
		System.out.println("Introducir un telefono de contacto (no obligatorio pero si recomendable)");
		individuo.setTelefono(teclado.nextLine());
		System.out.println("Introducir su edad (no obligatorio)");
		solista.setEdad(teclado.nextInt());
		// cargar los datos introducidos en la BD
		CandidatoDAO c=new CandidatoDAO(conexion);
		try {
			c.insertarCandidato(candidato);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	}

	


}
