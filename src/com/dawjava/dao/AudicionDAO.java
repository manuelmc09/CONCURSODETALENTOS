package com.dawjava.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.Scanner;

import com.dawjava.entidades.Audicion;
import com.dawjava.entidades.Convocatoria;
import com.dawjava.util.ConexionBD;

public class AudicionDAO {
	private Connection conexion = null;
	private Statement stmt = null;
	private ResultSet resultado = null;

	public AudicionDAO(Connection conexion) {
		conexion=ConexionBD.establecerConexion();
		if(conexion==null) {
			System.out.println("Error al conectar a la BD ");
		}
	}

	public Connection getConexion() {
		return conexion;
	}

	public static boolean insertarAudicion(Audicion a) {
		return false;

	}

	public static boolean borrarAudicion(int idaudicion) {
		return false;
	}

	public static boolean modificarAudicion(int idaudicion) {
		return false;

	}
}
