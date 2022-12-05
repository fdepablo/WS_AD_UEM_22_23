package _manejo_de_frases;


import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class MostrarFrase {

    String frase;
    public static final File NOMBRE_FICHERO = new File("file.txt");

    public void mostrarFrases() {

        try {
            if (NOMBRE_FICHERO.exists()) {

                BufferedReader br = new BufferedReader(new FileReader(NOMBRE_FICHERO));
                System.out.println("\nLas frases almacenadas en el fichero son: \n");

                while ((frase = br.readLine()) != null) {
                    for (int i = 0; i < frase.length(); i++) {
                        System.out.print(frase.charAt(i));
                        Thread.sleep(40);
                    }
                    System.out.println();
                }

                br.close();
                System.out.println();

            } else {
                System.out.println("\n-> Actualmente no hay frases en el fichero, introduce una frase para mostrar.\n");
            }
        }
        catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}

