package modelo.persistencia;

import modelo.entidad.Juego;

public interface DaoJuego {
	
	public String read(int ide);//Aqui mejor trabajar con objetos Juego
	
	public boolean update(Juego game);
	
	public boolean delete(int ide);
	
	public boolean create(Juego j);
	
	public String listarPorCompania(String compania);//Aqui mejor con listas de juegos
}
