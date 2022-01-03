package com.dawjava.fachada;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

import com.dawjava.entidades.Tribunal;
import com.dawjava.dao.TribunalDAO;
import com.dawjava.util.Utilidades;

public class FachadaTecnico {
	Fachada portal;

	Scanner teclado = new Scanner(System.in);

	public FachadaTecnico(int opcion) {
		switch (opcion) {
		case 1:
			int subopcion = -1;
			do {
				System.out.println("\n------------------------------------");
				System.out.println("Gestion de Categorias");
				System.out.println("------------------------------------\n");
				gestionCategorias();
				try {

					opcion = teclado.nextInt();
					if (opcion < 0 || opcion > 4) {
						System.out.println("Opcion incorrecta. Debe de ser un número entre 0 y 4.\n");
						continue;
					}
					switch (opcion) {
					case 1:
						break;
					case 2:
						break;
					case 3:
						break;
					case 4:
						System.out.println("Saliendo....");
						break;
					}

				} catch (InputMismatchException e) {
					System.out.println("La eleccion debe de ser un número entre 1 y 4. Intente de nuevo ");
					teclado.next();
				}

			} while (opcion != 4);

			break;
		case 2:
			subopcion = -1;
			do {
				System.out.println("\n------------------------------------");
				System.out.println("Gestion de Tribunales");
				System.out.println("------------------------------------\n");
				gestionTribunales();
				try {
					opcion = teclado.nextInt();
					if (opcion < 0 || opcion > 8) {
						System.out.println("Opcion incorrecta. Debe de ser un número entre 0 y 8.\n");
						continue;
					}
					switch (opcion) {
					case 1:
						teclado.nextLine();
						System.out.println("A continuación introducir los datos del juez-a ");
						char respuesta = 0;
						do {
							Tribunal t = new Tribunal();
							System.out.println("Introducir su nombre ");
							t.setNombre(teclado.nextLine());
							System.out.println("Introducir su dni ");
							t.setDni(teclado.nextLine());
							System.out.println("Introducir su email ");
							t.setEmail(teclado.nextLine());
							System.out.println("Introducir su telefono ");
							t.setTelefono(teclado.nextLine());
							System.out.println("Desea seguir introduciendo datos de otros jueces-as ");
							Utilidades.leerBoolean();
							// Añadir los datos de los jueces a la B.D. ó a un ArrayList<Tribunales>
							// listajueces
							ArrayList<Tribunal> jueces = new ArrayList<Tribunal>();
							//jueces.add(t);
						} while (respuesta == 's' && respuesta == 'S');

						break;
					case 2:
						break;
					case 3:
						break;
					case 4:
						/**
						 * Importar un objeto de la entidad Tribunal desde un fichero de texto en el que
						 * cada linea represente los datos del objeto mediante el separador '|' en este
						 * orden idtribunal, nombre, email, DNI y tléfono
						 */
						TribunalDAO t = new TribunalDAO();
						t.importarJuecesDesdeFicheroDeCaracteres("tribunales.txt");
						break;
					case 5:
						/**
						 * Importar un objeto de la entidad Tribunal desde un fichero de bytes, de
						 * acuerdo a los tipos de datos de cada tributo que se muestran en el diagrama
						 * de clases
						 */

						break;
					case 6:
						/**
						 * Exportar una colección de objetos de la entidad haciea un fichero de
						 * caracteres, en que cada linea será una cadena de texto formada por los
						 * atriburos del objeto separados por el separador '|' y en el que el orden de
						 * los campos es el marcado anteriormente
						 */
						TribunalDAO t1 = new TribunalDAO();
						ArrayList<Tribunal> jueces = new ArrayList<Tribunal>();
						t1.exportarDatosTribunal(jueces);
						break;
					case 7:
						/**
						 * Exportar los datos de un objeto de la clase Tribunal hacia un fichero binario
						 */
						break;
					case 8:
						System.out.println("Saliendo....");
						break;

					}
				} catch (InputMismatchException e) {
					System.out.println("La eleccion debe de ser un número entre 1 y 8. Intente de nuevo ");
					teclado.next();
				}

			} while (opcion != 8);

			break;
		case 3:
			subopcion = -1;
			do {
				System.out.println("\n------------------------------------");
				System.out.println("Gestion de Convocatorias");
				System.out.println("------------------------------------\n");
				gestionConvocatoria();
				try {
					opcion = teclado.nextInt();
					if (opcion < 0 || opcion > 3) {
						System.out.println("Opcion incorrecta. Debe de ser un número entre 0 y 3.\n");
						continue;
					}
					switch (opcion) {
					case 1:
						break;
					case 2:
						break;
					case 3:
						System.out.println("Saliendo....");
						break;
					}

				} catch (InputMismatchException e) {
					System.out.println("La eleccion debe de ser un número entre 1 y 3. Intente de nuevo ");
					teclado.next();
				}
			} while (opcion != 3);

			break;
		case 4:
			subopcion = -1;
			do {
				System.out.println("\n------------------------------------");
				System.out.println("Gestion de Audiciones");
				System.out.println("------------------------------------\n");
				gestionAudiciones();
				try {
					opcion = teclado.nextInt();
					if (opcion < 0 || opcion > 4) {
						System.out.println("Opcion incorrecta. Debe de ser un número entre 0 y 4.\n");
						continue;
					}
					switch (opcion) {
					case 1:
						break;
					case 2:
						break;
					case 3:
						break;
					case 4:
						System.out.println("Saliendo....");
					}

				} catch (InputMismatchException e) {
					System.out.println("La eleccion debe de ser un número entre 1 y 4. Intente de nuevo ");
					teclado.next();
				}

			} while (opcion != 4);

			break;
		case 5:
			System.out.println("Volviendo al Menu Principal.....");
			break;
		default:
			System.out.println("Opcion incorrecta");
		}
	}

	public void gestionCategorias() {
		Scanner teclado = new Scanner(System.in);
		System.out.println("Seleccione la opcion a realizar: \n");
		System.out.println("1. Dar de alta las Categorias ");
		System.out.println("2. Modificar las Categorias ");
		System.out.println("3. Eliminar Categorias ");
		System.out.println("4. Volver al Menu Principal de Tecnico-a ");

	}

	public void gestionTribunales() {
		Scanner teclado = new Scanner(System.in);
		System.out.println("Seleccione la opcion a realizar: \n");
		System.out.println("1. Dar de alta a un juez-a ");
		System.out.println("2. Modificar datos de un juez-a ");
		System.out.println("3. Eliminar los datos de un juez-a ");
		System.out.println("4. Importar datos sobre los jueces desde archivo .txt");
		System.out.println("5. Importar datos sobre los jueces desde archivo .dat");
		System.out.println("6. Exportar datos de los jueces de un arhivo de caracteres");
		System.out.println("7. Exportar datos de los jueces de un archivo .dat");
		System.out.println("8. Volver al Menu Principal de Tecnico-a ");

	}

	public void gestionAudiciones() {
		System.out.println("Seleccione la opcion a realizar: \n");
		System.out.println("1. Establecer lugar, fecha y hora de las audiciones de cada convocatoria ");
		System.out.println("2. Convocar a los candidatos ");
		System.out.println("3. Convocar a los jueces ");
		System.out.println("4. Volver al Menu Principal de Tecnico-a");

	}

	public void gestionConvocatoria() {
		System.out.println("Seleccione la opcion a realizar: \n");
		System.out.println("1. Establecer lugar y fecha de la convocatoria ");
		System.out.println("2. Establecer los jueces-zas para la convocatoria ");
		System.out.println("3. Volver al Menu Principal de Tecnico-a");
	}
}
