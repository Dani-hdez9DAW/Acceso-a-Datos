import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Ejercicio4 {
    private final static Scanner sc = new Scanner(System.in);
    private static List<String> palabras;

    private static String meterCadena() {
        System.out.println("Ingrese un meter cadena");
        return sc.nextLine();
    }

    private static void cadenaFichero(String cadenaTexto) {
        File fichero = new File("C:\\Users\\usoma\\Desktop\\GRADO_SUPERIOR_DAW\\DAM\\Acceso a Datos\\Tema 1\\Ejercicios Practicos\\Ficheros_Creados\\salida.txt");
        palabras = new ArrayList<String>();
        String[] palabrasLong = cadenaTexto.split(" ");
        try (FileWriter fw = new FileWriter(fichero, true); PrintWriter pw = new PrintWriter(fw);) {
            for (int i = 0; i < palabrasLong.length; i++) {
                palabras.add(palabrasLong[i]);
            }
            for (int k = 0; k < palabras.size(); k++) {
                pw.println(palabras.get(k));
            }

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
