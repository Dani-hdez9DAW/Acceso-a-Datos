import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Ejercicio5 {
    private final static Scanner sc = new Scanner(System.in);


    private static void cadenaFichero() throws FileNotFoundException {
        File fichero = new File("C:\\Users\\usoma\\Desktop\\GRADO_SUPERIOR_DAW\\DAM\\Acceso a Datos\\Tema 1\\Ejercicios Practicos\\Ficheros_Creados\\salida.txt");
        FileReader fr = new FileReader(fichero);
        int i;
        try (FileWriter fw = new FileWriter(fichero, true); PrintWriter pw = new PrintWriter(fw);) {
            while ((i = fr.read()) != -1) {//Si se pone 1 se hace bucle infinito
                System.out.print((char) i);
            }
            System.out.println("\nLa cadena se ha creado correctamente");
            fr.close();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) throws FileNotFoundException {
        cadenaFichero();

    }
}
