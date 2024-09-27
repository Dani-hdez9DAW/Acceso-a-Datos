import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Ejercicio6 {
    private final static Scanner sc = new Scanner(System.in);
    private static List<Empleado> empleados;

    private static void inicializar() {
        empleados = new ArrayList<Empleado>();
        empleados.add(new Empleado(1, "Pepe Rivera"));
        empleados.add(new Empleado(2, "Maria Rivera"));
        empleados.add(new Empleado(3, "Antonia Lopez"));
        empleados.add(new Empleado(4, "Lina Lopez"));
        empleados.add(new Empleado(5, "Arturo Cuesta"));
    }


    private static void cadenaFichero() {
        inicializar();
        File fichero = new File("C:\\Users\\usoma\\Desktop\\GRADO_SUPERIOR_DAW\\DAM\\Acceso a Datos\\Tema 1\\Ejercicios Practicos\\Ficheros_Creados\\salida.txt");


        try (FileWriter fw = new FileWriter(fichero, true); PrintWriter pw = new PrintWriter(fw); FileReader fr = new FileReader(fichero)) {
            int i;
            for (Empleado empleado : empleados) {
                pw.println("ID-" + empleado.getIdEmpleado() + " Nombre: " + empleado.getNombre());
            }
            while ((i = fr.read()) != -1) {//Si se pone 1 se hace bucle infinito
                System.out.print((char) i);
            }

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {


        cadenaFichero();
    }
}
