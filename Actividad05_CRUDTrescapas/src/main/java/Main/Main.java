package Main;

import Vista.FabricaDeJuegos;
import modelo.negocio.GestorJuego;
import modelo.persistencia.DaoJuego;
import modelo.persistencia.DaoJuegoMySQL;

public class Main {
	public static void main(String[] args) {
		DaoJuego db = new DaoJuegoMySQL();
		GestorJuego ln = new GestorJuego(db);//inyección de dependencias
		FabricaDeJuegos fj = new FabricaDeJuegos(ln);//Inyección de dependencias
		fj.startVista();
	}
}
