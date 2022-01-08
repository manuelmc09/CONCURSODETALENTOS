package com.dawjava.dao;

import java.util.ArrayList;

import com.dawjava.entidades.Persona;
import com.dawjava.util.ConexionBD;
import com.dawjava.entidades.Individual;
import com.dawjava.entidades.Grupo;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PersonaDAO {
	private static Connection conexion = null;
	private PreparedStatement ps;
	private ResultSet resultado;

	public PersonaDAO(Connection conexion) {
		conexion = ConexionBD.establecerConexion();
		if (conexion == null) {
			System.out.println("Error al conectar con la BD. ");
		}
	}

	public Connection getConexion() {
		return conexion;
	}

	public boolean insertarPersona(Persona p) {
		String sql = "INSERT INTO persona VALUES (?,?,?,?,?)";
		ResultSet resultado;
		PreparedStatement pstm;
		try {
			if (conexion == null) {
				conexion = ConexionBD.establecerConexion();
				pstm = conexion.prepareStatement(sql);
			}
			conexion.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;

	}

}
