package com.dawjava.principal;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import com.dawjava.entidades.*;
import com.dawjava.fachada.Fachada;
import com.dawjava.fachada.FachadaCandidatoGrupo;
import com.dawjava.fachada.FachadaCandidatoIndividual;
import com.dawjava.fachada.FachadaJuez;
import com.dawjava.fachada.FachadaTecnico;

public class Concurso {

	public static void main(String[] args) {
		Scanner teclado = new Scanner(System.in);
		Fachada portal = new Fachada();

		int opcion = 0;

		do {
			System.out.println("\n------------------------------------");
			System.out.println("Gestion del Concurso de Talentos ");
			System.out.println("------------------------------------\n");
			portal.mostrarMenuSeleccionRol();
			try {
				opcion = teclado.nextInt();
				if (opcion < 1 || opcion > 4) {
					System.out.println("Opcion incorrecta.\n");
					continue;
				}
				 int subopcion = -1;
				switch (opcion) {
				case 1:
					do {
						System.out.println("\nEligio rol  de Candidato/a-s");
						portal.mostrarMenuPrincipalCandidato();
						try {
							subopcion = teclado.nextInt();
							if (subopcion < 1 || subopcion > 3) {
								System.out.println("Opcion incorrecta.\n");
								continue;
							}
							//Aquí ya se tienen las opciones del menu para Candidatos individuales y grupos
							if(subopcion==1) {
								FachadaCandidatoIndividual portalindividual=new FachadaCandidatoIndividual(subopcion);
							}else if(subopcion==2) {
								FachadaCandidatoGrupo portalgrupo=new FachadaCandidatoGrupo(subopcion);
							}

						} catch (InputMismatchException e) {
							System.out.println("La eleccion debe de ser un número entre 1 y 3. Intente de nuevo ");
							teclado.next();
						}
					} while (subopcion != 3);
					break;
				case 2:
					do {
						System.out.println("\nEligio rol de Técnico-a");
						portal.mostrarMenuPrincipalTecnico();
						try {
							subopcion = teclado.nextInt();
							if (subopcion < 1 || subopcion > 5) {
								System.out.println("Opcion incorrecta.\n");
								continue;
							}
							//Aquí ya se tienen las opciones del menu para Tecnicos
							FachadaTecnico portaltecnico=new FachadaTecnico(subopcion);
						} catch (InputMismatchException e) {
							System.out.println("La eleccion debe de ser un número entre 1 y 6 Intente de nuevo ");
							teclado.next();
						}
					} while (subopcion !=5);

					break;
				case 3:
					do {
						System.out.println("\nEligio rol de Juez-a");
						portal.mostrarMenuPrincipalJuez();

						try {
							subopcion = teclado.nextInt();
							if (subopcion < 1 || subopcion > 3) {
								System.out.println("Opcion incorrecta.\n");
								continue;
							}
							//Aquí ya se tienen las opciones del menu para Candidatos individuales y grupos
							FachadaJuez portaljuez=new FachadaJuez(subopcion);

						} catch (InputMismatchException e) {
							System.out.println("La eleccion debe de ser un número entre 1 y 3. Intente de nuevo ");
							teclado.next();
						}
					} while (subopcion != 3);
					break;
				default:
					System.out.println("\nSaliendo....");
				}

			} catch (InputMismatchException e) {
				System.out.println("La eleccion debe de ser un número entre 1 y 4. Intente de nuevo ");
				teclado.next();
			}
		} while (opcion != 4);// opcion SALIR en el Menu de elección de rol
		System.out.println("Gracias por su participación");
	}

}
