package com.dawjava.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.Scanner;

import com.dawjava.entidades.Convocatoria;
import com.dawjava.util.ConexionBD;

public class ConvocatoriaDAO {

	private Connection conexion = null;
	private Statement stmt = null;
	private ResultSet resultado = null;

	public ConvocatoriaDAO(Connection conexion) {
		conexion = ConexionBD.establecerConexion();
		if (conexion == null) {
			System.out.println("Error al conectar a la BD");
		}
	}

	public Connection getConexion() {
		return conexion;
	}

	public static boolean insertarConvocatoria(Convocatoria c) {
		return false;

	}

	public static boolean borrarConvocatoria(int idconvocatoria) {
		return false;
	}

	public static boolean modificarConvocatoria(int idconvocatoria) {
		return false;

	}

}
