package activ03;

import java.io.File;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner       = new Scanner(System.in);
        Menu menu             = new Menu();
        menu.setScanner(scanner);//inyeccion de dependencias

        Configuration config  = new Configuration(new File("brian.conf"), menu);
        File archivoFrases    = new File(config.getNombreDelArchivo());
        IOFileManager manager = new IOFileManager(archivoFrases, config);

        menu.setManager(manager);
        menu.mainLoop();
    }
}
