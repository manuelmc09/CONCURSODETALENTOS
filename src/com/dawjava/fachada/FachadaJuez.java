package com.dawjava.fachada;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;

public class FachadaJuez {
	Scanner teclado = new Scanner(System.in);

	public FachadaJuez(int opcion) {
		switch (opcion) {
		case 1:
			System.out.println("Opcion para otorgar puntuación");
			break;
		case 2:
			System.out.println("Opcion para otorgar el pase de oro");
			break;
		case 3:
			System.out.println("Volviendo al Menu Principal.....");
			break;
		default:
			System.out.println("Opcion incorrecta");
		}
	}

}
