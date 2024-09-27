import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Ejercicio2 {
    private final static Scanner sc = new Scanner(System.in);
    private final static int OPCION_SALIR = 4;

    private static void menuInicial() {
        System.out.println("***INICIO****");
        System.out.println("1. Crear directorio + fichero");
        System.out.println("2. Eliminar el fichero del 1º directorio");
        System.out.println("3. Eliminar el directorio anterior");
        System.out.println("4. Salir");
        System.out.print("************\n");
    }

    public static void crearFichero() throws IOException {
        // Especifica la ruta completa del archivo
        File ficherocreado = new File("C:\\Users\\usoma\\Desktop\\GRADO_SUPERIOR_DAW\\DAM\\Acceso a Datos\\Tema 1\\Ejercicios Practicos\\Ficheros_Creados", "miFichero.txt");

        // Asegúrate de que la carpeta donde quieres crear el archivo exista
        if (!ficherocreado.getParentFile().exists()) {
            ficherocreado.getParentFile().mkdirs(); // Crea la carpeta si no existe
        }

        try (FileWriter fichero = new FileWriter(ficherocreado);
             PrintWriter informacion = new PrintWriter(fichero)) {
            informacion.println("Nombre del fichero");
            System.out.println("Fichero creado correctamente en la ruta especificada.");
        } catch (IOException e) {
            System.out.println("No se puede crear el fichero: " + e.getMessage());
        }
    }

    private static void procesarAccion(int opcion) {
        switch (opcion) {
            case 1 -> crearFicheroDirectorio();
            case 2 -> eliminarFicheroDirectorio();
            case 3 -> eliminarNuevoDirectorio();
            case 4 -> sc.close();
            default -> System.out.println("Opción incorrecta");
        }
    }

    private static void eliminarFicheroDirectorio() {
        // Especificar la ruta del fichero a eliminar
        File fichero = new File("C:\\Users\\usoma\\Desktop\\GRADO_SUPERIOR_DAW\\DAM\\Acceso a Datos\\Tema 1\\Ejercicios Practicos\\Ficheros_Creados\\Nuevo_directorio", "mifichero2.txt");

        if (fichero.exists()) {
            if (fichero.delete()) {
                System.out.println("Fichero eliminado correctamente.");
            } else {
                System.out.println("No se pudo eliminar el fichero.");
            }
        } else {
            System.out.println("El fichero no existe.");
        }
    }

    private static void eliminarNuevoDirectorio() {
        // Especificar la ruta del directorio a eliminar
        File directorio = new File("C:\\Users\\usoma\\Desktop\\GRADO_SUPERIOR_DAW\\DAM\\Acceso a Datos\\Tema 1\\Ejercicios Practicos\\Ficheros_Creados\\Nuevo_directorio");

        if (directorio.exists() && directorio.isDirectory()) {
            if (directorio.delete()) {
                System.out.println("Directorio eliminado correctamente.");
            } else {
                System.out.println("No se pudo eliminar el directorio. Asegúrate de que está vacío.");
            }
        } else {
            System.out.println("El directorio no existe.");
        }
    }

    private static void crearFicheroDirectorio() {
        // Especificar la ruta donde se creará el nuevo directorio
        File directorio = new File("C:\\Users\\usoma\\Desktop\\GRADO_SUPERIOR_DAW\\DAM\\Acceso a Datos\\Tema 1\\Ejercicios Practicos\\Ficheros_Creados\\Nuevo_directorio");
        File fichero = new File(directorio, "mifichero2.txt");

        // Usar mkdirs() para asegurarse de que todos los directorios intermedios se crean si no existen
        if (directorio.mkdirs()) {
            try (FileWriter ficheroA = new FileWriter(fichero);
                 PrintWriter informacion = new PrintWriter(ficheroA)) {
                informacion.println("Nombre del fichero");
                System.out.println("Directorio y fichero creados correctamente.");
            } catch (IOException e) {
                System.out.println("Error al crear el fichero: " + e.getMessage());
            }
        } else {
            System.out.println("No se pudo crear el directorio (ya existe o hubo un error).");
        }
    }

    public static void main(String[] args) throws IOException {
        int opcion;
        do {
            menuInicial();
            System.out.println("Por favor, introduzca un número del 1 al 4:");
            opcion = sc.nextInt();
            procesarAccion(opcion);
        } while (opcion != OPCION_SALIR);
    }
}
