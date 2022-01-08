package com.dawjava.util;

import java.sql.Date;
import java.time.LocalDate;
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
		if (resp == 's' || resp != 'S') {
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
		Puntuacion p = new Puntuacion();
		Audicion a = new Audicion();
		boolean ret;
		Scanner teclado;
		char resp;
		a.setPuntuacionmedia(10);
		do {
			System.out.println("Pulse s para Sí o n para No");
			teclado = new Scanner(System.in, "ISO-8859-1");
			resp = teclado.nextLine().charAt(0);
			if (resp != 's' && resp != 'S' && resp != 'n' && resp != 'N') {
				System.out.println("Valor introducido incorrecto.");
			}
		} while (resp != 's' && resp != 'S' && resp != 'n' && resp != 'N');
		if (resp == 's' || resp != 'S') {
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
}
