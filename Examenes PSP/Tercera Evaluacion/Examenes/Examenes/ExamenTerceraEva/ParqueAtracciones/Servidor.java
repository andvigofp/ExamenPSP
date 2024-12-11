package org.andres_example.Examenes.ExamenTerceraEva.ParqueAtracciones;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

/**
 * Diseña una aplicación donde, empleando datagram sockets, un proceso (que
 * actúa como cliente) le envía a otro (que actúa como servidor) el nombre del usuario
 * y el tipo de entrada al parque de atracciones. El servidor le devolverá un ticket en el
 * que figuren los datos del usuario y el importe total, numeroEntrdadas.
 * Cliente:
 * - Se pide al usuario el nombre completo
 * - Se le muestran los tipos de entradas, para que indique la que le interesa.
 * ▪ Normal: 10 €
 * ▪ Niños: 3 €
 * ▪ Carnet joven: 5 €
 * ▪ Pensionista: 4 €
 * Servidor:
 * Una vez que tiene todos los datos, mostrará por su consola una entrada:
 * VISITANTE: Pepe Pérez
 *  TIPO DE ENTRADA: Carnet joven
 * A PAGAR: 5 €
 * El paso de datos entre procesos se hará a través de un objeto de la clase
 * Ticket.
 */
public class Servidor {
    public static void main(String[] args) {
        System.out.println("Servidor Iniciado...");
        int puerto = 12345;

        try {
            DatagramSocket servidor = new DatagramSocket(puerto);

            byte[] buffer = new byte[1024];
            DatagramPacket paquete = new DatagramPacket(buffer, buffer.length);
            servidor.receive(paquete);

            ByteArrayInputStream entrada = new ByteArrayInputStream(paquete.getData());
            ObjectInputStream fentrada = new ObjectInputStream(entrada);
            Ticket ticket = (Ticket) fentrada.readObject();

            double importe=0;
            String tipo = "";

            switch (ticket.getTipoEntrada()) {
                case 1:
                    importe=10;
                    tipo = "Normal";
                    break;
                case 2:
                    importe=3;
                    tipo = "Niños";
                    break;
                case 3:
                    importe=5;
                    tipo= "Carnet Joven";
                    break;
                case 4:
                    importe = 4;
                    tipo = "Pensionista";
                    break;
                default:
                    tipo = "Entrada no diponible";
                    break;
            }

            System.out.println("Enviadmos los datos de la entrada: ");
            System.out.println("Vistante: " + ticket.getNombre());
            System.out.println("Número Entradas: " + ticket.getNumeroEntradas());
            System.out.println("Tipo de Entrada: " + tipo);
            System.out.println("A pagar: " + importe);

            double total = importe * ticket.getNumeroEntradas();

            String respuesta = "\nVistante: " + ticket.getNombre() + "\nNúmero Entradas: " + ticket.getNumeroEntradas() +
                    "\nTipo de Entrada: " + tipo + "\nTotal: " + total + " €\n";
            byte[] datosRespuesta = respuesta.getBytes();

            DatagramPacket paqueteRespuesta = new DatagramPacket(datosRespuesta, datosRespuesta.length, paquete.getAddress(), paquete.getPort());
            servidor.send(paqueteRespuesta);
            servidor.close();
        } catch (SocketException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
