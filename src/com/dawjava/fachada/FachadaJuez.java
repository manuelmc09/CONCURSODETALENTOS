package com.dawjava.fachada;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Scanner;

import com.dawjava.dao.PuntuacionDAO;
import com.dawjava.entidades.Audicion;
import com.dawjava.util.Utilidades;

public class FachadaJuez {
	Scanner teclado = new Scanner(System.in);

	public FachadaJuez(int opcion) {
		switch (opcion) {
		case 1:
			System.out.println("Opcion para otorgar puntuación");
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

			boolean notavalida = false;
			int nota = -1;
			do {
				System.out.println(
						"Introducir la puntuacion. \nRecuerde debe ser un numero entero, par y comprendido entre el 0 y el 10 incluidos ");
				nota = teclado.nextInt();
				notavalida = Utilidades.validarPuntacion(nota);
				/*if ((nota > 0) || (nota < 10)) {
					if (nota%2 != 0) {
						System.out.println("No es correcto.\nIntente de nuevo");
					}
				} else {
					System.out.println("Puntuacion correcta..... ");
					System.out.println("Se procedera a su registro. ");
					// LinkedHashMap<Audicion, Integer> puntuaciones
					notavalida = true;
				}*/
			} while (!notavalida);
			break;
		case 2:
			System.out.println("Opcion para otorgar el pase de oro");
			break;
		case 3:
			System.out.println("Volviendo al Menu Principal.....");
			break;
		default:
			System.out.println("Opcion incorrecta.");
		}
	}

}
