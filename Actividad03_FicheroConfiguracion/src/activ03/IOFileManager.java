package activ03;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;

public class IOFileManager  {



    private File file;

    private Configuration config;

    private FileWriter fileWriter;

    private BufferedReader fileReader;

    private ArrayList<String> lines;

    /**
     * Resultados posibles del método write
     */
    public enum Resultado{
        EXITOSO, STRING_VACIO, ERROR_DE_IO, TAMANO_MAX_AR, TAMANO_MAX_FR
    }

    /**
     * Se encarga de manejar la escritura y lectura del fichero.
     * También puede obtener una linea aleatoria.
     * @param file archivo de configuracion
     */
    public IOFileManager(File file, Configuration config){
        this.file   = file;
        this.config = config;
        crearArchivoSiNoExiste();

        boolean limpiarFichero = !config.isBorrarAlArrancar();



        try{
            this.fileReader = new BufferedReader(new FileReader(file));
            this.fileWriter = new FileWriter(file, StandardCharsets.UTF_8, limpiarFichero);
            this.lines      = new ArrayList<>();
            read();
        } catch (IOException e){
            System.out.println("Esto no es un archivo, sino un directorio.");
        }
    }

    /**
     * Escribe un string al archivo y hace flush.
     * @param text el texto a escribir.
     * @return Un enum con el resultado.
     */
    public Resultado write(String text){
        String stripped = text.strip();//quitamos espacios a la derecha y a la izquierda

        if(stripped.isEmpty())
            return Resultado.STRING_VACIO;

        if(stripped.getBytes().length > config.getTamanoMaximoFrase())
            return Resultado.TAMANO_MAX_FR;

        if(stripped.getBytes().length + file.length() > config.getTamanoMaximoArchivo())
            return Resultado.TAMANO_MAX_AR;


        if(fileWriter != null){
            try {
                fileWriter.append(stripped);
                fileWriter.append('\n');
                fileWriter.flush();
            } catch (IOException e) {
                return Resultado.ERROR_DE_IO;
            }
        }

        return Resultado.EXITOSO;
    }

    /**
     * Lee el archivo y devuelve un string con todas las lineas.
     * @return Arraylist con todas las líneas. Null si el fichero está vacío
     */
    public ArrayList<String> read(){
        if(fileReader != null ){
            try{
                String line;
                while((line = fileReader.readLine()) != null){
                    lines.add(line);
                }
            } catch (IOException e){
                throw new RuntimeException();
            }
        }

        if(lines == null || lines.isEmpty())
            return null;

        return lines;
    }


    public String getRandomLine(){
        if(lines == null || lines.isEmpty())
            return "El fichero está vacío.";

        return lines.get((int)(Math.random() * 200) % lines.size());
    }

    public void close(){
        try{
            fileReader.close();
            fileWriter.close();
        } catch (IOException e){
            System.out.println("No se puede acceder al archivo");
        }
    }



    private void crearArchivoSiNoExiste(){
        if(!file.exists()){
            try {
                file.createNewFile();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
