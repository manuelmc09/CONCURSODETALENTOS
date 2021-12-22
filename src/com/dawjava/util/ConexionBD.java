package com.dawjava.util;

import java.util.logging.Level;
import java.util.logging.Logger;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

import java.util.Properties;
import com.mysql.cj.jdbc.MysqlDataSource;

public class ConexionBD {
	static Connection conexion; // para la parte de JDBC

	/**
	 * // Datos de la conexion a la BD static final String DB_URL =
	 * "jdbc:mysql://localhost:2526/bdconcurso"; static final String USER =
	 * "manuelmc09"; static final String PASS = "VICtor1975";
	 */

	/**
	 * Statement stmt = null; PreparedStatement pstmt = null;
	 * 
	 * public static Connection establecerConexion() { try {
	 * //System.out.println("Conectando a la Base de Datos...");
	 * Class.forName("com.mysql.cj.jdbc.Driver"); conexion =
	 * DriverManager.getConnection(DB_URL, USER, PASS); } catch (SQLException ex) {
	 * System.out.println("Se ha producido una SQLException:" + ex.getMessage());
	 * Logger.getLogger(ConexionBD.class.getName()).log(Level.SEVERE, null, ex); }
	 * catch (ClassNotFoundException ex) { System.out.println("Se ha producido una
	 * ClassNotFoundException:" + ex.getMessage());
	 * Logger.getLogger(ConexionBD.class.getName()).log(Level.SEVERE, null, ex); }
	 * finally { return conexion; } }
	 */

	public Connection getCon() {
		try {
			if (conexion == null) {
				Properties propertie = new Properties();
				MysqlDataSource m = new MysqlDataSource();
				FileInputStream fis;

				try {

					fis = new FileInputStream("src/main/com/dawjava/resources/db.properties");
					// cargamos la información del fichero properties
					propertie.load(fis);
					// asignamos al origen de datos las propiedades leidas del fichero properties
					m.setUrl(propertie.getProperty("url"));
					m.setPassword(propertie.getProperty("password"));
					m.setUser(propertie.getProperty("usuario"));
					// obtememos la conexion
					conexion = m.getConnection();

				} catch (FileNotFoundException e) {
					System.out.println("Error al acceder al fichero properties " + e.getMessage());
				} catch (IOException e) {
					System.out.println("Error al leer las propiedades del fichero properties" + e.getMessage());
				} catch (SQLException e) {
					System.out.println("Error al conectar a la base de datos:usuario,password....");
				}
				return conexion;
			}

		} catch (Exception e) {
			System.out.println("Se ha producido una excepion al conectar con la BD." + e.getMessage());
			e.printStackTrace();
		}
		return conexion;
	}

	/**
	 * public static void cerrarConexion() { if (conexion != null) { try {
	 * conexion.close(); } catch (SQLException ex) { System.out.println("Se ha
	 * producido una SQLException:" + ex.getMessage());
	 * Logger.getLogger(ConexionBD.class.getName()).log(Level.SEVERE, null, ex); } }
	 * }
	 */
}
