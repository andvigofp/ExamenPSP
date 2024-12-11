package org.andres_example.Examenes.ExamenTerceraEva.ParqueAtracciones;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.*;
import java.util.Scanner;

public class Cliente {
    public static void main(String[] args) {
        System.out.println("Cliente Iniciado...");
        int puerto = 12345;
        String host = "localhost";

        try {
            DatagramSocket cliente = new DatagramSocket();
            InetAddress direccionServidor = InetAddress.getByName(host);
            Scanner teclado = new Scanner(System.in);

            System.out.println("Bienvenido al parque de atracciones: ");
            System.out.println("Introduce su nombre completo: ");
            String nombre = teclado.nextLine();

            Menu.menu();
            int tipoEntrada = teclado.nextInt();

            System.out.println("Escoge la cantidad de entradas");
            int numeroEntradas = teclado.nextInt();

            System.out.println("===============================================");
            Ticket ticket = new Ticket(nombre, numeroEntradas, tipoEntrada);

            ByteArrayOutputStream salida = new ByteArrayOutputStream();
            ObjectOutputStream fsalida = new ObjectOutputStream(salida);
            fsalida.writeObject(ticket);

            byte[] datos = salida.toByteArray();
            DatagramPacket paquete = new DatagramPacket(datos, datos.length, direccionServidor, puerto);
            cliente.send(paquete);

            byte[] bufferConfirmacion = new byte[1024];
            DatagramPacket paqueteConfirmacion = new DatagramPacket(bufferConfirmacion, bufferConfirmacion.length);
            cliente.receive(paqueteConfirmacion);

            String confirmacion = new String(paqueteConfirmacion.getData(), 0, paqueteConfirmacion.getLength());
            System.out.println("Confirmación: " + confirmacion);

            cliente.close();
        } catch (SocketException e) {
            throw new RuntimeException(e);
        } catch (UnknownHostException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
