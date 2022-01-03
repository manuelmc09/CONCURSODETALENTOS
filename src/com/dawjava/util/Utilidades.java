package com.dawjava.util;

import java.sql.Date;
import java.time.LocalDate;
import java.util.InputMismatchException;
import java.util.Scanner;

import com.dawjava.entidades.Audicion;
import com.dawjava.entidades.Puntuacion;
import com.dawjava.entidades.Tribunal;

public class Utilidades {
	public static boolean leerBoolean() {
		boolean ret;
		Scanner in;
		char resp;
		do {
			System.out.println("Pulse s para Sí o n para No");
			in = new Scanner(System.in, "ISO-8859-1");
			resp = in.nextLine().charAt(0);
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

		if (puntuacion < 0) {
			if (puntuacion % 2 != 0) {
				if (puntuacion > 10) {
					return false;
				}
			}
		}
		return true;
	}

	/**
	 * Metodo para validar el pase especial
	 * 
	 * @param p
	 * @return
	 */
	public static boolean validarPasedeoro(boolean paseOro) {
		Puntuacion p = new Puntuacion();
		if (paseOro == true) {
			p.setPuntuacion(10);
			return true;
		}
		return false;
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
}
