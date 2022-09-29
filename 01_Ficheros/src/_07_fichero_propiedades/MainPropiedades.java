package _07_fichero_propiedades;

/*
 * Los ficheros de propiedades son muy utiles en las aplicaciones y suelen servir para
 * establecer parametros de arranque de nuestras aplicaciones (o para lo que se quiera)
 */
public class MainPropiedades {
	public static void main(String[] args) {
		Configuracion conf = new Configuracion();
		conf.inicializar();
		
		String valor = conf.getProperty("propiedad1");
		System.out.println(valor);
		valor = conf.getProperty("usuario");
		System.out.println(valor);
	}
}
