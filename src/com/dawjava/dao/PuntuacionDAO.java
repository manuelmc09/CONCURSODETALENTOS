package com.dawjava.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.Scanner;

import com.dawjava.entidades.Puntuacion;

public class PuntuacionDAO {
	private Connection conexion;
	private PreparedStatement ps;
	private ResultSet resultado;

	public PuntuacionDAO(Connection conexion) {
		this.conexion = conexion;
	}

	public Connection getConexion() {
		return conexion;
	}

	
}
