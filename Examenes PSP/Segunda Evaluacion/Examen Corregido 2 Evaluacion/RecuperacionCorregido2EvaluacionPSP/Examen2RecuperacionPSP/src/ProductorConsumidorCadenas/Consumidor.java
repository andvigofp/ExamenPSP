package ProductorConsumidorCadenas;

/**
 * Usando el modelo productor-consumidor,crea un
 * programa cuyo productor lea cadenas de teclado
 * y su consumidor obtenga dichas cadenas,cuente
 * los caracteres recibidos y muestre el resultado
 * por pantalla.Cuando el usuario introduzca"*"
 * el programa debera finalizar
 */
public class Consumidor extends Thread{
    private Cola cola;

    public Consumidor(Cola cola) {
        this.cola = cola;
    }

    public void run() {
        try {
            String cadena;
            do {
                cadena = cola.obtener();
                if (!cadena.equals("*")) {
                    int longitud = cadena.length();
                    System.out.println("Cadena recibida: " + cadena);
                    System.out.println("Número de caracteres: " + longitud);
                    System.out.print("Introduce una cadena (o '*' para finalizar): ");
                }
            } while (!cadena.equals("*"));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
