package modelo.negocio;
import modelo.entidad.Juego;
import modelo.persistencia.DaoJuego;

// TODO: Auto-generated Javadoc
/**
 * The Class LogicaDeNegocio.
 *
 * @author hugog
 */
/**
 * The Class LogicaDeNegocio.
 */
public class GestorJuego {

	/** The dataBase. */
	private DaoJuego db;

	/**
	 * Instantiates a new logica de negocio.
	 *
	 * @param db2 the bd
	 */
	public GestorJuego(DaoJuego db) {
		this.db = db;
	}

	/**
	 * Insert a game into de database.
	 *
	 * @param game the game you want to insert
	 * @return if the operation is completed successfully it will return 0. In case
	 *         that the game's name is less than 5 letters it will return 1. In the
	 *         last case that the game price is negative it will return 3.
	 */
	public int crearJuego(Juego game) {
		if (game.getNombre().length() >= 5) {
			
			if (game.getPrecio() > -1) {
				
				if(db.create(game)) {
					return Respuesta.OPERATION_COMPLETED;
				} else {
					return Respuesta.ALREADY_EXIST;
				}
				
			} else {
				return Respuesta.NEGATIVE_PRICE_ERROR;
			}
			
		} else {
			return Respuesta.NAME_LENGTH_ERROR;
		}
	}

	/**
	 * Delete a game.
	 *
	 * @param game the game you want to delete
	 * @return true, if successful
	 */
	public boolean eliminarJuego(int id) {
		return db.delete(id);
	}

	/**
	 * @param id the id of the game you are willing to update
	 * @param game El juego con el quieres sobreescribir al otro
	 * @return true if successful
	 */
	public boolean updateJuego(Juego game) {
		return db.update(game);
		//MAL!! Hay que hacer lo mismo que en el alta (o parecido)
		//es decir, aquí tambien tendría que haber reglas de negocio
	}
	
	/**
	 * @param id the id of the game you want to see
	 * @return returns the game in case that all goes as espected, otherwise in the case that the game doesn�t exist it will return "NEG"
	 * If something goes wrong it will return "E"
	 */
	public String mostrarJuego(int id) {
		return db.read(id);
	}

	public String listarPorCompania(String compania) {
		return db.listarPorCompania(compania);
	}
}
