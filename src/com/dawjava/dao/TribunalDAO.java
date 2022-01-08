package com.dawjava.dao;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.io.Serializable;
import java.sql.*;
import java.util.ArrayList;
import java.util.Scanner;
import java.sql.SQLException;

import com.dawjava.entidades.Audicion;
import com.dawjava.entidades.Tribunal;
import com.dawjava.util.ConexionBD;

public class TribunalDAO {

	Connection conexion = null;
	Statement stmt = null;
	ResultSet resultado = null;

	public TribunalDAO() {

	}

	public TribunalDAO(Connection conexion) {
		conexion = ConexionBD.establecerConexion();
		if (conexion == null) {
			System.out.println("Error al conectar a la BD. ");
		}
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

	/**
	 * Metodo para importar una coleccion de objectos de Tribunal desde un fichero
	 * de texto
	 * 
	 * @param path
	 * @return
	 */
	public static void importarJuecesDesdeFicheroDeCaracteres(String path) {
		ArrayList<Tribunal> t = new ArrayList<Tribunal>();
		//path = "C:\\Users\\usuario\\eclipse-workspaceDAW2.1\\CONCURSODETALENTOS\\src\\com\\dawjava\\resources\\listajueces.txt";
		File fis = new File(path);
		FileReader fr = null;
		BufferedReader buffer = null;
		try {
			fr = new FileReader(path);
			buffer = new BufferedReader(fr);
			String linea;
			try {
				while ((linea = buffer.readLine()) != null) {
					String[] column = linea.split("\\|");
					int idtribunal = Integer.parseInt(column[0]);
					String nombre = column[1];
					String email = column[2];
					String dni = column[3];
					String telefono = column[4];
					Tribunal tr = new Tribunal(idtribunal, nombre, email, dni, telefono);
					//System.out.println(tr.data());
					t.add(tr);
				}
			} finally {
				if (buffer != null) {
					buffer.close();
				}
				if (fr != null) {
					fr.close();
				}
			}
		} catch (FileNotFoundException e) {
			System.out.println("Se ha producido una FileNotFoundException" + e.getMessage());
		} catch (IOException e) {
			System.out.println("Se ha producido una IOException" + e.getMessage());
		} catch (Exception e) {
			System.out.println("Se ha producido una Exception" + e.getMessage());
		}
		
			System.out.println("\nEstos son los datos leidos de los "+t.size()+"  jueces-as.\n");
			for(int i=0;i<t.size();i++) {
				System.out.print(t.get(i)+" ");
			}
	}

	/**
	 * Metodo para importar un objeto de Tribunal desde un fichero de bytes
	 * 
	 * @param path
	 * @throws IOException
	 */
	public static void importarTribunalesDesdeFicheroDeBytes(String path) {
		Tribunal t = new Tribunal();
		ArrayList<Tribunal> jueces = new ArrayList<Tribunal>();
		FileInputStream fis = null;
		ObjectInputStream ois = null;
		boolean lectura = true;
		//path = "C:\\Users\\usuario\\eclipse-workspaceDAW2.1\\CONCURSODETALENTOS\\src\\com\\dawjava\\resources\\listajueces.dat";
		try {
			try {
				// Asociamos el nombre interno del fichero con el externo
				fis = new FileInputStream(path);
				// Creamos el flujo binario intermedio
				ois = new ObjectInputStream(fis);
				while (true) {
					t = (Tribunal) ois.readObject();
					jueces.add(t);
				}
			} finally {
				if (ois != null)
					ois.close();
				if (fis != null)
					ois.close();
			}
		} catch (FileNotFoundException e) {
			System.out.println("Se ha producido una FileNotFoundException" + e.getMessage());
		} catch (EOFException e) {
			System.out.println("Final de fichero");
		} catch (IOException e) {
			System.out.println("Se ha producido una IOException: " + e.getMessage());
		} catch (ClassNotFoundException e) {
			System.out.println("Se ha producido una ClassNotFoundException" + e.getMessage());
		} catch (Exception e) {
			System.out.println("Se ha producido una Exception" + e.getMessage());
		}

		// En el caso de poder leer los objectos Tribunal los procesamos en el ArrayList
		for (int i = 0; i < jueces.size(); i++) {
			System.out.println(jueces.get(i).toString());
		}

	}

	/**
	 * Metodo para exportar una coleccion de objectos de Tribunal hacia un fichero
	 * de caracteres
	 * 
	 * @param jueces
	 */
	public void exportarDatosTribunalToFicheroCaracteres() {
		ArrayList<Tribunal> jueces = new ArrayList<Tribunal>();
		String path = "C:\\Users\\usuario\\eclipse-workspaceDAW2.1\\CONCURSODETALENTOS\\src\\com\\dawjava\\resources\\listajueces.txt";
		File fis = new File(path);
		FileWriter fw = null;
		PrintWriter buffer = null;
		// Podemos pedir los datos por teclado e ir introduciendo los datos en el
		// ArrayList. Proceso más largo....
		Tribunal t1 = new Tribunal(1, "Soledad Gimenez Satustregui", "solegimenez@gmail.com", "10894565T", "934321201");
		Tribunal t2 = new Tribunal(2, "Vladimir Petrov Magomedov", "vladpetrov@gmail.com", "53421344J", "986234567");
		jueces.add(t1);
		jueces.add(t2);
		/**
		 * for(Tribunal t:jueces) System.out.println(t.toString());
		 */
		try {
			try {
				fw = new FileWriter(fis, true);
				buffer = new PrintWriter(fw);
				for (Tribunal t : jueces) {
					buffer.print(t.getNombre() + "|" + t.getDni() + "|" + t.getEmail() + "|" + t.getDni() + "|"
							+ t.getTelefono() + "|" + "\n");
				}
			} finally {
				if (buffer != null) {
					buffer.close();
				}
				if (fw != null) {
					fw.close();
				}
			}
		} catch (FileNotFoundException e) {
			System.out.println("Se ha producido una FileNotFoundException" + e.getMessage());
		} catch (IOException e) {
			System.out.println("Se ha producido una IOException" + e.getMessage());
		} catch (Exception e) {
			System.out.println("Se ha producido una Exception" + e.getMessage());
		}
	}

	/**
	 * Metodo para exportar los datos de un objeto de la clase Tribunal hacia un
	 * fichero binario
	 */
	public void exportarTribunalToBinaryFile() {
		String path = "C:\\Users\\usuario\\eclipse-workspaceDAW2.1\\CONCURSODETALENTOS\\src\\com\\dawjava\\resources\\listajueces.dat";
		FileOutputStream fos = null;
		ObjectOutputStream oos = null;
		try {
			fos = new FileOutputStream(path, true);// el argumento true para concadenar al final del fichero y no
													// sobreescribir
			oos = new ObjectOutputStream(fos);
			// Podemos pedir los datos por teclado e ir introduciendo. Proceso más largo....
			Tribunal t1 = new Tribunal(1, "Soledad Gimenez Satustregui", "solegimenez@gmail.com", "10894565T",
					"934321201");
			Tribunal t2 = new Tribunal(2, "Vladimir Petrov Magomedov", "vladpetrov@gmail.com", "53421344J",
					"986234567");

			oos.writeObject((Tribunal) t1);
			oos.flush();
			oos.writeObject((Tribunal) t2);
			oos.flush();
			oos.close();
		} catch (FileNotFoundException e) {
			System.out.println("Se ha producido una FileNotFoundException" + e.getMessage());
		} catch (IOException e) {
			System.out.println("Se ha producido una IOException" + e.getMessage());
		} catch (Exception e) {
			System.out.println("Se ha producido una Exception" + e.getMessage());
		}
	}

	public static void infoTribunales(ArrayList<Tribunal> jueces) {

	}

}
