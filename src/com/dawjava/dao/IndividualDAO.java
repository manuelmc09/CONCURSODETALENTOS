package com.dawjava.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.dawjava.entidades.Individual;
import com.dawjava.util.ConexionBD;

public class IndividualDAO {

	private Connection conexion;
	private PreparedStatement ps;
	private ResultSet resultado;

	public IndividualDAO(Connection conexion) {
		conexion = ConexionBD.establecerConexion();
		if (conexion == null) {
			System.out.println("Error al conectar a la BD");
		}
	}

	public Connection getConexion() {
		return conexion;
	}

	public boolean insertarCandidatoIndividual(Individual i) {
		try {
			String sql = "INSERT INTO individuales(idcandidato,edad) VALUES (?,?)";
			ps = conexion.prepareStatement(sql);
			ps.setInt(1, i.getIdcandidato());
			ps.setInt(2, i.getEdad());
			ps.executeUpdate(sql);
			System.out.println("Inserccion correcta");
		} catch (SQLException e) {
			System.out.println("Error al insertar en Indidivuales " + e.getMessage());
		}
		return true;
	}
}
