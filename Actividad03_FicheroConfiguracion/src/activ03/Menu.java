package activ03;

import java.util.ArrayList;
import java.util.Scanner;

public class Menu {

    private Scanner scanner;

    private IOFileManager manager;

    public Menu(){

    }

    public Menu(Scanner scanner, IOFileManager manager){
        this.scanner = scanner;
        this.manager = manager;
    }

    public void printMenu(){
        System.out.println(
                "1 -> Introducir frases célebres\n" +
                        "2 -> Mostrar frases célebres\n" +
                        "3 -> Mostrar frase célebre aleatoria\n" +
                        "4 -> Salir\n");

        System.out.print("Selección: ");
    }

    public int obtenerSeleccion(){
        try{
            return Integer.valueOf(scanner.nextLine());

        } catch (NumberFormatException e){
            System.out.println("Por favor introduzca una opción válida :(");
            return -1;
        }
    }

    public void mainLoop(){
        boolean seguir = true;
        while(seguir){
            printMenu();
            switch (obtenerSeleccion()){
                case 1 -> escribir();
                case 2 -> leer();
                case 3 -> imprimirFraseAleatoria();
                case 4 -> seguir = false;
            }
        }
        manager.close();
    }

    private void escribir(){
        System.out.print("Linea a escribir: ");
        String linea = scanner.nextLine();

        switch(manager.write(linea)){
            case EXITOSO                 -> System.out.println("Hecho!");
            case STRING_VACIO            -> System.out.println("Por favor, no introduzcas una frase vacía.");
            case ERROR_DE_IO             -> System.out.println("No se puede acceder al archivo.");
            case TAMANO_MAX_AR           -> System.out.println("La frase sobrepasa el tamaño máximo del archivo.");
            case TAMANO_MAX_FR           -> System.out.println("La frase sobrepasa el tamaño máximo de frase.");
        }
    }

    private void leer(){
        ArrayList<String> lines = manager.read();

        if(lines == null)
            System.out.println("El fichero está vacío.");
        else
            lines.forEach(System.out::println);
    }

    private void imprimirFraseAleatoria(){
       String linea = manager.getRandomLine();

       if(linea == null)
            System.out.println("El fichero está vacío.");
       else
            System.out.println(linea);
    }

    public String pedirItem(String mensaje){
        String nombre = null;
        do{

            System.out.print(mensaje);

            nombre = scanner.nextLine();

        } while (nombre == null || nombre.trim().isEmpty());

        return nombre;
    }

    public void setScanner(Scanner scanner){
        this.scanner = scanner;
    }

    public void setManager(IOFileManager manager){
        this.manager = manager;
    }
}
