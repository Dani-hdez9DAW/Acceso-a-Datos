import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class Ejercicio1 {

    public static void crearFichero() throws IOException {
        // Especifica la ruta completa del archivo
        File ficherocreado = new File("C:\\Users\\usoma\\Desktop\\GRADO_SUPERIOR_DAW\\DAM\\Acceso a Datos\\Tema 1\\Ejercicios Practicos\\Ficheros_Creados", "miFichero.txt");

        // Asegúrate de que la carpeta donde quieres crear el archivo exista
        if (!ficherocreado.getParentFile().exists()) {
            ficherocreado.getParentFile().mkdirs(); // Crea la carpeta si no existe
        }

        try {
            // Usa la ruta completa para el FileWriter
            FileWriter fichero = new FileWriter(ficherocreado);
            PrintWriter informacion = new PrintWriter(fichero);
            informacion.println("Nombre del fichero");
            informacion.close(); // Siempre es una buena práctica cerrar el PrintWriter
            System.out.println("Fichero creado correctamente en la ruta especificada.");
        } catch (IOException e) {
            System.out.println("No se puede crear el fichero: " + e.getMessage());
        }

    }

    public static void main(String[] args) throws IOException {
        crearFichero();
    }
}
