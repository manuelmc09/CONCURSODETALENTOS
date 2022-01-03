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
	public boolean validarPuntacion(Puntuacion p) {
		if (p.getIdpuntuacion() < 0) {
			return false;
		}

		if (p.getPuntuacion() < 0) {
			if (p.getPuntuacion() % 2 != 0) {
				if (p.getPuntuacion() > 10) {
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
	public boolean validarPasedeoro(Puntuacion p) {
		if (p.isEspecial() == true) {
			p.setPuntuacion(10);
		}
		return false;
	}

	/**
	 * Metodo para validar el identificador de Tribunal
	 * 
	 * @param t
	 * @return
	 */
	public boolean validarTribunal(Tribunal t) {
		if (t.getIdtribunal() < 0) {
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
	public boolean validarAudicion(Audicion a) {
		if (a.getIdaudicion() < 0) {
			return false;
		}
		return true;
	}
}
