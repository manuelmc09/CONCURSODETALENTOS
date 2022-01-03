package com.dawjava.dao;

import com.dawjava.entidades.Candidato;

import java.sql.*;
import java.util.ArrayList;
import java.util.Scanner;
import java.sql.SQLException;

public class CandidatoDAO {

	private Connection conexion;

	public CandidatoDAO(Connection conexion) {
		this.conexion = conexion;
	}

	public Connection getConexion() {
		return conexion;
	}

	/**
	 * Metodo para insertar un nuevo Candidato
	 * 
	 * @param c
	 * @return
	 * @throws SQLException
	 */
	public boolean insertarCandidato(Candidato c) throws SQLException {
		Statement stmt = conexion.createStatement();
		String sql = "INSERT INTO candidatos VALUES(" + c.getNombre() + ", " + c.getCiudad();
		stmt.execute(sql);
		return true;
	}

	/**
	 * Metodo para filtrar por Nombre (sin terminar)
	 * @param nombre_buscar
	 * @return
	 */
	public boolean filtrarporNombre(String nombre_buscar) {
		Candidato c;
		try {
			Statement stmt = conexion.createStatement();
			String sql = "SELECT nombre FROM candidatos WHERE nombre='" + nombre_buscar + "'";
			ResultSet resultado = stmt.executeQuery(sql);
			resultado.next();
			c = new Candidato(resultado.getByte(1), resultado.getString(2), resultado.getString(3),
					resultado.getDate(3));
			stmt.close();
		} catch (SQLException e) {

		}
		return true;
	}

}
