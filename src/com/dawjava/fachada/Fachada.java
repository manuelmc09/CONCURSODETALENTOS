package com.dawjava.fachada;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

import com.dawjava.entidades.*;

public class Fachada {
	Scanner teclado = new Scanner(System.in);
	private static Fachada portal;
	
	

	public Fachada() {

	}

	public void mostrarMenuSeleccionRol() {
		System.out.println("Seleccione su rol: \n");
		System.out.println("1. Candidato/s  ");
		System.out.println("2. Técnico-a");
		System.out.println("3. Jueces");
		System.out.println("4. Salir ");
	}

	public void mostrarMenuPrincipalCandidato() {
		System.out.println("Seleccione el tipo de candidato: \n");
		System.out.println("1. Individual ");
		System.out.println("2. Grupo ");
		System.out.println("3. Salir ");
	}

	public void mostrarMenuPrincipalTecnico() {
		System.out.println("Seleccione la opcion a realizar: \n");
		System.out.println("1. Gestionar Categorias ");
		System.out.println("2. Gestionar Tribunales ");
		System.out.println("3. Gestionar Convocatorias ");
		System.out.println("4. Gestionar Audiciones ");
		System.out.println("5. Salir ");
	}

	public void mostrarMenuPrincipalJuez() {
		System.out.println("Seleccione la opcion a realizar: \n");
		System.out.println("1. Otorgar puntuación ");
		System.out.println("2. Otorgar pase de oro ");
		System.out.println("3. Salir ");
	}

}
