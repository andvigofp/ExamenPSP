package org.andres_example.Examenes.ExamenTerceraEva.Calculadora;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class HiloServidor extends Thread{
        private ObjectInputStream canalEntrada;
        private ObjectOutputStream canalSalida;
        private Socket cliente;

    public HiloServidor(Socket cliente) {
        this.cliente = cliente;

        try {
            this.canalEntrada = new ObjectInputStream(cliente.getInputStream());
            this.canalSalida = new ObjectOutputStream(cliente.getOutputStream());
        } catch (IOException e) {
            System.out.println("Error en los canales de E/S: " + e.getMessage());
        }
    }

    public void run() {
        System.out.println("Comienza la ejecucción del hilo.");
        Calculadora calculadora = null;

        try {
            calculadora = (Calculadora) canalEntrada.readObject();
            System.out.println("Recibe datos del cliente.");
            switch (calculadora.getOperacion()) {
                case "sumar":
                    calculadora.suma();
                    break;
                case "restar":
                    calculadora.resta();
                    break;
                case "multiplicar":
                    calculadora.multiplciacion();
                    break;
                case "division":
                    calculadora.division();
                    break;
                default:
                    System.out.println("Error no elegiste la opción correcta.");
                    break;

            }
            canalSalida.reset();
            canalSalida.writeObject(calculadora);
            System.out.println("Envía datos al cliente.");

            canalEntrada.close();
            canalSalida.close();
            cliente.close();
            System.out.println("Fin del servidor al cliente...");
        } catch (IOException e) {
            System.out.println("Error de lectura. " + e.getMessage());
        } catch (ClassNotFoundException e) {
            System.out.println("Error en la conversión del objecto. " + e.getMessage());
        }
    }
}

