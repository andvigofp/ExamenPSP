package ProductorConsumidorCadenas;

import java.util.Scanner;

/**
 * Usando el modelo productor-consumidor,crea un
 * programa cuyo productor lea cadenas de teclado
 * y su consumidor obtenga dichas cadenas,cuente
 * los caracteres recibidos y muestre el resultado
 * por pantalla.Cuando el usuario introduzca"*"
 * el programa debera finalizar
 */
public class Productor extends Thread{
    private Cola cola;

    public Productor(Cola cola) {
        this.cola = cola;
    }

    public void run() {
        Scanner teclado = new Scanner(System.in);
        String cadena="";

        System.out.println("Introduzca una cadena (o pulsa '*' para finalizar)");
        do {
            cadena = teclado.nextLine();
            cola.agregar(cadena);
        }while (!cadena.equals("*"));
        teclado.close(); //Finalizar la salida por teclado
    }
}
