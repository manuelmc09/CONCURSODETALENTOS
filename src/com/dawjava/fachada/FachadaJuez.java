package com.dawjava.fachada;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Scanner;

import com.dawjava.dao.PuntuacionDAO;
import com.dawjava.entidades.Audicion;
import com.dawjava.entidades.Candidato;
import com.dawjava.entidades.Puntuacion;
import com.dawjava.util.Utilidades;

public class FachadaJuez {
	Scanner teclado = new Scanner(System.in);

	public FachadaJuez(int opcion) {
		switch (opcion) {
		case 1:
			System.out.println("\n-------------------------------");
			System.out.println("\tOtorgar puntuación");
			System.out.println("-------------------------------\n");

			Audicion a = new Audicion();
			int numeroaudicion = -1;
			boolean idvalido = false;

			do {
				System.out.println("Introducir el identificar (idaudicion) que le corresponda para valorar ");
				numeroaudicion = teclado.nextInt();
				idvalido = Utilidades.validarAudicion(numeroaudicion);
				if (numeroaudicion <= 0) {
					System.out.println("No es correcto. Debe ser un número mayor que 0. \nIntente de nuevo ");
				} else {
					System.out.println("Identificador valido ");
					idvalido = true;
				}
			} while (!idvalido);

			System.out.println("Introducir la puntuacion. ");
			int nota = -1;
			boolean notavalida = false;
			do {
				System.out.println(
						"\nRecuerde debe ser un numero entero, par y comprendido entre el 0 y el 10 incluidos ");
				nota = teclado.nextInt();
				notavalida = Utilidades.validarPuntacion(nota);

			} while (!notavalida);
			break;
		case 2:
			System.out.println("\n-------------------------------");
			System.out.println("\tOtorgar pase de oro");
			System.out.println("-------------------------------\n");
			System.out.println("¿Desea conceder el pase de oro a esta audicion?(s/n) ");
			Candidato c=new Candidato();
			Puntuacion p = new Puntuacion();
			Utilidades.validarPasedeoro();

			break;
		case 3:
			System.out.println("Volviendo al Menu Principal.....");
			break;
		default:
			System.out.println("Opcion incorrecta.");
		}
	}

}
