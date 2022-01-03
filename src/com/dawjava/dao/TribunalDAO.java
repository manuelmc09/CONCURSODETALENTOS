package com.dawjava.dao;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.sql.*;
import java.util.ArrayList;
import java.util.Scanner;
import java.sql.SQLException;

import com.dawjava.entidades.Tribunal;

public class TribunalDAO {

	Connection conexion = null;
	Statement stmt = null;
	ResultSet resultado = null;

	public TribunalDAO() {

	}

	public TribunalDAO(Connection conexion) {
		this.conexion = conexion;
	}

	public Connection getConexion() {
		return conexion;
	}

	public boolean insertarJueces(Tribunal t) {
		return true;
	}

	public boolean borrarJueces(String dni) {
		return true;
	}

	public Tribunal findbyDni(String dni) {
		Tribunal t = null;
		return t;
	}

	public boolean modificarJueces(String dni) {
		return true;
	}

	public ArrayList<Tribunal> importarJuecesDesdeFicheroDeCaracteres(String path) {
		ArrayList<Tribunal> ret = new ArrayList<>();
		File fis = new File(path);
		FileReader lector = null;
		BufferedReader buffer = null;

		return ret;
	}

	public void exportarDatosTribunal(ArrayList<Tribunal> jueces) {

		String path = "C:\\Users\\usuario\\eclipse-workspaceDAW2.1\\CONCURSODETALENTOS\\com\\dawjava\\resources\\jueces.txt";
		File fichero=new File(path);
		FileWriter fw=null;
		PrintWriter buffer=null;
	}
}
