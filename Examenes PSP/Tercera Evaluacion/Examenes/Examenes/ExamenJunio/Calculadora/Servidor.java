package org.andres_example.Examenes.ExamenJunio.Calculadora;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 1. Realiza un programa cliente-servidor que implemente una calculadora (suma,
 * resta, multiplicación y división). El servidor ha de poder atender a múltiples
 * clientes simultáneamente.
 *  El programa servidor creará un stream socket y aguardará conexiones.
 *  El programa cliente recogerá de teclado la operación a realizar y los operandos,
 * y se los enviará al servidor para que la resuelva. A continuación, leerá la
 * respuesta del servidor y la mostrará por pantalla.
 */
public class Servidor {
    public static void main(String[] args) {
        ServerSocket servidor = null;

        try {
            servidor = new ServerSocket(6000);
        } catch (IOException e) {
            System.out.println("Error en la apertura del socket " + e.getMessage());
        }

        while (true) {
            try {
                System.out.println("Esperando la conexión del cliente...");
                Socket cliente = servidor.accept();
                System.out.println("Cliente conectado....");
                HiloServidor hiloServidor = new HiloServidor(cliente);
                hiloServidor.start();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
