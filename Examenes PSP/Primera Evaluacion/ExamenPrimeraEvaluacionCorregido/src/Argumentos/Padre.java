package Argumentos;

import java.io.*;

public class Padre {
    public static void main(String[] args) throws IOException, InterruptedException {
        // Establecemos el directorio donde está la clase Main (ajusta esta ruta si es necesario)
        File directorio = new File(".\\out\\production\\ExamenPrimeraEvaluacionCorregido\\Argumentos");

        // Creamos el ProcessBuilder para ejecutar Main y pasar el argumento "-2"
        ProcessBuilder pb = new ProcessBuilder("java", "Main", "-2");
        pb.directory(directorio);

        // Iniciamos el proceso
        Process p = pb.start();

        // Usamos InputStream para leer la salida estándar
        InputStreamReader isr = new InputStreamReader(p.getInputStream());
        BufferedReader br = new BufferedReader(isr);

        // Leemos la salida estándar línea por línea
        String line = null;
        while ((line = br.readLine()) != null) {
            System.out.println(line);  // Imprime la salida en la consola
        }

        // Esperamos que el proceso termine y obtenemos el valor de salida
        int exitval = p.waitFor();
        System.out.println("Valor de salida: " + exitval);

        // Verificamos el código de salida para mostrar el mensaje adecuado
        switch (exitval) {
            case 1:
                System.out.println("No se ha recibido ningún valor.");
                break;
            case 2:
                System.out.println("Demasiados argumentos.");
                break;
            case 3:
                System.out.println("El primer argumento debe ser un número entero.");
                break;
            case 4:
                System.out.println("El número ingresado es mayor que 5.");
                break;
            case 5:
                System.out.println("No se puede dividir por cero.");
                break;
            case 6:
                System.out.println("Hay más de dos argumentos.");
                break;
            case 0:
                System.out.println("El argumento se procesó correctamente.");
                break;
            default:
                System.out.println("Código de salida inesperado: " + exitval);
                break;
        }

        // Cerramos el BufferedReader
        br.close();
    }
}

