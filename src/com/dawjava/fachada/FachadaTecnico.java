package com.dawjava.fachada;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Iterator;
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
						System.out.println("Dar de alta a una nueva Categoria. ");
						break;
					case 2:
						System.out.println("Modificar una Categoria. ");
						break;
					case 3:
						System.out.println("Eliminar una Categoria. ");
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
						boolean valido = false;

						Tribunal t = null;
						ArrayList<Tribunal> jueces = new ArrayList<Tribunal>();

						do {
							t.nuevoTribunal();
							do {
								try {
									System.out.println(
											"Desea seguir introduciendo datos de jueces. Pulse s para Sí o n para No");
									respuesta = teclado.nextLine().charAt(0);

								} catch (Exception e) {
									System.out.println(
											"La respuesta no es correcta. Debe introducir 's' para Si o 'n' para No .\nIntente de nuevo");
									teclado.next().charAt(0);
								}

							} while (respuesta != 's' && respuesta != 'S' && respuesta != 'n' && respuesta != 'N');

							// Añadir los datos de los jueces a la B.D. ó a un ArrayList<Tribunales>
							// listajueces
							jueces.add(new Tribunal());
							if (respuesta == 'n' || respuesta == 'N') {
								System.out.println("Gracias...");
								System.out.println("Número de elemento de la coleccion=" + jueces.size());
								for (Tribunal tr : jueces)
									System.out.println(" " + tr.getNombre() + " " + tr.getDni());

							}

						} while (respuesta == 's' || respuesta == 'S');

						break;
					case 2:
						System.out.println("Modificamos los datos de un juez-a ");
						break;
					case 3:
						System.out.println("Eliminamos los datos de un juez-a ");
						break;
					case 4:
						/**
						 * Importar un objeto de la entidad Tribunal desde un fichero de texto en el que
						 * cada linea represente los datos del objeto mediante el separador '|' en este
						 * orden idtribunal, nombre, email, DNI y tléfono
						 */
						TribunalDAO t1 = new TribunalDAO();
						String ruta = Utilidades.leerNombredeFichero("ficherodeentrada");
						// Podemos asignar una ruta concreta para evitar error al introducir los datos
						// de la ruta del fichero
						// String ruta =
						// "C:\\Users\\usuario\\eclipse-workspaceDAW2.1\\CONCURSODETALENTOS\\src\\com\\dawjava\\resources\\listajueces.txt";
						t1.importarJuecesDesdeFicheroDeCaracteres(ruta);
						break;
					case 5:
						/**
						 * Importar un objeto de la entidad Tribunal desde un fichero de bytes, de
						 * acuerdo a los tipos de datos de cada tributo que se muestran en el diagrama
						 * de clases
						 */
						TribunalDAO tdao1 = new TribunalDAO();
						String path = Utilidades.leerNombredeFichero("ficherodeentrada");
						// Podemos asignar una ruta concreta para evitar error al introducir los datos
						// de la ruta del fichero
						// String path =
						// "C:\\Users\\usuario\\eclipse-workspaceDAW2.1\\CONCURSODETALENTOS\\src\\com\\dawjava\\resources\\listajueces.dat";
						tdao1.importarTribunalesDesdeFicheroDeBytes(path);

						break;
					case 6:
						/**
						 * Exportar una colección de objetos de la entidad hacia un fichero de
						 * caracteres, en que cada linea será una cadena de texto formada por los
						 * atriburos del objeto separados por el separador '|' y en el que el orden de
						 * los campos es el marcado anteriormente
						 */
						TribunalDAO t2 = new TribunalDAO();
						// ArrayList<Tribunal> listadojueces = new ArrayList<Tribunal>();
						t2.exportarDatosTribunalToFicheroCaracteres();
						break;
					case 7:
						/**
						 * Exportar los datos de un objeto de la clase Tribunal hacia un fichero binario
						 */
						TribunalDAO tdao = new TribunalDAO();
						tdao.exportarTribunalToBinaryFile();
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
						System.out.println("Establecemos el lugar, fecha y hora de la convocatoria ");
						break;
					case 2:
						System.out.println("Establecer los jueces-zas para la convocatoria. ");
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
						System.out.println("Establecemos el lugar, fecha y hora de las audiciones de cada convocatoria ");
						break;
					case 2:
						System.out.println("Convocamos a los candidatos ");
						break;
					case 3:
						System.out.println("Convocamos a los jueces ");
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
