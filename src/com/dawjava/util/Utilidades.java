package com.dawjava.util;

import java.sql.Date;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.InputMismatchException;
import java.util.Scanner;

import com.dawjava.entidades.Audicion;
import com.dawjava.entidades.Puntuacion;
import com.dawjava.entidades.Tribunal;

public class Utilidades {
	/**
	 * Metodo que pide 's' o 'S' o en caso contrario 'n' o 'N' para devolver true o
	 * false en cada caso
	 */
	public static boolean leerBoolean() {
		boolean ret;
		Scanner teclado;
		char resp;
		do {
			System.out.println("Pulse s para Sí o n para No");
			teclado = new Scanner(System.in, "ISO-8859-1");
			resp = teclado.nextLine().charAt(0);
			if (resp != 's' && resp != 'S' && resp != 'n' && resp != 'N') {
				System.out.println("Valor introducido incorrecto.");
			}
		} while (resp != 's' && resp != 'S' && resp != 'n' && resp != 'N');
		if (resp == 's' || resp == 'S') {
			ret = true;
		} else {
			ret = false;
		}
		return ret;
	}

	/**
	 * Metodos de validacion para las puntuaciones
	 * 
	 * @param p
	 * @return
	 */
	public static boolean validarPuntacion(int puntuacion) {

		if ((puntuacion < 0) || (puntuacion > 10)) {
			return false;
		}

		if (puntuacion % 2 != 0) {
			return false;
		}
		return true;
	}

	/**
	 * Metodo para validar el pase especial
	 * 
	 * @param p
	 * @return
	 */
	public static boolean validarPasedeoro() {
		Puntuacion p = new Puntuacion(); /// ¿Para qué estos 2 campos?
		Audicion a = new Audicion();/// ¿?
		boolean ret;
		Scanner teclado;
		char resp;
		a.setPuntuacionmedia(10);/// ¿?
		do {
			System.out.println("Pulse s para Sí o n para No");
			teclado = new Scanner(System.in, "ISO-8859-1");
			resp = teclado.nextLine().charAt(0);
			if (resp != 's' && resp != 'S' && resp != 'n' && resp != 'N') {
				System.out.println("Valor introducido incorrecto.");
			}
		} while (resp != 's' && resp != 'S' && resp != 'n' && resp != 'N');
		if (resp == 's' || resp == 'S') {
			System.out.println("Da el pase de Oro ");
			System.out.println("La puntuacion media ahora es de: " + a.getPuntuacionmedia());
			ret = true;
		} else {
			System.out.println("No da el pase de Oro...");
			ret = false;
		}
		return ret;
	}

	/**
	 * Metodo para validar el identificador de Tribunal
	 * 
	 * @param t
	 * @return
	 */
	public static boolean validarTribunal(int idtribunal) {
		if (idtribunal <= 0) {
			return false;
		}
		return true;
	}

	/**
	 * Metodo para validar el identificador de Audicion
	 * 
	 * @param a
	 * @return
	 */
	public static boolean validarAudicion(int idaudicion) {
		if (idaudicion <= 0) {
			return false;
		}
		return true;
	}

	/**
	 * Metodo que pedira al usuario por el nombre del fichero y su ubicación
	 * 
	 * @param msm
	 * @return
	 */
	public static String leerNombredeFichero(String msm) {
		String cad;
		Scanner teclado = new Scanner(System.in);
		System.out.println(msm);
		System.out.println("Introduzca la ruta completa y el nombre del archivo:");
		cad = teclado.nextLine();
		return cad;
	}

	/**
	 * Función que pide al usuario que introduce un valor para una fecha a partir de
	 * 3 enteros para el día, mes y año respectivamente Y una hora a partir de ptrps
	 * 3 valores para la hora, minutos y segundos. Si los valores introducidos no
	 * producen una fecha u hora correctas, avisa al usuario y le pide que los
	 * introduzca de nuevo. Si no lo consigue, devolverá null
	 *
	 * @return una fecha-hora de la clase java.time.LocalDateTime o null si hay
	 *         error
	 */
	public static java.time.LocalDateTime leerFechaHora() {
		LocalDateTime ret = null;
		int dia, mes, anio;
		int hora, min, seg;
		boolean correcto = false;
		Scanner in;
		do {
			System.out.println("Introduzca un valor para el día (1...31)");
			in = new Scanner(System.in, "ISO-8859-1");
			dia = in.nextInt();
			System.out.println("Introduzca un valor para el mes (1...12)");
			in = new Scanner(System.in, "ISO-8859-1");
			mes = in.nextInt();
			System.out.println("Introduzca un valor para el año");
			in = new Scanner(System.in, "ISO-8859-1");
			anio = in.nextInt();
			System.out.println("Introduzca un valor para la hora del día (0...23)");
			in = new Scanner(System.in, "ISO-8859-1");
			hora = in.nextInt();
			System.out.println("Introduzca un valor para los minutos (0...59)");
			in = new Scanner(System.in, "ISO-8859-1");
			min = in.nextInt();
			System.out.println("Introduzca un valor para los segundos (0...59)");
			in = new Scanner(System.in, "ISO-8859-1");
			seg = in.nextInt();

			try {
				ret = LocalDateTime.of(anio, mes, dia, hora, min, seg);
				correcto = true;
			} catch (Exception e) {
				System.out.println("Fecha-hora introducida incorrecta.");
				correcto = false;
			}
		} while (!correcto);
		return ret;
	}

	/**
	 * Función que pide al usuario que introduce un valor para una fecha a partir de
	 * 3 enteros para el día, mes y año respectivamente. Si los valores introducidos
	 * no producen una fecha correcta, avisa al usuario y le pide que los introduzca
	 * de nuevo. Si no lo consigue, devolverá null
	 *
	 * @return una fecha de la clase java.time.LocalDate o null si hay error
	 */
	public static java.time.LocalDate leerFecha() {
		LocalDate ret = null;
		int dia, mes, anio;
		boolean correcto = false;
		Scanner in;
		do {
			System.out.println("Introduzca un valor para el día (1...31)");
			in = new Scanner(System.in, "ISO-8859-1");
			dia = in.nextInt();
			System.out.println("Introduzca un valor para el mes (1...12)");
			in = new Scanner(System.in, "ISO-8859-1");
			mes = in.nextInt();
			System.out.println("Introduzca un valor para el año");
			in = new Scanner(System.in, "ISO-8859-1");
			anio = in.nextInt();

			try {
				ret = LocalDate.of(anio, mes, dia);
				correcto = true;
			} catch (Exception e) {
				System.out.println("Fecha introducida incorrecta.");
				correcto = false;
			}
		} while (!correcto);
		return ret;
	}
}
