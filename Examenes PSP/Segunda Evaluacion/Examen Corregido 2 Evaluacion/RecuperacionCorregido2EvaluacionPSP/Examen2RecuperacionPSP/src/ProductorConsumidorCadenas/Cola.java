package ProductorConsumidorCadenas;

import java.util.LinkedList;

/**
 * Usando el modelo productor-consumidor,crea un
 * programa cuyo productor lea cadenas de teclado
 * y su consumidor obtenga dichas cadenas,cuente
 * los caracteres recibidos y muestre el resultado
 * por pantalla.Cuando el usuario introduzca"*"
 * el programa debera finalizar
 */
public class Cola {
    private LinkedList<String> cola = new LinkedList<>();

    public synchronized void  agregar(String cadena) {
        cola.add(cadena);
        notify(); // Notificar al consumidor que hay elmentos en la cola
    }

    public synchronized String obtener() throws InterruptedException {
        while (cola.isEmpty()) {
            wait(); // Esperar si la cola está vacía
        }
        return cola.poll();
    }
}
