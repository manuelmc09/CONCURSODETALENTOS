package com.dawjava.dao;

import java.sql.*;
import java.util.Scanner;

import com.dawjava.entidades.Categoria;

public class CategoriaDAO {
	private Connection conexion;
	PreparedStatement ps;
	ResultSet resultado;

	public CategoriaDAO(Connection conexion) {
		this.conexion = conexion;
	}

	public Connection getConexion() {
		return conexion;
	}

	/**
	 * Metodo para añadir una nueva Categoria a la BD
	 * 
	 * @param cat
	 * @return booleano
	 */
	public boolean insertarCategoria(Categoria cat) {

		try {
			ps = conexion.prepareStatement(("INSERT INTO categoria(idcategoria,categoria) VALUES (?,?)"));
			ps.setInt(1, cat.getIdcategoria());
			ps.setNString(2, cat.getCategoria());
			ps.executeUpdate();
			ps.close();

		} catch (SQLException e) {
			System.out.println("Se ha producido un error al añadir la categoria ");
			e.printStackTrace();
		}
		return true;
	}

	/**
	 * Metodo para eliminar una categoria por su nombre en la BD
	 * 
	 * @param categoria
	 * @return
	 */
	public boolean eliminarCategoria(String categoria) {

		try {
			ps = conexion.prepareStatement("DELETE FROM categoria WHERE categoria=?");
			ps.setString(1, categoria);
			// ejecutamos la sentencia
			ps.executeUpdate();
			System.out.println("Categoria borrada correctamente ");
			ps.close();
			return true;

		} catch (SQLException e) {
			System.out.println("Error al borrar " + e.getMessage());
			return false;
		}
	}

	/**
	 * Método para buscar por nombre de categoria en la BD
	 * @param categoria_buscar
	 * @return Categoria cat
	 */
	public Categoria findbynombre(String categoria_buscar) {
		Categoria cat = null;

		try {
			ps = conexion.prepareStatement("SELECT categoria FROM categoria WHERE categoria=?");
			ps.setString(1, categoria_buscar);
			//ejecutamos la sentecia
			resultado = ps.executeQuery();
			resultado.next();
			cat=new Categoria(resultado.getInt(1),resultado.getString(2));
			ps.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return cat;
	}

	/**
	 * (Sin terminar)
	 * @param nombre_categoria
	 * @return
	 */
	public boolean modificarCategoria(String nombre_categoria) {
		Scanner teclado = new Scanner(System.in);
		try {
			Statement stmt = conexion.createStatement();

		} catch (SQLException e) {
			System.out.println("Error al modificar ..." + e.getMessage());
		}
		return true;

	}

}
