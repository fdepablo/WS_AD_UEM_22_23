package activ03;

import java.io.*;
import java.util.Properties;

public class Configuration {

    private File config;

    private String nombreDelArchivo;

    private int tamanoMaximoArchivo;

    private int tamanoMaximoFrase;

    private int frase;

    private boolean borrarAlArrancar;

    private boolean hayCambios;


    private Menu menu;


    public Configuration(File config, Menu menu){
        this.config = config;
        this.menu   = menu;
        this.hayCambios = false;
        crearConfiguracionSiNoExiste();
        obtenerPropiedades();

    }


    public void obtenerPropiedades() {
        try (InputStream url = new FileInputStream(config);
             OutputStream out = new FileOutputStream(config, true)){

            // Cargamos el properties
            // tiene que estar dentro de una ruta de classpath
            Properties properties = new Properties();
            properties.load(url);

            nombreDelArchivo = obtenerPropiedad(properties, "nombre_del_archivo", "Nombre: ");

            tamanoMaximoArchivo = obtenerPropiedad(properties,
                    "tamano_maximo_archivo", intParser("Tamaño máximo del archivo (bytes): "));

            tamanoMaximoFrase = obtenerPropiedad(properties,
                    "tamano_maximo_frase", intParser("Tamaño máximo de cada mensaje (bytes): "));
            
            borrarAlArrancar = obtenerPropiedad(properties,
                    "borrar_al_iniciar", booleanParser("Borrar al iniciar la aplicacion? (S/n): "));

            if(hayCambios){
                properties.store(out, null);//almacenar datos en el fichero de propiedades
                hayCambios = false;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }


    public String obtenerPropiedad(Properties properties, String propiedad, String mensaje) throws IOException {
        String valor = properties.getProperty(propiedad);

        if(valor == null){
            valor = menu.pedirItem(mensaje);
            properties.put(propiedad, valor);
            hayCambios = true;
        }

        return valor;
    }

    public <T> T obtenerPropiedad(Properties properties, String propiedad,
                                  Parseable<T> parser) throws IOException {
        String valor = properties.getProperty(propiedad);

        T valorARetornar = null;

        if(valor == null){
            valorARetornar = parser.parseFromMenu();
            properties.put(propiedad, String.valueOf(valorARetornar));
            hayCambios = true;
        } else{
            valorARetornar = parser.parse(valor);
        }

        return valorARetornar;
    }

	private Parseable<Integer> intParser(String mensaje){
        return new Parseable() {
            @Override
            public Integer parseFromMenu() {
                Integer retorno = null;
                do{
                    try{
                        retorno = Integer.parseInt(menu.pedirItem(mensaje));
                    } catch (Exception e){
                        System.out.println("Por favor, escriba un número.");
                    }
                }while(retorno == null);

                return retorno;
            }

            @Override
            public Integer parse(String str){
                return Integer.parseInt(str);
            }
        };
    }

    private Parseable<Boolean> booleanParser(String mensaje){
        return new Parseable() {
            @Override
            public Boolean parseFromMenu() {
                Boolean retorno = null;
                do{
                    try{
                        String str = menu.pedirItem(mensaje);
                        if(str.equalsIgnoreCase("S"))
                            retorno = true;

                        else if (str.equalsIgnoreCase("n"))
                            retorno = false;

                        else
                            throw new NumberFormatException();


                    } catch (NumberFormatException e){
                        System.out.println("Por favor, escriba (S) para verdadero, o (n) para falso.");
                    }
                }while(retorno == null);

                return retorno;
            }

            @Override
            public Boolean parse(String str){
                return Boolean.parseBoolean(str);
            }
        };
    }


    private boolean crearConfiguracionSiNoExiste(){
        if(!config.exists()){
            try {
                config.createNewFile();
                return false;
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

        return true;
    }

    public String getNombreDelArchivo() {
        return nombreDelArchivo;
    }

    public int getTamanoMaximoArchivo() {
        return tamanoMaximoArchivo;
    }

    public int getTamanoMaximoFrase() {
        return tamanoMaximoFrase;
    }

    public boolean isBorrarAlArrancar() {
        return borrarAlArrancar;
    }
}
