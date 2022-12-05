package modelo.entidad;

public class Juego {
	private final int ID;
	private String nombre;
	private String compañia;
	private float precio;
	
	public Juego(int iD, String nombre, String compañia, float precio) {
		ID = iD;
		this.nombre = nombre;
		this.compañia = compañia;
		this.precio = precio;
	}
	
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getCompañia() {
		return compañia;
	}

	public void setCompañia(String compañia) {
		this.compañia = compañia;
	}

	public float getPrecio() {
		return precio;
	}

	public void setPrecio(float precio) {
		this.precio = precio;
	}

	public int getID() {
		return ID;
	}

}
