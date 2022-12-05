package modelo.persistencia;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import modelo.entidad.Juego;

/**
 * The Class AccesoDatos.
 */
/**
 * @author hugog
 *
 */
public class DaoJuegoMySQL implements DaoJuego {

	/** The conection */
	private Connection con;

	/**
	 * Abrir conexion.
	 */
	private void abrirConexion() {
		String cadenaConexion = "jdbc:mysql://localhost:3306/videojuegos";
		String user = "root";
		String pass = "";
		try {
			con = DriverManager.getConnection(cadenaConexion, user, pass);
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}

	/**
	 * Cerrar conexion.
	 */
	private void cerrarConexion() {
		try {
			con.close();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}

	/**
	 * Comprueba si el juego existe.
	 *
	 * @param ide es el id del juego del cual deseas comprobar si existe
	 * @return devuelve true si existe
	 */
	private boolean existe(int ide) {
		boolean existe = false;
		try {
			PreparedStatement sentencia = con.prepareStatement("SELECT COUNT(id) from juegos where id=?");
			sentencia.setInt(1, ide);
			ResultSet rs = sentencia.executeQuery();
			rs.next();
			if (rs.getInt(1) == 1) {
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return existe;
	}

	/**
	 * inserta un juego.
	 *
	 * @param j juego que vas a insertar
	 */
	public boolean create(Juego j) {
		abrirConexion();
		if (!existe(j.getID())) {
			String sql = "INSERT INTO juegos (ID, Nombre, Compañia, Precio) VALUES (?,?,?,?);";
			try {
				PreparedStatement sentencia = con.prepareStatement(sql);
				sentencia.setInt(1, j.getID());
				sentencia.setString(2, j.getNombre());
				sentencia.setString(3, j.getCompañia());
				sentencia.setDouble(4, j.getPrecio());
				sentencia.execute();
			} catch (SQLException e1) {
				e1.printStackTrace();
				cerrarConexion();
				return false;
			}
			cerrarConexion();
			return true;
		} else {
			cerrarConexion();
			return false;
		}
	}

	public boolean delete(int ide) {
		abrirConexion();
		if (existe(ide)) {
			try {
				PreparedStatement sentencia = con.prepareStatement("DELETE FROM juegos where id=?");
				sentencia.setInt(1, ide);
				sentencia.execute();
				System.out.println("eliminado correctamente");
			} catch (SQLException e) {
				e.printStackTrace();
				return false;
			}
			cerrarConexion();
			return true;
		} else {
			cerrarConexion();
			return false;
		}
	}

	/**
	 * Update juego.
	 *
	 * @param idA  es el id del juedo que quieres actualizar
	 * @param game los datos del juego
	 * @return true, if successful
	 */
	public boolean update(Juego game) {
		abrirConexion();
		if (existe(game.getID())) {
			try {
				String sql = "UPDATE juegos SET nombre=?, compañia=?, Precio=? WHERE ID=?";
				PreparedStatement sentencia = con.prepareStatement(sql);
				sentencia.setString(1, game.getNombre());
				sentencia.setString(2, game.getCompañia());
				sentencia.setFloat(3, game.getPrecio());
				sentencia.setInt(4, game.getID());
				sentencia.execute();
			} catch (SQLException e) {
				e.printStackTrace();
				return false;
			}
			cerrarConexion();
			return true;
		} else {
			cerrarConexion();
			return false;
		}
	}

	/**
	 * Mostrar juego.
	 *
	 * @param ide the ide
	 * @return the string
	 */
	public String read(int ide) {
		abrirConexion();
		if (existe(ide)) {
			String total = "";
			try {
				PreparedStatement sentencia = con.prepareStatement("SELECT * FROM juegos WHERE ID=?");
				sentencia.setInt(1, ide);
				ResultSet rs = sentencia.executeQuery();
				while (rs.next()) {
					total += rs.getInt("ID") + "-";
					total += rs.getString("Nombre") + "-";
					total += rs.getString("Compañia") + "-";
					total += rs.getFloat("Precio");
				}
			} catch (SQLException e) {
				e.printStackTrace();
				return "E";
			}
			cerrarConexion();
			return total;
		} else {
			cerrarConexion();
			return "NEG";
		}
	}

	public String listarPorCompania(String compania) {
		abrirConexion();
		String total = "";
		try {
			PreparedStatement sentencia = con.prepareStatement("SELECT * FROM juegos WHERE Compa�ia=?");
			sentencia.setString(1, compania);
			ResultSet rs = sentencia.executeQuery();
			while (rs.next()) {
				total += "ID: " + rs.getInt("ID") + "-";
				total += "Nombre: " + rs.getString("Nombre") + "-";
				total += "Compañia: " + rs.getString("Compañia") + "-";
				total += "Precio: " + rs.getFloat("Precio") + "-";
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return "E";
		}
		cerrarConexion();
		return total;
	}
}
