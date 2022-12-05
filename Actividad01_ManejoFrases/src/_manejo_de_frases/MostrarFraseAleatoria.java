package _manejo_de_frases;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class MostrarFraseAleatoria {

    public static final File NOMBRE_FICHERO = new File("file.txt");
    String frase;
    int contador, numeroAleatorio;
    public void mostrarFraseAleatoria() {

        try {
            BufferedReader br = new BufferedReader(new FileReader(NOMBRE_FICHERO));

            while ((frase = br.readLine()) != null) {
                contador++;
            }

            br.close();
            numeroAleatorio = (int) (Math.random() * contador + 1);
            br = new BufferedReader(new FileReader(NOMBRE_FICHERO));

            for (int i = 0; i < numeroAleatorio; i++) {
                frase = br.readLine();
            }

            System.out.println("La frase aleatoria es: " + frase + "\n");
            br.close();

        } catch (Exception e) {
            System.out.println("\n-> No hay frases en el archivo, la función aleatoria está desactivada.\n");
        }
    }
}
