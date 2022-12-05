package _manejo_de_frases;

import java.util.Scanner;

public class Menu {
    public void menu() {

        Scanner sc = new Scanner(System.in);
        int opcion = 0;

    try{
        do{
        System.out.println("\t\t:MENÚ:");
        System.out.println("1. Introducir frase");
        System.out.println("2. Mostrar frase");
        System.out.println("3. Mostrar frase aleatoria");
        System.out.println("4. Salir");
        System.out.println();
        System.out.println("Introduzca una opción: ");
        opcion = sc.nextInt();
            switch (opcion) {
                case 1:
                    IntroducirFrase introducirFrase = new IntroducirFrase();
                    introducirFrase.existeFichero();
                    introducirFrase.introducirFrase();
                    break;
                case 2:
                    MostrarFrase mostrarFrase = new MostrarFrase();
                    mostrarFrase.mostrarFrases();
                    break;
                case 3:
                    MostrarFraseAleatoria mostrarFraseAleatoria = new MostrarFraseAleatoria();
                    mostrarFraseAleatoria.mostrarFraseAleatoria();
                    break;
                case 4:
                    System.out.println("-> Adiós...\n");
                    break;
                default:
                    System.out.println("\n-> Opción incorrecta\n");
            }
        } while (opcion != 4);
    }

    catch (Exception e) {

        System.out.println("\n-> Opción incorrecta\n");
        menu();

        }
    }
}