package _manejo_de_frases;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class IntroducirFrase {
    String linea;
    private BufferedWriter bw;
    public static final File NOMBRE_FICHERO = new File("file.txt");


    public void setBw(BufferedWriter bw) {

        this.bw = bw;
    }

    public BufferedWriter getBw() {

        return bw;
    }
    public void setFrase(String frase) {

        this.linea = frase;
    }
    public void getFrase() throws IOException {

        bw = new BufferedWriter(new FileWriter(NOMBRE_FICHERO, true));
        bw.write(linea);
        bw.newLine();
        bw.close();
    }

    public void existeFichero() throws IOException {

        if (NOMBRE_FICHERO.exists()) {
            System.out.println("El fichero ya existe, se añadirá la nueva frase.");
        } else {
            System.out.println("El fichero no existe, se creará un nuevo fichero.");
            NOMBRE_FICHERO.createNewFile();
        }
    }
    public void introducirFrase() throws IOException {

        System.out.println("Introduzca la frase: ");
        linea = new Scanner(System.in).nextLine();
        setFrase(linea);
        getFrase();
    }
}
