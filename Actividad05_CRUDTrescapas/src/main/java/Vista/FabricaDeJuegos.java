package Vista;

import java.util.Scanner;

import modelo.entidad.Juego;
import modelo.negocio.GestorJuego;


public class FabricaDeJuegos {
	private GestorJuego ln;
	
	public FabricaDeJuegos(GestorJuego ln) {
		this.ln = ln;
	}

	public void startVista(){
		boolean continuar = true;
		while (continuar) {
			continuar = menu();
		}
	}

	private boolean menu() {
		Scanner sc = new Scanner(System.in);
		System.out.println();
		System.out.println("1- Crear Juego");
		System.out.println("2- Mostrar Juego");
		System.out.println("3- Actualizar Juego");
		System.out.println("4- Eliminar Juego");
		System.out.println("5- Listar por compa�ia");
		System.out.println("6- Salir");
		System.out.println();
		System.out.print("Elige opcion: ");
		int eleccion = sc.nextInt();
		boolean continuar = true;
		switch (eleccion) {
		case 1:
			crearJuego();
			break;
		case 2:
			mostrarJuego();
			break;
		case 3:
			actualizarJuego();
			break;
		case 4:
			eliminarJuego();
			break;
		case 5:
			listarPorCompania();
		case 6:
			continuar = false; 
		}
		return continuar;
	}

	private void listarPorCompania() {
		Scanner sc = new Scanner(System.in);
		System.out.print("Dime el nombre de la empresa: ");
		String[] r = ln.listarPorCompania(sc.nextLine()).split("-");	
		for (String dato : r) {
			System.out.println(dato);
			System.out.println();
		}
	}

	private void eliminarJuego() {
		Scanner sc = new Scanner(System.in);
		System.out.print("Dime el id del coche que quieres eliminar: ");
		ln.eliminarJuego(sc.nextInt());
	}

	private void actualizarJuego() {
		Scanner sc = new Scanner(System.in);
		System.out.print("Dime el id del juego que quieres actualizar: ");
		int ide = Integer.parseInt(sc.nextLine());
		System.out.print("Nombre: ");
		String nombre = sc.nextLine();
		System.out.print("Compa�ia: ");
		String compañia = sc.nextLine();
		System.out.print("Precio: ");
		float precio = sc.nextFloat();
		if(ln.updateJuego(new Juego(ide, nombre,compañia,precio))) {
			System.out.println("actualizado correctamente");
		} else {
			System.out.println("Ha habido un error en el proceso de actualizaci�n");
		}
	}

	private void mostrarJuego() {
		Scanner sc = new Scanner(System.in);
		System.out.print("Dime el id del videojuego que quieres ver: ");
		String r = ln.mostrarJuego(sc.nextInt());
		if(r.equals("NEG")) {
			System.out.println("El juego no existe");
		} else if(r.equals("N")) {
			System.out.println("Error al insertar el Juego");
		} else {
			String[] resultado = r.split("-");
			System.out.println("ID: " + resultado[0]);
			System.out.println("Nombre: " + resultado[1]);
			System.out.println("Compa�ia: " + resultado[2]);
			System.out.println("Precio: " + resultado[3]);
		}
	}

	private void crearJuego() {
		Scanner sc = new Scanner(System.in);
		System.out.print("ID: ");
		int id = Integer.parseInt(sc.nextLine());
		System.out.print("Nombre: ");
		String nombre = sc.nextLine();
		System.out.print("Compañia: ");
		String compania = sc.nextLine();
		System.out.print("Precio: ");
		double p = sc.nextDouble();
		float precio = (float) p;
		int r = ln.crearJuego(new Juego(id, nombre, compania, precio));
		if(r == 0) {
			System.out.println("Insertado correctamente");
		} else if(r == 1) {
			System.out.println("El nombre es menor a 5 letras");
		} else if(r == 2){
			System.out.println("No se puede poner un precion negativo");
		} else {
			System.out.println("El id del juego ya existe");
		}
	}
}
