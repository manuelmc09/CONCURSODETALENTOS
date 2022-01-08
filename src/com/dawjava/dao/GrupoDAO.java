package com.dawjava.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import com.dawjava.entidades.Grupo;
import com.dawjava.util.ConexionBD;

public class GrupoDAO {

	static Connection conexion = null;
	private ResultSet resultado;
	private PreparedStatement pstm;

	public GrupoDAO() {
		conexion = ConexionBD.establecerConexion();
		if (conexion == null) {
			System.out.println("Error al conectar a la BD ");
		}
	}

	public static Connection getConexion() {
		return conexion;
	}

	public static boolean insertarGrupo(Grupo g) {
		return false;
	}

	public static boolean borrarGrupo(int idcandidato) {
		return false;
	}

	public static boolean modificarGrupo(Grupo g) {
		return false;
	}
}
