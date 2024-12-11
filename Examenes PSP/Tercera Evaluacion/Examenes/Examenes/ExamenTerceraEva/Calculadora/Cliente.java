package org.andres_example.Examenes.ExamenTerceraEva.Calculadora;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Cliente {
    public static void main(String[] args) {
    Scanner teclado = new Scanner(System.in);
    Socket cliente = null;
    ObjectOutputStream fsalida = null;
    ObjectInputStream fentrada = null;
    boolean conectado = false;

    do {
        try {
            cliente = new Socket("127.0.0.1", 6000);
            fsalida = new ObjectOutputStream(cliente.getOutputStream());
            fentrada = new ObjectInputStream(cliente.getInputStream());
            conectado = true;
        }catch (UnknownHostException e) {
            System.out.println("El servidor no está conectado. Se intentará de nuevo " + e.getMessage());
        } catch (IOException e) {
            System.out.println("Error, no se ha podido coectar los canales de comunicación. " + e.getMessage());
        }
    }while (conectado==false);

    int operando1 =0, operando2=0;
    String operacion= "";

        System.out.println("Introduzcca el operando1:");
        operando1 = teclado.nextInt();
        System.out.println("Introduzca el operando2:");
        operando2 = teclado.nextInt();
        teclado.nextLine();

        System.out.println("Que operación desea realizar (sumar, restar, multiplicar, division): ");
        operacion = teclado.nextLine();

        try {
            Calculadora calculadora = new Calculadora(operando1, operando2, operacion);

            fsalida.reset();
            fsalida.writeObject(calculadora);
            System.out.println("Enviar datos al servidor.");
            Calculadora resultado = (Calculadora) fentrada.readObject();

            System.out.println("El resultado de la operación es: " + resultado.getResultado());
            fentrada.close();
            cliente.close();
        }catch (InputMismatchException imme) {
            System.out.println("Error, introduzca un valor númerico:");
            teclado.nextLine();
        } catch (IOException e) {
            System.out.println("Error al enviar información al servidor. " + e.getMessage());
        } catch (ClassNotFoundException e) {
            System.out.println("Error en la clase. " + e.getMessage());
        }


    }
}
