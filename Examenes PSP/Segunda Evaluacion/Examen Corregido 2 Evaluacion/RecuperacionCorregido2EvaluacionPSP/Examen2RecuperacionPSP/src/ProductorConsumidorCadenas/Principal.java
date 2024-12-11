package ProductorConsumidorCadenas;

/**
 * Usando el modelo productor-consumidor,crea un
 * programa cuyo productor lea cadenas de teclado
 * y su consumidor obtenga dichas cadenas,cuente
 * los caracteres recibidos y muestre el resultado
 * por pantalla.Cuando el usuario introduzca"*"
 * el programa debera finalizar
 */
public class Principal {
    public static void main(String[] args) {
        Cola cola = new Cola();
        Productor productor = new Productor(cola);
        Consumidor consumidor = new Consumidor(cola);

        productor.start();
        consumidor.start();

        try {
            consumidor.join(); // Esperar a que el consumidor termine
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Programa finalizado.");
    }
}