package com.dawjava.fachada;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;

import com.dawjava.entidades.Persona;
import com.dawjava.entidades.Grupo;

public class FachadaCandidatoGrupo {

	Grupo banda = new Grupo();
	Persona miembro = new Persona();
	Scanner teclado = new Scanner(System.in);

	public FachadaCandidatoGrupo() {

	}

	public FachadaCandidatoGrupo(int opcion) {
		System.out.println("A continuación introduzca los datos que se solicitan para formalizar la inscripción ");
		System.out.println("Introduzca su nombre artistico ");
		banda.setNombre(teclado.nextLine());
		System.out.println("Introducir el nombre de su ciudad ");
		banda.setCiudad(teclado.nextLine());
		System.out.println(
				"\nLos siguientes datos personales son obligatorios para formalizar la inscripción.\nEn este caso es necesario consignar los de todos los miebros del grupo/conjunto");
		System.out.println(
				"En cualquier caso los datos serán tratados de tal manera que se garantice su seguridad y la confidencialidad de los mismos \n");

		int numbanda = -1;
		try {
			System.out.println("Numero de miembros del grupo/banda");

			do {
				numbanda = teclado.nextInt();
				if (numbanda < 2 || numbanda > 10) {
					System.out.println("Numero de miembros no valido.\nIntente de nuevo");
					continue;
				}
			} while ((numbanda < 2) || (numbanda > 10));
		} catch (Exception e) {
			System.out.println(
					"El número de integrantes del grupo-banda no es correcto. Debe ser un numero entre 2 y 10.\nIntente de nuevo");
			teclado.next();
		}

		if ((numbanda > 1) && (numbanda < 11)) {
			//Limpiar el bufer??
			for (int i = 0; i < numbanda; i++) {
				System.out.println("Introducir su nombre personal");
				miembro.setNombre(teclado.nextLine());
				System.out.println("Introducir su dni ");
				miembro.setDni(teclado.nextLine());
				System.out.println("Introducir su email ");
				miembro.setEmail(teclado.nextLine());
				System.out.println("Introducir un telefono de contacto (no obligatorio pero si recomendable)");
				miembro.setTelefono(teclado.nextLine());
			}
		}

		// cargar los datos introducidos en la BD

	}

}
