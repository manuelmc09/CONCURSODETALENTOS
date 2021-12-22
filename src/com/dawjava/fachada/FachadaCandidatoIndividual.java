package com.dawjava.fachada;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;

import com.dawjava.entidades.Individual;
import com.dawjava.entidades.Persona;

public class FachadaCandidatoIndividual {
	Individual solista = new Individual();;
	Persona individuo = new Persona();
	Scanner teclado = new Scanner(System.in);

	public FachadaCandidatoIndividual() {

	}

	public FachadaCandidatoIndividual(int opcion) {
		System.out.println("A continuación introduzca los datos que se solicitan para formalizar la inscripción ");
		System.out.println("Introduzca su nombre artistico ");
		solista.setNombre(teclado.nextLine());
		System.out.println("Introducir el nombre de su ciudad ");
		solista.setCiudad(teclado.nextLine());
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
		//cargar los datos introducidos en la BD 
		
		
	}

}
