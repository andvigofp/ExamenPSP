package org.andres_example.Examenes.ExamenJunio.Factorial;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

public class Servidor {
    public static void main(String[] args) {
        System.out.println("Servidor Iniciado...");
        int puerto = 12345;

        try {
            DatagramSocket servidor = new DatagramSocket(puerto);

            while (true) {
                byte[] buffer = new byte[1024];
                DatagramPacket paquete = new DatagramPacket(buffer, buffer.length);
                servidor.receive(paquete);

                ByteArrayInputStream entrada = new ByteArrayInputStream(paquete.getData());
                ObjectInputStream fentrada = new ObjectInputStream(entrada);
                Factorial factorial = (Factorial) fentrada.readObject();
                fentrada.close();

                // Calcular el factorial y mostrar el proceso
                double numero = factorial.getNumero();
                double resultado = calcularFactorial(numero);
                factorial.setResultado(resultado);
                System.out.println("Calculado: " + factorial);

                // Envía una confirmación con el resultado del cálculo del factorial
                String mensajeConfirmacion = "Factorial de " + factorial.getNumero() + " es " + factorial.getResultado();
                byte[] datosConfirmacion = mensajeConfirmacion.getBytes();
                DatagramPacket paqueteConfirmacion = new DatagramPacket(
                        datosConfirmacion, datosConfirmacion.length, paquete.getAddress(), paquete.getPort());
                servidor.send(paqueteConfirmacion);
            }
        } catch (SocketException e) {
            System.err.println("Error de socket: " + e.getMessage());
        } catch (IOException e) {
            System.err.println("Error de E/S: " + e.getMessage());
        } catch (ClassNotFoundException e) {
            System.err.println("Error de clase no encontrada: " + e.getMessage());
        }
    }

    // Método para calcular el factorial de un número y mostrar el proceso
    private static double calcularFactorial(double numero) {
        if (numero == 0 || numero == 1) {
            System.out.println(numero + " = 1");
            return 1;
        }
        double fact = 1;
        System.out.print(numero + " = ");
        for (int i = 1; i <= numero; i++) {
            fact *= i;
            System.out.print(i);
            if (i < numero) {
                System.out.print(" * ");
            }
        }
        System.out.println(" = " + fact);
        return fact;
    }
}
