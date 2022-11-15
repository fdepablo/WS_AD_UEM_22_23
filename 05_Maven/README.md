# Configuracion de un proyecto Maven en Eclipse

Maven es una herramienta de software para la gesti�n y construcci�n de proyectos Java. Nos ayuda a gestionar el ciclo de vida de una aplicaci�n java.

Maven utiliza un Project Object Model (POM) para describir el proyecto de software a construir, sus dependencias de otros m�dulos y componentes externos, y el orden de construcci�n de los elementos. Viene con objetivos predefinidos para realizar ciertas tareas claramente definidas, como la compilaci�n del c�digo y su empaquetado. 

Para realizar un proyecto maven en eclipse:

1. File -> new -> Maven proyect. Aceptamos.

2. Checkear la opcion "Create a simple proyect", para hacerlo de la manera m�s sencilla

3. En la pantalla que nos sale de configuraci�n de proyecto debemos dar el nombre del grupo y el nombre del artefacto:
	
    - <b>Nombre del grupo</b>, ser�a la agrupaci�n del proyecto, muchos proyectos tienen un mismo grupo. Podriamos entenderlo como el nombre de la compa�ia que ha hecho el proyecto. Tiene formato de paquete en java. Ejemplos:
        - com.empresa.departamento
        - com.felix
        - es.felix
        - es.dgt.puntos
		
    - <b>Nombre del artefacto</b>, ser�a el propio nombre del proyecto. Ejemplos: 
        - NombreProyecto
        - Minecraft
        - WhatsApp
        - 30_Maven
    - La conbinaci�n de nombre del grupo junto con el nombre del proyecto, deber�a de ser <b>UNICA</b> en el mundo

4. Un proyecto Maven tiene una estructura de carpetas y paquetes establecida por defecto, esto es para que todos los proyectos maven del mundo sean lo m�s parecidos posibles.
Entre las carpetas y paquetes m�s importantes encontraermos:

    - <b>src/main/java</b>, esta carpeta es donde pondremos todos nuestros ficheros fuente del proyecto. Es de las carpetas m�s importantes.
    - <b>src/main/resources</b>, en esta carpeta pondremos todos los ficheros que son recursos de nuestra aplicacion. Por ejemplo un fichero .txt que sera leido, un fichero .dat que servira para guardar objetos de nuestra aplicacion, un fichero .properties, un fichero de configuraci�n, etc.
    - <b>src/test/java</b>, igual que la carpeta 3.1 pero para realzar las pruebas de nuestra aplicaci�n
    - <b>src/test/resources</b>, igual que la carpeta 3.2 pero para realzar las pruebas de nuestra aplicaci�n
    - <b>Maven dependecies</b>, aqui podemos ver todos las librer�as (.jar) que van a ser usadas en nuestro proyecto. Se configuran en el fichero pom.xml
    - <b>target</b>, principalmente podremos encontrar los ejecutables de nuestro proyecto
    - <b>src</b>, donde estan los fuentes finales del proyecto
    - <b>pom.xml</b>, es el fichero m�s importante de un proyecto MAVEN. Es donde controlaremos el ciclo 	de vida de nuestro proyecto, desde con que version de java trabajaremos, que librer�as queremos usar, hasta como queremos generar el ejecutable o desplegable de nuestro proyecto. Este fichero es donde tenemos que ir para configurar todo nuestro proyecto.
	
5. Una vez configurado el fichero pom.xml, podemos empezar a realizar nuestro proyecto, normalmente en src/main/java. Para este ejemplo hemos usado la libreria de pdf que hemos a�adido a nuestras dependencias. Ver el fichero pom.xml para ver m�s detalles de donfiguraci�n.
	
	
## Bibliografia
https://maven.apache.org/
