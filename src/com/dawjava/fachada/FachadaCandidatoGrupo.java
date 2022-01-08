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
		//Comprobar si existe ya el nombre artistico. En caso de existir informar y volver a pedir un nombre
		System.out.println("Introducir el nombre de su ciudad ");
		banda.setCiudad(teclado.nextLine());
		System.out.println(
				"\nLos siguientes datos personales son obligatorios para formalizar la inscripción.\nEn este caso es necesario consignar los de todos los miebros del grupo/conjunto");
		System.out.println(
				"En cualquier caso los datos serán tratados de tal manera que se garantice su seguridad y la confidencialidad de los mismos \n");

		int numbanda = -1;

		do {
			try {
				System.out.println("Numero de miembros del grupo/banda");

				numbanda = teclado.nextInt();
				if (numbanda < 2 || numbanda > 10) {
					System.out.println(
							"Numero de miembros no valido.Debe de ser un número entre 2 y 10. \nIntente de nuevo");
					continue;
				}
			} catch (Exception e) {
				System.out.println(
						"El número de integrantes del grupo-banda no es correcto. Debe ser un numero entre 2 y 10.\nIntente de nuevo");
				teclado.next();
			}
		} while ((numbanda < 2) || (numbanda > 10));
		System.out.println(teclado.nextLine());

		if ((numbanda > 1) && (numbanda < 11)) {
			for (int i = 0; i < numbanda; i++) {
				System.out.println("Introducir su nombre personal");
				System.out.println("Componente[" + (i + 1) + "]:\t");
				miembro.setNombre(teclado.nextLine());
				System.out.println("Introducir su dni ");
				System.out.println("Componente[" + (i + 1) + "]:\t");
				miembro.setDni(teclado.nextLine());
				System.out.println("Introducir su email ");
				System.out.println("Componente[" + (i + 1) + "]:\t");
				miembro.setEmail(teclado.nextLine());
				System.out.println("Introducir un telefono de contacto (no obligatorio pero si recomendable)");
				System.out.println("Componente[" + (i + 1)+ "]:\t");
				miembro.setTelefono(teclado.nextLine());
			}
		}
		
		System.out.println("Indicar a continuación cual de los componentes del grupo/banda será el portavoz. \nIntroducir su DNI personal para asignarle un identifidor como portavoz ");
		miembro.setDni(teclado.nextLine());
		

		// cargar los datos introducidos en la BD

	}

}
