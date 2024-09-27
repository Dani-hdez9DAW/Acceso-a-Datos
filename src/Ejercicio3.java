import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Scanner;

public class Ejercicio3 {
    private final static Scanner sc = new Scanner(System.in);

    private static String meterCadena() {
        System.out.println("Ingrese un meter cadena");
        return sc.nextLine();
    }

    private static void cadenaFichero(String cadenaTexto) {
        File fichero = new File("C:\\Users\\usoma\\Desktop\\GRADO_SUPERIOR_DAW\\DAM\\Acceso a Datos\\Tema 1\\Ejercicios Practicos\\Ficheros_Creados\\salida.txt");
        //Siempre al meter informacion en el fichero , hacer con un try ()
        try (FileWriter fw = new FileWriter(fichero, true); PrintWriter pw = new PrintWriter(fw);) {
            pw.println(cadenaTexto);
            pw.println("*");
            System.out.println("La cadena se ha creado correctamente");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {
        String cadena = meterCadena();
        cadenaFichero(cadena);
    }
}
