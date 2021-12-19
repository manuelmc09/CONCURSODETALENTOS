package com.dawjava.fachada;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;

public class FachadaTecnico {

	Scanner teclado=new Scanner(System.in);
	
	public FachadaTecnico(int opcion) {
		switch(opcion) {
		case 1:
			System.out.println("Opcion para la gestion de Categorias");
			break;
		case 2:
			System.out.println("Opcion para la gestion de los Tribunales");
			break;
		case 3:
			System.out.println("Opcion para la gestion de las Audicciones");
			break;
		case 4:
			System.out.println("Opcion para la gestion de las Convocatorias");
			break;
		case 5:
			System.out.println("Volviendo al Menu Principal.....");
			break;
		default:
			System.out.println("Opcion incorrecta");
		}
	}
}
