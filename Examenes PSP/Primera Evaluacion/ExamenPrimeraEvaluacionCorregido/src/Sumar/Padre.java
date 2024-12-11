package Sumar;

import java.io.*;

public class Padre {
        public static void main(String[] args) {
            // Especificar la ruta del directorio donde se encuentra la clase Hijo
            File directorio = new File(".\\out\\production\\ExaExamenPrimeraEvaluacionCorregido\\Sumar");

            // Comprobar si el directorio existe
            if (!directorio.exists()) {
                System.out.println("El directorio no existe.");
                return;
            }

            // Imprimir el directorio y el comando que se va a ejecutar para depuración
            System.out.println("Directorio donde se ejecuta el proceso: " + directorio.getAbsolutePath());
            System.out.println("Comando que se ejecuta: java Sumar.Hijo");

            // Crear un ProcessBuilder para ejecutar la clase Hijo
            ProcessBuilder pb = new ProcessBuilder("java", "Sumar.Hijo");
            pb.directory(directorio);

            try {
                // Iniciar el proceso
                Process p = pb.start();

                // Crear el BufferedReader para leer la salida del proceso hijo
                BufferedReader br = new BufferedReader(new InputStreamReader(p.getInputStream()));

                // Verificar el directorio actual de ejecución
                System.out.println("Directorio actual de ejecución: " + new File(".").getAbsolutePath());

                // Crear el PrintWriter para escribir la salida en el archivo
                PrintWriter writer = new PrintWriter(new FileWriter(".\\fichero.txt"));
                System.out.println("Creando fichero.txt...");

                // Leer la salida del proceso hijo línea por línea
                String line;
                while ((line = br.readLine()) != null) {
                    System.out.println("Leyendo del proceso hijo: " + line);  // Imprimir en consola
                    writer.println(line);                                    // Escribir en el archivo
                }

                // Esperar que el proceso hijo termine
                int exitval = p.waitFor();
                System.out.println("Valor de salida del proceso hijo: " + exitval);

                // Cerrar los flujos
                writer.close();
                br.close();
                System.out.println("Archivo cerrado correctamente.");

            } catch (IOException | InterruptedException e) {
                // Capturar y mostrar cualquier excepción que ocurra
                e.printStackTrace();
            }
        }
    }

