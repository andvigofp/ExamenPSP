package org.andres_example.Examenes.ExamenJunio.Factorial;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.*;
import java.util.Scanner;

public class Cliente {
    public static void main(String[] args) {
        System.out.println("Cliente Inicio....");
        int puerto = 12345;
        String host = "localhost";
        Scanner teclado = new Scanner(System.in);
        try {
            DatagramSocket cliente = new DatagramSocket();
            InetAddress direccionServidor = InetAddress.getByName(host);

            System.out.println("Introduce un número: ");
            double numero = teclado.nextDouble();
            if (numero < 0) {
                System.out.println("El número debe ser no negativo.");
                cliente.close();
                return;
            }

            Factorial factorial = new Factorial(numero);

            ByteArrayOutputStream salida = new ByteArrayOutputStream();
            ObjectOutputStream fsalida = new ObjectOutputStream(salida);
            fsalida.writeObject(factorial);
            fsalida.close();

            byte[] datos = salida.toByteArray();
            DatagramPacket paquete = new DatagramPacket(datos, datos.length, direccionServidor, puerto);
            cliente.send(paquete);

            byte[] bufferConfirmacion = new byte[1024];
            DatagramPacket paqueteConfirmacion = new DatagramPacket(bufferConfirmacion, bufferConfirmacion.length);
            cliente.receive(paqueteConfirmacion);

            String respuesta = new String(paqueteConfirmacion.getData(), 0, paqueteConfirmacion.getLength());
            System.out.println("Respuesta del servidor: " + respuesta);

            cliente.close();
            System.out.println("Fin del cliente");
        } catch (SocketException e) {
            throw new RuntimeException(e);
        } catch (UnknownHostException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
