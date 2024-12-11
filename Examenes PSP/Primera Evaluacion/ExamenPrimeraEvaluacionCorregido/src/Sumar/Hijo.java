package Sumar;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Hijo {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int numero1, suma = 0; // Inicializamos suma como 0

        // Bucle para ingresar números y realizar la suma
        do {
            System.out.println("Introduce un número (0 para salir):");
            numero1 = Integer.parseInt(br.readLine());

            // Si el número ingresado es 0, se termina el ciclo
            if (numero1 == 0) {
                System.out.println("Has salido correctamente.");
                break;  // Sale del bucle
            }

            // Se suma el número al total acumulado
            suma += numero1;

            // Muestra la suma acumulada
            System.out.println("La suma acumulada es: " + suma);

        } while (numero1 != 0);  // El bucle sigue hasta que se ingrese 0

        // Muestra la suma final después de que el bucle termina
        System.out.println("La suma final de todos los números es: " + suma);
    }
}
