package com.dawjava.dao;

import com.dawjava.entidades.Candidato;
import com.dawjava.util.ConexionBD;

import java.sql.*;
import java.util.ArrayList;
import java.util.Scanner;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class CandidatoDAO {

	private Connection conexion;
	private PreparedStatement ps;
	private ResultSet resultado;

	public CandidatoDAO(Connection conexion) {
		conexion = ConexionBD.establecerConexion();
		if (conexion == null) {
			System.out.println("Error al conectar a la BD ");
		}
	}

	public Connection getConexion() {
		return conexion;
	}

	/**
	 * Metodo para insertar un nuevo Candidato
	 * 
	 * @param c
	 * @return true
	 * @throws SQLException
	 */
	public boolean insertarCandidato(Candidato c) throws SQLException {
		String sql = "INSERT INTO candidatos(nombre,ciudad,fechainscripcion,finalista) VALUES(?,?,?,?)";
		ps = conexion.prepareStatement(sql);
		ps.setString(1, c.getNombre());
		ps.setString(2, c.getCiudad());
		java.sql.Date fechasql = Date.valueOf(LocalDate.now());
		fechasql.setDate(c.getFechainscripcion().getDayOfMonth());
		fechasql.setMonth(c.getFechainscripcion().getMonthValue());
		fechasql.setYear(c.getFechainscripcion().getYear());
		
		ps.setDate(3, fechasql);
		ps.setBoolean(4, false);

		ps.executeUpdate(sql);
		System.out.println("Inserccion correcta");
		return true;
	}

	/**
	 * Metodo para filtrar por Nombre (sin terminar)
	 * 
	 * @param nombre
	 * @return true
	 */
	public boolean filtrarporNombre(String nombre) {
		Candidato ret = null;

		try {
			String sql = "SELECT * FROM candidatos WHERE nombre=?";
			ps = conexion.prepareStatement(sql);
			ps.setString(1, nombre);
			resultado = ps.executeQuery();
			if (resultado.next()) {
				java.sql.Date fecha = resultado.getDate(4);
				java.time.LocalDate fechaformat = LocalDate.parse(fecha.toLocaleString());

				ret = new Candidato(resultado.getInt(1), resultado.getString(2), resultado.getString(3), fechaformat,
						resultado.getBoolean(5));
			}

		} catch (SQLException e) {
			System.out.println("error al consultar por nombre " + e.getMessage());
		}
		return true;
	}

}
