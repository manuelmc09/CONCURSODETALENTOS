package com.dawjava.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.Scanner;

import com.dawjava.entidades.Audicion;

public class AudicionDAO {
	private Connection conexion = null;
	private Statement stmt = null;
	private ResultSet resultado = null;

	public AudicionDAO(Connection conexion) {
		this.conexion = conexion;
	}

	public Connection getConexion() {
		return conexion;
	}

}
