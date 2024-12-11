package Colecta;

/**
 * Diseña un programa que simule una colecta,que
 * se realizara en 5 participantes.Cada uno de los
 * participantes aportara,cada tiempo aleatorio entre
 * 0 y 5 segundos una cantidad aleatoria entre 1€ y
 * 20€. La colecta termina cuando se llegue a una
 * cantidad de 2000€. La gestion de los fondos de
 * la colecta se realizara en un objeto compartido
 * por todos los participantes,donde se ira incrementando
 * su valor
 */
public class Colecta {
    private int fondos;

    public Colecta() {
        this.fondos = 0;
    }

    public synchronized void agregarFondos(int cantidad) {
        fondos += cantidad;
    }

    public synchronized int obtenerFondos() {
        return fondos;
    }

    public synchronized boolean alcanzarMeta(int meta) {
        return fondos >= meta;
    }
}
